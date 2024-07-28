# Exercise 1 
# Design Patterns

## 1. Creational Patterns

### 1.1 Factory Pattern

**Definition:** Creates objects without specifying the exact class to create.

**Use Case:** "Flexible Payment Processing System"

**Description:** Defines a PaymentGateway interface with concrete implementations. A PaymentGatewayFactory creates appropriate objects based on user input.

**How it works:** User selects a payment method, factory creates the corresponding object, which processes the payment.

### 1.2 Singleton Pattern

**Definition:** Ensures a class has only one instance with global access.

**Use Case:** "Global In-Memory Cache Management"

**Description:** Implements a Cache class with private constructor and static instance. Provides methods for data storage and retrieval.

**How it works:** getInstance() method returns the single instance, allowing global access to the cache.

## 2. Behavioral Patterns

### 2.1 Observer Pattern

**Definition:** Defines a subscription mechanism to notify multiple objects about events.

**Use Case:** "Real-time YouTube Video Upload Notification System"

**Description:** Defines Observer and Subject interfaces. YouTubeChannel notifies Subscribers of new uploads.

**How it works:** Subscribers register with a channel. When a new video is uploaded, all subscribers are notified.

### 2.2 State Pattern

**Definition:** Allows an object to alter its behavior when its internal state changes.

**Use Case:** "Dynamic Vending Machine Operation Management"

**Description:** Defines different states for a vending machine, each implementing a common State interface.

**How it works:** VendingMachine delegates operations to its current state object, which changes based on actions performed.

## 3. Structural Patterns

### 3.1 Adapter Pattern

**Definition:** Allows objects with incompatible interfaces to collaborate.

**Use Case:** "Unified Music Playback System for Multiple Audio Formats"

**Description:** Creates adapters for different music sources (VinylRecord, DigitalAudioFile) to conform to a StandardTrack interface.

**How it works:** Adapters wrap specific music sources, translating method calls to the common interface.

### 3.2 Composite Pattern

**Definition:** Composes objects into tree structures to represent part-whole hierarchies.

**Use Case:** "Hierarchical File System Structure Management"

**Description:** Defines a common FileSystemComponent interface for both File and Directory classes.

**How it works:** Directories can contain files and other directories, allowing for a nested structure treated uniformly.

These patterns provide solutions to common software design problems, promoting code reusability, flexibility, and maintainability.


# Exercise 2
# Virtual Classroom Manager

A simple command-line application for managing virtual classrooms, students, and assignments.

## Table of Contents
- [Overview](#overview)
- [Features](#features)
- [Classes](#classes)
  - [Main](#main)
  - [ClassroomManager](#classroommanager)
  - [Classroom](#classroom)
  - [Student](#student)
  - [Assignment](#assignment)
- [Commands](#commands)
- [Logging](#logging)

## Overview
The Virtual Classroom Manager is a Java-based application designed to simplify the management of virtual classrooms, students, and assignments. It provides a command-line interface for users to interact with the system, performing actions such as adding classrooms, enrolling students, scheduling assignments, and submitting assignments.

## Features
- Add classrooms with unique names
- Enroll students in specific classrooms
- Schedule assignments for classrooms
- Submit assignments for students in specific classrooms
- Log all system activities to a file

## Classes

### Main

- `main(String[] args)`: The entry point of the program. Sets up the logger, prints welcome messages, provides a list of available commands, and enters a loop to prompt the user for commands and execute them.
- `setupLogger()`: Sets up the logger for the application. Creates a `FileHandler` to log messages to a file named `virtual_classroom.log`, sets up a `SimpleFormatter` to format the log messages, and adds the logger to the `FileHandler`.
- `addClassroom(String name)`: Adds a classroom with the given name using the `ClassroomManager` and prints a message to the console.
- `addStudent(String studentId, String className)`: Adds a student to a classroom using the `ClassroomManager` and prints a message to the console.
- `scheduleAssignment(String className, String assignmentDetails)`: Schedules an assignment for a classroom using the `ClassroomManager` and prints a message to the console.
- `submitAssignment(String studentId, String className, String assignmentDetails)`: Submits an assignment for a student in a classroom using the `ClassroomManager` and prints a message to the console.

### ClassroomManager

- `getInstance()`: Returns the singleton instance of `ClassroomManager`.
- `addClassroom(String name)`: Adds a new `Classroom` with the given name. Throws an `IllegalArgumentException` if the name is empty or already exists.
- `enrollStudent(String studentId, String studentName, String classroomName)`: Enrolls a `Student` in a `Classroom`. Throws an `IllegalArgumentException` if the classroom does not exist.
- `scheduleAssignment(String classroomName, String assignmentName, String assignmentDetails)`: Schedules an `Assignment` for a given classroom. Throws an `IllegalArgumentException` if the classroom does not exist.
- `submitAssignment(String studentId, String classroomName, String assignmentName)`: Submits an `Assignment` for a student in a classroom. Throws an `IllegalArgumentException` if the classroom or assignment does not exist, or if the student is not enrolled in the classroom.

### Classroom

- `Classroom(String name)`: Constructor that initializes the name of the classroom and empty lists for students and assignments.
- `getName()`: Returns the name of the classroom.
- `addStudent(Student student)`: Adds a student to the classroom. Throws an exception if the student with the same ID is already enrolled.
- `listStudents()`: Returns an unmodifiable list of all students in the classroom.
- `addAssignment(Assignment assignment)`: Adds an assignment to the classroom if it does not already exist. Throws an exception if the assignment already exists.
- `listAssignments()`: Returns an unmodifiable list of all assignments in the classroom.

### Student

- `Student(String id, String name)`: Constructor that initializes the student's ID and name.
- `getId()`: Returns the ID of the student.
- `getName()`: Returns the name of the student.

### Assignment

- `Assignment(String name, String details)`: Constructor that initializes the assignment's name and details.
- `getName()`: Returns the name of the assignment.
- `getDetails()`: Returns the details of the assignment.

## Commands

The following commands are available:

- `add_classroom <class_name>`: Add a new classroom with the specified name
- `add_student <student_id> <class_name>`: Add a new student to the specified classroom
- `schedule_assignment <class_name> <assignment_details>`: Schedule a new assignment for the specified classroom
- `submit_assignment <student_id> <class_name> <assignment_details>`: Submit an assignment for the specified student and classroom
- `exit`: Exit the application

## Logging

All system activities are logged to a file named `virtual_classroom.log` in the project directory. The log file is created automatically when the application starts. The logger logs messages at different levels, such as info, warning, and severe.
