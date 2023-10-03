# SmallWebshop_JSP

This is a Java Enterprise web application for a simple online shop. The application uses a three-layer architecture, with a presentation layer (JSP), business logic layer (Java classes), and data access layer (JDBC for database access).

## Features

- Shopping cart functionality.
- User identification and authentication.
- Ability to add and view items in the shopping cart.

## Project Structure

The project is structured as follows:

- `bo`: This package contains Java classes for the business logic of the webshop.
- `Db`: Here, you'll find Java classes responsible for database access using JDBC.
- `ui`: This package contains servlets and controllers for handling user requests and interfacing with JSP pages.
- `webapp`: This directory includes JSP pages and static resources for the web interface.

## Architecture

This application follows a three-layer architecture:

- Presentation Layer: Implemented using JavaServer Pages (JSP) in the `webapp` directory.
- Business Logic Layer: Java classes in the `bo` package handle the business logic of the webshop.
- Data Access Layer: JDBC is used for database access, with Java classes in the `Db` package responsible for database interactions.

## Getting Started

To run this application, follow these steps:

1. Clone the repository to your local machine.
2. Configure your Apache Tomcat server in your IntelliJ IDEA project settings.
3. Set up your database and update the JDBC connection details in the appropriate Java classes.
4. Build and deploy the application to your Tomcat server.

## Database Configuration

You'll need to set up a database and create the necessary tables for products, users, and shopping carts. Update the JDBC connection URL, username, and password in the `Db` package Java classes to match your database configuration.

## Usage

- Access the application by opening it in a web browser.
- Browse products, add them to your shopping cart, and proceed to checkout.
- You can create an account or log in to track your shopping history and save your cart.

## Contributing

If you'd like to contribute to this project, please fork the repository and create a pull request. We welcome any contributions that enhance the functionality or improve the code quality.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Acknowledgments

- This project was created as part of a Java Enterprise lab exercise.
- Thanks to [IntelliJ IDEA](https://www.jetbrains.com/idea/) for providing a great development environment.
- Special thanks to our instructors and fellow students for their support and collaboration.

