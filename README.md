IoT Consumer Worker Service
===========================

A Spring Boot microservice that consumes telemetry data from Kafka and stores it in a database.

Overview
--------

This service listens to a Kafka topic for telemetry data, validates that the sending device is registered, and stores the telemetry readings in a MySQL database for further analysis.

Features
--------

*   Kafka consumer with batch processing
*   Device validation before processing telemetry
*   Batch database operations for efficiency
*   Configurable concurrency for parallel processing
*   Database indexing for query optimization

Technology Stack
----------------

*   Java 17+
*   Spring Boot 3.x
*   Spring Data JPA
*   Spring Kafka
*   MySQL Database
*   Maven

Project Structure
-----------------

src/main/java/com/iot\_consumer\_worker/uditha97/
├── config/             # Configuration classes

├── consumer/           # Kafka consumers

├── model/             # Entity models

├── repository/        # Data access layer

└── IotConsumerWorkerApplication.java  # Main application class


Configuration
-------------

Update the `application.yml` file with your environment-specific settings:

spring:
datasource:
url: jdbc:mysql://localhost:3306/iotdatabase
username: root
password: your\_password
kafka:
bootstrap-servers: localhost:9092
consumer:
group-id: iot-telemetry-group
max-poll-records: 500


### Kafka Consumer Configuration

The service is configured with:

*   Consumer group: `iot-telemetry-group`
*   Batch size: 500 records per poll
*   Concurrency: 3 listener threads
*   Manual offset commit management
*   Start reading from earliest available offset

Database Schema
---------------

### Device Table

CREATE TABLE device (
id BIGINT AUTO\_INCREMENT PRIMARY KEY,
device\_id VARCHAR(255) NOT NULL UNIQUE,
name VARCHAR(255),
model VARCHAR(255),
created\_at TIMESTAMP
);


### Telemetry Table

CREATE TABLE telemetry (
id BIGINT AUTO\_INCREMENT PRIMARY KEY,
device\_id VARCHAR(255) NOT NULL,
timestamp TIMESTAMP NOT NULL,
payload JSON,
INDEX idx\_device\_ts (device\_id, timestamp)
);


Build and Run
-------------

### Prerequisites

*   Java 17 or higher
*   Maven 3.6+
*   MySQL 8.0+
*   Kafka 2.8+

### Build the Application

mvn clean package

### Run the Application

java -jar target/iot-consumer-worker-0.1.0.jar

### Run with Docker

\# Build the Docker image
docker build -t iot-consumer-worker .

# Run the container
docker run -p 8081:8081 --name iot-consumer-worker iot-consumer-worker


Scaling Considerations
----------------------

To handle increased load:

*   Increase the `concurrency` setting for more consumer threads
*   Adjust `max-poll-records` based on message size and processing requirements
*   Add more instances of the consumer with the same group ID for horizontal scaling
*   Consider partitioning the Kafka topic by device ID for better parallelism

**Note:** Ensure that Kafka and MySQL are running before starting the application. The database tables will be created automatically if they don't exist.

[Demo.pdf](Extra%20Things/Demo.pdf)
