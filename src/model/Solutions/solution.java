package model.Solutions;
import java.util.*;
public class solution {
    static ArrayList<String> Permutation(String str) {
        ArrayList<String> res = new ArrayList<>();
        if (str != null && str.length() > 0) {
            fun(str.toCharArray(), 0, res);
            Collections.sort(res);
        }
        return res;
    }
    static ArrayList<String> fun(char[] sc, int i, ArrayList<String> res) {
        if (i == sc.length - 1) {
            res.add(String.valueOf(sc));
        } else {
            for (int j = i; j < sc.length; j++) {
                if (i == j || sc[i] != sc[j]) {
                    swap(sc, i, j);
                    fun(sc, i + 1, res);
                    swap(sc, i, j);
                }
            }
        }
        return res;
    }
    static void swap(char[] str, int i, int j) {
        if (i != j) {
            char t = str[i];
            str[i] = str[j];
            str[j] = t;
        }
    }
    public String LeftRotateString(String str, int n) {
        StringBuffer s = new StringBuffer();
        StringBuffer s1 = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            if (i < n) s.append(str.charAt(i));
            else s1.append(str.charAt(i));
        }
        s.deleteCharAt(s.length() - 1);
        String ss = (s1.toString() + s.toString());
        return ss;
    }
    static int[] fun(int[] a) {  // webank 3
        int[] b = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            int temp = a[i], count = 0;
            if (temp < 1) b[i] = -1;
            if (temp == 1) b[i] = 0;
            while (temp != 1) {
                if (temp % 2 == 0) {
                    temp = temp / 2;
                    count++;
                    continue;
                }
                if (temp % 2 == 1) {
                    temp = 3 * temp + 1;
                    count++;
                }
            }
            b[i] = count;
        }
        return b;
    }

    static int fun1(int  n, int k, int m) { // webank 2
        if (n <= m)
            return k;
        return (n/m)*k+(n%m == 0 ? 0:1)*k;
    }
    static void YueSeFu(int total ,int cycle){  // webank 1
        Queue<Integer> list=new LinkedList<>();
        for (int i=0;i<total;i++){
            list.add(i+1);
        }
        int k=0;
        while (!list.isEmpty()){
            Integer temp= list.poll();
            k++;
            if (k % cycle==0){
                System.out.print(temp);
            }
            else {
                list.add(temp);
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int  n = sc.nextInt();
        int k= sc.nextInt();
        int m = sc.nextInt();
        System.out.print(fun1(n,k,m));

    }
}
