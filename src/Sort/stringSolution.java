package Sort;
import java.util.*;
public class stringSolution {

    static ArrayList<String> Permutation(String str) { // 字符串全排列
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

    // 从集合依次选出每一个元素，作为排列的第一个元素，然后对剩余的元素进行全排列，如此递归处理；
    //
    //比如：首先我要打印abc的全排列，就是第一步把a 和bc交换（得到bac,cab），这需要一个for循环，
    // 循环里面有一个swap，交换之后就相当于不管第一步了，进入下一步递归，所以跟一个递归函数，
    // 完成递归之后把交换的换回来，变成原来的字串
    static Set<String> ans = new HashSet<>();

    static void Permutation2(char[] s , int from, int to){
        if (to<1) return ;
        if (from==to){
            ans.add( String.valueOf(s));
        }else {
            for (int i=from; i<=to ;i++){
                if ( i==from || s[i]!=s[from]){
                    swap(s,i,from);
                    Permutation2(s,from+1,to);
                    swap(s,from,i);
                }

            }
        }
    }
    static void swap(char[] str, int i, int j) {
        if (i != j ) {
            char t = str[i];
            str[i] = str[j];
            str[j] = t;
        }
    }


    // 字符串的全组合
    public static Set<String> Combination(char [] s){
        Set<String> res = new HashSet<>();
        if(s.length == 0){
            return null;
        }
        int len = s.length;
        int n = 1<<len;
        //从1循环到2^len-1
        for(int i=0;i<n;i++){
            StringBuffer sb = new StringBuffer();
            //查看第一层循环里面的任意一种取值当中的哪一位是1[比如ab,011]， 如果是1，对应的字符就存在，打印当前组合。
            for(int j=0;j<len;j++){
                if( (i & (1<<j)) != 0) // 对应位上为1，则输出对应的字符
                {
                    sb.append(s[j]);
                }
            }
            if (!sb.toString().equals("")){
                res.add(sb.toString());
            }

        }
        return res;
    }




    static String fun1(String s1,String s2){ //寻找最长公共子串
        char[] t1=s1.toCharArray();
        char[] t2=s2.toCharArray();
        int [][]temp=new int[t1.length][t2.length];
        int length=0,index=0;
        for (int i=0;i<t1.length;i++){
            for (int j=0;j<t2.length;j++){
                if (t1[i]==t2[j]){
                    if (i>0 && j>0){
                        temp[i][j]=temp[i-1][j-1]+1;
                    }else{
                        temp[i][j]=1;
                    }
                    if (temp[i][j]>length)
                        length=temp[i][j];
                    index=j;
                }
                else temp[i][j]=0;
            }
        }
        StringBuilder t3=new StringBuilder();
        for (int k=index-length+1;k<=index;k++){
            t3.append(t2[k]);
        }
        return t3.toString();
    }



    public String LeftRotateString(String str, int n) { // 左旋n位字符串
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


    // aabba
    public static String longestPalindrome(String s){ // 最长回文子串
        if (s==null) return null;
        int start = 0 , end = 0;
        for (int i=0;i<s.length();i++){
            int len1 = lengthString(s,i,i);
            int len2 = lengthString(s,i,i+1);
            int len = Math.max(len1,len2);
            if (len>end-start){
                start = i - (len-1)/2;
                end = i+ len/2;
            }
        }
        return s.substring(start,end+1);
    }
    public static int lengthString(String s , int left , int right){
        int l = left, r = right;
        while (l>=0 && r<s.length() &&(s.charAt(l)==s.charAt(r))){
            l--;
            r++;
        }
        return r-l-1;
    }




    static int num =0;
    public static int countSubstrings(String s){  // 回文子串数目
        for (int i=0;i<s.length();i++){
            count(s,i,i);
            count(s,i,i+1);
        }
        return num;
    }
    public  static void count(String s,int start,int end){
        while (start>=0&& end<s.length() && s.charAt(start)==s.charAt(end)){
            num++;
            start--;
            end++;
        }
    }


    /**
     * 解题思路：
     * 将decodeStr拆解后会有四种可能：数字、字母、[、]
     * 使用栈保存遍历的结果，numStack保存数字，stringStack保存字母
     * 例:3[a2[c]]
     * 1、遇到数字：计算数字的大小，注意连续数字的情况
     * 2、遇到左括号：将之前得到的数字入栈，之前得到的字母也入栈，情况数字和字母
     * 3、遇到字母：累加连续字母
     * 4、遇到右括号：将数字出栈，将累加字母根据数字翻倍，将字母也出栈，和翻倍字母拼接
     * 5、循环1-4
     *
     * @param s
     * @return
     */
    public static String decodeString(String s) {
        StringBuilder builder = new StringBuilder();
        LinkedList<Integer> numStack = new LinkedList<>();
        LinkedList<String> stringStack = new LinkedList<>();
        int num = 0;
        for (char c : s.toCharArray()) {
            if (c >= '0' && c <= '9') {
                //1
                num = num * 10 + c - '0';
            } else if (c == '[') {
                //2
                numStack.addLast(num);
                stringStack.addLast(builder.toString());
                builder.delete(0, builder.length());
                num = 0;
            } else if (c == ']') {
                //4
                String item = builder.toString();
                Integer numItem = numStack.removeLast();
                for (int i = 1; i < numItem; i++) {
                    builder.append(item);
                }
                builder.insert(0, stringStack.removeLast());
            } else {
                //3
                builder.append(c);
            }
        }

        return builder.toString();

    }


    public static void main(String[] args) {

    Permutation2("abac".toCharArray(),0,"abac".length()-1);
        System.out.println(ans);
        ArrayList<String> anss = Permutation("aabc");
        System.out.println(anss);

        Set<String>  s = Combination("ababc".toCharArray());
        ArrayList<String> an = new ArrayList<>(s);
        Collections.sort(an);
        System.out.println(an);

        String ansss = longestPalindrome("abba");
        System.out.println(ansss);

        String decode = decodeString("3[a]2[bc]ef");
        System.out.println(decode);
    }
}
