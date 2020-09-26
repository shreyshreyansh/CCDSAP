import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        CP sc = new CP();
        char[] c = sc.nextLine().toCharArray();
        int n = c.length;
        ArrayList<Integer> a = new ArrayList<>();
        for (int i = 0, k = 0, temp = 0; i < n; i++) {
            if (c[i] == '(') {
                ++k;
            } else {
                --k;
            }
            if (k != -1) {
                ++temp;
            }
            if (k == 0 && temp > 0) {
                a.add(temp);
            }
            if (k == -1) {
                k = 0;
                temp = 0;
            }
        }
        int max = (a.size() > 0 ? Collections.max(a) : 0), num = 0;
        for (Integer integer : a) {
            if (integer == max) {
                ++num;
            }
        }
        a = new ArrayList<>();
        for (int i = n - 1, k = 0, temp = 0; i >= 0; i--) {
            if (c[i] == ')') {
                ++k;
            } else {
                --k;
            }
            if (k != -1) {
                ++temp;
            }
            if (k == 0 && temp > 0) {
                a.add(temp);
            }
            if (k == -1) {
                k = 0;
                temp = 0;
            }
        }
        int max2 = (a.size() > 0 ? Collections.max(a) : 0), num2 = 0;
        for (Integer integer : a) {
            if (integer == max2) {
                ++num2;
            }
        }
        if (max2 > max) {
            max = max2;
            num = num2;
        } else if (max == max2) {
            num = Math.max(num, num2);
        }
        System.out.println(max + " " + (max == 0 ? 1 : num));
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