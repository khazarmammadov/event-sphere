
## Event Sphere

Event Sphere is a comprehensive event management system designed to facilitate event creation, registration, and management. This platform provides an efficient and user-friendly experience for both event organizers and participants.

## Table of Contents

- [Introduction](#introduction)
- [Objectives](#objectives)
- [Technologies Used](#technologies-used)
- [System Architecture](#system-architecture)
- [Features Implemented](#features-implemented)
- [Setup and Deployment Instructions](#setup-and-deployment-instructions)
- [Future Enhancements](#future-enhancements)
- [License](#license)

## Introduction

Event Sphere is a comprehensive event management system designed to facilitate event creation, registration, and management. The project provides an efficient and user-friendly platform for both event organizers and participants. The backend of the system has been implemented based on a well-structured architecture, ensuring scalability and maintainability.

## Objectives

The primary objectives of Event Sphere are:
- Seamless event creation and management.
- Efficient event registration for users.
- Real-time updates and notifications for events.
- Strong data security and role-based access control.

## Technologies Used

### Backend:
- **Programming Language:** Java (Spring Boot)
- **Frameworks & Libraries:**
  - Spring Boot (for backend development)
  - Spring Security (for authentication and authorization)
  - Hibernate (for ORM and database management)
  - Lombok (to reduce boilerplate code)
- **Database:** PostgreSQL
- **API Documentation:** Swagger
- **Authentication:** JWT (JSON Web Token)
- **Build Tool:** Gradle

### Frontend (Planned):
- **Framework:** React.js (for future development)
- **UI Design:** Figma
- **Figma Design Link:** [Event Sphere UI Design](https://www.figma.com/design/HIKkVCyG7z3v7jd9RMEA9L/eventSphere?node-id=0-1&t=stzINk8mHHFtFVxO-1)

### Other Tools & Services:
- **Version Control:** Git, GitHub ([https://github.com/khazarmammadov/event-sphere](https://github.com/khazarmammadov/event-sphere))
- **Cloud Storage:** MinIO (for file uploads)

## System Architecture

The system follows a **Architecture** with the following key services:
- **User Service:** Handles user registration, authentication, and role-based access control.
- **Event Service:** Manages event creation, updates, and deletions.
- **Registration Service:** Handles user registrations for events.
- **Notification Service:** Sends real-time notifications to users.

## Features Implemented

- **User Authentication & Authorization:**
  - JWT-based authentication
  - Role-based access control (Admin, Organizer, Attendee)
- **Event Management:**
  - Create, update, delete events
  - View event details
- **User Registration:**
  - Sign-up and login functionality
  - Register for events
- **Secure API Endpoints:**
  - Protected routes for event management
  - Public routes for event browsing

## Setup and Deployment Instructions

To run the application locally, follow these steps:

1. Clone the repository:
   ```sh
   git clone https://github.com/khazarmammadov/event-sphere.git
   ```

2. Open the project in IntelliJ IDEA or any other preferred IDE.

3. Ensure Docker is installed and running on your system. If not, install Docker from [https://www.docker.com/](https://www.docker.com/).

4. Navigate to the **infrastructure** directory.

5. Run the following command in the terminal to start the required services:
   ```sh
   docker compose up
   ```

6. Once the services are up, open your browser and go to:
   ```
   http://localhost:8080/swagger-ui/index.html
   ```

7. Review the API documentation and test the endpoints.

## Future Enhancements

- Implement the **React.js** frontend based on the Figma design.
- Integrate **payment gateways** for paid event registrations.
- Develop **mobile application support** for a wider user base.
- Implement **real-time notifications** using WebSockets.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

Let me know if you'd like any changes or further additions!
