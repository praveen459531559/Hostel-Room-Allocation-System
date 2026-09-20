#include <stdio.h>
#include "file_handler.h"
#include "student_list.h"

void saveStudents() {
FILE *file = fopen("c-backend/data/students.txt", "w");
    if (file == NULL) {
        printf("Error: Could not open students.txt for writing.\n");
        return;
    }

    Student *temp = getHead();

    while (temp != NULL) {

        fprintf(file, "%d|%s|%s|%d|%s\n",
                temp->studentID,
                temp->name,
                temp->department,
                temp->year,
                temp->roomNumber);

        temp = temp->next;
    }

    fclose(file);

    printf("Student data saved successfully.\n");
}
void loadStudents() {

    FILE *file = fopen("c-backend/data/students.txt", "r");

    if (file == NULL) {
        printf("No saved student data found.\n");
        return;
    }

    int id;
    char name[50];
    char department[30];
    int year;
    char roomNumber[20];

    while (fscanf(file, "%d|%49[^|]|%29[^|]|%d|%19[^\n]\n",
                  &id,
                  name,
                  department,
                  &year,
                  roomNumber) == 5) {

        addStudent(id, name, department, year, roomNumber);
    }

    fclose(file);

    printf("Student data loaded successfully.\n");
}