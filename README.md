# Spring Boot Microservice - Book Management

## Description

Simple Book Management Microservice with full CRUD operations.

## Technology Stack

- Java 17
- Spring Boot
- Spring Data JPA
- PostgreSQL
- Maven
- Postman

## Spring Application Name Folder Project

D:\book-management

## Database Configuration

Create PostgreSQL database:

book_management

Configure the following environment variables:

DB_URL=jdbc:postgresql://localhost:5432/book_management
DB_USERNAME=postgres
DB_PASSWORD=your_password

## How to Run the Project

1. Clone the repository
2. Configure PostgreSQL
3. Configure environment variables
4. Run:

- mvn clean

- mvn spring-boot:run

Application runs on Base URL:

http://localhost:8080

## API Endpoints

POST   /api/books       -> Add a new book
GET    /api/books       -> Get all books
GET    /api/books/{id}  -> Get a book by ID
PUT    /api/books/{id}  -> Update a book by ID (full update)
PATCH  /api/books/{id}  -> Partial update of a book (e.g. title only)
DELETE /api/books/{id}  -> Delete a book

## Sample Postman Request or Collection JSON

POST /api/              | Status code: 201 Created

{
    "title": "Pemrograman Java Komplet",
    "author": "Jubilee Enterprise",
    "isbn": "9786230068010",
    "publishedDate": "2025-01-08",
    "id": 1
}

GET /api/books          | Status code: 200 OK

{
    "title": "Pemrograman Java Komplet",
    "author": "Jubilee Enterprise",
    "isbn": "9786230068010",
    "publishedDate": "2025-01-08",
    "id": 1
}

GET /api/books/1        | Status code: 200 OK

{
    "title": "Pemrograman Java Komplet",
    "author": "Jubilee Enterprise",
    "isbn": "9786230068010",
    "publishedDate": "2025-01-08",
    "id": 1
}

PUT /api/books/1        | Status code: 200 OK

{
    "title": "Logika Pemrograman Java",
    "author": "Abdul Kadir",
    "isbn": "9786230017513",
    "publishedDate": "2020-07-08",
    "id": 1
}

PATCH /api/books/1      | Status code: 200 OK

{
    "title": "Algoritma & Pemrograman Menggunakan Java",
    "author": "Abdul Kadir",
    "isbn": "9786230017513",
    "publishedDate": "2020-07-08",
    "id": 1
}

DELETE /api/books/1     | Status code: 204 No Content

{
    "title": "Algoritma & Pemrograman Menggunakan Java",
    "author": "Abdul Kadir",
    "isbn": "9786230017513",
    "publishedDate": "2020-07-08",
    "id": 1
}


## Architecture Application
                  ┌─────────────┐
                  │   Postman   │
                  └──────┬──────┘
                         │ HTTP
                         ▼
                ┌─────────────────┐
                │   Controller    │
                │ BookController  │
                └────────┬────────┘
                         │
                         ▼
                ┌─────────────────┐
                │     Service     │
                │   BookService   │
                └────────┬────────┘
                         │
                         ▼
                ┌─────────────────┐
                │   Repository    │
                │ BookRepository  │
                └────────┬────────┘
                         │ JPA
                         ▼
                ┌─────────────────┐
                │   PostgreSQL    │
                │ book_management │
                └─────────────────┘
## PostgreSQL Structure
                
book_management=# SELECT * FROM books;
 id |   author    |     isbn      | published_date |                  title
----+-------------+---------------+----------------+------------------------------------------
  1 | Abdul Kadir | 9786230017513 | 2020-07-08     | Algoritma & Pemrograman Menggunakan Java
(1 row)


book_management=# SELECT * FROM books;
 id | author | isbn | published_date | title
----+--------+------+----------------+-------
(0 rows)