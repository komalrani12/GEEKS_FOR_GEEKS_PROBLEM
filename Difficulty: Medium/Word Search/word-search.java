//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt(); // Number of test cases
        while (tc-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            char[][] mat = new char[n][m];

            // Reading the matrix
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    mat[i][j] = sc.next().charAt(0);
                }
            }

            String word = sc.next();
            Solution obj = new Solution();
            boolean ans = obj.isWordExist(mat, word);
            if (ans)
                System.out.println("true");
            else
                System.out.println("false");

            System.out.println("~");
        }
        sc.close();
    }
}
// } Driver Code Ends

class Solution {
    int m;
    int n;
    int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}}; // Fixed type and values

    // Corrected method to check if the word exists
    public boolean checkIfExist(char[][] mat, int i, int j, String word, int idx) {
        if (idx == word.length()) {
            return true; // Successfully matched the entire word
        }

        if (i < 0 || j < 0 || i >= mat.length || j >= mat[0].length || mat[i][j] != word.charAt(idx)) {
            return false; // Out of bounds or mismatch
        }

        char temp = mat[i][j];
        mat[i][j] = '$'; // Mark as visited

        for (int[] dir : directions) {
            int new_i = i + dir[0];
            int new_j = j + dir[1];
            if (checkIfExist(mat, new_i, new_j, word, idx + 1)) {
                return true; // Found the word
            }
        }

        mat[i][j] = temp; // Restore the character after backtracking
        return false;
    }

    public boolean isWordExist(char[][] mat, String word) {
        m = mat.length;
        n = mat[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == word.charAt(0)) { // Start searching from matching character
                    if (checkIfExist(mat, i, j, word, 0)) {
                        return true;
                    }
                }
            }
        }

        return false; // Word not found
    }
}


