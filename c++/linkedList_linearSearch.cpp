////////////////////////////////////////////////////////////////////
//Linear search in linked list
//Date: 2/14/2015
//Author: Tyler Gajewski gajewskies@gmail.com
///////////////////////////////////////////////////////////////////

#include <iostream>

using namespace std;

struct Node															//Struct node data type
{
	int number;														//data
	Node* next;														//pointer to the next node
};

bool isEmpty(Node *head);											//function prototype
char menu();
void insetAsFirstElement(Node *&head, Node *&last, int number);		//function prototype
void insert(Node *&head, Node *&last, int number);					//function prototype
void remove(Node *&head, Node *&last);								//function prototype
void showList(Node *current);										//function prototype
int search(Node* head, int x);										//function prototype

bool isEmpty(Node *head)											//is empty function
{
	if (head == NULL)												//if head node is empty
		return true;												//return empty
	else															//if head node is not empty
		return false;												//return not empty
}

char menu()															//function for menu
{
	char choice;													//declare choice value
	system("cls");													//clear screen

	cout << "Menu" << endl;											//menu
	cout << "1. Add an item" << endl;								//menu item
	cout << "2. Remove an item" << endl;							//menu item
	cout << "3. Show the list" << endl;								//menu item
	cout << "4. Search for an element" << endl;						//menu item
	cout << "5. Exit" << endl;										//menu item

	cin >> choice;													//input choice

	return choice;													//return input
}

void insetAsFirstElement(Node *&head, Node *&last, int number)		//function for insert
{
	Node *temp = new Node;											//create a temperary node
	temp->number = number;											//assign local number to node number
	temp->next = NULL;												//temp pointing to next is empty
	head = temp;													//first value in list equal to temp
	last = temp;													//last element in list is also te first becuase theres only one element
}

void insert(Node *&head, Node *&last, int number)					//funciton for insert
{
	if (isEmpty(head))												//if list is empty
		insetAsFirstElement(head, last, number);					//call function
	else
	{
		Node *temp = new Node;										//create a temperary node
		temp->number = number;										//assign local number to node number
		temp->next = NULL;											//temp pointing to next is empty
		last->next = temp;											//last pointing to next = the temp value
		last = temp;												//last id temp value
	}

}

void remove(Node *&head, Node *&last)								//function for remove
{
	if (isEmpty(head))												//if first element is empty
		cout << "The list is empty" << endl;						//print words
	else if (head == last)											//if head is the same as last node
	{	
		delete head;												//delete head node
		head == NULL;												//declare list empty
		last == NULL;												//declare list empty
	}
	else
	{
		Node *temp = head;											//nodes temp is first node
		head = head->next;											//firsrt node pointing to next
		delete temp;												//delete temp value
	}
}

void showList(Node *current)										//function for showing list
{		
	if (isEmpty(current))											//if list is empty
		cout << "The list is empty" << endl;						//print words
	else
	{
		cout << "The list contains: " << endl;						//print words
		while (current != NULL)										//while loop 
		{
			cout << current->number << endl;						//print item
			current = current->next;								//go to next item
		}
	}
}

int main()															//main function
{
	Node *head = NULL;												//nothing in list
	Node *last = NULL;												//nothing in list
	char choice;													//delcare choice value
	int number;														//declare integer value
	int x;															//declare integer value

	do{																//do while loop
		choice = menu();											//choice value = menu functions return value choice

		switch (choice)												//switch case
		{
		case '1':													//case 1
			cout << "Please enter an number: ";						//print words
			cin >> number;											//input number
			insert(head, last, number);								//send to insert function
			break;													//break 
		case '2':													//case 2
			remove(head, last);										//call remove function
			break;													//break
		case '3':													//case 3
			showList(head);											//call show list function
			system("pause");										//pause screen
			break;													//break
		case '4':													//case 4
			cout << "Enter the integer you wish to search for: " << endl;//print words
			cin >> x;												//input x
			if (search(head, x) == -1)								//if function search input x = to - 1
				cout << "Element not found" << endl;				//element not found
			else
				cout << "Element " << x << " found at node " << search(head, x);//cout elements
			cout << endl;											//print blank line
			system("pause");										//pause screen
			break;													//break
		default:													//default
			cout << "System exit" << endl;							//print words
		}
	} while (choice != '5');										//while choice foes not equal 5
	return 0;
}

//finds the first node with the specified value
//assume that head pointer is defined elsewhere
int search(Node* head, int x)										//function for search
{
	int nodeNumber = 0;												//declare node number
	while (head != NULL)											//while list is not empty
	{
		if (head->number == x)										//if head is the search value
			return nodeNumber;										//return node number location
		nodeNumber++;												//increment node number
		head = head->next;											//go to next node
	}
	return -1;														//return not found
}