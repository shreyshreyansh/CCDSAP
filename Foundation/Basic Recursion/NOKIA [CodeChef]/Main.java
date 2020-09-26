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
            int n = sc.nextInt(), m = sc.nextInt();
            int min = minValue(n);
            int max = maxValue(n);
            if(m>=min&&m<=max)
                System.out.println(0);
            else if(m>max)
                System.out.println(m-max);
            else
                System.out.println(-1);
        }
    }
    static int minValue(int n){
        if(n==1)
            return 2;
        else if(n==2)
            return 5;
        return n + 1 + minValue(n/2) + minValue((n-1)/2);
    }
    static int maxValue(int n){
        if(n==1)
            return 2;
        return n + 1 + maxValue(n - 1);
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