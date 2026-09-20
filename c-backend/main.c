#include <stdio.h>
#include "student_list.h"
#include "hash_table.h"
#include "room.h"

int main() {

    printf("===== HOSTEL ROOM ALLOCATION SYSTEM =====\n");

    initializeRooms();

    printf("\n--- ADD STUDENTS ---\n");

    addStudent(24001, "Praveen", "CSE", 2, "F-01");
    addStudent(24002, "Arun", "ECE", 2, "F-01");
    addStudent(24003, "Karthik", "CSE", 1, "F-02");

    printf("\n--- INITIAL STATUS ---\n");
    displayStudents();
    displayHashTable();
    displayRooms();

    printf("\n--- MOVE STUDENT 24001 ---\n");

    updateStudent(24001, "CSE", 2, "F-03");

    printf("\n--- AFTER MOVE ---\n");
    displayStudents();
    displayRooms();

    printf("\n--- VACATE STUDENT 24002 ---\n");

    vacateRoom(24002);

    printf("\n--- AFTER VACATING ---\n");
    displayStudents();
    displayRooms();

    printf("\n--- DELETE STUDENT 24003 ---\n");

    deleteStudent(24003);

    printf("\n--- FINAL STATUS ---\n");
    displayStudents();
    displayHashTable();
    displayRooms();

    return 0;
}