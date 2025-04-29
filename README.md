# Bank Management System

## Overview

The Bank Management System is a Java-based desktop application that simulates basic banking operations. Built using Java Swing and backed by a MySQL database, the system allows users to register, log in, deposit/withdraw funds, and view recent transactions. This project is designed to demonstrate object-oriented programming, GUI development, and database integration.

---

## Features
- User Registration (multi-step signup process)
- Secure Login using Card Number and PIN
- Deposit and Withdraw Money
- Mini Statement (Recent Transaction History)
- GUI-based navigation using Java Swing
---

## Project Structure
```
Project_1_Bank_Management_Sys/
├── Additionals/                  # Fonts and other resources
├── src/                          # Java source code
│   └── bank/management/system/
│       ├── Final/                # Final application classes
│       └── ...                   # Other packages and classes
├── sql_dump/                     # SQL dump files for database setup
│   ├── banksystem_signup.sql
│   ├── banksystem_signup2.sql
│   ├── banksystem_signup3.sql
│   ├── banksystem_login.sql
│   ├── banksystem_deposit.sql
│   └── banksystem_routines.sql
├── Documentation.docx            # Project documentation
├── BMS.iml                       # IntelliJ module file
└── README.md                     # Project README
```

---

## Prerequisites
- Java JDK 8 or above
- MySQL Server (recommended: 5.7+)
- MySQL Workbench (optional)
- IntelliJ IDEA or any Java IDE
---

## Database Setup
1. Create a new database in MySQL:
```sql
CREATE DATABASE banksystem;
USE banksystem;
```
2. Import the SQL dump files located in the `sql_dump/` folder in the following order:

   - `banksystem_signup.sql`
   - `banksystem_signup2.sql`
   - `banksystem_signup3.sql`
   - `banksystem_login.sql`
   - `banksystem_deposit.sql`
   - `banksystem_routines.sql`
These can be imported using MySQL Workbench or executed manually via the terminal or any SQL client.
---

## Application Setup
1. Clone the repository:
```bash
git clone https://github.com/Hmmmmmmmmmmmmmmmmmmmmmmm/Project_1_Bank_Management_Sys.git
```
2. Open the project in your IDE (e.g., IntelliJ IDEA).
3. Configure the MySQL connection in the `ConnectionFinal.java` file:
```java
String url = "jdbc:mysql://localhost:3306/banksystem";
String username = "your_mysql_username";
String password = "your_mysql_password";
```
4. Ensure that MySQL Connector/J is added to the project’s classpath.
5. Build and run the application by executing `Main.java`.
---
## Dependencies
- Java Swing
- MySQL
- JDBC (MySQL Connector/J)
---

---

## Troubleshooting

- **MySQL connection issues**: Check that MySQL is running and credentials are correct in `ConnectionFinal.java`.
- **Missing tables**: Ensure all `.sql` files have been imported in correct order.
- **UI errors**: Verify that font and UI resources under `/Additionals` are correctly linked.

---

Author: Aftab Aqueel Khan

---

