
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        CP sc = new CP();
        while (true) {
            int t = sc.nextInt();
            if (t == 0)
                break;
            long[] hist = new long[t];
            for (int i = 0; i < t; i++)
                hist[i] = sc.nextInt();
            System.out.println(getMaxArea(hist, t));
        }
    }

    public static long getMaxArea(long hist[], long n) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        long res = 0;
        for (int i = 0; i < hist.length; i++) {
            while (!stack.isEmpty() && hist[stack.peek()] >= hist[i]) {
                int tp = stack.pop();
                long curr = hist[tp] * ((stack.isEmpty()) ? i : (i - stack.peek() - 1));
                res = Math.max(res, curr);
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            int tp = stack.pop();
            long curr = hist[tp] * ((stack.isEmpty()) ? n : (n - stack.peek() - 1));
            res = Math.max(res, curr);
        }
        return res;
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