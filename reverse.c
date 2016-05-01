#include <stdio.h>
#include <stdlib.h>
int main() {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT */ 
    int i, j, n, temp;
    scanf("%d", &n);
    int *num = malloc(sizeof(int)*n);
    for(i = 0 ; i < n ; i++){
        scanf("%d", (num+i));
    }
    
    i = 0; 
    j = n-1;
    while(i<j){
       temp = *(num+i);
       *(num+i) = *(num + j);
        *(num + j) = *(num + i);
    }
    
    for(i = 0 ; i < n ; i++){
        printf("%d", *(num+i));
}
        
    return 0;
}