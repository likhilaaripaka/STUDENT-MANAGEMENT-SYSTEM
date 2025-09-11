# Student Management System (Spring Boot MVC + Thymeleaf + JDBC + PostgreSQL/Neon)

A simple Student Management CRUD app using Spring Boot (MVC), Thymeleaf, JDBC Template, and PostgreSQL. Designed to connect with Neon serverless PostgreSQL.

## Features
- Create, Read, Update, Delete Students
- MVC architecture: `controller` → `service` → `repository` → DB
- Thymeleaf views: `list.html`, `form.html`
- JDBC (no JPA/Hibernate)

## Project Structure
```
management system/
├─ pom.xml
├─ src/
│  ├─ main/java/com/example/studentmanagement/
│  │  ├─ StudentManagementApplication.java
│  │  ├─ controller/StudentController.java
│  │  ├─ model/Student.java
│  │  ├─ repository/StudentRepository.java
│  │  └─ service/StudentService.java
│  └─ main/resources/
│     ├─ application.properties
│     ├─ schema.sql
│     ├─ static/css/styles.css
│     └─ templates/{list.html, form.html}
└─ README.md
```

## Prerequisites
- Java 17+
- Maven 3.8+
- Neon PostgreSQL database (host/user/password/DB name, SSL on)

## Neon Connection
1. Create a Neon project and a database.
2. Get the connection string (JDBC) from Neon dashboard. Example:
   - JDBC URL: `jdbc:postgresql://ep-xxx.us-east-2.aws.neon.tech/neondb?sslmode=require`
   - Username: `neondb_user`
   - Password: `your_password`
3. Set environment variables before running the app (Windows PowerShell):
```powershell
$env:JDBC_URL="jdbc:postgresql://<host>/<db>?sslmode=require"
$env:DB_USERNAME="<username>"
$env:DB_PASSWORD="<password>"
```

Alternatively, you can set them in your IDE Run Configuration.

## Run Locally
```powershell
# From the project root
mvn spring-boot:run
```
App runs at `http://localhost:8080/students`.

The database schema is auto-applied on startup from `resources/schema.sql`.

## CRUD URLs
- List: `GET /students`
- Create Form: `GET /students/new`
- Create: `POST /students`
- Edit Form: `GET /students/{id}/edit`
- Update: `POST /students/{id}`
- Delete: `POST /students/{id}/delete`

## Notes
- Uses `JdbcTemplate` with `students` table.
- Email is unique per schema.
- Logging of SQL queries can be seen with `org.springframework.jdbc.core=DEBUG`.

## Build Jar
```powershell
mvn clean package
java -jar target/student-management-0.0.1-SNAPSHOT.jar
```
Ensure the environment variables are present for the jar process as well.

## Troubleshooting
- SSL required: Neon usually requires `sslmode=require`.
- Firewall/VPN: Ensure outbound connections to Neon are permitted.
- Unique violation on email: Use a different email when creating.
