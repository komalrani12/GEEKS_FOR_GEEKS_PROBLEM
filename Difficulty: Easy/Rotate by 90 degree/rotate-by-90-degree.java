//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int matrix[][] = new int[n][n];
            // String st[] = read.readLine().trim().split("\\s+");
            int k = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) matrix[i][j] = sc.nextInt();
            }
            Solution ob = new Solution();
            ob.rotateby90(matrix);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) System.out.print(matrix[i][j] + " ");
                System.out.println();
            }
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    // Function to rotate matrix anticlockwise by 90 degrees.
    static void rotateby90(int mat[][]) {
       transpose(mat);
       reverse(mat);
    }
    private static void transpose(int mat[][]){
        int m= mat.length;
        int n=mat[0].length;
        for(int i=0; i<n; i++){
            for(int j=0; j<i; j++){
                int temp=mat[i][j];
                mat[i][j]=mat[j][i];
                mat[j][i]=temp;
            }
        }
        
    }
    private static  void reverse(int mat[][]){
       int m= mat.length;
        int n=mat[0].length;
    
        for(int col=0; col<n; col++){
             int top=0;
        int down=n-1;
            while(top<down){
                int temp=mat[top][col];
                mat[top][col]=mat[down][col];
                mat[down][col]=temp;
                top++;
                down--;
            }
        }
    }
}