#ifndef STUDENT_H
#define STUDENT_H

typedef struct Student {
    int studentID;
    char name[50];
    char department[30];
    int year;
    char roomNumber[20];

    struct Student *next;
} Student;

#endif