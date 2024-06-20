# Stripe Payment Gateway Integration

This project demonstrates a backend API for integrating Stripe Payment Gateway using Spring Boot. The APIs allow you to create payment intents, capture payment intents, create refunds, and retrieve a list of all payment intents.

## Table of Contents

- [Getting Started](#getting-started)
- [Prerequisites](#prerequisites)
- [Installation](#installation)
- [Running the Application](#running-the-application)
- [API Endpoints](#api-endpoints)
- [Deployment](#deployment)
- [Built With](#built-with)
- [Authors](#authors)
- [Acknowledgments](#acknowledgments)

## Getting Started

These instructions will help you set up and run the project on your local machine for development and testing purposes.

### Prerequisites

- Java 17 or higher
- Maven

### Installation

1. Clone the repository:
    ```bash
    git clone https://github.com/yourusername/stripe-payment-gateway-integration.git
    ```

### Running the Application

1. Build the project using Maven:
    ```bash
    mvn clean install
    ```

2. Run the Spring Boot application:
    ```bash
    mvn spring-boot:run
    ```

3. The application will start on `http://localhost:8080`.

## API Endpoints

### Create Intent
- **URL:** `/api/v1/create_intent`
- **Method:** `POST`
- **Description:** Creates a new payment intent.
- **Request Body:**
    ```json
    {
        "amount": 1000,
        "currency": "eur"
    }
    ```

### Capture Intent
- **URL:** `/api/v1/capture_intent/{id}`
- **Method:** `POST`
- **Description:** Captures an existing payment intent.

### Create Refund
- **URL:** `/api/v1/create_refund/{id}`
- **Method:** `POST`
- **Description:** Creates a refund for an existing payment intent.

### Get Intents
- **URL:** `/api/v1/get_intents`
- **Method:** `GET`
- **Description:** Retrieves a list of all payment intents.

## Deployment

This project is deployed on Railway Cloud. You can access the deployed application [here](https://stripeinteg-production.up.railway.app/api/v1/create_intent).

## Built With

- [Spring Boot](https://spring.io/projects/spring-boot) - The web framework used
- [Stripe Java Library](https://github.com/stripe/stripe-java) - Stripe API client library
- [Maven](https://maven.apache.org/) - Dependency management
- [Railway Cloud](https://railway.app/) - Deployment platform

## Authors

- [Hitesh_Chandra](https://github.com/HiteshChandra001)

## Acknowledgments

- Thanks to [Stripe](https://stripe.com) for providing a robust payment processing platform.
- Inspiration from various online tutorials and resources.
