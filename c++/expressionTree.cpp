/*
Implementation of an expression tree in c++
Date: 04/21/2015
Author: Tyler Gajewski gajewskies@gmail.com
*/
#include <iostream>
#include <string> 

using namespace std;

class TreeNode {
	public:
		char data;
		TreeNode *left, *right;
		TreeNode(char data) {
			this->data = data;
			this->left = NULL;
			this->right = NULL;
		}
};

class StackNode {
	public:
		TreeNode *treeNode;
		StackNode *next;
		StackNode(TreeNode *treeNode) {
			this->treeNode = treeNode;
			next = NULL;
		}
};

class ExpressionTree {
	private:
		StackNode *top;
	public:
		ExpressionTree();
		void clear();
		void push(TreeNode *ptr);
		void insert(char val);
		bool isDigit(char ch);
		bool isOperator(char ch);
		int toDigit(char ch);
		void buildTree(string eqn);
		double evaluate();
		double evaluate(TreeNode *ptr);
		void postOrder(TreeNode *ptr);
		void postfix();
		void infix();
		void inOrder(TreeNode *ptr);
		void prefix();
		void preOrder(TreeNode *ptr);

		TreeNode *pop() {
			if (top == NULL) {
				cout << "Underflow" << endl;
			}
			else {
				TreeNode *ptr = top->treeNode;
				top = top->next;
				return ptr;
			}
		}

		TreeNode *peek() {
			return top->treeNode;
		}

};

ExpressionTree::ExpressionTree(){
	top = NULL;
}

void ExpressionTree::clear(){
	top = NULL;
}

void ExpressionTree::push(TreeNode *ptr) {
	if (top == NULL)
		top = new StackNode(ptr);
	else {
		StackNode *nptr = new StackNode(ptr);
		nptr->next = top;
		top = nptr;
	}
}

void ExpressionTree::insert(char val) {
	if (isDigit(val)) {
		TreeNode *nptr = new TreeNode(val);
		push(nptr);
	}
	else if (isOperator(val)) {
		TreeNode *nptr = new TreeNode(val);
		nptr->left = pop();
		nptr->right = pop();
		push(nptr);
	} else {
		cout << "Invalid Expression" << endl;
		return;
	}
}

bool ExpressionTree::isDigit(char ch) {
	return ch >= '0' && ch <= '9';
}

bool ExpressionTree::isOperator(char ch) {
	return ch == '+' || ch == '-' || ch == '*' || ch == '/';
}

int ExpressionTree::toDigit(char ch) {
	return ch - '0';
}

void ExpressionTree::buildTree(string eqn) {
	for (int i = eqn.length() - 1; i >= 0; i--)
		insert(eqn[i]);
}

double ExpressionTree::evaluate() {
	return evaluate(peek());
}

double ExpressionTree::evaluate(TreeNode *ptr) {
	if (ptr->left == NULL && ptr->right == NULL)
		return toDigit(ptr->data);
	else {
		double result = 0.0;
		double left = evaluate(ptr->left);
		double right = evaluate(ptr->right);
		char op = ptr->data;
		switch (op) {
		case '+':
			result = left + right;
			break;
		case '-':
			result = left - right;
			break;
		case '*':
			result = left * right;
			break;
		case '/':
			result = left / right;
			break;
		default:
			result = left + right;
			break;
		}
		return result;
	}
}

void ExpressionTree::postfix() {
	postOrder(peek());
}

void ExpressionTree::postOrder(TreeNode *ptr) {
	if (ptr != NULL) {
		postOrder(ptr->left);
		postOrder(ptr->right);
		cout << ptr->data;
	}
}

void ExpressionTree::infix() {
	inOrder(peek());
}

void ExpressionTree::inOrder(TreeNode *ptr) {
	if (ptr != NULL) {
		inOrder(ptr->left);
		cout << ptr->data;
		inOrder(ptr->right);
	}
}

void ExpressionTree::prefix() {
	preOrder(peek());
}

void ExpressionTree::preOrder(TreeNode *ptr) {
	if (ptr != NULL) {
		cout << ptr->data;
		preOrder(ptr->left);
		preOrder(ptr->right);
	}
}


int main(){
	string equation;
	ExpressionTree expression;
	int choice;

	do {
		cout << "=================================" << endl;
		cout << "Expression tree evalutation" << endl;
		cout << "(1) New evaluation" << endl;
		cout << "(2) Exit" << endl;
		cout << "=================================" << endl;
		cin >> choice;
	
		cout << "Enter an equation in the prefix form: ";
		cin >> equation;

		expression.buildTree(equation);
		cout << "===========================================" << endl;
		cout << "Prefix traversal: ";
		expression.prefix();
		cout << endl;
		cout << "===========================================" << endl;
		cout << endl;
		cout << "===========================================" << endl;
		cout << "Infix traversal: ";
		expression.infix();
		cout << endl;
		cout << "===========================================" << endl;
		cout << endl;
		cout << "===========================================" << endl;
		cout << "Postfix traversal: ";
		expression.postfix();
		cout << endl;
		cout << "===========================================" << endl;
		cout << endl;
		cout << "===========================================" << endl;
		cout << "The result of the Evaluation is: " << expression.evaluate() << endl;
		cout << "===========================================" << endl << endl;
	} while (choice < 2 && choice > 0);
	return 0;
}