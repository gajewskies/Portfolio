////////////////////////////////////////////////////////////
//Selection sort in array
//Date: 2/12/2015
//Author: Tyler Gajewski gajewskies@gmail.com
///////////////////////////////////////////////////////////

#include <iostream>
using namespace std;

void selection_sort(int MyArray[], int n)												
{
	int temp, position;																	

	for (int i = 0; i < n -1 ; i++)														
	{
		position = i;
		for (int j = i; j < n; j++)													
		{
			if (MyArray[j] < MyArray[position])												
			{
				position = j;
			}
			if (position != i)
			{
				temp = MyArray[i];														
				MyArray[i] = MyArray[position];												
				MyArray[position] = temp;													
			}
		}
	}
}

int main()																				
{
	const int n = 10;																	
	int MyArray[n] = { 73, 3, 2, 2, 2, 32, 1, 1, 637, 3 };								
	 
	cout << "Array before the sort" << endl;											
	for (int i = 0; i < n; i++)															
		cout << MyArray[i] << " ";														
	
	cout << endl;																		
	
	selection_sort(MyArray, n);															

	cout << "Array after the sort" << endl;												
	for (int i = 0; i < n; i++)															
		cout << MyArray[i] << " ";														

	cout << endl;																		
	return 0;
}
	