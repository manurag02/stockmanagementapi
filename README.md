# PayConiq Stock Management api

## Description:

This service will allow you to manage stocks based on current price and currency code(ISO format)

### Docker Compose SetUp :

This service uses Docker compose with postgres as db. You can run this project in two ways :-
1. Locally using H2  dev profile for debugging.
2. By using docker compose. Please find the instructions below for running the same :-
    2.1 Install docker-compose/ docker desktop from `https://docs.docker.com/compose/install/`
    2.2 Pull docker image using `docker pull postgres`
    2.2 Navigate to `src/main/docker` and use `docker compose up`.
    2.3 Postgres docker image will be pulled and application will start on port 8081 

## Pre-requisite

- Java 11
- Docker compose
- Maven
- Git bash (Or any IDE from where you can connect to git)

## Steps to run the application

- Checkout the code / Download from git repo()
- checkout : open git bash and run command `git clone `
- open command prompt(cmd) and navigate to `stockmanagement\src\main`
- run command `mvn clean install`
- once its successfully build run command `mvn spring-boot: run`

Now application is up and running

## How to view the documentation 

- Open the URL in your browser : http://localhost:8081/stockManagementApi/v1/swagger-ui/index.html

