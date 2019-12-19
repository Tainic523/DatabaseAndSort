package Sort;

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
    static void qsort(int[] arr,int start,int end){ // 快速排序
        int pivot = arr[start];
        int i = start;
        int j = end;
        while (i<j) {
            while ((i<j)&&(arr[j]>pivot)) {
                j--;
            }
            while ((i<j)&&(arr[i]<pivot)) {
                i++;
            }
            if ((arr[i]==arr[j])&&(i<j)) {
                i++;
            } else {
                swap(arr,i,j);
            }
        }
        if (i-1>start) qsort(arr,start,i-1);
        if (j+1<end) qsort(arr,j+1,end);
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

    /**
     * 堆排序
     * @param arr
     */
    public static void heapSort(int[] arr) {
        // 将待排序的序列构建成一个大顶堆
        for (int i = arr.length / 2; i >= 0; i--){
            heapAdjust(arr, i, arr.length);
        }

        // 逐步将每个最大值的根节点与末尾元素交换，并且再调整二叉树，使其成为大顶堆
        for (int i = arr.length - 1; i > 0; i--) {
            swap(arr, 0, i); // 将堆顶记录和当前未经排序子序列的最后一个记录交换
            heapAdjust(arr, 0, i); // 交换之后，需要重新检查堆是否符合大顶堆，不符合则要调整
        }
    }

    /**
     * 构建堆的过程
     * @param arr 需要排序的数组
     * @param i 需要构建堆的根节点的序号
     * @param n 数组的长度
     */
    private static void heapAdjust(int[] arr, int i, int n) {
        if (i>n){ // 递归出口
            return;
        }
        int c1 = 2*i+1; // 左孩子
        int c2 = 2*i+2; //  右孩子
        int max = i;   // 找出三个最大的
        if (c1<n && arr[c1]>arr[max]){
            max = c1;
        }
        if (c2<n && arr[c2]>arr[max]){
            max = c2;
        }
        if (i!=max){
            swap(arr,i,max);
            heapAdjust(arr,max,n);
        }

    }

    // 交换元素位置
    private static void swap(int[] arr, int index1, int index2) {
        int tmp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = tmp;
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
        int [] a={2,4,3,6,3,2,5,5};
        heapSort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }

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
