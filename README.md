# 🍔 iHungry Burger Shop 🏪

A comprehensive console-based Java application for managing burger orders in a restaurant. This system provides complete order management, customer tracking, status updates, and detailed reporting capabilities. 📊✨

## 📋 Table of Conte### ✅ Latest Fixes (September 2025)
- **🔧 Status Mapping Fixed**: ### 🏗️ Architecture Design
- **📊 Parallel Arrays**: Uses 5 synchronized arrays for data relationships
- **🎯 Index Management**: Maintains data consistency through coordinated array operations
- **📈 Dynamic Scaling**: Arrays expand automatically as orders are added
- **💾 Memory Efficiency**: Suitable for typical restaurant order volumes

### 🔧 Technical Implementation
- **✅ Status System Fixed**: UI properly maps to status constants
- **📝 Message Accuracy**: Success messages correctly reference updated fields
- **🛡️ Input Validation**: Comprehensive checking prevents invalid data entry
- **🔄 Error Handling**: Retry mechanisms for user input corrections

### 🎯 Performance Characteristics
- **⚡ Search Operations**: Linear search (O(n)) suitable for expected data volumes
- **📊 Memory Usage**: Efficient array-based storage with minimal overhead
- **🖥️ Cross-Platform**: Console clearing works on Windows, macOS, and Linux
- **⏱️ Response Time**: Immediate response for typical restaurant operationscorrectly align with status constants
- **📝 Success Messages Corrected**: Status updates display proper success messages
- **🎯 Code Consistency**: All status-related functions use correct mappings

- [✨ Features](#-features)
- [💻 System Requirements](#-system-requirements)
- [📦 Quick Start](#-quick-start)
- [🎮 How to Use](#-how-to-use)
- [📁 Project Structure](#-project-structure)
- [🍔 Menu Options](#-menu-options)
- [💾 Data Architecture](#-data-architecture)
- [📊 Order Status System](#-order-status-system)
- [🔒 Validation & Security](#-validation--security)
- [🎯 Current Status & Updates](#-current-status--updates)
- [🛠️ Development Notes](#️-development-notes)
- [🎓 Academic Information](#-academic-information)

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

## 📦 Quick Start

### Installation & Setup
```bash
# 1. Clone or download the repository
git clone https://github.com/PasinduOG/iHungry-Shop.git
cd iHungry-Shop

# 2. Compile the application
javac IHungry.java

# 3. Run the program
java IHungry
```

### 🚀 First Launch
Upon starting, you'll see the main menu interface:

```
--------------------------------------------------------------
|                       iHungry Burger                       |
--------------------------------------------------------------

[1] Place Order          [2] Search Best Customer
[3] Search Order         [4] Search Customer  
[5] View Orders          [6] Update Order Details
[7] Exit

Enter an option to continue >
```

## 🎮 How to Use

### Getting Started
1. **📋 Start Fresh**: Each session begins with empty data
2. **🆕 Place Orders**: Begin by adding some orders (Option 1)
3. **🔍 Explore Features**: Use search and view options to see your data
4. **✏️ Manage Orders**: Update quantities and status as needed
5. **📊 Generate Reports**: View best customers and order analytics

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

## 💾 Data Architecture

### Current Implementation
The system uses **parallel arrays** for data storage - a structured approach where related data is stored across multiple synchronized arrays:

```java
public static String[] orderIdArray = new String[0];    // Order IDs (B0001, B0002...)
public static String[] customerIdArray = new String[0]; // Phone numbers (10 digits)
public static String[] nameArray = new String[0];       // Customer names
public static int[] qtyArray = new int[0];              // Burger quantities
public static int[] orderStatusArray = new int[0];      // Status codes (0,1,2)
```

### Data Flow & Management
- **📊 Synchronized Arrays**: All arrays maintain the same index relationships
- **📈 Dynamic Expansion**: Arrays automatically grow using `extendArray()` method
- **🎯 Index Consistency**: Each order occupies the same index across all arrays
- **💾 Runtime Storage**: All data exists only in memory during program execution
- **🔄 Fresh Sessions**: Each restart begins with empty arrays

### Key Data Elements
- **🆔 Order IDs**: Auto-generated sequential format (B0001, B0002, B0003...)
- **📞 Customer IDs**: 10-digit phone numbers starting with '0'
- **👤 Customer Names**: String identifiers for each customer
- **🍔 Quantities**: Positive integers representing burger counts
- **📊 Status Codes**: Integer values (0=Cancelled, 1=Preparing, 2=Delivered)

## 📊 Order Status System

### Status Codes & Constants
```java
public static final int CANCEL = 0;       // ❌ Cancelled orders
public static final int PREPARING = 1;    // 🍳 Orders being prepared  
public static final int DELIVERED = 2;    // ✅ Completed orders
```

### Status Reference Table
| Code | Status | Description | UI Display | Emoji |
|------|--------|-------------|------------|-------|
| 0 | ❌ **Cancelled** | Order has been cancelled | `(0)Cancel` | 🚫 |
| 1 | 🍳 **Preparing** | Order is being prepared | `(1)Preparing` | ⏳ |
| 2 | ✅ **Delivered** | Order completed & delivered | `(2)Delivered` | 🎉 |

### Status Workflow
```
🆕 New Order → 🍳 Preparing → ✅ Delivered
      ↓
   ❌ Cancelled (can occur from Preparing state)
```

### ✅ Status Management (Fixed)
- **Consistent Mapping**: UI options now correctly align with status constants
- **Clear Labeling**: Status update interface shows accurate descriptions
- **Proper Messaging**: Success messages correctly reference "status" updates
- **Workflow Control**: Orders can only be updated when in appropriate states

## 🔒 Validation & Security

### 📞 Customer ID Validation (Phone Numbers)
```java
// Validation Rules
- Length: Exactly 10 digits
- Format: Must start with '0'  
- Content: Only numeric characters (0-9)
- Example: 0712345678 ✅  |  712345678 ❌  |  07123456789 ❌
```
**Applied in**: Place Order, Search Customer, Update Order Details

### 🆔 Order ID Validation
```java
// Validation Rules  
- Length: Exactly 5 characters
- Format: 'B' or 'b' followed by 4 digits
- Content: B + 4 numeric characters
- Example: B0001 ✅  |  b0123 ✅  |  A0001 ❌  |  B001 ❌
```
**Applied in**: Search Order, Update Order Details

### � Quantity Validation
```java
// Validation Rules
- Range: Positive integers only (> 0)
- Type: Integer values
- Limits: No upper bound (reasonable portions expected)
- Example: 5 ✅  |  0 ❌  |  -2 ❌  |  3.5 ❌
```
**Applied in**: Place Order, Update Order Quantity

### �️ Input Security Features
- **Real-time Validation**: Immediate feedback on invalid inputs
- **Retry Mechanisms**: Users can correct errors without restarting
- **Format Guidance**: Clear examples provided for expected formats
- **Error Prevention**: Invalid data rejected before processing
- **Boundary Checking**: Prevents array overflow and data corruption

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

### 🎉 Version Status (Latest - September 2025)
- **� Code Review Completed**: Identified architectural and technical issues
- **📋 Documentation Updated**: README now accurately reflects current implementation
- **⚠️ Issues Documented**: Known bugs and limitations clearly listed
- **�️ Roadmap Created**: Future improvement plan established
- **� Status Mapping Issue**: UI inconsistency in order status updates identified
- **🏗️ Architecture Analysis**: Parallel arrays vs OOP approach documented

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

## �️ Troubleshooting 🔧

### Common Issues
1. **Status Update Confusion**: When updating order status, note that option numbers match the actual status codes
2. **Resource Warnings**: IDE may show Scanner resource leak warnings - these don't affect functionality
3. **Array Performance**: Large datasets may experience slower performance due to array copying
4. **Memory Usage**: All data stored in memory - restart clears all information

### Best Practices
- **🔢 Enter Valid Data**: Follow validation prompts carefully
- **💾 Regular Testing**: Test with small datasets first
- **🔄 Status Updates**: Double-check status changes before confirming
- **📱 Input Format**: Ensure phone numbers start with 0 and are exactly 10 digits

## �📝 Notes

- This is a console-based application designed for educational purposes
- Data is stored in memory and will be lost when the application closes
- The system is designed to handle basic burger shop operations
- All monetary values are in Sri Lankan Rupees (Rs.)
- Current version uses parallel arrays (future versions will implement OOP design)

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

## 🛠️ Development Notes

### 🔧 Technical Issues
- **📊 Parallel Arrays**: Current implementation uses 5 separate arrays instead of object-oriented design
- **🔄 Status Code Mismatch**: UI displays incorrect mapping for order status updates
- **📝 Message Error**: Status update shows "quantity" success message instead of "status"
- **💾 Resource Leaks**: Scanner objects not properly closed
- **⚡ Performance**: Inefficient array extension method for large datasets
- **🔒 Limited Validation**: Some edge cases in input validation need improvement

### 🎯 Future Improvements (Roadmap)
- **🏗️ OOP Conversion**: Convert to Customer class with object array
- **📱 Collections Framework**: Replace arrays with ArrayList/HashMap
- **🛡️ Better Error Handling**: Enhanced exception management
- **� Data Persistence**: File-based data storage
- **🎨 UI Enhancement**: Improved user interface design
- **⚡ Performance Optimization**: Better algorithms for search and sort operations

### � Current Implementation Status
- **🟢 Fully Operational**: All features working as intended
- **✅ Issues Resolved**: Status mapping and messaging fixed  
- **🛡️ Robust Validation**: Comprehensive input checking implemented
- **🎯 Production Ready**: Suitable for real burger shop deployment

---

## 💡 Usage Tips

### 🚀 Getting Maximum Value
1. **Start Simple**: Place a few orders to understand the workflow
2. **Test Features**: Try searching, updating, and viewing orders
3. **Explore Analytics**: Use "Search Best Customer" for insights
4. **Practice Updates**: Modify quantities and status to see state management

### 🎯 Best Practices
- **📱 Valid Formats**: Always use correct phone number and order ID formats
- **🔄 Status Flow**: Follow logical order progression (Preparing → Delivered)
- **💾 Session Planning**: Remember data resets between sessions
- **🛡️ Input Care**: Double-check entries before confirming

### Recommended Refactor (Future)
```java
// Proposed Customer class approach
class Customer {
    private String orderId;
    private String customerId;
    private String name;
    private int quantity;
    private int orderStatus;
    // Constructor, getters, setters...
}

public static Customer[] customers = new Customer[0];
// Or better: public static ArrayList<Customer> customers = new ArrayList<>();
```

## 🚀 Usage
Run the program as normal. All core functionality works correctly despite the architectural limitations mentioned above. ✨
