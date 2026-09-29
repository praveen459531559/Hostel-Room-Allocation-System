#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#include "student.h"
#include "student_list.h"
#include "hash_table.h"
#include "room.h"
#include "file_handler.h"


/* =========================================================
   Find student by ID
   ========================================================= */

Student *findStudentByID(int id) {

    Student *temp = getHead();

    while (temp != NULL) {

        if (temp->studentID == id) {
            return temp;
        }

        temp = temp->next;
    }

    return NULL;
}


/* =========================================================
   MAIN BACKEND
   ========================================================= */

int main() {

    char command[300];


    /* -----------------------------------------------------
       Initialize rooms and load saved student data
       ----------------------------------------------------- */

    initializeRooms();

    loadStudents();


    /* -----------------------------------------------------
       Tell Java GUI that backend is ready
       ----------------------------------------------------- */

    printf("READY|Backend started\n");

    fflush(stdout);


    /* =====================================================
       COMMAND LOOP
       ===================================================== */

    while (
        fgets(
            command,
            sizeof(command),
            stdin
        ) != NULL
    ) {

        /* Remove newline */
        command[
            strcspn(
                command,
                "\r\n"
            )
        ] = '\0';


        /* =================================================
           ADD STUDENT
           ================================================= */

        if (
            strncmp(
                command,
                "ADD|",
                4
            ) == 0
        ) {

            char *token;

            char *idToken;
            char *nameToken;
            char *departmentToken;
            char *yearToken;
            char *roomToken;


            token = command + 4;


            idToken =
                strtok(
                    token,
                    "|"
                );

            nameToken =
                strtok(
                    NULL,
                    "|"
                );

            departmentToken =
                strtok(
                    NULL,
                    "|"
                );

            yearToken =
                strtok(
                    NULL,
                    "|"
                );

            roomToken =
                strtok(
                    NULL,
                    "|"
                );


            /* Validate command */

            if (
                idToken == NULL ||
                nameToken == NULL ||
                departmentToken == NULL ||
                yearToken == NULL ||
                roomToken == NULL
            ) {

                printf(
                    "ERROR|Invalid ADD command\n"
                );

                fflush(stdout);

                continue;
            }


            int id =
                atoi(idToken);

            int year =
                atoi(yearToken);


            /* Check duplicate student ID */

            if (
                findStudentByID(id) != NULL
            ) {

                printf(
                    "ERROR|Student ID already exists\n"
                );

                fflush(stdout);

                continue;
            }


            /* Check room availability */

            if (
                strcmp(
                    roomToken,
                    "NOT ALLOCATED"
                ) != 0
            ) {

                if (
                    !isRoomAvailable(
                        roomToken
                    )
                ) {

                    printf(
                        "ERROR|Room is not available\n"
                    );

                    fflush(stdout);

                    continue;
                }
            }


            /* Add student */

            addStudent(
                id,
                nameToken,
                departmentToken,
                year,
                roomToken
            );


            /* Save to file */

            saveStudents();


            printf(
                "SUCCESS|Student added|%d\n",
                id
            );

            fflush(stdout);
        }


        /* =================================================
           SEARCH STUDENT
           ================================================= */

        else if (
            strncmp(
                command,
                "SEARCH|",
                7
            ) == 0
        ) {

            char *idToken =
                command + 7;


            if (
                idToken == NULL ||
                strlen(idToken) == 0
            ) {

                printf(
                    "ERROR|Invalid SEARCH command\n"
                );

                fflush(stdout);

                continue;
            }


            int id =
                atoi(idToken);


            Student *student =
                findStudentByID(id);


            if (
                student == NULL
            ) {

                printf(
                    "NOT_FOUND|Student not found\n"
                );

                fflush(stdout);

                continue;
            }


            printf(
                "FOUND|%d|%s|%s|%d|%s\n",
                student->studentID,
                student->name,
                student->department,
                student->year,
                student->roomNumber
            );

            fflush(stdout);
        }


        /* =================================================
           UPDATE STUDENT
           ================================================= */

        else if (
            strncmp(
                command,
                "UPDATE|",
                7
            ) == 0
        ) {

            char *token =
                command + 7;


            char *idToken =
                strtok(
                    token,
                    "|"
                );

            char *departmentToken =
                strtok(
                    NULL,
                    "|"
                );

            char *yearToken =
                strtok(
                    NULL,
                    "|"
                );

            char *roomToken =
                strtok(
                    NULL,
                    "|"
                );


            /* Validate */

            if (
                idToken == NULL ||
                departmentToken == NULL ||
                yearToken == NULL ||
                roomToken == NULL
            ) {

                printf(
                    "ERROR|Invalid UPDATE command\n"
                );

                fflush(stdout);

                continue;
            }


            int id =
                atoi(idToken);

            int year =
                atoi(yearToken);


            Student *student =
                findStudentByID(id);


            /* Student doesn't exist */

            if (
                student == NULL
            ) {

                printf(
                    "NOT_FOUND|Student not found\n"
                );

                fflush(stdout);

                continue;
            }


            /* Check new room */

            if (
                strcmp(
                    roomToken,
                    student->roomNumber
                ) != 0
            ) {

                if (
                    strcmp(
                        roomToken,
                        "NOT ALLOCATED"
                    ) != 0
                ) {

                    if (
                        !isRoomAvailable(
                            roomToken
                        )
                    ) {

                        printf(
                            "ERROR|Room is not available\n"
                        );

                        fflush(stdout);

                        continue;
                    }
                }
            }


            /* Update student */

            updateStudent(
                id,
                departmentToken,
                year,
                roomToken
            );


            /* Save */

            saveStudents();


            printf(
                "SUCCESS|Student updated|%d\n",
                id
            );

            fflush(stdout);
        }


        /* =================================================
           DELETE STUDENT
           ================================================= */

        else if (
            strncmp(
                command,
                "DELETE|",
                7
            ) == 0
        ) {

            char *idToken =
                command + 7;


            if (
                idToken == NULL ||
                strlen(idToken) == 0
            ) {

                printf(
                    "ERROR|Invalid DELETE command\n"
                );

                fflush(stdout);

                continue;
            }


            int id =
                atoi(idToken);


            Student *student =
                findStudentByID(id);


            if (
                student == NULL
            ) {

                printf(
                    "NOT_FOUND|Student not found\n"
                );

                fflush(stdout);

                continue;
            }


            deleteStudent(id);


            saveStudents();


            printf(
                "SUCCESS|Student deleted|%d\n",
                id
            );

            fflush(stdout);
        }


        /* =================================================
           ROOM STATUS
           ================================================= */

        else if (
            strcmp(
                command,
                "ROOMS"
            ) == 0
        ) {

            displayRooms();


            printf(
                "ROOMS_END\n"
            );

            fflush(stdout);
        }


        /* =================================================
           STATISTICS
           
           Returns:
           
           STATS|
           totalStudents|
           occupiedBeds|
           availableBeds|
           occupiedRooms|
           availableRooms
           
           Example:
           
           STATS|15|12|28|8|12
           ================================================= */

        else if (
            strcmp(
                command,
                "STATS"
            ) == 0
        ) {

            int totalStudents = 0;

            int occupiedBeds = 0;

            int occupiedRooms = 0;


            /*
             * F-01 to F-10
             *
             * 0 = room not occupied
             * 1 = room occupied
             */

            int fRooms[10] = {0};


            /*
             * G-01 to G-10
             */

            int gRooms[10] = {0};


            Student *temp =
                getHead();


            /* ---------------------------------------------
               Count students and occupied rooms
               --------------------------------------------- */

            while (
                temp != NULL
            ) {

                totalStudents++;


                /*
                 * Student has a room
                 */

                if (
                    strcmp(
                        temp->roomNumber,
                        "NOT ALLOCATED"
                    ) != 0
                ) {

                    occupiedBeds++;


                    /* -------------------------------------
                       F BLOCK
                       ------------------------------------- */

                    if (
                        temp->roomNumber[0] == 'F' &&
                        temp->roomNumber[1] == '-'
                    ) {

                        int roomNumber =
                            atoi(
                                temp->roomNumber + 2
                            );


                        if (
                            roomNumber >= 1 &&
                            roomNumber <= 10
                        ) {

                            if (
                                fRooms[
                                    roomNumber - 1
                                ] == 0
                            ) {

                                fRooms[
                                    roomNumber - 1
                                ] = 1;


                                occupiedRooms++;
                            }
                        }
                    }


                    /* -------------------------------------
                       G BLOCK
                       ------------------------------------- */

                    else if (
                        temp->roomNumber[0] == 'G' &&
                        temp->roomNumber[1] == '-'
                    ) {

                        int roomNumber =
                            atoi(
                                temp->roomNumber + 2
                            );


                        if (
                            roomNumber >= 1 &&
                            roomNumber <= 10
                        ) {

                            if (
                                gRooms[
                                    roomNumber - 1
                                ] == 0
                            ) {

                                gRooms[
                                    roomNumber - 1
                                ] = 1;


                                occupiedRooms++;
                            }
                        }
                    }
                }


                temp =
                    temp->next;
            }


            /* ---------------------------------------------
               Calculate available beds and rooms
               --------------------------------------------- */

            int availableBeds =
                40 - occupiedBeds;


            int availableRooms =
                20 - occupiedRooms;


            /* ---------------------------------------------
               Send statistics to Java
               --------------------------------------------- */

            printf(
                "STATS|%d|%d|%d|%d|%d\n",
                totalStudents,
                occupiedBeds,
                availableBeds,
                occupiedRooms,
                availableRooms
            );


            printf(
                "STATS_END\n"
            );


            fflush(stdout);
        }


        /* =================================================
           EXIT
           ================================================= */

        else if (
            strcmp(
                command,
                "EXIT"
            ) == 0
        ) {

            saveStudents();


            printf(
                "SUCCESS|Backend closed\n"
            );

            fflush(stdout);


            break;
        }


        /* =================================================
           UNKNOWN COMMAND
           ================================================= */

        else {

            printf(
                "ERROR|Unknown command\n"
            );

            fflush(stdout);
        }
    }


    return 0;
}