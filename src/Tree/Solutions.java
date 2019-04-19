package Tree;
import java.util.Scanner;

public class Solutions {
    static int fun(int n,long [] d,int [] p){
        long current=d[0];
        int sum=p[0];
        if (n==1)
            return sum;
        return fun1(current,sum,1,d,p);

    }
   static int fun1(long current,int sum,int index,long [] d,int [] p){
        if (index==d.length)
            return sum;
        if (current<d[index]){
            current+=d[index];
            sum+=p[index];
            index++;
            return fun1(current,sum,index,d,p);
        }
        else {
            int f1=fun1(current,sum,index+1,d,p);
            int f2=fun1(current+d[index],sum+p[index],index+1,d,p);
            return f1<f2 ? f1:f2;
        }
    }

    public static void main(String[] args ){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        if (n<=0){
            System.out.println(0);
            return;
        }
        long[]d=new long[n];
        for (int i=0;i<n;i++){
            d[i]=sc.nextLong();
        }
        int[]p=new int[n];
        for (int i=0;i<n;i++){
            p[i]=sc.nextInt();
        }
        System.out.println(fun(n,d,p));
    }
}




