//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int N = sc.nextInt();
            int M[][] = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    M[i][j] = sc.nextInt();
                }
            }
            System.out.println(new Solution().celebrity(M));
            t--;

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    public int celebrity(int arr[][]) {
        // code here
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<n; i++){
            st.push(i);
        }
        while(st.size()>1){
            int top = st.peek(); st.pop();
            int stop = st.peek(); st.pop();
            if(arr[top][stop]==0){
                st.push(top);
            }
            else {
                st.push(stop);
            }
        }
        int celeb = st.peek();
        for(int i=0; i<n; i++){
            if(i!=celeb && (arr[celeb][i]==1 || arr[i][celeb]==0)) return -1; 
        }
        return celeb;
        
    }
}