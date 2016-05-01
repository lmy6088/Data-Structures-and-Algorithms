#include <stdio.h>
#include <stdlib.h>

typedef struct BstNode {
	int data;
	struct BstNode* left;
	struct BstNode* right;
}BstNode;

//Function to create a new node in heap
BstNode *getNewNode(int data){
	BstNode* newNode = malloc(sizeof(BstNode));
	newNode -> data = data;
	newNode -> left = NULL;
	newNode -> right = NULL;
	return newNode;
}

//Inserting data in BST, returns address of the root node
BstNode *Insert(BstNode* root, int data){
	if(root == NULL){
		root = getNewNode(data);
	}
	//if data inserted is lesser, insert to the left of tree
	else if(data <= root->data){
		root -> left = Insert(root -> left, data);//returns address of left
	}
	//vice versa
	else{
		root -> right = Insert(root -> right, data);//returns address of right 
	}
	return root;
}

//searching through the tree for data
int Search(BstNode *root, int num){
	if(root == NULL)
		return 0;
	else if(num == root->data)
		return 1;
	else if(num <= root->data)
		return Search(root->left,num);
	else 
		return Search(root->right,num);
}

int main(void){
	BstNode* root = NULL;//creating an empty tree
	int num,choice;
	while(1){
		puts("1: Insert Node");
		puts("2: Search tree");
		puts("0: Exit");		
		scanf("%d", &choice);
		switch(choice){
		case 1:
		puts("Enter number to be inserted");
		scanf("%d",&num);
		root = Insert(root,num); //root must be set to be returned pointer of Insert!
		break;
		case 2:
		puts("Enter number to be searched for");
		scanf("%d",&num);
		if(Search(root,num) == 1)
			puts("Found!");
		else if(Search(root,num) == 0)
			puts("Not found!");
		break;
		case 0:
		exit(1);
		break;
		default:
		puts("Invalid choice");
		}
	}
}