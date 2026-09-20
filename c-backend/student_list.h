#ifndef STUDENT_LIST_H
#define STUDENT_LIST_H

#include "student.h"

void addStudent(int id, const char name[],
                const char department[], int year,
                const char roomNumber[]);

void displayStudents();

void searchStudent(int id);

void updateStudent(int id, const char newDepartment[],
                   int newYear, const char newRoomNumber[]);

void deleteStudent(int id);

void vacateRoom(int id);

#endif