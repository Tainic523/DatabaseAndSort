package model.Sort;

import java.util.Arrays;

public class sorttest {
    static int[] insertsort(int[] a) { // 插入排序
        int n = a.length;
        int i, j;
        for (i = 1; i < n; i++) {
            int temp = a[i];
            for (j = i - 1; j >= 0 && a[j] > temp; j--) {
                a[j + 1] = a[j];
            }
            a[j + 1] = temp;
        }
        return a;
    }
    static void fastsort(int[] a,int low,int high){ // 快速排序
        if(low>high) return;
        int index=a[low];
        int i=low,j=high;
        while(i<j){
            while(i<j && a[j]>=index){
                j--;
            }
            while(i<j && a[i]<=index){
                i++;
            }
            if (i<j){
                int temp=a[i];
                a[i]=a[j];
                a[j]=temp;
            }

        }
        a[low]=a[j];
        a[j]=index;
        fastsort(a,low,j-1);
        fastsort(a,j+1,high);
    }

    static int[] bininsertsort(int[] a){ // 折半排序
        for (int i=1;i<a.length;i++){
            if (a[i]<a[i-1]){
                int temp=a[i];
                int low=0,high=i-1;
                while(low<=high){
                    int mid=(low+high)/2;
                    if (temp<a[mid])
                        high=mid-1;
                    else low=mid+1;
                }
                for (int j=i-1;j>=high+1;j--){
                    a[j+1]=a[j];
                }
                a[high+1]=temp;
            }
        }
        return a;
    }
    static int[] shellsort(int[] a){ // 希尔排序
        int d=a.length/2;
        while (d>0){
        for (int i=d;i<a.length;i++){
            int temp=a[i],j=i-d;
            while(j>=0 && temp<a[j]){
                a[j+d]=a[j];
                j=j-d;
            }
            a[j+d]=temp;
        }
        d=d/2;
        }
        return a;
    }
    static int[]  bubblesort(int[] a){ //冒泡排序

        for (int i=0;i<a.length;i++){
            boolean exchange=false;
            for (int j=a.length-1;j>i;j--){
                if (a[j]<a[j-1]){
                    int temp=a[j];
                    a[j]=a[j-1];
                    a[j-1]=temp;
//                    swap(a[j],a[j-1]);
                    exchange=true;
                }
            }
            if (!exchange)
                break;
        }
        return a;
    }
//    static void swap(int a,int b){
//        int temp=a;
//        a=b;
//        b=temp;
//    }
    static void selectsort(int[] a){ //选择排序
        for (int i=0;i<a.length;i++){
            int min=i;
            for (int j=i+1;j<a.length;j++){
                if (a[j]<a[min]){
                    min=j;
                }
            }
            if (min!=i){
                int temp=a[min];
                a[min]=a[i];
                a[i]=temp;
            }
        }
        Arrays.parallelSort(a);
    }
    static double myPow(double x, int n) { // 求x的n次方
        if (n == 0) return 1;
        double half = myPow(x, n / 2);
        if (n % 2 == 0) return half * half;
        if (n > 0) return half * half * x;
        return half * half / x;
    }
    public static void main(String[] args){
        sorttest st=new sorttest();
        System.out.println(st.myPow(-10,2));
//        int [] a={2,4,3,6,3,2,5,5};
//        st.insertsort(a);
//        st.fastsort(a);
//        st.bininsertsort(a);
//        st.shellsort(a);
//        st.bubblesort(a);
//          st.selectsort(a);
//        st.fastsort(a,0,a.length -1);
//        for (int i:a) {
//            System.out.print(i+" ");
//        }
    }

}
