package model.Sort;
import java.util.*;
import java.util.ArrayList;

public class baidu {
    public void me(){
        System.out.println("me is invoked");
    }
    static ArrayList<Integer> fun(int n, int m){
        ArrayList<Integer> array=new ArrayList<>();
        for (int i=n;i<=m;i++){
            int a=i/100;
            int b=(i-a*100)/10;
            int c=i-a*100-b*10;
            if((Math.pow(a,3)+Math.pow(b,3)+Math.pow(c,3))==i)
                array.add(i);
        }
        return array;
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
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        if(array.length==0) return;
        ArrayList<Integer> a1=new ArrayList<>();
        ArrayList<Integer> a2=new ArrayList<>();
        int sum=array[0];
        for(int i=1;i<array.length;i++){ //将数组的每个数字按位 异或 得到最后的数字就是两个唯一的数字异或的结果
            sum^=array[i];
        }
        int index=find(sum);
        for (int i=0;i<array.length;i++){ // 按照第index位是不是1分成两组，这两组里面一组有一个唯一的数字
            if (isindex1(array[i],index)==0)
                a1.add(array[i]);
            else a2.add(array[i]);
        }

        for (Integer i:a1
        ) {num1[0]^=i;
        }
        for (Integer j:a2
        ) {num2[0]^=j;
        }
    }
    static int isindex1(int num,int index){ //判断数字的第index位置是不是1
        return (num>>(index-1))&1;
    }
    static int find(int sum){ // 找出数字的第一个为1 的位置
        int index=1;
        while(sum!=0){
            if((sum&1)==1){
                return index;
            }else{
                sum=sum>>1;
                index++;

            }
        }
        return index;
    }
    static double ssqrt(double n){ // 求平方根
        double diff=1e-9;
        double x=1.0;
        while(Math.abs(x*x-n) >diff){
            x=x-((x*x-n)/(2*x));
        }
        return x;
    }
    static double swqrt(double n){ // 求li方根
        double diff=1e-9;
        double x=1.0;
        while(Math.abs(x*x*x-n) >diff){
            x=x-((x*x*x-n)/(3*x*x));
        }
        return x;
    }
    static int Strint2Int(String str){
        if (str==null || str.trim().equals("")) return 0;
        int res=0; int minus=1; int start=0;
        char[] chars=str.trim().toCharArray();
        if (chars[0]=='+') {minus=1; start=1;}
        if (chars[0]=='-') {minus=-1;start=1;}
        for (int i=start;i<chars.length;i++){
            if (chars[i]>'9' || chars[i]<'0'){
                return 0;
            }
            res=res*10+(int)(chars[i]-'0');
        }
        return res*minus;
    }
    static ArrayList<String[]> fun(String arr[]){
        ArrayList<String[]> res=new ArrayList<>();
        if(arr!= null && arr.length>0)
        {
            fun1(arr,0,res);

        }
        return  res;


    }
    static ArrayList<String[]> fun1(String[] sc,int i,ArrayList<String[]> res){
        if(i==sc.length-1){
            res.add(sc);
        }
        else{
            for(int j=i;j<sc.length;j++){
                if(i==j || sc[i]!=sc[j]){
                    swap(sc,i,j);
                    fun1(sc,i+1,res);
                    swap(sc,i,j);
                }
            }
        }
        return res;

    }
    static void swap(String[] str, int i, int j) {
        if (i != j) {
            String t = str[i];
            str[i] = str[j];
            str[j] = t;
        }
    }

    public static void main(String[] args )throws Exception{

        String[] arr={  "abcd","defg","ghij","jkl" };
        ArrayList<String[]> ans=fun(arr);
        for (String[] a:ans
             ) {
            for (int i=0;i<a.length;i++){
                System.out.println(a[i]);
            }
            System.out.println("done");

        }
//        baidu b =new baidu();
//        System.out.println(b.Strint2Int("1+23"));
//        Map<String,Integer> map=new LinkedHashMap<>();
        List<String> languages = Arrays.asList("java","scala","python");
        languages.forEach(x->System.out.println(x));
//        Scanner sc=new Scanner(System.in);
//        int n,m;
//        while(sc.hasNext()) {
//            n = sc.nextInt();
//            m = sc.nextInt();
//            ArrayList<Integer> a= fun(n,m);
//            if(a.size()==0)
//            {System.out.print("no");}
//            else {
//                for (Integer i: a
//                     ) {System.out.print(i+" ");
//                }
//            }
//        }
//        String s1="abcbced";
//        String s2="acbcbcef";
//
//        System.out.println(swqrt(8));
//
//        baidu b=new baidu();
//        System.out.println(b.getClass().getSimpleName());
//        Class c=b.getClass();
//        baidu a=(baidu)c.newInstance();
//        Method[] m=c.getDeclaredMethods();
//        Method mmm=c.getDeclaredMethod("me");
//        mmm.invoke(a);
//        Method mc=c.getDeclaredMethod("ssqrt", double.class);
//        System.out.println(mc.invoke(a,9));
//        for (Method mm:m
//             ) {
//            System.out.println(mm);
//        }

    }
}

