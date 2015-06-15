////////////////////////////////////////////////////////////
//Fibinacci numbers with recursion and with iteration
//Date: 3/3/2015
//Author: Tyler Gajewski gajewskies@gmail.com
////////////////////////////////////////////////////////////

#include <iostream>															
using namespace std;														

int RecursiveFibanacci(int index)											
{
	if (index == 0)															
		return 0;															
	if (index == 1)															
		return 1;															
	return RecursiveFibanacci(index - 1) + RecursiveFibanacci(index - 2);	  
}

int IterativeFibanacci(int index) {											
	if (index == 0 || index == 1)											
		return index;														
		
	int previous = 1;														
	int current = 1;														
	int next = 1;															

	for (int i = 3; i <= index; i++) {										
		next = current + previous;											
		previous = current;													
		current = next;                                                     
	}
	return next;															
}

int main()																	
{
	int choice;																
	int index;																

	while (true) {															
		cout << "(1) Recursive Fibinacci" << endl;							
		cout << "(2) Iterative Fibinacci" << endl;							
		cout << "(3) Exit" << endl;											
		cin >> choice;

		while (true) {														
			if (choice == 1) {
				cout << "Enter the index of the fibanacci number you would like to search for: ";
				cin >> index;
				cout << "Fibonacci number is: " << RecursiveFibanacci(index) << endl;
			}
			else if (choice == 2) {
				cout << "Enter the index of the fibanacci number you would like to search for: ";
				cin >> index;
				cout << "Fibonacci number is: " << IterativeFibanacci(index) << endl;
			}
			else {
				exit(0);
			}			
		}
	}
	return 0;

}