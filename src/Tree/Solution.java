package Tree;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {
    public ArrayList<ArrayList<Integer>> threeSum(int[] nums){
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        Arrays.parallelSort(nums);
        for (int i=0;i<nums.length;i++){
            for (int j=i+1;j<nums.length;j++){
                for (int k=j+1;k<nums.length;k++){
                    if ((nums[i]+nums[j]+nums[k])==0){
                        ArrayList<Integer> temp=new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);
                        if (!iscontain(ans,temp)){
                            ans.add(temp);
                        }
                    }
                }
            }
        }
        return ans;
    }
    static boolean iscontain(ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> a){
        for (ArrayList<Integer> aa:ans
             ) {
            if (aa.equals(a))
                return true;
        }
        return false;
    }

    public static void main(String[] args){
        Solution s=new Solution();
        int[] num={-4,-1,-1,0,1,2};
        ArrayList<ArrayList<Integer>> ans=s.threeSum(num);
        System.out.println(ans);

    }
}
