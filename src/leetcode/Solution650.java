package leetcode;

import static java.lang.Math.sqrt;

public class Solution650 {

    public static void main(String[] args) {
        int ans = 0;
        ans = minSteps(20);
        System.out.println(ans);
    }
    public static int minSteps(int n) {

        if (n == 1) return 0;//1不用操作
        int maxfactor = 1;
        for (int i = 2; i <= sqrt(n); i++)//找公因式老套路了。。
        {
            if (n%i == 0) {
                maxfactor = i;//这里找出n大于1的最小公因数，打个比方，18的最小公因数是3，那么只用把6经过三次操作就可以变成18了
                break;
            }
        }
        if (maxfactor == 1) return n;//maxfactor为1代表n是质数，质数没有公因式，直接返回本身就ok
        return maxfactor + minSteps(n / maxfactor);//还是拿18做例子，变成18所需要的次数=3+变成6所需要的次数。
        //变成6所需要的次数=2+变成3所需要的次数。
        //3是质数，直接返回3，所以答案就是3+2+3=8
    }

}
