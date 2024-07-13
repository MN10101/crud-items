# CRUD Items Application

This is a simple Spring Boot application for managing inventory items. It provides basic CRUD (Create, Read, Update, Delete) operations for inventory items.

## Technologies Used

- Java
- Spring Boot
- Thymeleaf
- MySQL

## Setup Instructions

1. **Clone the repository**

    ```bash
    git clone https://github.com/MN10101/crud-items
    ```

2. **Database Configuration**

    - Create a MySQL database with the name `itemsdb`.
    - Update `application.properties` file in `src/main/resources` with your MySQL username and password.
    
    ```properties
    spring.application.name=curd-items
    
    spring.datasource.url=jdbc:mysql://localhost:3306/itemsdb
    
    spring.datasource.username=your_username
    spring.datasource.password=your_password
    
    spring.jpa.hibernate.ddl-auto=update
    ```

3. **Run the application**

    ```bash
    mvn spring-boot:run
    ```

4. **Access the application**

    Open your web browser and navigate to [http://localhost:8080/items/get](http://localhost:8080/items/get) to access the application.

## Usage

- **List all items:** [http://localhost:8080/items/get](http://localhost:8080/items/get)
- **Add a new item:** [http://localhost:8080/items/addItem](http://localhost:8080/items/addItem)
- **Update an item:** Click on the "Update" button next to the item you want to update.
- **Delete an item:** Click on the "Delete" button next to the item you want to delete.


## Author

[Mahmoud Najmeh](https://mn10101.github.io/portfolio-mn/)


## Screenshots

![1](https://github.com/MN10101/curd-items/assets/78208459/e617ffcb-c7b2-4f02-be65-5ece6d753cc9)

![2](https://github.com/MN10101/curd-items/assets/78208459/e7e15608-f017-4178-8dc4-5f31b89ed486)

![3](https://github.com/MN10101/curd-items/assets/78208459/8c40b58a-7b75-4c8d-9b53-b4404fedc810)
