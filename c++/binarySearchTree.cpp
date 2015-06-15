/*********************************************************************
Implementation of a binary search tree
Date: 3/29/2015
Author: Tyler Gajewski gajewskies@gmail.com
**********************************************************************/

#include <iostream>											//Input and output
#include <cstdlib>											//Include the standard library

using namespace std;										//Standard namespace

struct node													//declare node
{
	int info;												//data variable
	struct node *left;										//pointer to the left side of struct node
	struct node *right;										//pointer to the right side of the struct node
}*root;														//pointer to the root node of the stuct

class BST													//the class declaration
{
public:														//public part of the class
	void find(int, node **, node **);						//function to find node
	void insert(node *, node *);										//function to insert a node
	void del(int);											//function to delete a node
	void track_1(node *, node *);							//function for the first case
	void track_2(node *, node *);							//function for the second case
	void track_3(node *, node *);							//function for the third case
	void preorder(node *);									//function for pre order traversal
	void inorder(node *);									//function for in order traversal 
	void postorder(node *);									//function for post order traversal
	void display(node *, int);								//function to dislay nodes
	BST();
};

BST()														//constructior
{
	root = NULL;											//root is empty thus tree is empty
}


void BST::find(int item, node **par, node **loc)			//function to find
{
	node *ptr, *ptrsave;									//node pointers
	if (root == NULL)										//if empty
	{
		*loc = NULL;										//pointers is null
		*par = NULL;										//pointers is null
		return;
	}
	if (item == root->info)									//item data == roots data
	{
		*loc = root;
		*par = NULL;
		return;
	}
	if (item < root->info)									//if item is less then root node
		ptr = root->left;
	else
		ptr = root->right;
	ptrsave = root;
	while (ptr != NULL)										//if the pointer is not null
	{
		if (item == ptr->info)								//item is the same as pointers data
		{
			*loc = ptr;
			*par = ptrsave;
			return;
		}
		ptrsave = ptr;										//pointer save is pointer
		if (item < ptr->info)								//if item is less then
			ptr = ptr->left;								//push to left
		else
			ptr = ptr->right;								//push to right
	}
	*loc = NULL;											//pointer to loc is empty
	*par = ptrsave;
}

void BST::insert(node *tree, node *newnode)					//function for inserting
{
	if (root == NULL)										//if the root node is empty
	{
		root = new node;									//root is a new node
		root->info = newnode->info;							//push data to root
		root->left = NULL;									//roots left is empty
		root->right = NULL;									//roots right is empty
		cout << "Root Node is Added" << endl;
		return;
	}
	if (tree->info == newnode->info)						//if the ree data and new noed data are equal
	{
		cout << "Element already in the tree" << endl;
		return;
	}
	if (tree->info > newnode->info)							//if tree data is less than
	{
		if (tree->left != NULL)								//if left node is empty
		{
			insert(tree->left, newnode);					//recursive call
		}
		else
		{
			tree->left = newnode;							//left nofe is new node
			(tree->left)->left = NULL;						//lefts lefts is empty
			(tree->left)->right = NULL;						//lefts right is empty
			cout << "Node Added To Left" << endl;
			return;
		}
	}
	else
	{
		if (tree->right != NULL)							//if tress right is not empty
		{
			insert(tree->right, newnode);					//recursive call
		}
		else
		{
			tree->right = newnode;							//tress right node is new node
			(tree->right)->left = NULL;						//rughts left is empty
			(tree->right)->right = NULL;					//rights right is empty
			cout << "Node Added To Right" << endl;
			return;
		}
	}
}

void BST::del(int item)										//function to delete node
{
	node *parent, *location;								//delcare a new node pointer
	if (root == NULL)										//if root is empty
	{
		cout << "Tree empty" << endl;
		return;
	}
	find(item, &parent, &location);							//call the find function
	if (location == NULL)									// if thelocation is empty
	{
		cout << "Item not present in tree" << endl;
		return;
	}
	if (location->left == NULL && location->right == NULL)	//if
		track_1(parent, location);
	if (location->left != NULL && location->right == NULL)	//if
		track_2(parent, location);
	if (location->left == NULL && location->right != NULL)	//if
		track_2(parent, location);
	if (location->left != NULL && location->right != NULL)	//if
		track_3(parent, location);
	free(location);
}

void BST::track_1(node *par, node *loc)						//function for case 1
{
	if (par == NULL)										//if parent is empty
	{
		root = NULL;										//root is empty
	}
	else
	{
		if (loc == par->left)								//locations = parent left
			par->left = NULL;								//pointers left is empty
		else
			par->right = NULL;								//parents right is empty
	}
}

void BST::track_2(node *par, node *loc)						//function for case 2
{
	node *child;											//declare new node child
	if (loc->left != NULL)									//if left node of location is not empty
		child = loc->left;									// child is the left node
	else
		child = loc->right;									//child is the right ndoe
	if (par == NULL)
	{
		root = child;										//root is now the child
	}
	else
	{
		if (loc == par->left)
			par->left = child;
		else
			par->right = child;
	}
}

void BST::track_3(node *par, node *loc)						//function for case 3
{
	node *ptr, *ptrsave, *suc, *parsuc;						//declare new pointers
	ptrsave = loc;
	ptr = loc->right;
	while (ptr->left != NULL)								//while loop and while left node is not empty
	{
		ptrsave = ptr;
		ptr = ptr->left;
	}
	suc = ptr;
	parsuc = ptrsave;
	if (suc->left == NULL && suc->right == NULL)
		track_1(parsuc, suc);
	else
		track_2(parsuc, suc);
	if (par == NULL)
	{
		root = suc;
	}
	else
	{
		if (loc == par->left)
			par->left = suc;
		else
			par->right = suc;
	}
	suc->left = loc->left;
	suc->right = loc->right;
}

void BST::preorder(node *ptr)								//function for pre order
{
	if (root == NULL)										//if empty
	{
		cout << "Tree is empty" << endl;
		return;
	}
	if (ptr != NULL)										// if not empty
	{
		cout << ptr->info << "  ";							//cout data
		preorder(ptr->left);								//recursive call
		preorder(ptr->right);								//recursive call
	}
}

void BST::inorder(node *ptr)								//function for inorder traversal
{
	if (root == NULL)										//if root is empty
	{
		cout << "Tree is empty" << endl;
		return;
	}
	if (ptr != NULL)										// if not empty
	{
		inorder(ptr->left);									//recursive call
		cout << ptr->info << "  ";							//output data
		inorder(ptr->right);								//recursive call
	}
}

void BST::postorder(node *ptr)								//function for post order traversal
{
	if (root == NULL)										//is empty
	{
		cout << "Tree is empty" << endl;
		return;
	}
	if (ptr != NULL)										//if not empty
	{
		postorder(ptr->left);								//recursive call
		postorder(ptr->right);								//recursive call
		cout << ptr->info << "  ";							//cout data
	}
}

void BST::display(node *ptr, int level)						//function to display 
{		
	int i;													//integer i
	if (ptr != NULL)										//if the pointer is not equal to null
	{
		display(ptr->right, level + 1);
		cout << endl;
		if (ptr == root)									//if pointer is root
			cout << "Root->:  ";
		else
		{
			for (i = 0; i < level; i++)
				cout << "       ";
		}
		cout << ptr->info;									//cout data
		display(ptr->left, level + 1);						//recursively call function
	}
}

int main()													//main function
{
	int choice, num;										//integer for choice and number
	BST bst;												//declare class
	node *temp;												//node pointer of temp
	while (1)												//while loop true
	{
		cout << "-----------------" << endl;				//menu
		cout << "Operations on BST" << endl;				//menu
		cout << "-----------------" << endl;				//menu
		cout << "1.Insert Element " << endl;				//men
		cout << "2.Delete Element " << endl;				//menu
		cout << "3.Inorder Traversal" << endl;				//menu
		cout << "4.Preorder Traversal" << endl;				//menu
		cout << "5.Postorder Traversal" << endl;			//menu
		cout << "6.Display" << endl;						//menu
		cout << "7.Quit" << endl;							//menu
		cout << "Enter your choice : ";						//menu
		cin >> choice;										//input choice
		switch (choice)										//switch case
		{
		case 1:												//case 1
			temp = new node;								//temp = node
			cout << "Enter the number to be inserted : ";
			cin >> temp->info;
			bst.insert(root, temp);							//insert at root node with temp
		case 2:
			if (root == NULL)								//if root node is empty
			{
				cout << "Tree is empty, nothing to delete" << endl;
				continue;
			}
			cout << "Enter the number to be deleted : ";
			cin >> num;
			bst.del(num);
			break;
		case 3:
			cout << "Inorder Traversal of BST:" << endl;
			bst.inorder(root);
			cout << endl;
			break;
		case 4:
			cout << "Preorder Traversal of BST:" << endl;
			bst.preorder(root);
			cout << endl;
			break;
		case 5:
			cout << "Postorder Traversal of BST:" << endl;
			bst.postorder(root);
			cout << endl;
			break;
		case 6:
			cout << "Display BST:" << endl;
			bst.display(root, 1);
			cout << endl;
			break;
		case 7:
			exit(1);
		default:
			cout << "Wrong choice" << endl;
		}
	}
}
