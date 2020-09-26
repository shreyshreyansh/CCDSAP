
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuffer s1 = new StringBuffer();
        String ss = sc.nextLine().trim();
        Queue<Character> s = new LinkedList<>();
        int[] a = new int[26];
        for(int i=0;i<ss.length();i++){
            a[(int)ss.charAt(i)-97]++;
            s.add(ss.charAt(i));
        }
        Stack<Character> t = new Stack<>();
        while(!s.isEmpty())
        {
            if(t.isEmpty()){
                a[(int)s.peek()-97]--;
                t.push(s.remove());
            }
            else{
                boolean f = true;
                for(int i=(int)t.peek()-97-1;i>=0;i--)
                    if(a[i]!=0){
                        f = false;
                        break;
                    }
                if(f){
                    s1.append(t.pop());
                }
                else{
                    a[(int)s.peek()-97]--;
                    t.push(s.remove());
                }
            }
        }
        while(!t.isEmpty())
            s1.append(t.pop());
        System.out.print(s1);
    }
}
