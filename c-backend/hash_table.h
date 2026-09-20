#ifndef HASH_TABLE_H
#define HASH_TABLE_H

#include "student.h"

#define TABLE_SIZE 10

typedef struct HashNode {
    Student *student;
    struct HashNode *next;
} HashNode;

int hashFunction(int studentID);

void insertHash(Student *student);

void displayHashTable();

void searchHash(int studentID);

void deleteHash(int studentID);

#endif