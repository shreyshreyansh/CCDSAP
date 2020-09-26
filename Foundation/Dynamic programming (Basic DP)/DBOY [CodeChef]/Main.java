/* I have solved this problem with the help of "Minimum number of coins question by GFG"   */
/* link : https://www.geeksforgeeks.org/find-minimum-number-of-coins-that-make-a-change/  */
/*Idea is to find the minimum number of fuel filling for the maximum element in the array
and if I fill the array in top-down method then all the elements of the array will also
have answers for the smaller elements.*/

/*
Note:
For input :
1
4
1 2 3 4
1 4 5 3
dp[] will be {0 1 2 1 1 1 2 2 2} for 8 i.e (4*2) as 4 is the max element.
So if h is {1 2 3 4} then dp[1*2]+dp[2*2]+dp[3*2]+dp[4*2] will be the answer
And if you want to know about the minTimes function go to the above link.
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main
{
    public static void main(String[] args)
    {
        CP sc =new CP();
        int tt = sc.nextInt();
        while (tt-- > 0) {
            int n = sc.nextInt();
            int[] h = new int[n];
            int[] k = new int[n];

            // Finding the max element of the array and storing it's index as well as storing the distance of houses from the restaurant.
            long max = Long.MIN_VALUE;
            int idx = -1;
            for(int i=0;i<n;i++) {
                h[i] = sc.nextInt();
                if(h[i]>max){
                    max = h[i];
                    idx = i;
                }
            }

            // input the fuel station capacity.
            for(int i=0;i<n;i++)
                k[i] = sc.nextInt();

            long result =0;

            // the below function returns the bottom-up dp for the max element.
            long[] dp = minTimes(k, n, 2*h[idx]);

            // this dp will also have the answers for the smaller element of 'h' array.
            for(int i=0;i<n;i++){
                result+= dp[2*h[i]];
            }

            System.out.println(result);
        }
    }
    static long[] minTimes(int[] petrol, int len, int dist)
    {

        long[] dp = new long[dist + 1];
        dp[0] = 0;
        for (int i = 1; i <= dist; i++)
            dp[i] = Integer.MAX_VALUE;
        for (int i = 1; i <= dist; i++)
        {
            for (int j = 0; j < len; j++)
                if (petrol[j] <= i)
                {
                    long sub_res = dp[i - petrol[j]];
                    if (sub_res != Integer.MAX_VALUE && sub_res + 1 < dp[i])
                        dp[i] = sub_res + 1;
                }
        }
        return dp;

    }

    // For faster inputs.
    /*****************************************************************************/
    static class CP
    {
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
                }
                catch (IOException  e) {
                    e.printStackTrace();
                }
            }
            return stringTokenizer.nextToken();
        }
        String nextLine() {
            String spl = "";
            try {
                spl = bufferedReader.readLine();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            return spl;
        }
    }
    /*****************************************************************************/
}