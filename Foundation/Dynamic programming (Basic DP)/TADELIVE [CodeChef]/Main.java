import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main
{
    public static void main(String[] args)
    {
        CP sc =new CP();

        int n = sc.nextInt(), a = sc.nextInt(), b = sc.nextInt();

        int[] andy = new int[n];
        int[] bob = new int[n];

        // Input of tips for andy and bob
        for(int i=0;i<n;i++)
            andy[i] = sc.nextInt();
        for(int i=0;i<n;i++)
            bob[i] = sc.nextInt();

        //Made a pair for both the corresponding tips so that it is easy to sort them.
        Pair[] p = new Pair[n];
        for(int i=0;i<n;i++)
            p[i] = new Pair(andy[i], bob[i]);

        //Sort the pair array with respect to the max difference in their tips.(Highest difference will be placed last)
        Arrays.sort(p, Comparator.comparingInt(o -> Math.abs(o.x - o.y)));

        int andyOrders = 0, bobOrders = 0;

        long res = 0;

        // traverse the array from last.
        for(int i=n-1;i>=0;i--){

            // if tip of andy is greater than boby.
            if(p[i].x>p[i].y){

                // if andy's order did exceed the limit of his order.
                if(andyOrders<=a-1){
                    andyOrders++;
                    res+=p[i].x;
                }else{
                    bobOrders++;
                    res+=p[i].y;
                }
            }else{
                if(bobOrders<=b-1){
                    bobOrders++;
                    res+=p[i].y;
                }else{
                    andyOrders++;
                    res+=p[i].x;
                }
            }
        }

        System.out.println(res);
    }
    static class Pair{
        int x,y;
        Pair(int a, int b){
            x=a;
            y=b;
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