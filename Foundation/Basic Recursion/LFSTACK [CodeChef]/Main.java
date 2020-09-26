import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        CP sc = new CP();
        int tt = sc.nextInt();
        while (tt-- > 0) {
            int t = sc.nextInt();
            Stack<Integer>[] st = new Stack[t];
            for (int i = 0; i < t; i++)
                st[i] = new Stack<>();
            for (int i = 0; i < t; i++) {
                int c = sc.nextInt();
                int[] A = new int[c];
                for (int j = 0; j < c; j++) {
                    A[j] = sc.nextInt();
                }
                for (int j = c - 1; j >= 0; j--)
                    st[i].add(A[j]);
            }
            String[] s = sc.nextLine().split(" ");
            if(t==1){
                int i = s.length-1;
                boolean flag = false;
                while(!st[0].isEmpty()){
                    if(Integer.parseInt(s[i]) != st[0].pop()){
                        flag = true;
                        break;
                    }
                    i--;
                }
                if (flag)
                    System.out.println("No");
                else
                    System.out.println("Yes");
                continue;
            }
            if(popRec(st, s, s.length-1))
                System.out.println("Yes");
            else
                System.out.println("No");
        }
    }
    static boolean popRec(Stack<Integer>[] st, String[] s, int n){
        if(n==0)
            return true;
        int x = Integer.parseInt(s[n]);
        for (Stack<Integer> stack : st) {
            if (!stack.isEmpty() && stack.peek() == x) {
                int p = stack.pop();
                if (popRec(st, s, n - 1))
                    return true;
                stack.add(p);
            }
        }
        return false;
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