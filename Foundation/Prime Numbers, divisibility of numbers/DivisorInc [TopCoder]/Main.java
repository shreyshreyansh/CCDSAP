import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        CP sc = new CP();
        int N = sc.nextInt(), M = sc.nextInt();
        System.out.println(countOperations(N,M));
    }
    static int countOperations(int N, int M){
        Queue<Integer> q;
        int[] A;
        q = new LinkedList<>();
        A = new int[M + 1];
        Arrays.fill(A, -1);
        q.add(N);
        A[N] = 0;
        while (!q.isEmpty()) {
            int v = q.poll();
            if (v == M)
                break;
            for (int d : getAllDivisor(v)) {
                int path = v + d;
                if (path <= M && A[path] == -1) {
                    q.add(path);
                    A[path] = A[v] + 1;
                }
            }
        }
        return A[M];
    }
    static ArrayList<Integer> getAllDivisor(int n) {
        ArrayList<Integer> ar = new ArrayList<>();
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                ar.add(n / i);
                ar.add(i);
            }
        }
        return ar;
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