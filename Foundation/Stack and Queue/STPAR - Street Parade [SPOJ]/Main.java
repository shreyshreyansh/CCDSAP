
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        CP sc = new CP();
        while(true) {
            int n = sc.nextInt();
            if(n==0)
                break;
            Queue<Integer> queue = new LinkedList<>();
            for (int i = 0; i < n; i++)
                queue.add(sc.nextInt());
            int want = 1;
            Stack<Integer> st = new Stack<>();
            while (!queue.isEmpty()) {
                if (st.isEmpty()) {
                    if (queue.peek() == want) {
                        want++;
                        queue.poll();
                    } else
                        st.push(queue.poll());
                } else {
                    if (st.peek() == want || (!queue.isEmpty() && queue.peek() == want)) {
                        if (st.peek() == want) {
                            st.pop();
                        } else
                            queue.poll();
                        want++;
                    } else if (!queue.isEmpty()) {
                        st.push(queue.poll());
                    }
                }
            }
            while ((!st.isEmpty() && st.peek() == want)) {
                st.pop();
                want++;
            }
            if (st.isEmpty())
                System.out.println("yes");
            else
                System.out.println("no");
        }
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