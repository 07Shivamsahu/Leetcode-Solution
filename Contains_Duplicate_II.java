// Given an integer array nums and an integer k, return true if there are two distinct indices i and j in the array such that nums[i] == nums[j] and abs(i - j) <= k.

 

// Example 1:

// Input: nums = [1,2,3,1], k = 3
// Output: true
// Example 2:

// Input: nums = [1,0,1,1], k = 1
// Output: true
// Example 3:

// Input: nums = [1,2,3,1,2,3], k = 2
// Output: false
 

// Constraints:

// 1 <= nums.length <= 105
// -109 <= nums[i] <= 109
// 0 <= k <= 105
import java.util.HashSet;
import java.util.Scanner;

public class Contains_Duplicate_II {
    public static void main(String [] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the size of the array: ");
        int size=sc.nextInt();
        int[] nums =new int[size];
        System.out.println("Enter the Array: ");
        for(int i=0; i<size; i++){
            System.out.println("Enter Element"+ i + ": ");
            nums[i]=sc.nextInt();
        }
        System.out.println("Enter the element you want to check: ");
        int k=sc.nextInt();
        Contains_Duplicate_II cd=new Contains_Duplicate_II();
        System.out.print(cd.containsNearbyDuplicate(nums, k));
        sc.close();
    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        // Base case
        if(nums == null || nums.length<2 || k==0){
            return false;
        }   
        int i=0;
        HashSet<Integer> hset=new HashSet<Integer>();

        for(int j=0; j<nums.length; j++){
            if(!hset.add(nums[j])){
                return true;
            }
            if(hset.size()>=k+1){
                hset.remove(nums[i++]);
            }
        }
        return false;
    }
}
