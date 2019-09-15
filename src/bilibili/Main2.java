package bilibili;


import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        int ans = fun(n);
        System.out.println(ans);
    }

    private static int fun(long n) {
        int ans=1;
        if (n<=0){
            return 0;
        }
        if (n==1 || n==2){
            return 1;
        }
        if (n==3){
            return 2;
        }
         long i=1;
            while (i<= n/2){
               long sum = i;
                for (long j=i+1;j<=(n/2+1);j++){
                    sum+=j;
                    if (sum==n){
                        ans++;
                    }
                    if (sum>n){
                        break;
                    }
                }
                i++;
            }
        return ans;
    }
}
