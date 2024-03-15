# Student Counselor App
## Overview
The Student Counselor App is a comprehensive solution designed for educational institutions, enabling inquiry counselors to efficiently manage and track student inquiries. Built using Spring Boot and MySQL, with a Thymeleaf front-end and Ajax for responsive interactions, this application streamlines the process of data management related to student counseling sessions.

## Features
- **Account Creation**: Counselors can sign up and create their own accounts to manage their sessions and data securely.
- **Data Management**: Securely save and retrieve detailed records of student/customer inquiries.
- **Dynamic Table View**: View and manage student data through a dynamic table, equipped with filtering options for efficient data access.
## Getting Started
### Prerequisites
Before you begin, ensure you have met the following requirements:

- Java JDK 8 or newer
- MySQL Server (5.7 or newer recommended)
- Maven for dependency management
### Installation
1. **Clone the repository**:
```git clone https://github.com/AyushChandel30/Student-Counselor-App```
2. **Navigate to the project directory**:
```cd Student-Counselor-App```
3. **Configure MySQL**:
- Edit src/main/resources/application.properties to set your MySQL database username and password.
- You also need to configure your Gmail account and create a Gmail app password.
4. **Run the application**:
Use Maven to run the application.
The application will start running on ```http://localhost:9090```.

## Usage
After logging in, counselors can use the dashboard to:

- Add new student inquiries.
- View all saved inquiries in a tabular format.
- Apply filters to search and organize inquiry data efficiently.
## Contributing
We welcome contributions to the Student Counselor App! To contribute:

1. Fork the repository.
2. Create your feature branch (```git checkout -b feature/AmazingFeature```).
3. Commit your changes (```git commit -m 'Add some AmazingFeature'```).
4. Push to the branch (```git push origin feature/AmazingFeature```).
5. Open a pull request.

## Contact
For any queries or feedback, please contact us at ayush.chibu@gmail.com.

## Acknowledgments
- Spring Boot for the comprehensive application framework.
- MySQL for reliable data storage and management.
- Thymeleaf for dynamic HTML views.
- Ajax for enhancing user interaction and responsiveness.
