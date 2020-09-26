/*Using Lexicographically permutation*/
/*
        1) An sequence sorted in descending order does not have next permutation. For example edcba” does not have next permutation.
        2) For a sequence which is not sorted in descending order for example “abedc”, we can follow below steps.
            a) Traverse from right and find the first item that is not following the descending order.
               For example in “abedc”, the character ‘b’ does not follow the descending order.
            b) Swap the found character with closest greater (or smallest greater) element on right side of it.
               In case of “abedc”, we have ‘c’ as the closest greater element. After swapping ‘b’ and ‘c’, string becomes “acedb”.
            c) After swapping, sort the string after the position of character found in step a.
               After sorting the substring “edb” of “acedb”, we get “acbde” which is the required next permutation.
        Optimizations in step b) and c)
        a) Since the sequence is sorted in decreasing order, we can use binary search to find the closest greater element.
        c) Since the sequence is already sorted in decreasing order (even after swapping as we swapped with the closest greater),
           we can get the sequence sorted (in increasing order) after reversing it.
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        CP sc = new CP();
        StringBuilder sb = new StringBuilder();
        int tt = sc.nextInt();
        while (tt-- > 0) {
            int n = sc.nextInt();
            int[] A = new int[n];
            for (int i = 0; i < n; i++)
                A[i] = sc.nextInt();
            int i = n-1;
            while(i>0 && A[i-1]>=A[i])
                i--;
            if(i==0)
                sb.append(-1).append('\n');
            else{
                int j=n-1;
                while(A[i-1]>=A[j])
                    j--;
                int temp = A[i-1];
                A[i-1] = A[j];
                A[j] = temp;
                for(int h=0;h<i;h++)
                    sb.append(A[h]);
                for(int h=n-1;h>=i;h--)
                    sb.append(A[h]);
                sb.append('\n');
            }
        }
        System.out.println(sb);
    }
    /*****************************************************************************/
    static class CP {
        BufferedReader bufferedReader;
        StringTokenizer stringTokenizer;

        public CP() {
            bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        }

        int nextInt() {
            return Integer.parseInt(NNNN());
        }

        long nextLong() {
            return Long.parseLong(NNNN());
        }

        double nextDouble() {
            return Double.parseDouble(NNNN());
        }

        String NNNN() {
            while (stringTokenizer == null || !stringTokenizer.hasMoreElements()) {
                try {
                    stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return stringTokenizer.nextToken();
        }

        String nextLine() {
            String spl = "";
            try {
                spl = bufferedReader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return spl;
        }
    }
    /*****************************************************************************/
}