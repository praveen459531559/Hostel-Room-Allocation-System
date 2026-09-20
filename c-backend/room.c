#include <stdio.h>
#include <string.h>
#include "room.h"

Room rooms[MAX_ROOMS];

void initializeRooms() {

    int index = 0;

    // F Block
    for (int i = 1; i <= 10; i++) {
        sprintf(rooms[index].roomNumber, "F-%02d", i);
        rooms[index].capacity = 2;
        rooms[index].occupied = 0;
        index++;
    }

    // G Block
    for (int i = 1; i <= 10; i++) {
        sprintf(rooms[index].roomNumber, "G-%02d", i);
        rooms[index].capacity = 2;
        rooms[index].occupied = 0;
        index++;
    }
}

void displayRooms() {

    printf("\n===== ROOM STATUS =====\n");

    for (int i = 0; i < MAX_ROOMS; i++) {

        printf("Room: %s | Capacity: %d | Occupied: %d | ",
               rooms[i].roomNumber,
               rooms[i].capacity,
               rooms[i].occupied);

        if (rooms[i].occupied == 0) {
            printf("VACANT\n");
        }
        else if (rooms[i].occupied < rooms[i].capacity) {
            printf("AVAILABLE\n");
        }
        else {
            printf("FULL\n");
        }
    }
}

int isRoomAvailable(const char roomNumber[]) {

    for (int i = 0; i < MAX_ROOMS; i++) {

        if (strcmp(rooms[i].roomNumber, roomNumber) == 0) {

            if (rooms[i].occupied < rooms[i].capacity) {
                return 1;
            }

            return 0;
        }
    }

    return 0;
}

int allocateRoom(const char roomNumber[]) {

    for (int i = 0; i < MAX_ROOMS; i++) {

        if (strcmp(rooms[i].roomNumber, roomNumber) == 0) {

            if (rooms[i].occupied < rooms[i].capacity) {

                rooms[i].occupied++;

                printf("Room %s allocated successfully.\n",
                       roomNumber);

                return 1;
            }

            printf("Room %s is FULL.\n", roomNumber);
            return 0;
        }
    }

    printf("Room %s does not exist.\n", roomNumber);
    return 0;
}

int vacateRoomByNumber(const char roomNumber[]) {

    for (int i = 0; i < MAX_ROOMS; i++) {

        if (strcmp(rooms[i].roomNumber, roomNumber) == 0) {

            if (rooms[i].occupied > 0) {

                rooms[i].occupied--;

                printf("Room %s vacated successfully.\n",
                       roomNumber);

                return 1;
            }

            printf("Room %s is already vacant.\n", roomNumber);
            return 0;
        }
    }

    printf("Room %s does not exist.\n", roomNumber);
    return 0;
}