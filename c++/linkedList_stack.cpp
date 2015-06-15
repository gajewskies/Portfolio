/****************************************************************
Implementation of a stack with a linked list
Date: 01/23/2015
Author: Tyler Gajewski gajewskies@gmail.com
*****************************************************************/

#include <iostream>

using namespace std;

const int MAX_ITEMS = 10;						

class stack										
{
public:
	stack();									
	void clear();								
	void push(int item);						
	void pop(int item);							
	void display();								
	bool IsEmpty() const;
	bool IsFull() const;
private:
	int top;									
	int items[MAX_ITEMS];						
};

stack::stack()								
{
	top = -1;							
}

bool stack::IsEmpty() const					
{
	return (top == -1);						
}

bool stack::IsFull() const						
{
	return (top == MAX_ITEMS - 1);				
}

void stack::clear()								
{
	top = -1;									
}

void stack::push(int item)						
{
	top++;									
	items[top] = item;							
}

void stack::pop(int item)						
{
	item = items[top];							
	top--;										
}

void stack::display()						
{
	if (IsEmpty())								
	{	
		cout << "Empty" << endl;				
	}
	for (int i = 0; i <= top; i++)				
	{
		cout << items[i]<<endl;					
	}
}

void main()										
{
	stack A;
	int number;
	int choice;

	while (true)
	{
		cout << "---------Menu---------" << endl;
		cout << "(1) Add to stack" << endl;
		cout << "(2) Remove from stack" << endl;
		cout << "(3) Display stack" << endl;
		cout << "(4) Clear stack" << endl;
		cout << "(5) Exit" << endl;
		cout << "-> ";
		cin >> choice;

		while (choice < 6)
		{
			if (choice == 1)
			{
				if (!A.IsFull())							
				{
					cout << "Enter an integer to add to stack: ";
					cin >> number;
					A.push(number);
					cout << number << " added to stack" << endl;
					system("pause");
					system("cls");
					break;
				}
			}
			else if (choice == 2)
			{
				if (!A.IsEmpty())								
				{
					A.pop(0);									
					cout << "Integer removed from stack" << endl;
					system("pause");
					system("cls");
					break;
				}
			}
			else if (choice == 3)
			{
				cout << "--------------------" << endl;
				A.display();	
				system("pause");
				system("cls");
				break;		
			}
			else if (choice == 4)
			{
				A.clear();
				system("pause");
				system("cls");
				break;
			}
			else if (choice == 5)
				exit(0);
			else
				cout << "Not an option" << endl;
		}
	}
}

