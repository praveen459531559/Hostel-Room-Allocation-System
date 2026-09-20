#ifndef ROOM_H
#define ROOM_H

#define MAX_ROOMS 20

typedef struct {
    char roomNumber[20];
    int capacity;
    int occupied;
} Room;

void initializeRooms();

void displayRooms();

int isRoomAvailable(const char roomNumber[]);

int allocateRoom(const char roomNumber[]);

int vacateRoomByNumber(const char roomNumber[]);

#endif