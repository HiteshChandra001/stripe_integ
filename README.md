# Stripe Payment Gateway Integration

This project demonstrates a backend API for integrating Stripe Payment Gateway using Spring Boot. The APIs allow you to create payment intents, capture payment intents, create refunds, and retrieve a list of all payment intents.

## Table of Contents

- [Getting Started](#getting-started)
- [Prerequisites](#prerequisites)
- [Deployment](#deployment)
- [Api-Documentation](#Api-Documentation)
- [Installation](#installation)
- [Running the Application](#running-the-application)
- [API Endpoints](#api-endpoints)
- [Built With](#built-with)
- [Authors](#authors)
- [Acknowledgments](#acknowledgments)

## Getting Started

These instructions will help you set up and run the project on your local machine for development and testing purposes.

### Prerequisites

- Java 17 or higher
- Maven

## Deployment

This project is deployed on Railway Cloud. You can access the deployed application [here](https://stripeinteg-production.up.railway.app/api/v1/create_intent).

## Api Documentation

- api documentation [click here](https://documenter.getpostman.com/view/25982404/2sA3XTfgG7)
- postman api collection [click here](https://api.postman.com/collections/25982404-f1b63667-bf04-4b1e-a76c-4a9371efc15d?access_key=PMAT-01J0SZYTP08EEG1KQGV85FZ3ZZ)

### Installation

1. Clone the repository:
    ```bash
    git clone https://github.com/HiteshChandra001/stripe_integ.git
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
- **URL:** `/api/v1/capture_intent/{intentId}`
- **Method:** `POST`
- **Description:** Captures an existing payment intent.

### Create Refund
- **URL:** `/api/v1/create_refund/{intentId}`
- **Method:** `POST`
- **Description:** Creates a refund for an existing payment intent.

### Get Intents
- **URL:** `/api/v1/get_intents`
- **Method:** `GET`
- **Description:** Retrieves a list of all payment intents.


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
