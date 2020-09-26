
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main
{
    public static void main(String[] args)
    {
        CP sc =new CP();
        StringBuilder sb=new StringBuilder();
        int tt = sc.nextInt();
        while (tt-- > 0) {
            char[] s =sc.nextLine().toCharArray();
            int i;
            int n=s.length;
            int[] a =new int[n];
            Arrays.fill(a,-1);
            Stack<Integer> st=new Stack<>();
            for(i=0;i<n;i++)
            {
                if(s[i]=='<') st.push(i);
                else
                {
                    if(st.isEmpty()) break;
                    else
                    {
                        int p=st.pop();
                        a[i]=p;
                        a[p]=i;
                    }
                }
            }
            int l=0;
            for(i=0;i<n;i++)
                if(a[i]>=0) l++;
                else break;
            sb.append(l).append("\n");
        }
        System.out.println(sb);
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