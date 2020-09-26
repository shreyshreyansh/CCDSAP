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
        String s = sc.nextLine();
        Stack<Character> st = new Stack<>();
        for(int i=0;i<s.length();i++) {
            if(st.isEmpty()) {
                st.add(s.charAt(i));
            }else{
                if(st.peek()==s.charAt(i))
                    st.pop();
                else
                    st.add(s.charAt(i));
            }
        }
        if(st.isEmpty())
            System.out.println("Yes");
        else
            System.out.println("No");
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