import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main
{
    static boolean[] prime = new boolean[1000002];
    static void sieveOfEratosthenes()
    {
        for(int i=0;i<1000001;i++)
            prime[i] = true;
        for(int p = 2; p*p <=1000001; p++)
        {
            if(prime[p])
            {
                for(int i = p*p; i <= 1000001; i += p)
                    prime[i] = false;
            }
        }
        prime[1] = false;
    }
    static boolean isPresent(String s, ArrayList<String> Res)
    {
        for (String str : Res) {
            if (str.equals(s))
                return true;
        }
        return false;
    }
    static ArrayList<String> distinctPermute(String str)
    {
        if (str.length() == 0) {
            ArrayList<String> baseRes = new ArrayList<>();
            baseRes.add("");
            return baseRes;
        }
        char ch = str.charAt(0);
        String restStr = str.substring(1);
        ArrayList<String> prevRes = distinctPermute(restStr);
        ArrayList<String> Res = new ArrayList<>();
        for (String s : prevRes) {
            for (int i = 0; i <= s.length(); i++) {
                String f = s.substring(0, i) + ch + s.substring(i);
                if (!isPresent(f, Res))
                    Res.add(f);
            }
        }
        return Res;
    }
    public static void main(String[] args)
    {
        CP sc =new CP();
        sieveOfEratosthenes();
        int tt = sc.nextInt();
        while (tt-- > 0) {
            StringBuilder st = new StringBuilder(sc.nextLine());
            char[] c = st.toString().toCharArray();
            String[] res = new String[3];
            Arrays.sort(c);
            st = new StringBuilder();
            for (char value : c) st.append(value);
            long min = Long.MAX_VALUE;
            ArrayList<String> ar = distinctPermute(st.toString());
            for (String s : ar) {
                if (s.charAt(0) == '0')
                    continue;
                for (int i = 0; i < s.length() - 2; i++) {
                    if (s.charAt(i + 1) == '0')
                        continue;
                    for (int j = i + 1; j < s.length() - 1; j++) {
                        if (s.charAt(j + 1) == '0')
                            continue;
                        String[] t = new String[3];
                        if (j - i + 1 < i + 1)
                            continue;
                        t[0] = s.substring(0, i + 1);
                        t[1] = s.substring(i + 1, j - i + 1);
                        t[2] = s.substring(j - i + 1);
                        if (!t[1].equals("") && !t[2].equals("") && !t[0].startsWith("0") && !t[1].startsWith("0") && !t[2].startsWith("0"))
                            if (prime[Integer.parseInt(t[0])] && prime[Integer.parseInt(t[1])] && prime[Integer.parseInt(t[2])]) {
                                long h = Integer.parseInt(t[0]) * Integer.parseInt(t[1]) * Integer.parseInt(t[2]);
                                if (min > h) {
                                    min = h;
                                    res = t;
                                }
                            }
                    }
                }
            }
            if(min==Long.MAX_VALUE) {
                System.out.println("{ }");
                continue;
            }
            Arrays.sort(res, Comparator.comparingInt(Integer::parseInt));
            System.out.print("{ ");
            for(String g : res)
                System.out.print(g+" ");
            System.out.println("}");
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