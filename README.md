## Introduction
This is a project that aims to provide waivers to customers.
The Waivers are of different types. It has different endpoints to create a waivers,get waivers.


## Prerequisites

- Docker: Install Docker on your machine. You can download Docker from [here](https://www.docker.com/get-started).
- Git: You need Git to clone this repository. You can download Git from [here](https://git-scm.com/downloads).
- Java Development Kit (JDK): Ensure you have Java 17 or later installed for building the Spring Boot application.

## Getting Started

Follow these steps to set up and run your Dockerized Spring Boot application:

1. Clone the repository to your local machine:

   ```bash
   git clone <repository_url>
   cd dockerized-spring-boot-app

2. Run the following command in the same directory as your docker-compose.yml file to start both the Spring Boot application and the MySQL database as containers:
    `docker-compose up`

    The -d flag can be added to run the containers in detached mode, allowing you to use the terminal for other tasks:
    `docker-compose up -d`

## Access the Spring Boot Application:

After the containers are up and running, you can access your Spring Boot application at http://localhost:8080/<endpoint>. It should be able to connect to the MySQL database container using the specified environment variables.
## Stop and Remove Containers:
To stop and remove the containers, use the following command:
`docker-compose down`

## Configuration
Application configuration can be found in the `src/main/resources/application.properties file`. Modify this file to configure your Spring Boot application as needed.



