#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "student_list.h"
#include "hash_table.h"
#include "room.h"

Student *head = NULL;

void addStudent(int id, const char name[],
                const char department[], int year,
                const char roomNumber[]) {

    // Check for duplicate Student ID
    Student *check = head;

    while (check != NULL) {
        if (check->studentID == id) {
            printf("Student ID %d already exists.\n", id);
            return;
        }

        check = check->next;
    }

    // Check room availability
    if (!isRoomAvailable(roomNumber)) {
        printf("Room %s is not available.\n", roomNumber);
        return;
    }

    // Create new student node
    Student *newNode = (Student *)malloc(sizeof(Student));

    if (newNode == NULL) {
        printf("Memory allocation failed!\n");
        return;
    }

    // Store student details
    newNode->studentID = id;
    strcpy(newNode->name, name);
    strcpy(newNode->department, department);
    newNode->year = year;
    strcpy(newNode->roomNumber, roomNumber);
    newNode->next = NULL;

    // Allocate room
    allocateRoom(roomNumber);

    // Add to linked list
    if (head == NULL) {
        head = newNode;
    }
    else {
        Student *temp = head;

        while (temp->next != NULL) {
            temp = temp->next;
        }

        temp->next = newNode;
    }

    // Add same student to hash table
    insertHash(newNode);

    printf("Student %d added successfully.\n", id);
}
void displayStudents() {

    Student *temp = head;

    if (temp == NULL) {
        printf("No students found.\n");
        return;
    }

    printf("\n--- Student Details ---\n\n");

    while (temp != NULL) {

        printf("Student ID : %d\n", temp->studentID);
        printf("Name       : %s\n", temp->name);
        printf("Department : %s\n", temp->department);
        printf("Year       : %d\n", temp->year);
        printf("Room       : %s\n", temp->roomNumber);

        printf("------------------------\n\n");

        temp = temp->next;
    }
}
void searchStudent(int id) {

    Student *temp = head;

    while (temp != NULL) {

        if (temp->studentID == id) {

            printf("\n--- Student Found ---\n");
            printf("Student ID : %d\n", temp->studentID);
            printf("Name       : %s\n", temp->name);
            printf("Department : %s\n", temp->department);
            printf("Year       : %d\n", temp->year);
            printf("Room       : %s\n", temp->roomNumber);

            return;
        }

        temp = temp->next;
    }

    printf("\nStudent with ID %d not found.\n", id);
}
void updateStudent(int id, const char newDepartment[],
                   int newYear, const char newRoomNumber[]) {

    Student *temp = head;

    while (temp != NULL) {

        if (temp->studentID == id) {

            // Check whether the room is actually being changed
            if (strcmp(temp->roomNumber, newRoomNumber) != 0) {

                // Check whether the new room is available
                if (!isRoomAvailable(newRoomNumber)) {
                    printf("Room %s is not available.\n",
                           newRoomNumber);
                    return;
                }

                // Save old room
                char oldRoom[20];
                strcpy(oldRoom, temp->roomNumber);

                // Vacate old room
                if (strcmp(oldRoom, "NOT ALLOCATED") != 0) {
                    vacateRoomByNumber(oldRoom);
                }

                // Allocate new room
                allocateRoom(newRoomNumber);

                // Update student's room
                strcpy(temp->roomNumber, newRoomNumber);
            }

            // Update other student details
            strcpy(temp->department, newDepartment);
            temp->year = newYear;

            printf("Student %d updated successfully.\n", id);

            return;
        }

        temp = temp->next;
    }

    printf("Student %d not found.\n", id);
}
void deleteStudent(int id) {

    Student *temp = head;
    Student *prev = NULL;

    while (temp != NULL) {

        if (temp->studentID == id) {

            // Save room before deleting student
            char oldRoom[20];
            strcpy(oldRoom, temp->roomNumber);

            // Remove from hash table
            deleteHash(id);

            // Vacate student's room
            if (strcmp(oldRoom, "NOT ALLOCATED") != 0) {
                vacateRoomByNumber(oldRoom);
            }

            // Remove from linked list
            if (prev == NULL) {
                head = temp->next;
            }
            else {
                prev->next = temp->next;
            }

            free(temp);

            printf("Student %d deleted successfully.\n", id);
            return;
        }

        prev = temp;
        temp = temp->next;
    }

    printf("Student %d not found.\n", id);
}
void vacateRoom(int id) {

    Student *temp = head;

    while (temp != NULL) {

        if (temp->studentID == id) {

            // Check whether the student has a room
            if (strcmp(temp->roomNumber, "NOT ALLOCATED") == 0) {
                printf("Student %d has no allocated room.\n", id);
                return;
            }

            // Store the current room number
            char oldRoom[20];
            strcpy(oldRoom, temp->roomNumber);

            // Vacate the room
            if (vacateRoomByNumber(oldRoom)) {

                // Update student's room
                strcpy(temp->roomNumber, "NOT ALLOCATED");

                printf("Student %d's room %s has been vacated.\n",
                       id, oldRoom);
            }

            return;
        }

        temp = temp->next;
    }

    printf("Student %d not found.\n", id);
}