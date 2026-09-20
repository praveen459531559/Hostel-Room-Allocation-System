#include <stdio.h>
#include "student_list.h"
#include "hash_table.h"
#include "room.h"
#include "file_handler.h"

int main() {

    printf("===== FILE LOADING TEST =====\n");

    // Initialize rooms before loading students
    initializeRooms();

    printf("\n--- LOADING SAVED DATA ---\n");

    loadStudents();

    printf("\n--- LOADED STUDENTS ---\n");
    displayStudents();

    printf("\n--- HASH TABLE ---\n");
    displayHashTable();

    printf("\n--- ROOM STATUS ---\n");
    displayRooms();

    return 0;
}