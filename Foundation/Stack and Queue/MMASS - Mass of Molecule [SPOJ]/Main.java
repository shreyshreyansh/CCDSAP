
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        CP sc = new CP();
        String s = sc.nextLine();
        Stack<Long> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'C')
                st.add(12L);
            else if (s.charAt(i) == 'O')
                st.add(16L);
            else if (s.charAt(i) == 'H')
                st.add(1L);
            else if (s.charAt(i) == '(')
                st.add(-1L);
            else if (Character.isDigit(s.charAt(i))) {
                if (!st.isEmpty()) {
                    long x = st.pop();
                    x = x * (s.charAt(i) - '0');
                    st.add(x);
                }
            } else if (s.charAt(i) == ')') {
                long x = 0;
                while (st.peek() != -1) {
                    x += st.pop();
                }
                st.pop();
                st.add(x);
            }
        }
        long x = 0;
        while (!st.isEmpty()) {
            x += st.pop();
        }
        System.out.println(x);
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