import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main
{
    public static void main(String[] args)
    {
        CP sc =new CP();
        int tt = sc.nextInt();
        while (tt-- > 0) {
            int n = sc.nextInt();
            map = new HashMap<>();
            System.out.println(count(n,2));
            System.out.println(map);
        }
    }
    static HashMap<String,Integer> map;
    static int count(int n, int l){
        int res = 0;
        if(map.containsKey(n+" "+l))
            return map.get(n+" "+l);
        for(int i=l;i*i<=n;i++){
            if(n%i==0)
                res+= count(n/i, i) + 1;
        }
        map.put(n+" "+l,res);
        return res;
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