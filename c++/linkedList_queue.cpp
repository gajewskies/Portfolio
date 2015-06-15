/*******************************************************************************
Imlement a gueue in a linked list
Date: 1/23/2015
Author: Tyler Gajewski gajewskies@gmail.com
********************************************************************************/
#include<iostream>

using namespace std;

struct node								
{
	int info;							
	struct node *next;					
};

class Queue								
{
	private:
		node *last;						
		node *head;						
	public:
		Queue();						
		void enqueue();					
		void dequeue();					
		void display();					
		void clearList();				
		bool isEmpty(node *head);		
		bool isFull();				
};

Queue::Queue()							
{										
	last = NULL;						
	head = NULL;						
}

bool Queue::isFull() 					
{
	node *temp;							

	if (temp = new node)				
	{
		delete temp;					
		return false;					
	}
	return true;						
}
bool Queue::isEmpty(node *head)			
{
	if (head == NULL)					
		return true;					
	else                                
		return false;					
}

void Queue::enqueue()					
{
	int data;							
	node *temp = new node;				

	cout << "Enter the data to enqueue" << endl;
	cin >> data;

	temp->info = data;					
	temp->next = NULL;					

	if (!isFull())
	{
		if (isEmpty(head))				
		{
			head = temp;				
		}
		else
		{
			last->next = temp;			
		}
	}
	last = temp;						
}

void Queue::dequeue()					
{
	system("cls");						
	node *temp = new node;				

	if (isEmpty(head))					
	{
		cout << "List is Empty"<<endl;	
	}
	else
	{
		temp = head;					
		head = head->next;				

		cout << "The data Dequeued is " << temp->info;
		cout << endl;
		delete temp;					
	}
}

void Queue::display()					
{	
	system("cls");						
	node *p = new node;					
	p = head;							

	if (isEmpty(head))					
	{
		cout << "List is empty"<<endl;	
	}
	else
	{
		while (p != NULL)				
		{
			cout << endl << p->info;	
			p = p->next;				
		}
		cout << endl;
	}
}

void Queue::clearList()					
{
	system("cls");						
	head = NULL;						
	last = NULL;						
}
int main()								
{
	Queue queue;						
	int choice;							

	while (true)						
	{ 
		cout << "----Menu----" << endl;
		cout << "(1) Enqueue" << endl;
		cout << "(2) Dequeue" << endl;
		cout << "(3) Display" << endl;
		cout << "(4) Clear List" << endl;
		cout << "(5) Exit" << endl;
		cin >> choice;

		while (true)					
		{
			if (choice == 1)
			{
				queue.enqueue();		
				system("cls");
				break;
			}
			else if (choice == 2)
			{
				queue.dequeue();		
				break;
			}
			else if (choice == 3)
			{
				queue.display();		
				break;
			}
			else if (choice == 4)
			{
				queue.clearList();
				break;
			}
			else if (choice == 5)
				exit(0);				
			else
				cout << "Invalid input" << endl;
		}
	}
	return 0;
}