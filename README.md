# TechRecruit - Full Stack Job Board

TechRecruit is a modern, full-stack web application designed to connect tech talent with top companies. It features a responsive user interface and a robust Spring Boot backend that allows users to view current job openings and post new ones directly to a MySQL database.

## 🚀 Tech Stack

**Frontend:**
* HTML5 & CSS3
* Bootstrap (for responsive UI components)
* Vanilla JavaScript (Fetch API for asynchronous requests)

**Backend:**
* Java 17
* Spring Boot 3
* Maven (Dependency Management)
* JDBC (Database Connectivity)

**Database:**
* MySQL

---

## 🛠️ Local Setup Instructions

Follow these steps to get a local copy up and running on your machine.

### 1. Prerequisites
Ensure you have the following installed on your local machine:
* **Java Development Kit (JDK) 17** or higher
* **MySQL Server**
* **Git**

### 2. Clone the Repository
```bash
git clone [https://github.com/Sun12Moon/Recruitment-website.git](https://github.com/Sun12Moon/Recruitment-website.git)
cd Recruitment-website

Database Configuration
Log into your local MySQL terminal as root (sudo mysql on Linux/Ubuntu) and run the following commands to create the database and the dedicated application user:

SQL
-- Create the database
CREATE DATABASE IF NOT EXISTS TechRecruitDB;
USE TechRecruitDB;

-- Create the Jobs table
CREATE TABLE Jobs (
    id INT AUTO_INCREMENT PRIMARY KEY,
    Title VARCHAR(255) NOT NULL,
    Company VARCHAR(255) NOT NULL,
    Location VARCHAR(255) NOT NULL,
    SalaryRange VARCHAR(100),
    Tags VARCHAR(255)
);

-- Create the dedicated app user and grant permissions
CREATE USER 'techuser'@'localhost' IDENTIFIED BY 'techpass123';
GRANT ALL PRIVILEGES ON TechRecruitDB.* TO 'techuser'@'localhost';
FLUSH PRIVILEGES;

Run the Application
The project uses the Maven wrapper, so you don't need to install Maven globally. Run the following command from the root of the project:

Mac/Linux:

Bash
./mvnw spring-boot:run

Windows:

DOS
mvnw spring-boot:run

The application will compile and the embedded Tomcat server will start on port 8080.

5. Access the Platform
Once the server is running, open your web browser and navigate to:

Frontend UI: Open the index.html file in your browser to explore the site.

API Endpoint: http://localhost:8080/api/jobs (Returns JSON list of jobs)

✨ Features
Dynamic Job Listing: Fetches real-time job data from the MySQL database and dynamically renders HTML cards.

Post a Job: A form that captures user input and sends a POST request to the Spring Boot API to insert new records into the database.

Responsive Design: Fully mobile-friendly layout.


***

### How to push this new file to GitHub:
Since you just created a new file locally, you need to sync it to your GitHub repository. Run these three commands in your terminal:

```bash
git add README.md
git commit -m "Add project README"
git push origin main
