﻿# currency-converter
# How to Run It  

1. **Clone the repository**:  
   - Run the following commands in your terminal:  
     ```
     git clone <repository-url>  
     cd <repository-name>
     ```

2. **Set up your environment variables**:  
   - Create a `.env` file inside the `src/main/resources` directory.  
   - Add the following environment variable:  
     ```
     EXCHANGE_API_KEY=<your-exchange-rate-api-key>
     ```

3. **Build the project**:  
   - Ensure you have Maven installed.  
   - Run the following command to build the project:  
     ```
     mvn clean install
     ```

4. **Run the application**:  
   - Navigate to the `target` directory where the JAR file is created:  
     ```
     cd target
     ```
   - Execute the application using the following command:  
     ```
     java -jar <your-jar-file-name>.jar
     ```
     Replace `<your-jar-file-name>` with the name of the generated JAR file (e.g., `currency-converter-1.0-SNAPSHOT.jar`).

**NOTE: If for some reasone you are unable to run it through commands do it with the inbuild button of your IDE**

5. **Test the currency menu**:  
   - Once the application is running, you can use the menu utility to see all available currency conversion rates in a paginated and alphabetical format.  
   - Use the numbers displayed in the menu to select your desired options.  

6. **Exit**:  
   - Select the `Exit` option in the menu when you are done.  

---

# Features  

1. **Exchange Rate API Integration**:  
   - Automatically fetches the latest exchange rates using `HttpClient` with the API key stored in an `.env` file.  
   - Configured with Gson for seamless JSON parsing.  

2. **Hexagonal Architecture**:  
   - Domain layer with entities and service interfaces.  
   - Application layer containing service implementations.  
   - Infrastructure layer for API communication.  

3. **Interactive Currency Conversion Menu**:  
   - Displays available currencies in alphabetical order.  
   - Paginated menu showing 10 options per page, with `Next`, `Previous`, and `Exit` options for easy navigation.  
   - Supports selecting currencies by typing a number.  

4. **Robust Input Handling**:  
   - Prevents invalid inputs and gracefully handles edge cases such as negative values or non-numeric input.  

5. **Environment Variable Management**:  
   - Uses the `dotenv-java` library to securely load the API key from a `.env` file located in the `src/main/resources` directory.  

6. **Scalable Design**:  
   - Designed to support additional features like adding new API endpoints or extending the menu utility.  

---

# How to Contribute  

We welcome contributions to improve this project! Follow the steps below to contribute:  

1. **Fork the repository**:  
   - Click the `Fork` button at the top of this repository to create your own fork.  

2. **Clone your fork**:  
   - Run the following commands in your terminal:  
     ```
     git clone <your-forked-repository-url>  
     cd <repository-name>
     ```

3. **Set up the development environment**:  
   - Ensure you have Maven installed.  
   - Set up the `.env` file in `src/main/resources` with your own API key:  
     ```
     EXCHANGE_API_KEY=<your-api-key>
     ```

4. **Create a new branch**:  
   - Use a descriptive branch name for your feature or fix:  
     ```
     git checkout -b feature/<feature-name>
     ```

5. **Make your changes**:  
   - Implement your changes in the appropriate layers following the hexagonal architecture.  
   - Ensure your code is well-documented and formatted.  

6. **Test your changes**:  
   - Run the application and ensure all features work as expected.  
   - Use the interactive menu to verify functionality.  

7. **Commit and push your changes**:  
   - Run the following commands:  
     ```
     git add .  
     git commit -m "Describe your changes"  
     git push origin feature/<feature-name>
     ```

8. **Create a pull request**:  
   - Open a pull request from your branch to the main repository's `main` branch.  
   - Provide a clear description of your changes and their purpose.  

9. **Collaborate**:  
   - Address any comments or requested changes from reviewers.  

10. **Celebrate**:  
    - Once your pull request is merged, your contribution is part of the project!  

### Guidelines  
- Follow the project's coding standards.  
- Write clear and concise commit messages.  
- Document any new features in the `README.md`.  
- Ensure all new code is thoroughly tested.  
