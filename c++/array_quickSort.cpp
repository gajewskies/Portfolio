////////////////////////////////////////////////////////////
//Quick sort in array
//Date: 2/12/2015
//Author: Tyler Gajewski gajewskies@gmail.com
///////////////////////////////////////////////////////////

#include <iostream>
using namespace std;

void quick_sort(int MyArray[], int left, int right)												
{
	int temp, middle;																			
	int i = left;																				
	int j = right;																				

	middle = MyArray[(left + right) / 2];														
	do {																						
		while (MyArray[i] < middle)																
			i++;																				
		while (middle < MyArray[j])																
			j--;																				

		if (i <= j)																				
		{
			temp = MyArray[i];																	
			MyArray[i] = MyArray[j];															
			MyArray[j] = temp;																	
			i++;																				
			j--;																				
		}
	} while (i <= j);																			

	if (left < j)																				
		quick_sort(MyArray, left, j);															
	if (i < right)																				
		quick_sort(MyArray, i, right);															
}

int main()																						
{
	const int n = 10;																			
	int MyArray[n] = {1,2,3,4,5,6,7,8,9,10};										

	cout << "Array before the sort" << endl;													
	for (int i = 0; i < n; i++)																	
		cout << MyArray[i] << " ";																

	cout << endl;																				
		
	quick_sort(MyArray, 0, n-1);																

	cout << "Array after the sort" << endl;														
	for (int i = 0; i < n; i++)																	
		cout << MyArray[i] << " ";																

	cout << endl;																				
		
	return 0;
}