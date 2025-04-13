# Student Survey Microservices Application

This project is a **Spring Boot** based microservices application designed to manage student survey data using RESTful APIs, **Amazon RDS MySQL**, and **JPA/Hibernate**. It performs full **CRUD operations** and is containerized using **Docker** and deployed on **Kubernetes** with a CI/CD pipeline.

## Features

- Create, Read, Update, and Delete student survey entries
- Persist data using Amazon RDS MySQL
- Microservices built using Spring Boot, REST APIs, and JPA/Hibernate
- Dockerized application with Kubernetes deployment
- CI/CD integrated deployment
- Postman tested endpoints

## Student Survey Form Fields

The following data is collected from students via the API:

### Personal Information (Required)
- First Name
- Last Name
- Street Address
- City
- State
- Zip
- Telephone Number
- Email
- Date of Survey

### Survey Responses
- What they liked most about the campus:
  - Students, Location, Campus, Atmosphere, Dorm Rooms, Sports
- How they became interested in the university:
  - Friends, Television, Internet, Other
- Likelihood of recommending this school:
  - Very Likely, Likely, Unlikely

---

## Tech Stack

- Java 17
- Spring Boot
- Spring Data JPA / Hibernate
- RESTful Web Services
- Amazon RDS (MySQL)
- Docker
- Kubernetes
- Jenkins (CI/CD Pipeline)
- Postman (API testing)

---

## Setup Instructions

### 1. Clone the Repository
```bash
git clone https://github.com/your-username/student-survey-service.git
cd student-survey-service
```
### 2. Configure MySQL on Amazon RDS
```bash
1. Launch a MySQL instance on **Amazon RDS**
2. Create a new database `surveydb`
3. Allow public access and update inbound rules (3306 port)
4. Update application.properties:
   spring.datasource.url=jdbc:mysql://<RDS-ENDPOINT>:3306/surveydb
   spring.datasource.username=your_username
   spring.datasource.password=your_password
   spring.jpa.hibernate.ddl-auto=update
   spring.jpa.show-sql=true
```
### 3. Build and Run Locally
```bash
mvn clean install
mvn spring-boot:run
```
### 4. Dockerize the Application
```bash
docker build -t student-survey-service .
docker tag student-survey-service <your-dockerhub-username>/student-survey-service
docker push <your-dockerhub-username>/student-survey-service

```
### 5. Kubernetes Deployment
```bash
kubectl apply -f k8s/deployment.yaml
kubectl apply -f k8s/service.yaml
```
