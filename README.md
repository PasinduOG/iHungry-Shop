# iHungry Burger Shop Management System

A console-based Java application for managing burger orders in a restaurant. This system allows users to place orders, track customers, manage order status, and generate reports.

## 📋 Table of Contents

- [Features](#-features)
- [System Requirements](#-system-requirements)
- [Installation](#-installation)
- [Usage](#-usage)
- [Project Structure](#-project-structure)
- [Menu Options](#-menu-options)
- [Data Management](#-data-management)
- [Order Status](#-order-status)
- [Validation Rules](#-validation-rules)
- [Sample Data](#-sample-data)
- [Contributing](#-contributing)

## 🚀 Features

### Order Management
- **Place New Orders**: Add customer orders with automatic order ID generation
- **Search Orders**: Find specific orders by Order ID with enhanced validation
- **Update Orders**: Modify quantity and status of existing orders
- **View Orders**: Filter orders by status (Preparing, Delivered, Cancelled)

### Customer Management
- **Customer Registration**: Automatically register new customers
- **Customer Search**: Find customer details and order history with validation
- **Best Customer Analysis**: Identify top customers by total purchase value

### System Features
- **Automatic Order ID Generation**: Sequential burger order IDs (B0001, B0002, etc.)
- **Enhanced Input Validation**: Comprehensive validation for phone numbers and order IDs across all functions
- **Dynamic Data Storage**: Arrays that automatically expand as needed
- **Cross-platform Console Clearing**: Works on Windows and Unix-based systems
- **Error Prevention**: Robust validation prevents invalid data entry

## 💻 System Requirements

- **Java Development Kit (JDK)**: Version 8 or higher
- **Operating System**: Windows, macOS, or Linux
- **Memory**: Minimum 256MB RAM
- **Disk Space**: 10MB free space

## 📦 Installation

1. **Clone or Download the Repository**
   ```bash
   git clone <repository-url>
   cd iHungry-Shop
   ```

2. **Compile the Java File**
   ```bash
   javac IHungry.java
   ```

3. **Run the Application**
   ```bash
   java IHungry
   ```

## 🎯 Usage

When you start the application, you'll see the main menu with 7 options:

```
--------------------------------------------------------------
|                       iHungry Burger                       |
--------------------------------------------------------------

[1] Place Order		[2] Search Best Customer
[3] Search Order	[4] Search Customer
[5] View Orders		[6] Update Order Details
[7] Exit
```

Simply enter the number corresponding to your desired action and follow the prompts.

## 📁 Project Structure

```
iHungry-Shop/
│
├── IHungry.java       # Main source code file
├── IHungry.class      # Compiled Java class file  
├── README.md          # Project documentation
├── .gitignore         # Git ignore file (excludes .class files)
└── .git/              # Git repository folder
```

## 🍔 Menu Options

### 1. Place Order
- Generate automatic order ID
- Validate customer phone number (10 digits starting with 0)
- Handle new and returning customers
- Calculate total order value
- Confirm order before saving

### 2. Search Best Customer
- Display customers ranked by total purchase amount
- Show customer ID, name, and total spent
- Sorted in descending order of purchase value

### 3. Search Order
- Find orders by Order ID with **enhanced input validation**
- Display complete order details including status
- **Improved error handling** - validates order ID format before search
- Validate order ID format (B + 4 digits)
- Retry mechanism for invalid inputs

### 4. Search Customer
- Search by customer phone number
- Show customer information and order history
- Display all orders placed by the customer

### 5. View Orders
- **Delivered Orders**: View all completed orders
- **Preparing Orders**: View orders in preparation
- **Cancelled Orders**: View cancelled orders

### 6. Update Order Details
- Modify order quantity for non-delivered orders
- Change order status (Preparing → Delivered → Cancelled)
- Prevent updates to delivered/cancelled orders

## 💾 Data Management

The system uses in-memory arrays to store data:

- **Order IDs**: Automatically generated sequential IDs
- **Customer IDs**: 10-digit phone numbers
- **Customer Names**: String array for customer names
- **Order Quantities**: Integer array for burger quantities
- **Order Status**: Integer codes (0=Preparing, 1=Delivered, 2=Cancelled)

### Dynamic Array Management
Arrays automatically expand when new orders are placed using the `extendArray()` method.

## 📊 Order Status

| Status Code | Status Name | Description |
|-------------|-------------|-------------|
| 0 | Preparing | Order is being prepared |
| 1 | Delivered | Order has been delivered |
| 2 | Cancelled | Order has been cancelled |

## ✅ Validation Rules

### Customer ID (Phone Number)
- Must be exactly 10 digits
- Must start with '0'
- Must contain only numeric characters
- **Applied in**: Place Order, Search Customer, Update Order Details

### Order ID
- Must be exactly 5 characters
- Must start with 'B' or 'b'
- Last 4 characters must be numeric
- **Applied in**: Search Order, Update Order Details
- **Enhanced validation**: Prevents invalid searches and updates

## 📋 Sample Data

The system comes pre-loaded with sample data:

| Order ID | Customer ID | Name | Quantity | Status |
|----------|-------------|------|----------|--------|
| B0001 | 0702436642 | Pasindu | 2 | Preparing |
| B0002 | 0715518744 | Sawen | 3 | Delivered |
| B0003 | 0702436642 | Pasindu | 7 | Cancelled |
| B0004 | 0702345678 | Ravindu | 5 | Delivered |

**Burger Price**: Rs. 500.00 per burger

## 🔧 Key Constants

```java
final static double BURGERPRICE = 500;    // Price per burger
public static final int PREPARING = 0;    // Order status: Preparing
public static final int DELIVERED = 1;    // Order status: Delivered  
public static final int CANCELLED = 2;    // Order status: Cancelled
```

## 🎨 Features Highlights

- **User-Friendly Interface**: Clear menu options and prompts
- **Enhanced Error Handling**: Comprehensive input validation and error messages with retry mechanisms  
- **Data Persistence**: Maintains data throughout the session
- **Flexible Updates**: Allow modifications only for appropriate order states
- **Reporting**: Customer analysis and order filtering capabilities
- **Robust Input Validation**: Prevents invalid data entry across all system functions
- **Improved User Experience**: Better error messages and validation feedback

## 📝 Recent Updates

### Version Improvements
- **Enhanced Order Search**: Added input validation for Order ID in search functionality
- **Better Error Prevention**: Order search now validates ID format before attempting search
- **Improved Code Quality**: Added .gitignore file to exclude compiled class files from version control
- **Consistent Validation**: Standardized validation patterns across all input functions

## 🤝 Contributing

This is a coursework project. If you'd like to contribute improvements:

1. Fork the repository
2. Create a feature branch
3. Make your changes
4. Test thoroughly
5. Submit a pull request

## 📝 Notes

- This is a console-based application designed for educational purposes
- Data is stored in memory and will be lost when the application closes
- The system is designed to handle basic burger shop operations
- All monetary values are in Sri Lankan Rupees (Rs.)

## 🎓 Academic Context

This project is part of coursework for **ICD119** and demonstrates:
- Java programming fundamentals
- Array manipulation and dynamic resizing
- Input validation and error handling
- Console-based user interface design
- Basic business logic implementation
- Data organization and management

---

*Developed as part of ICD119 Coursework - Burger Shop Management System*
