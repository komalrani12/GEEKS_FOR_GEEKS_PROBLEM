//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String input = br.readLine();
            String[] inputArray = input.split("\\s+");
            int a[] = new int[inputArray.length];

            for (int i = 0; i < a.length; i++) a[i] = Integer.parseInt(inputArray[i]);

            Solution ob = new Solution();
            ob.sort012(a);

            for (int num : a) {
                System.out.print(num + " ");
            }
            System.out.println();
            System.out.println("~");
        }
    }
}


// } Driver Code Ends
class Solution {
    // Function to sort an array of 0s, 1s, and 2s
    public void sort012(int[] arr) {
        int zeroes=0;
        int ones=0;
        int l=arr.length;
        for(int i=0; i<l; i++){
            if(arr[i]==0) {
                zeroes++;
            }
            else if(arr[i]==1) ones++;
        }
        for(int i=0; i<l; i++) {
            if(zeroes>0){
                arr[i]=0;
                zeroes--;
            }else if(ones>0){
                arr[i]=1;
                ones--;
            }else{
                arr[i]=2;
            }
        }
    }
}

//{ Driver Code Starts.
// } Driver Code Ends