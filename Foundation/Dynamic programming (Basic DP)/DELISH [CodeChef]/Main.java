/* Let us look at the final solution, and work backwards. Let the final solution be due to some i0, j0, k0, l0. We now have two cases:

Case 1: D[k0] + … + D[l0] <= D[i0] + … + D[j0].
In this case, we get that among all possible choices of l, D[k0] + … + D[l] is MINIMUM for l = l0. Else, we could choose such l, and this would give us a larger absolute difference. We also get, that among all 1 <= i <= j <= k0-1, D[i] + … + D[j] is MAXIMUM.

Case 2: D[k0] + … + D[l0] > D[i0 + … + D[j0].
In this case, among all possible choices of l, we choose l0 to give the MAXIMUM value of the sum, and we choose i0, j0 to give the MINIMUM possible sum.

Hence, it would be useful precomputing values that answer “what is the [minimum|maximum] value I can get if I [start|end] at position i?”
[/quote] */



/* We use Kadane Algorithm for every element. We find Max subarray sum on the right of every element and store it in rightMax
* similarly stores the Min Subarray sum on the right of every element and store it in rightMin, similarly for leftMax and leftMin */

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
            int n=sc.nextInt();

            int[] arr =new int[n];

            for (int i=0;i<n;i++){
                arr[i]=sc.nextInt();
            }
            // filling the leftMin array for all the elements.
            long[] leftMin =new long[n];

            //leftMin for the first element will the element itself.
            leftMin[0]=arr[0];

            // for every element in the leftMin array, find an element with the minimum value on it's left and if the sum of min+arr[i]<arr[i] then store the value in leftMin
            for (int i=1;i<n;i++){
                leftMin[i]=Math.min(leftMin[i-1]+arr[i],arr[i]);
            }

            long[] leftMax =new long[n];

            leftMax[0]=arr[0];

            // for every element in the leftMax array, find an element with the maximum value on it's left and if the sum of max+arr[i]>arr[i] then store the value in leftMax
            for (int i=1;i<n;i++){
                leftMax[i]=Math.max(leftMax[i-1]+arr[i],arr[i]);
            }

            long[] rightMin =new long[n];

            // for the rightMin we have to start the array from n-1 so that we can build the array considering right elements.
            rightMin[n-1]=arr[n-1];

            for (int i=n-2;i>=0;i--){
                rightMin[i]=Math.min(rightMin[i+1]+arr[i],arr[i]);
            }

            long[] rightMax =new long[n];

            rightMax[n-1]=arr[n-1];

            for (int i=n-2;i>=0;i--){
                rightMax[i]=Math.max(rightMax[i+1]+arr[i],arr[i]);
            }

            long ans=0;

            // once all the four arrays are filled then find the max absolute difference in the rightMax and LeftMin or rightMin and LeftMax
            for (int i=0;i<n-1;i++){
                ans=Math.max(ans,Math.max(Math.abs(rightMax[i+1]-leftMin[i]),Math.abs(rightMin[i+1]-leftMax[i])));
            }

            System.out.println(ans);
        }
    }
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
                catch (IOException e) {
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