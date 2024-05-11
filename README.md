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
    git clone https://github.com/your_username/curd-items.git
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

## Screenshots

![ItemList](![1](https://github.com/MN10101/curd-items/assets/78208459/e4cb5e56-b578-40b1-99f5-5e1bf5f202d9))

![AddItem](screenshots/add_item.png)

## Author

[Your Name](https://github.com/your_username)

Feel free to contact me if you have any questions or suggestions.
