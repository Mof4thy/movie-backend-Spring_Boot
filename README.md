# Movie Backend API

A Spring Boot REST API for managing movies with user authentication.

## Prerequisites

- Java 17+
- Maven 3.6+

## How to Run

1. **Clone the repository**
   ```bash
   git clone <repository-url>
   cd movie-backend
   ```

2. **Run the application**
   ```bash
   ./mvnw spring-boot:run
   ```
   
   Or on Windows:
   ```cmd
   mvnw.cmd spring-boot:run
   ```

3. **Access the application**
   - API Base URL: `http://localhost:8080`
   - H2 Database Console: `http://localhost:8080/h2-console`

## API Endpoints

### Authentication
- `POST /api/auth/register` - Register a new user
- `POST /api/auth/login` - Login user

### Movies
- `GET /api/movies` - Get all movies
- `GET /api/movies/{imdbID}` - Get movie by ID
- `POST /api/movies` - Add a new movie
- `DELETE /api/movies/{imdbID}` - Delete a movie
- `POST /api/movies/batch` - Add multiple movies
- `DELETE /api/movies/batch` - Delete multiple movies

## Default Admin User

- Username: `admin`
- Password: `admin123`

## Database

Uses H2 in-memory database. Data is reset on each restart.
