import java.util.Scanner;

/**
 * Created by lauminyi on 25/2/16.
 */
public class Dijkstra {
    public static void main(String[] args) {
        int[] distance  = new int [5];//holds the array of chosen distances(i.e the cost)
        int[][] matrix = new int[5][5];//shows the costs from each edge to every other edge including itself
        int[] preD = new int[5];
        int min;
        int nextNode = 0;//next Node holds the value for next node
        int[] visited = new int[5];//Array containing the states of each node whether visited or not
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter cost matrix");
        //Prompt user to input cost matrix;
        for(int i = 0; i<distance.length; i++){
            visited[i] = 0;
            preD[i] = 0;
            for(int j = 0; j<distance.length; j++) {
                matrix[i][j] = scan.nextInt();
                if (matrix[i][j] == 0) {
                    matrix[i][j] = 999;//make the zeros 999 to make them infinity
                }
            }

        }
        //Initialise starting node
        distance = matrix[0]; //set the initial distance array as the first cost matrix row
        visited[0] = 0;
        distance[0] = 0;

        for(int i  = 0; i<5; i++){
            min=999;
            //We go through all the costs in the distance array
            for(int j = 0; j<5; j++){
                if(min > distance[i] && visited[i]!=1) {
                    //Here we set the min cost
                    min = distance[i];
                    nextNode = i;
                }
            }
            //We set the node where we obtained the min cost as visited
            visited[nextNode]=1;
            for(int j=0; j<5; j++){
                //We go through all the unvisited nodes and add the min cost to the cost to travel
                //to that unvisited node!
                if(visited[j] != 1){
                    if(min+matrix[nextNode][j]<distance[j]){
                        distance[j]= min+matrix[nextNode][j];
                        preD[j]= nextNode;
                    }
                }
            }

        }
        for(int i = 0; i < 5; i++){

            System.out.print("|" + distance[i]);

        }
        System.out.println("|");

        int j;
        for(int i = 0; i < 5; i++){

            if(i!=0){

                System.out.print("Path = " + i);
                j = i;
                do{

                    j=preD[j];
                    System.out.print(" <- " + j);

                }while(j!=0);

            }

            System.out.println();

        }
    }
}
