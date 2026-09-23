#include <stdio.h>
#include <string.h>
#include "student_list.h"
#include "room.h"
#include "file_handler.h"

int main() {

    char command[20];

    // Initialize room system
    initializeRooms();

    // Load previously saved students
    loadStudents();

    /*
        Java will send commands through stdin.

        Examples:

        ADD|24001|Praveen|CSE|2|F-01
        SEARCH|24001
        UPDATE|24001|CSE|3|F-02
        DELETE|24001
        ROOMS
        SAVE
        EXIT
    */

    while (1) {

        if (fgets(command, sizeof(command), stdin) == NULL) {
            break;
        }

        // Remove newline
        command[strcspn(command, "\n")] = '\0';

        // EXIT
        if (strcmp(command, "EXIT") == 0) {

            saveStudents();

            printf("SUCCESS|Backend closed\n");
            fflush(stdout);

            break;
        }

        // SAVE
        else if (strcmp(command, "SAVE") == 0) {

            saveStudents();

            printf("SUCCESS|Data saved\n");
            fflush(stdout);
        }

        // ADD
        else if (strncmp(command, "ADD|", 4) == 0) {

            int id;
            int year;

            char name[50];
            char department[30];
            char room[20];

            int result =
                sscanf(
                    command,
                    "ADD|%d|%49[^|]|%29[^|]|%d|%19[^\n]",
                    &id,
                    name,
                    department,
                    &year,
                    room
                );

            if (result == 5) {

                addStudent(
                    id,
                    name,
                    department,
                    year,
                    room
                );

                saveStudents();

                printf(
                    "SUCCESS|Student added|%d\n",
                    id
                );

            }
            else {

                printf(
                    "ERROR|Invalid ADD command\n"
                );
            }

            fflush(stdout);
        }

        // SEARCH
        else if (strncmp(command, "SEARCH|", 7) == 0) {

            int id;

            if (sscanf(
                    command,
                    "SEARCH|%d",
                    &id
                ) == 1) {

                Student *temp =
                    getHead();

                int found = 0;

                while (temp != NULL) {

                    if (temp->studentID == id) {

                        printf(
                            "FOUND|%d|%s|%s|%d|%s\n",
                            temp->studentID,
                            temp->name,
                            temp->department,
                            temp->year,
                            temp->roomNumber
                        );

                        found = 1;

                        break;
                    }

                    temp = temp->next;
                }

                if (!found) {

                    printf(
                        "NOT_FOUND|Student not found\n"
                    );
                }

            }
            else {

                printf(
                    "ERROR|Invalid SEARCH command\n"
                );
            }

            fflush(stdout);
        }

        // UPDATE
        else if (strncmp(command, "UPDATE|", 7) == 0) {

            int id;
            int year;

            char department[30];
            char room[20];

            int result =
                sscanf(
                    command,
                    "UPDATE|%d|%29[^|]|%d|%19[^\n]",
                    &id,
                    department,
                    &year,
                    room
                );

            if (result == 4) {

                updateStudent(
                    id,
                    department,
                    year,
                    room
                );

                saveStudents();

                printf(
                    "SUCCESS|Student updated|%d\n",
                    id
                );

            }
            else {

                printf(
                    "ERROR|Invalid UPDATE command\n"
                );
            }

            fflush(stdout);
        }

        // DELETE
        else if (strncmp(command, "DELETE|", 7) == 0) {

            int id;

            if (sscanf(
                    command,
                    "DELETE|%d",
                    &id
                ) == 1) {

                deleteStudent(id);

                saveStudents();

                printf(
                    "SUCCESS|Student deleted|%d\n",
                    id
                );

            }
            else {

                printf(
                    "ERROR|Invalid DELETE command\n"
                );
            }

            fflush(stdout);
        }

        // ROOMS
        else if (strcmp(command, "ROOMS") == 0) {

            /*
                Temporary room display.

                We will later create a structured
                room response specifically for Java.
            */

            displayRooms();

            fflush(stdout);
        }

        // UNKNOWN COMMAND
        else {

            printf(
                "ERROR|Unknown command\n"
            );

            fflush(stdout);
        }
    }

    return 0;
}