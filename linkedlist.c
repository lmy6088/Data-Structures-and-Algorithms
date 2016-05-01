#include <stdio.h>
#include <stdlib.h>

typedef struct Node {
	int data;
	struct Node* next;
} Node;

//inserting node at start of the list
Node *InsertStart(Node *head , int data){
	Node *temp = (Node*)malloc(sizeof(Node)); // create new node;
	temp -> data = data;
	temp -> next = head; // satisfies the possibility that head is NULL;
	head = temp;
	return head;
// We have to return head because a new value is updated at the beginning
// because node is added at the start.
}

//the reason for void here is because the head value is not changed;
void *InsertEnd(Node *head, int data){
	Node *newNode, *temp;
	//cannot insert a node at the begining;
	if(head == NULL){
		printf("Sorry cannot insert node at the end for an empty list!\n");
		return;
	}
	newNode = (Node*)malloc(sizeof(Node));
	newNode -> data = data;
	temp = head;
	//travel to end of list;
	while(temp -> next != NULL){
		temp = temp -> next;
	}
	//sets the last node to point to ADDRESS of new node;
	temp -> next = newNode;
	newNode -> next = NULL;

}

//inserting a node at nth position;
Node *InsertNth(Node* head, int data, int pos){
	Node *newNode = (Node *)malloc(sizeof(Node));
	int i;
	newNode->data = data;
	//case for the first position which is zero;
	//Also handles the case where the list is empty;
	if(pos == 0){
		newNode->next = head;
		head = newNode;
		return head;
	}
	Node *temp = head;
	//traverse to the (nth-1)position of the list;
	for(i = 0; i < pos -1 ; i++){
		temp = temp->next;
	}
	newNode->next = temp->next;
	temp->next = newNode;
	return head;
}

void PrintList(Node *head){
	printf("List is ");
	while(head != NULL){
		printf("%d,", head -> data);
		head = head -> next; // travels to end of the list;
	}
	printf("\n");
}

int main(void){
	Node *start = NULL; // initializing the empty list;
	int choice, num, pos;
	while(1){
		printf("\n1: Display\n");
		printf("2: Add node to empty list / Add node at beginning\n");
		printf("3: Add node at the end\n");
		printf("4: Insert node at nth position\n");
		printf("0: Exit\n");
		printf("Please enter choice\n");
		scanf("%d", &choice);
		switch(choice){
			case 1:
			PrintList(start);
			break;
			case 2:
			printf("Enter data to be inserted\n");
			scanf("%d", &num);
			start = InsertStart(start,num);
			break;
			case 3:
			printf("Enter data to be inserted\n");
			scanf("%d", &num);
			InsertEnd(start,num);
			break;
			case 4:
			printf("Enter position to be inserted\n");
			scanf("%d",&pos);
			printf("Enter data to be inserted\n");
			scanf("%d",&num);
			start = InsertNth(start,num,pos);
			break;
			case 0:
			exit(1);
			default:
			printf("Invalid choice\n");
		}
	}
}
	


