
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main
{
    public static void main(String[] args)
    {
        CP sc =new CP();
        int k=0;
        while(true){
            ++k;
            String s = sc.nextLine();
            if(s.indexOf('-')>=0)
                break;
            else{
                int o = 0, min = 0;
                char[] c = s.toCharArray();
                for(int i=0;i<c.length;i++){
                    if(c[i] == '{') {
                        ++o;
                        continue;
                    }
                    if(o==0) {
                        ++min;
                        ++o;
                        continue;
                    }
                    --o;
                }
                System.out.println(k+". "+(min+(o>>1)));
            }
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