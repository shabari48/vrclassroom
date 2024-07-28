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
