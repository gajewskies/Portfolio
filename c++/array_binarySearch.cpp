///////////////////////////////////////////////////////
//Binary search in an array
//Date: 2/13/2015
//Author: Tyler Gajewski gajewskies@gmail.com
//////////////////////////////////////////////////////

#include <iostream>

using namespace std;

int binary_Search(int MyArray[], int number)							
{
	int size = 10;														
	int middle, left = 0, right = size - 1, position = -1;				

	
	do																	
	{
		middle = (left + right) / 2;									
		if (number<MyArray[middle])										
			right = middle - 1;											

		else if(number>MyArray[middle])									
			left = middle + 1;											
	} while (left <= right && MyArray[middle] != number);				

	if (MyArray[middle] == number)										
		position = middle;												

	return position;													
}

int main()																
{
	const int size = 10;												
	int MyArray[size] = {1,2,3,4,5,6,7,8,9,10};							
	int number, choice, flag = 0;										
	
	do{
	cout << "--------------Menu-------------" << endl;									
	cout << "(1) Show elements in array" << endl;						
	cout << "(2) Search for element in array" << endl;					
	cin >> choice;														
		
	
		if (choice == 1)													
		{
			for (int i = 0; i < size; i++)									
				cout << MyArray[i] << ", ";									
			cout << endl;
		}
		else if (choice == 2)												
		{
			cout << "Enter the integer you would like to search for" << endl;
			cin >> number;													
			flag = binary_Search(MyArray, number);							
			if (flag != -1)													
			{
				cout << "Element " << number << " found at array spot " << flag << endl;
			}
		}
	} while (choice != 3);
	

	
}