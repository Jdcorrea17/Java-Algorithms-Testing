//Write a function that takes this list of numbers, as well as the max_num, and it should return the missing number.
//For example, given a list of numbers, in random order, of 1…10, 8 was removed. If this list and the maxNum of 10 was passed into the function, it would return 8: missingNumber({2, 1, 4, 3, 6, 5, 7, 10, 9}, 10) ⇒ 8
//If there is no missing number, the function should return 0.

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class MissingNumber {

public static int missingNumber(int[] nums, int maxNum){
        Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());

        for(int i = 1; i <= maxNum; i += 1){
        if(!set.contains(i)){
        return i;
        }
        }
        return 0;
        }

public static int missingNumberSort(int[] nums, int maxNum){
        Arrays.sort(nums);

        for(int i = 1; i < maxNum; i +=1){
        if(i != nums[i -1]){
        return i;
        }
        }
        if(nums.length == maxNum && nums[maxNum -1] == maxNum){
        return 0;
        }
        return maxNum;
        }

public static int missingNumberSum(int[] nums, int maxNum){
        int expectedSum = 0;

        for(int i = 1; i <= maxNum; i += 1){
        expectedSum += 1;
        }
        int actualSum = Arrays.stream(nums).sum();
        return expectedSum - actualSum;
        }
}

//My Solution
//public static void findMissing(int arr[], int N){
//        int i;
//        int temp[] = new int[N + 1];
//        for(i = 0; i < N; i++){
//            temp[arr[i] - 1] = 1;
//        }
//        int ans = 0;
//        for(i = 0; i <= N; i++){
//            if(temp[i] == 0)
//                ans = i +1;
//        }
//        System.out.println(ans);
//    }
//
//    public static void main(String[] args){
//        int arr[] = {1,3,4,5,6,7,8,9,10};
//        int n = arr.length;
//
//        findMissing(arr, n);
//    }
// My solution is a lot different from the answer in the 30 minutes I look at how to come up with a solution still not that great with time complexity. But my solution was able to show with number was missing from 1-10 but when I add the missing number and rerun the program it said the missing number was 11. Seeing the solution help better understand the different things needed for the program to run correctly and is insightful.