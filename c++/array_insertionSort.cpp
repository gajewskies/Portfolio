////////////////////////////////////////////////////////////
//Insertion sort in an array
//Date: 2/12/2015
//Author: Tyler Gajewski gajewskies@gmail.com
///////////////////////////////////////////////////////////


#include <iostream>
using namespace std;

void insertion_sort(int MyArray[], int n)
{
	int temp, j;																

	for (int i = 1; i < n; i++)													
	{
		j = i;																	
		while (j > 0 && MyArray[j -1] > MyArray[j])								
		{
			temp = MyArray[j];													
			MyArray[j] = MyArray[j - 1];										 
			MyArray[j - 1] = temp;												
			j--;																
		}
	}
}

int main()																		
{
	const int n = 10;															
	int MyArray[n] = {10,9,8,7,6,5,4,3,2,1};						

	cout << "Array before the sort" << endl;									
	for (int i = 0; i < n; i++)													
		cout << MyArray[i] << " ";												
		
	cout << endl;																

	insertion_sort(MyArray, n);													

	cout << "Array after the sort" << endl;										
	for (int i = 0; i < n; i++)													
		cout << MyArray[i] << " ";												

	cout << endl;																

	return 0;
}
