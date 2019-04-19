package xiecheng;
import java.util.*;
public class solutionss {
    public static void main(String[] args ){
        Scanner sc1=new Scanner(System.in);
        int m= sc1.nextInt();
        HashMap<String,Integer> hashMap=new HashMap<>();
        ArrayList<String> arrayList=new ArrayList<>();
        int [] a=new int [m];
        for (int i=0;i<m;i++){
            String s=sc1.next();
            if (s.charAt(s.length()-1)=='/')
                s=s.substring(0,s.length()-1);

            if (hashMap.containsKey(s)){
                arrayList.add(s);
                a[i]=hashMap.get(s)+1;
                hashMap.put(s,a[i]);
            }else {
                arrayList.add(s);
                a[i]=1;
                hashMap.put(s,1);
            }
        }
        fun1(fun2(arrayList.get(0)),a[0]);
        for (int i=1;i<m;i++){
            System.out.print(" ");
            fun1(fun2(arrayList.get(i)),a[i]);
        }
    }
    static  int fun2(String s){
        int count=0;
        for (int i=0;i<s.length();i++){
            if (s.charAt(i)=='/')
                count++;
        }
        return count;
    }
    static void fun1(int n,int val){
        if (n==1) System.out.print("1");
        else if (n==2){
            System.out.print("11");
        }else {
            System.out.print("1");
            for (int i=0;i<n-1;i++){
                System.out.print(val);
            }
            System.out.print("1");
        }
    }
}
