# Golf Membership REST API - SDAT QAP 2
A simple Java golf membership RESTful API with CRUD operations for members and tournaments.

## PROGRAM DETAILS
### FEATURES & TECHNOLOGY
* Classes for members and tournaments 
* Create, read, update and delete (CRUD) operations and search functionality
* Endpoints tested in Postman (screenshots included)
* Technology:
    - Java (Maven)
    - MySQL Database
    - Postman
    - Spring Boot
    - Spring Data JPA
    - Docker

### ENDPOINTS
* GET Requests (Members):
  - GET /api/members 
  - GET /api/members/{id}
  - GET /api/members/search?name={name}
  - GET /api/members/search?email={email}
  - GET /api/members/search?phone={phone}
* GET Requests (Tournaments):
  - GET /api/tournaments
  - GET /api/tournaments/{id}
  - GET /api/tournaments/search?tourneyname={tourneyname}
  - GET /api/tournaments/search?location={location}
  - GET /api/tournaments/search?startdate={startdate}
* POST Requests (Create New Member/Tournament)
  -POST /api/members OR
  -POST /api/tournaments
* PUT Requests (Update via ID)
  - PUT /api/members/{id} OR
  - PUT /api/tournaments/{id}
* DELETE Requests (Delete via ID)
  - DELETE /api/members/{id} OR
  - DELETE /api/tournaments/{id}
  
### EXAMPLES
* GET Member by Name
  - /api/members/search?name=Chelsea%20Slade
* GET Tournament by Start Date
  - /api/tournaments/search?startdate=2024-10-20
* POST New Member
  - JSON Structure:
   ```
    {
    "name": "Chelsea Slade",
    "address": "424 Way Lane",
    "email": "cslade@example.com",
    "phone": "373-829-3939",
    "membershipStart": "2024-03-15"
    }
    ```
* PUT Existing Member (Update)
  - /api/members/1
  - JSON Structure:
  ```
  {
  "name": "Updated Name",
  "address": "Updated Address",
  "email": "updated@email.com",
  "phone": "123-456-7890",
  "membershipStart": "2023-01-01"
  }
  ```
* DELETE Existing Member
  - /api/members/1
    
### FILE STRUCTURE
```
- screenshots
- src
  - main
    - java
      - org.keyin
          - member
              Member
              MemberController
              MemberRepository
              MemberService
          - tournament
              Tournament
              TournamentController
              TournamentRepository
              TournamentService
        GolfMembershipApp
        HomeController
      - resources
          application.properties
    -test
      - Java
- target
.gitignore
docker-compose.yml
Dockerfile
pom.xml
```
## HOW TO RUN
### REQUIRED TECHNOLOGY
* Docker Desktop (Open prior following below instructions)
* Postman (if testing endpoints)
* Java w/ Maven installed
* MySQL (edit password and user in applications.properties to match your credentials)

Run the following commands in IDE terminal to install and run: 

### GITHUB: CLONE REPOSITORY
```
git clone https://github.com/chelseaslade/Golf-Membership-REST-API.git
cd Golf-Membership-REST-API
```
### MAVEN BUILD
```
mvn clean package
```
### BUILD & RUN IN DOCKER
* Ensure ports for program are not already in use (3306, 8080)
```
docker-compose up --build
```
### CHECK RUNNING CONTAINERS
```
docker ps
```
-The following should be running: 
* golf-api (Spring Boot app)
* mysql-db (MySQL database)

### STOP CONTAINERS
```
docker-compose down
```
