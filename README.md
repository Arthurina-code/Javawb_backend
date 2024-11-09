# Project Name: Novel Platform

## Project Overview
This is a comprehensive backend system for a novel platform designed for writers, readers, and platform administrators. The system offers a variety of features, including novel management, user management, and commenting and feedback systems. It also supports advanced search and recommendation features using both the database and Elasticsearch.

## Key Features

### 1. **Author Module**
- **Author Registration**: Authors can register on the platform.
- **Query Author Status**: Authors can check their current status (e.g., registered, approved).
- **Publish Novel**: Authors can publish their novels to the platform.
- **Novel List Management**: Authors can view a list of their published novels.
- **Chapter Management**: Authors can add, update, or delete chapters from their novels.
- **Chapter Content Query**: Authors can view the content of specific chapters.

### 2. **Book Module**
- **Query Novel Categories**: Query and display categories of novels based on genre.
- **Novel Information Management**: Retrieve detailed information about novels, including chapters and descriptions.
- **Click Count Management**: Track and increase click counts for novels to track their popularity.
- **Chapter Management**: Retrieve details of chapters, including the latest chapters and content.
- **Recommendation System**: Recommend novels based on category or popularity.
- **Novel Rankings**: Provide rankings based on clicks, new books, and updates.
- **Chapter Query and Navigation**: Mechanism to query chapters and navigate between them (previous and next chapters).

### 3. **Home Module**
- **Homepage Novel Recommendations**: Display recommended novels on the homepage.
- **Homepage Friend Links**: Manage a list of external links displayed on the homepage.

### 4. **News Module**
- **Latest News Query**: Display the latest news related to the platform.
- **News Details**: Retrieve detailed information for a specific news article.

### 5. **User Module**
- **User Registration and Login**: Allow users to register and log in to the platform.
- **User Profile Management**: Users can view and update their profile information.
- **User Feedback**: Users can submit feedback and delete previously submitted feedback.
- **Comment System**: Users can post, update, and delete comments on novels.
- **Bookshelf Management**: Users can manage their bookshelf by adding novels and checking their collection status.

### 6. **Search Module**
- **Novel Search**: Provide search functionality based on keywords, categories, word count, and update time.

### 7. **Resource Module**
- **Image Verification**: Generate and return image-based verification codes.
- **Image Upload**: Allow users to upload images with format validation.

---

## Technologies Used
- **Spring Boot**: Used for building RESTful APIs.
- **Spring Security**: Provides JWT authentication and authorization for secure access.
- **MyBatis-Plus**: Simplifies database interaction with automatic CRUD operations and pagination support.
- **Elasticsearch**: Provides fast and efficient full-text search functionality.
- **Redis**: Used for caching frequently accessed data (such as author info, novel data, and chapters).
- **RabbitMQ**: Handles asynchronous operations (e.g., notifications, background tasks) to improve system responsiveness.
- **JWT**: Used for stateless authentication to ensure secure API access.
- **MySQL**: Relational database used for storing user data, novels, chapters, comments, and other platform-related information.
- **Lombok**: Reduces boilerplate code by automatically generating getter/setter methods and constructors.
- **Swagger**: Used to document API endpoints for easy integration with front-end developers.

---

## Project Structure

### 1. **Controller Layer**
Handles HTTP requests and responses, mapping API endpoints to corresponding service methods.

- **Key Controllers**:
    - `AuthorController`: Manages author actions (registration, novel publishing, chapter management).
    - `BookController`: Handles novel queries and management (category, information, chapters, rankings).
    - `HomeController`: Manages homepage content (novel recommendations, friend links).
    - `NewsController`: Handles news-related queries.
    - `ResourceController`: Manages resources like image verification and uploads.
    - `SearchController`: Provides search functionality for novels.
    - `UserController`: Handles user-related operations (registration, login, profile management, comments, feedback).

### 2. **Service Layer**
Contains business logic and interacts with repositories and external services (e.g., Elasticsearch).

- **Key Services**:
    - `AuthorServiceImpl`: Handles author registration and status management.
    - `BookServiceImpl`: Manages novel-related operations (publishing, chapters, comments).
    - `DbSearchServiceImpl` & `EsSearchServiceImpl`: Provide database and Elasticsearch search functionality.
    - `HomeServiceImpl`: Manages homepage content (novel recommendations, friend links).
    - `NewsServiceImpl`: Manages news content.
    - `ResourceServiceImpl`: Handles resource-related operations like image uploads and captcha generation.
    - `UserServiceImpl`: Manages user registrations, logins, profiles, feedback, and bookshelf data.

### 3. **DAO Layer**
Manages direct database interactions through MyBatis. Each class corresponds to a database table.

- **Key Mappers**:
    - `UserInfoMapper`, `BookInfoMapper`, `AuthorInfoMapper`: Handle data persistence for user, book, and author information.
    - `BookChapterMapper`, `BookCommentMapper`, `UserBookshelfMapper`: Manage novel chapters, comments, and bookshelves.

### 4. **DTO Layer**
Defines the Data Transfer Objects (DTOs) used to structure the request and response data.

- **Key DTOs**:
    - **Request DTOs**: `AuthorRegisterReqDto`, `BookAddReqDto`, `UserLoginReqDto`.
    - **Response DTOs**: `BookInfoRespDto`, `UserInfoRespDto`, `UserRegisterRespDto`.

### 5. **Cache and Manager Layer**
Handles caching to optimize performance and reduce database queries.

- **Key Managers**:
    - `BookInfoCacheManager`, `AuthorInfoCacheManager`: Manage caching of books and authors.
    - `VerifyCodeManager`: Manages the generation and validation of image-based verification codes.

### 6. **Config Layer**
Contains configuration classes for various services (e.g., database, messaging, security).

- **Key Configs**:
    - `CacheConfig.java`, `MailProperties.java`, `EsConfig.java`: Configure caching, mail services, and Elasticsearch integration.

---

## Project Workflow

### 1. **User Registration**
- The user sends a registration request to `UserController` with data (username, password, etc.).
- `UserServiceImpl` validates the data, stores it in the database, and returns a JWT token for authentication.

### 2. **Novel Publishing**
- Authors publish novels through `AuthorController`.
- `BookServiceImpl` handles saving the novel and updating the database and cache.

### 3. **Search and Recommendations**
- Users or authors can search for novels using `SearchController`.
- Depending on whether Elasticsearch is enabled, either `EsSearchServiceImpl` or `DbSearchServiceImpl` handles the query and returns paginated results.

### 4. **User Interaction**
- Users can leave feedback, comment on novels, or add books to their bookshelf.
- `UserServiceImpl` and `BookServiceImpl` manage these operations.

### 5. **Caching and Performance Optimization**
- Frequently accessed data is cached using Redis to reduce the load on the database.
- Cache managers ensure that data retrieval is fast and efficient.

### 6. **Asynchronous Processing**
- RabbitMQ handles asynchronous tasks such as notifications and background operations, preventing blocking and ensuring responsiveness.

---

## Running Principle

The system uses a **separation of concerns** architecture:
- **Request Handling**: Requests are routed via controllers to the appropriate service methods.
- **Service Layer**: Handles business logic and interacts with the database or Elasticsearch for data.
- **Caching**: Frequently accessed data is cached with Redis for improved performance.
- **Asynchronous Operations**: Long-running tasks are processed using RabbitMQ to maintain responsiveness.
- **Database Interaction**: MyBatis-Plus handles CRUD operations in the database, ensuring consistency.

This architecture ensures the system is efficient, stable, and scalable.

---

## Conclusion

This Novel Platform integrates modern technologies like Spring Boot, MyBatis, Elasticsearch, Redis, and RabbitMQ to provide high-performance functionality for managing novels, users, feedback, and recommendations. The system is designed to handle high traffic efficiently while maintaining a smooth and responsive user experience.