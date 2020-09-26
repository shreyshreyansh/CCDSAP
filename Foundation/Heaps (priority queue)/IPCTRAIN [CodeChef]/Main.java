import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main
{
    public static void main(String[] args)
    {
        CP sc =new CP();
        int tt = sc.nextInt();
        while (tt-- > 0) {
            int n = sc.nextInt();
            int d = sc.nextInt();
            ArrayList<Pair>[] days = new ArrayList[d + 1];
            for(int i = 0; i < d + 1; i++) days[i] = new ArrayList<>();
            for(int i = 0; i < n; i++) {
                int D = sc.nextInt();
                int T = sc.nextInt();
                int S = sc.nextInt();
                days[D].add(new Pair(T, S));
            }
            PriorityQueue<Pair> pairPriorityQueue = new PriorityQueue<>((o1, o2) -> {
                if (o1.b != o2.b)
                    return (o1.b - o2.b > 0) ? -1 : 1;
                else if(o1.a != o2.a)
                    return (o1.a - o2.a > 0) ? -1 : 1;
                else
                    return 0;
            });
            for(int i = 1; i < d + 1; i++) {
                for(int j = 0; j < days[i].size(); j++) {
                    Pair p = new Pair(days[i].get(j).a, days[i].get(j).b);
                    pairPriorityQueue.add(p);
                }
                if(pairPriorityQueue.size() > 0) {
                    pairPriorityQueue.peek().a -= 1;
                    if(pairPriorityQueue.peek().a <= 0) {
                        pairPriorityQueue.poll();
                    }
                }
            }
            long res = 0;
            while(pairPriorityQueue.size() > 0) {
                Pair z = pairPriorityQueue.poll();
                res += ((long) z.a * z.b);
            }
            System.out.println(res);
        }
    }
    static class Pair {
        int a, b;
        Pair(int x, int y) {
            a = x;
            b = y;
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