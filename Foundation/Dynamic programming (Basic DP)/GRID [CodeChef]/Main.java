import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main
{
    public static void main(String[] args)
    {
        CP sc =new CP();
        int t = sc.nextInt();
        while (t-- > 0) {

            int n = sc.nextInt();

            // Input :
            // 1
            // 5
            // ..#..
            // ....#
            // .....
            // .##.#
            // ...#.
            int[][] mat1 = new int[n][n];
            int[][] mat2 = new int[n][n];

            // Make two matrix and intialize -1 wherever there is '#'
            for(int i=0;i<n;i++){
                String s = sc.nextLine().trim();
                for(int j=0;j<s.length();j++){
                    if(s.charAt(j)=='#') {
                        mat1[i][j] = -1;
                        mat2[i][j] = -1;
                    }
                }
            }

            // Use prefix sum from both the matrix. Matrix1 will be right to left prefix sum
            // and Matrix2 will be bottom to top prefix sum.
            /*
            Matrix1:
            -1 -1 -1  0   0
            -1 -1 -1 -1 -1
             0  0  0  0  0
            -3 -3 -2 -1 -1
            -1 -1 -1 -1  0

            Matrix2:
            0 -1 -2 -1 -2
            0 -1 -1 -1 -2
            0 -1 -1 -1 -1
            0 -1 -1 -1 -1
            0  0  0 -1  0
            */
            for(int i=0;i<n;i++) {
                for (int j = n-1; j >= 1; j--) {
                    mat1[i][j-1]+=mat1[i][j];
                    mat2[j-1][i]+=mat2[j][i];
                }
            }

            int ans = 0;

            // if cell in mat1 and mat2 are 0 then that means we can see from south to east.
            for(int i=0;i<n;i++) {
                for(int j=0;j<n;j++){
                    if(mat1[i][j]==0 && mat2[i][j]==0)
                        ans++;
                }
            }

            System.out.println(ans);
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