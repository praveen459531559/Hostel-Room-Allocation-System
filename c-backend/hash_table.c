#include <stdio.h>
#include <stdlib.h>
#include "hash_table.h"

HashNode *hashTable[TABLE_SIZE] = {NULL};


int hashFunction(int studentID) {

    return studentID % TABLE_SIZE;
}


void insertHash(Student *student) {

    int index = hashFunction(student->studentID);

    HashNode *newNode = (HashNode *)malloc(sizeof(HashNode));

    if (newNode == NULL) {
        printf("Memory allocation failed!\n");
        return;
    }

    newNode->student = student;
    newNode->next = NULL;

    if (hashTable[index] == NULL) {

        hashTable[index] = newNode;

    }
    else {

        HashNode *temp = hashTable[index];

        while (temp->next != NULL) {
            temp = temp->next;
        }

        temp->next = newNode;
    }

    printf("Student %d inserted into hash table at index %d.\n",
           student->studentID, index);
}


void displayHashTable() {

    printf("\n===== HASH TABLE =====\n");

    for (int i = 0; i < TABLE_SIZE; i++) {

        printf("Index %d: ", i);

        HashNode *temp = hashTable[i];

        if (temp == NULL) {
            printf("EMPTY");
        }
        else {

            while (temp != NULL) {

                printf("%d", temp->student->studentID);

                if (temp->next != NULL) {
                    printf(" -> ");
                }

                temp = temp->next;
            }
        }

        printf("\n");
    }
}


void searchHash(int studentID) {

    int index = hashFunction(studentID);

    HashNode *temp = hashTable[index];

    while (temp != NULL) {

        if (temp->student->studentID == studentID) {

            Student *student = temp->student;

            printf("\n--- Student Found Using Hashing ---\n");
            printf("Student ID : %d\n", student->studentID);
            printf("Name       : %s\n", student->name);
            printf("Department : %s\n", student->department);
            printf("Year       : %d\n", student->year);
            printf("Room       : %s\n", student->roomNumber);

            return;
        }

        temp = temp->next;
    }

    printf("\nStudent %d not found in hash table.\n", studentID);
}


void deleteHash(int studentID) {

    int index = hashFunction(studentID);

    HashNode *temp = hashTable[index];
    HashNode *prev = NULL;

    while (temp != NULL) {

        if (temp->student->studentID == studentID) {

            if (prev == NULL) {
                hashTable[index] = temp->next;
            }
            else {
                prev->next = temp->next;
            }

            free(temp);

            printf("\nStudent %d deleted from hash table.\n", studentID);
            return;
        }

        prev = temp;
        temp = temp->next;
    }

    printf("\nStudent %d not found in hash table.\n", studentID);
}