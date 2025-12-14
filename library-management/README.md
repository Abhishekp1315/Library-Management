Library Management System (Microservices + Angular)

Prerequisites:
- Java 17, Maven
- Docker & Docker Compose
- Node.js 18+, npm, Angular CLI (for frontend)

Start MongoDB:
  docker compose up -d

Build backend modules:
  mvn -q -DskipTests package

Run services:
  cd auth-service && mvn spring-boot:run
  cd ../book-service && mvn spring-boot:run
  cd ../section-service && mvn spring-boot:run

Frontend setup (once):
  cd frontend
  npm install -g @angular/cli
  ng new frontend --routing --style=scss --directory .
  npm install
  ng serve --open

