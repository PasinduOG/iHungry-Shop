# 🍔 iHungry Burger Shop 🏪

A console-based Java application for managing burger orders in a restaurant. This system allows users to place orders, track customers, manage order status, and generate reports. 📊✨

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

## 🚀 Features ⭐

### 📋 Order Management
- **🆕 Place New Orders**: Add customer orders with automatic order ID generation
- **🔍 Search Orders**: Find specific orders by Order ID with enhanced validation
- **✏️ Update Orders**: Modify quantity and status of existing orders
- **👀 View Orders**: Filter orders by status (Delivered, Preparing, Cancelled)

### 👥 Customer Management
- **📝 Customer Registration**: Automatically register new customers
- **🔎 Customer Search**: Find customer details and order history with validation
- **🏆 Best Customer Analysis**: Identify top customers by total purchase value

### 🛠️ System Features
- **🎯 Automatic Order ID Generation**: Sequential burger order IDs (B0001, B0002, etc.)
- **✅ Enhanced Input Validation**: Comprehensive validation for phone numbers, order IDs, and quantities
- **📈 Dynamic Data Storage**: Arrays that automatically expand as needed
- **🖥️ Cross-platform Console Clearing**: Works on Windows and Unix-based systems
- **🛡️ Error Prevention**: Robust validation prevents invalid data entry
- **🏗️ Clean Architecture**: Streamlined code with improved maintainability
- **😊 Improved User Experience**: Better error messages and structured confirmation flows
- **👋 Graceful Exit**: Proper application termination with thank you message

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

## 🍔 Menu Options 🎮

### 1️⃣ Place Order 🆕
- 🎯 Generate automatic order ID
- 📞 Validate customer phone number (10 digits starting with 0)
- 👤 Handle new and returning customers
- 💰 Calculate total order value
- **✨ Enhanced confirmation flow** with retry options
- **🛡️ Improved error handling** for invalid confirmations
- **🧭 Better user guidance** with clear option prompts

### 2️⃣ Search Best Customer 🏆
- 📊 Display customers ranked by total purchase amount
- 👤 Show customer ID, name, and total spent
- 📈 Sorted in descending order of purchase value

### 3️⃣ Search Order 🔍
- 🎯 Find orders by Order ID with **enhanced input validation**
- 📄 Display complete order details including status
- **🛡️ Improved error handling** - validates order ID format before search
- ✅ Validate order ID format (B + 4 digits)
- 🔄 Retry mechanism for invalid inputs

### 4️⃣ Search Customer 👥
- 📞 Search by customer phone number
- ℹ️ Show customer information and order history
- 📋 Display all orders placed by the customer

### 5️⃣ View Orders 👀
- **✅ Delivered Orders**: View all completed orders
- **🍳 Preparing Orders**: View orders in preparation
- **❌ Cancelled Orders**: View cancelled orders

### 6️⃣ Update Order Details ✏️
- 🔢 Modify order quantity for non-delivered orders with **quantity validation**
- 🔄 Change order status (Cancelled ← Preparing → Delivered)
- 🚫 Prevent updates to delivered/cancelled orders
- **✅ Enhanced validation**: Ensures only positive quantities are accepted

## 💾 Data Management

The system uses in-memory arrays to store data:

- **Order IDs**: Automatically generated sequential IDs starting from B0001
- **Customer IDs**: 10-digit phone numbers
- **Customer Names**: String array for customer names
- **Order Quantities**: Integer array for burger quantities (with positive validation)
- **Order Status**: Integer codes (0=Cancelled, 1=Preparing, 2=Delivered)

### Dynamic Array Management
- **Initial State**: All arrays start empty for a fresh system experience
- **Runtime Population**: Data is added as users interact with the system
- **Automatic Expansion**: Arrays automatically expand when new orders are placed using the `extendArray()` method
- **Clean Start**: Each program execution begins with no pre-existing data

## 📊 Order Status 🏷️

| Status Code | Status Name | Description | Emoji |
|-------------|-------------|-------------|-------|
| 0 | ❌ Cancelled | Order has been cancelled | 🚫 |
| 1 | 🍳 Preparing | Order is being prepared | ⏳ |
| 2 | ✅ Delivered | Order has been delivered | 🎉 |

## ✅ Validation Rules 🔒

### 📞 Customer ID (Phone Number)
- 🔟 Must be exactly 10 digits
- 0️⃣ Must start with '0'
- 🔢 Must contain only numeric characters
- **🎯 Applied in**: Place Order, Search Customer, Update Order Details

### 🆔 Order ID
- 5️⃣ Must be exactly 5 characters
- 🅱️ Must start with 'B' or 'b'
- 🔢 Last 4 characters must be numeric
- **🎯 Applied in**: Search Order, Update Order Details
- **🛡️ Enhanced validation**: Prevents invalid searches and updates

### 🔢 Quantity Validation
- ➕ Must be a positive integer (greater than 0)
- **🎯 Applied in**: Update Order Quantity
- **🚫 Prevents**: Zero or negative quantity values

## 📋 Data Storage

The system uses empty arrays that dynamically populate as users add data:

- **Initial State**: All arrays start empty for a fresh system experience
- **Dynamic Growth**: Arrays automatically expand when new orders are placed
- **Runtime Data**: All customer and order information is entered during program execution
- **Fresh Start**: Each program run begins with a clean slate

**🍔 Burger Price**: Rs. 500.00 per burger 💰

## 🔧 Key Constants ⚙️

```java
final static double BURGERPRICE = 500;    // 🍔 Price per burger
public static final int CANCEL = 0;       // ❌ Order status: Cancelled
public static final int PREPARING = 1;    // 🍳 Order status: Preparing
public static final int DELIVERED = 2;    // ✅ Order status: Delivered
```

## 🎨 Features Highlights ⭐

- **👤 User-Friendly Interface**: Clear menu options and prompts
- **🛡️ Enhanced Error Handling**: Comprehensive input validation and error messages with retry mechanisms  
- **💾 Data Persistence**: Maintains data throughout the session
- **🔄 Flexible Updates**: Allow modifications only for appropriate order states
- **📊 Reporting**: Customer analysis and order filtering capabilities
- **🔒 Robust Input Validation**: Prevents invalid data entry across all system functions
- **😊 Improved User Experience**: Better error messages and validation feedback
- **🎯 Clean System Design**: Starts fresh with no pre-loaded data, building organically
- **🚀 Production Ready**: Suitable for real-world deployment with proper data validation

## 📝 Recent Updates 🆕

### 🎉 Version Improvements (Latest - September 2025)
- **🔧 Fixed Status Constants**: Corrected order status mapping (CANCEL=0, PREPARING=1, DELIVERED=2)
- **⚡ Enhanced Place Order Flow**: Improved confirmation process with better error handling
- **📋 Proper Array Initialization**: Standardized empty array initialization syntax
- **👋 Better Exit Functionality**: Added graceful application termination with thank you message
- **😊 Improved User Experience**: Enhanced error messages and structured confirmation flows
- **🔄 Code Consistency**: Fixed all status-related functions to use correct constants

### Previous Updates
- **Clean Architecture**: Removed sample data for a fresh system experience
- **Enhanced Quantity Validation**: Added positive number validation for order quantity updates
- **Code Optimization**: Cleaned up inline comments and improved code readability
- **Production Ready**: System now starts with empty arrays, ready for real-world use
- **Enhanced Order Search**: Added input validation for Order ID in search functionality
- **Better Error Prevention**: Order search now validates ID format before attempting search
- **Improved Code Quality**: Added .gitignore file to exclude compiled class files from version control

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

## 🔄 Object-Oriented Refactor ⚡

This program now uses an object-oriented approach for managing orders. All order data is encapsulated in a `Customer` class, and a single `Customer[]` array is used to store all orders, replacing the previous parallel arrays. 🎯

### 🔑 Key Changes
- ➕ Added a `Customer` class with fields: `orderId`, `customerId`, `name`, `quantity`, and `orderStatus`.
- 🔄 All order management logic now uses the `Customer` object array.
- 🛠️ Methods for placing, searching, updating, and viewing orders have been refactored to use the new class structure.

### 🎉 Benefits
- 📈 Improved code maintainability and readability
- ➕ Easier to add new features or fields
- 🔒 Data is better encapsulated and managed
- 🏗️ Follows proper object-oriented programming principles

## 🚀 Usage
Run the program as before. All functionality remains the same, but the code is now cleaner and more robust. ✨
