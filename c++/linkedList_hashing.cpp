/*
Implementation of hashing in a linked list
Date: 04/20/2015
Author: Tyler Gajewski gajewskies@gmail.com
*/

#include <iostream>													

using namespace std;												

class LinkedHashEntry {												
	int key;
	int value;
	LinkedHashEntry *next;

public:																
	LinkedHashEntry(int key, int value) {							
		this->key = key;
		this->value = value;
		this->next = NULL;
	}

	int getKey() {													
		return key;
	}

	int getValue() {												
		return value;	
	}

	void setValue(int value) {										
		this->value = value;
	}

	LinkedHashEntry *getNext() {									
		return next;
	}

	void setNext(LinkedHashEntry *next) {							
		this->next = next;
	}
};

const int TABLE_SIZE = 9;											

class HashMap {														
	LinkedHashEntry **table;

public:																
	HashMap() {
		table = new LinkedHashEntry*[TABLE_SIZE];
		for (int i = 0; i < TABLE_SIZE; i++)
			table[i] = NULL;
	}

	int get(int key) {												
		int hash = (key % TABLE_SIZE);
		if (table[hash] == NULL)
			return -1;
		else {
			LinkedHashEntry *entry = table[hash];
			while (entry != NULL && entry->getKey() != key)
				entry = entry->getNext();
			if (entry == NULL)
				return -1;
			else
				return entry->getValue();
		}
	}

	void put(int key, int value) {									
		int hash = (key % TABLE_SIZE);

		cout << "hash: " << hash << " ==> " << key << endl;

		if (table[hash] == NULL)
			table[hash] = new LinkedHashEntry(key, value);
		else {
			LinkedHashEntry *entry = table[hash];
			while (entry->getNext() != NULL)
				entry = entry->getNext();

			if (entry->getKey() == key)
				entry->setValue(value);
			else
				entry->setNext(new LinkedHashEntry(key, value));
		}
	}

	void remove(int key) {											
		int hash = (key % TABLE_SIZE);
		if (table[hash] != NULL) {
			LinkedHashEntry *prevEntry = NULL;
			LinkedHashEntry *entry = table[hash];
			while (entry->getNext() != NULL && entry->getKey() != key) {
				prevEntry = entry;
				entry = entry->getNext();
			}
			if (entry->getKey() == key) {
				if (prevEntry == NULL) {
					LinkedHashEntry *nextEntry = entry->getNext();
					delete entry;
					table[hash] = nextEntry;
				}
				else {
					LinkedHashEntry *next = entry->getNext();
					delete entry;
					prevEntry->setNext(next);
				}
			}
		}
	}

	void print(){													
		LinkedHashEntry *node;

		for (int i = 0; i < TABLE_SIZE; i++){
			node = table[i];
			if (!node){
				cout << "null" << endl;
				continue;
			}
			else
				cout << node->getKey() << ", " << node->getValue();

			if (node->getNext()){

				LinkedHashEntry* inner = node->getNext();

				while (inner){
					cout << " --> " << inner->getKey() << ", " << inner->getValue();
					inner = inner->getNext();
				}
			}

			cout << endl;
		}
	}

	~HashMap(){														
		for (int i = 0; i < TABLE_SIZE; i++)
			if (table[i] != NULL) {
			LinkedHashEntry *prevEntry = NULL;
			LinkedHashEntry *entry = table[i];

			while (entry != NULL) {
				prevEntry = entry;
				entry = entry->getNext();
				delete prevEntry;
			}
			}
		delete[] table;
	}
};

int main(int argc, char* argv[]){								
	HashMap h;

	h.put(5, 443);						
	h.put(29, 199);						
	h.put(20, 1200);					
	h.put(0, 00);						
	h.put(27, 77);						
	h.put(18, 88);	
	cout << "===============" << endl;
	h.print();
	cout << "===============" << endl;
	h.remove(27);					
	h.remove(20);						

	h.print();						


	cout << endl;
	return 0;
}