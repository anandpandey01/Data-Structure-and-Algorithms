//{ Driver Code Starts
import java.util.*;
import java.util.Scanner;
import java.util.Stack;

class SortedStack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            Stack<Integer> s = new Stack<>();
            int n = sc.nextInt();
            while (n-- > 0) s.push(sc.nextInt());
            GfG g = new GfG();
            Stack<Integer> a = g.sort(s);
            while (!a.empty()) {
                System.out.print(a.peek() + " ");
                a.pop();
            }
            System.out.println();
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


/*Complete the function below*/
class GfG {
    public Stack<Integer> sort(Stack<Integer> s) {
        // add code here.
        return helper(s,0);
    }
    Stack<Integer> helper(Stack<Integer> s,int n){
        if(s.size()==n) return s;
        Stack<Integer> t = new Stack<>();
        
        int min = Integer.MAX_VALUE;
        
        while(s.size()!=n){
            min=Math.min(min,s.peek());
            t.push(s.pop());
        }
        s.push(min);
        while(!t.isEmpty()){
            if(t.peek()==min){
                t.pop();
                min=Integer.MAX_VALUE;
            }
            else s.push(t.pop());
        }
        return helper(s,n+1);
        
    }
}