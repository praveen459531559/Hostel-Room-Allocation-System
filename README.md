# Hostel Room Allocation System

A Data Structures based Hostel Room Allocation System developed using C, Java Swing, and Git/GitHub.

The system manages student records, hostel room allocation, room availability, and student operations through a graphical user interface connected to a C backend.

---

## 📌 Project Overview

The Hostel Room Allocation System is designed to simplify hostel room management by providing a centralized system for:

- Adding students
- Searching student records
- Updating student information
- Deleting student records
- Allocating hostel rooms
- Managing room availability
- Viewing room status
- Tracking hostel statistics

The project demonstrates the practical implementation of Data Structures and Algorithms in a real-world hostel management scenario.

---

## 🎯 Objectives

- Implement Data Structures in a practical application.
- Efficiently manage student records.
- Provide fast student searching using hashing.
- Manage student records using a linked list.
- Manage hostel room allocation and availability.
- Provide a user-friendly graphical interface.
- Demonstrate communication between Java and C.
- Store student data using file handling.

---

## 🧠 Data Structures Used

### 1. Linked List

A Singly Linked List is used to store and manage student records dynamically.

Operations implemented:

- Insertion
- Searching
- Updating
- Deletion
- Traversal

Each student record contains:

- Student ID
- Name
- Department
- Year
- Room Number

---

### 2. Hash Table

A Hash Table with Separate Chaining is used for efficient student ID searching.

Hash function:

studentID % TABLE_SIZE

Separate chaining is used to handle hash collisions.

---

### 3. Room Management

The hostel contains 20 rooms with a capacity of 2 students per room.

Total capacity: 40 students

Rooms are divided into two blocks:

F Block:
F-01 to F-10

G Block:
G-01 to G-10

The Room Management system tracks:

- Room number
- Room capacity
- Occupied beds
- Available beds
- Occupied rooms
- Available rooms

The system also checks room availability before allocating a student.

When a student is deleted, the allocated room bed is released.

---

## 🏗️ System Architecture

Java Swing GUI
        ↓
Backend Controller
        ↓
Process Builder
        ↓
C Backend
        ↓
Linked List + Hash Table + Room Manager
        ↓
File Storage

---

## ⚙️ Technologies Used

| Technology | Purpose |
|------------|---------|
| C | Backend and Data Structures |
| Java | GUI and application control |
| Java Swing | Graphical User Interface |
| ProcessBuilder | Java-C communication |
| File Handling | Persistent student data |
| Git | Version control |
| GitHub | Source code hosting |

---

## ✨ Features

### 🔐 Login System

The application provides a login screen before accessing the hostel management system.

Demo credentials:

Username: admin
Password: admin123

---

### 👨‍🎓 Student Management

#### Add Student

Allows the administrator to enter:

- Student ID
- Full Name
- Department
- Year
- Room Number

The system checks for duplicate student IDs and room availability.

#### Search Student

Searches for a student using Student ID.

The system displays:

- Student ID
- Name
- Department
- Year
- Room Number

#### Update Student

Allows modification of:

- Department
- Year
- Room allocation

#### Delete Student

Removes a student record and releases the student's allocated room bed.

---

### 🏠 Room Management

The Room Status section displays hostel room information including:

- Room number
- Capacity
- Occupancy
- Availability

The hostel contains:

- 20 rooms
- 2 beds per room
- 40 total beds

Room blocks:

- F Block: F-01 to F-10
- G Block: G-01 to G-10

---

### 📊 Dashboard

The dashboard displays hostel statistics such as:

- Total students
- Occupied beds
- Available beds
- Occupied rooms
- Available rooms

---

## 🔄 Java-C Communication

The Java application communicates with the C backend using Java's ProcessBuilder.

Communication flow:

Java Swing
    ↓
BackendController
    ↓
ProcessBuilder
    ↓
C Backend Executable
    ↓
Data Structures

Commands are exchanged between Java and C using structured text messages.

Example command:

ADD|24001|Praveen|CSE|2|F-01

Example backend response:

SUCCESS|Student added successfully

---

## 💾 Data Persistence

Student records are stored using file handling.

Data file:

c-backend/data/students.txt

Example record:

24001|Praveen|CSE|2|F-01
24002|Arun|ECE|2|F-02

The runtime data file is excluded from Git using .gitignore.

---

## 📂 Project Structure

DS_project/
│
├── .gitignore
├── README.md
│
├── c-backend/
│   ├── backend_main.c
│   ├── student.h
│   ├── student_list.c
│   ├── student_list.h
│   ├── hash_table.c
│   ├── hash_table.h
│   ├── room.c
│   ├── room.h
│   ├── file_handler.c
│   ├── file_handler.h
│   └── data/
│
├── java-gui/
│   └── src/
│       ├── Main.java
│       └── gui/
│           ├── Dashboard.java
│           ├── LoginPanel.java
│           ├── WelcomePanel.java
│           ├── NeoUI.java
│           ├── BackendController.java
│           ├── AddStudentPanel.java
│           ├── SearchStudentPanel.java
│           ├── UpdateStudentPanel.java
│           ├── DeleteStudentPanel.java
│           └── RoomStatusPanel.java
│
└── screenshots/

---

## ▶️ How to Run

### 1. Compile the C Backend

From the project root:

gcc c-backend\backend_main.c c-backend\student_list.c c-backend\hash_table.c c-backend\room.c c-backend\file_handler.c -o c-backend\hostel_backend.exe

### 2. Compile the Java GUI

Navigate to the Java source directory:

cd java-gui\src

Compile:

javac Main.java gui\*.java -d ..\out

### 3. Run the Application

From the java-gui directory:

cd ..

Run:

java -cp out Main

The Java application automatically starts the C backend using ProcessBuilder.

---

## 🖥️ Application Screenshots

Screenshots will be added here after capturing the application screens.

---

## 🔑 Key Concepts Demonstrated

This project demonstrates practical implementation of:

- Singly Linked Lists
- Hash Tables
- Separate Chaining
- Searching
- Insertion
- Deletion
- Updating
- File Handling
- Dynamic Memory Allocation
- Room Allocation
- Process Communication
- Java Swing GUI
- Object-Oriented Programming
- Git and GitHub

---

## 🔮 Future Improvements

Possible future enhancements include:

- Android mobile application
- Online database integration
- Student authentication
- Admin and student roles
- Hostel fee management
- Room transfer history
- Cloud-based data storage
- Advanced reporting and analytics
- Notification system

---

## 👨‍💻 Project Information

Project: Hostel Room Allocation System

Domain: Data Structures

Application Type: Desktop Application

Backend: C

Frontend: Java Swing

Version: 1.0.0

---

## 📜 License

This project is developed for academic and educational purposes.