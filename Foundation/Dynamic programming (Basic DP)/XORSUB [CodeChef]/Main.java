import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main
{
    public static void main(String[] args)
    {
        CP sc =new CP();
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] arr = new int[n];
            // As we know that the N<=1000 then XOR of any number of N elements cannot exceed more than 1024.
            // because 1000 when converted to binary contains 10 digits and 2^10 is 1024 i.e. if all the 10
            // bits are set then the value will be 1024.

            // This dp has 1024 cells and each cell will have only 0 and 1,so if dp[i]=0 then that means
            // any subset of the given array's XOR does not have value 'i'. For example: i = 24 then there is no
            // subset whose XOR value is 24.
            // Where as, if dp[i] = 1 that means there is a subset whose value is i.

            int[] dp = new int[1024];

            // dp[0] = 1 is because as given in the Q, the XOR of an empty set is 0 so 0 is a possible_xor.
            dp[0] = 1;

            for (int i = 0; i < n; i++)
                arr[i] = sc.nextInt();

            // To understand this, we have to know some XOR fundamentals :
            // if a^b=c then a^c=b and c^b=a because it toggles 1’s which are present in both (a^a^b=b)
            // For example : (1^2^3)^3 = 1^2;
            // Similarly if j is (1^2^3) and arr[i] is 3 then j^arr[i] is (1^2) and if dp[(1^2)]=1 i.e. if 1^2 is
            // a possible subset answer then (1^2)^(3) will also be a possible subset answer because (1^2)^arr[i]
            // will also be a subset answer so dp[j]=1.
            // Suppose now j=(1^2) and arr[i] = 3 and if dp[1^2^3] =1 then dp[1^2] =1.
            for (int i = 0; i < n; i++) {
                for (int j = 1; j < 1024; j++) {
                    if (dp[j ^ arr[i]] == 1)
                        dp[j] = 1;
                }
            }

            int ans = 0;

            // Now we know all the possible answers of subset through the dp array and now we just have to find the
            // max out of all the possible value with k.
            for (int i = 0; i < 1024; i++) {
                if (dp[i] == 1)
                    ans = Math.max(ans, k ^ i);
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