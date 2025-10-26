# Stock-microservices-kafka-practice-project
This is a **multi-module Spring Boot project** for practicing **Kafka-based messaging** using a simulated stock price feed.

It includes:

- **Producer module** → generates random stock prices and sends them to a Kafka topic
- **Consumer module** → listens to that topic, processes incoming messages, and stores them in a PostgreSQL database  

This project demonstrates:
- Event-driven microservices architecture
- Kafka consumer groups and topic partitioning
- Integration between Kafka, Spring Boot, and databases 


## Project Structure

stock-microservices-kafka-practice-project/
```markdown

root-project
├─ stock-producer/
|- src/
├─ main/
│   ├─ java/
│   └─ resources/
|-pom.xml
├─ stock-consumer/
|- src/
├─ main/
│   ├─ java/
│   └─ resources/
|-pom.xml
├─ build.gradle / pom.xml
└─ settings.gradle / settings.gradle.kts


```

## Setup Instructions
1. **Clone the repository**:
   ```bash
   git clone https://github.com/ragujan/Stock-microservices-kafka-practice-project.git
   ```
2. **Navigate to the project directory**:
3. Run the docker-compose to start Kafka in KRaft mode  :
   ```bash
   docker-compose up -d
   ```
4. Connect to the postgres database by configuring the application.properties file in both modules.
5. Build and run the application


## How the app works
The Producer (stock-producer) automatically generates random stock prices (e.g., AAPL, TSLA, MSFT) every few seconds using a @Scheduled task.

It sends each price message (e.g. AAPL:152.34) to a Kafka topic defined in your config (app.kafka.topic.name = stock-prices).

The Consumer (stock-consumer) listens to that topic using a @KafkaListener, prints the messages to the console, and save them to the database.

Kafka ensures reliable delivery — if the consumer is down, messages are persisted and replayed when it restarts.

   
