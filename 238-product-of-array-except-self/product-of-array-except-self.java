class Solution {
    public int[] productExceptSelf(int[] nums) {
     int [] answer = new int [nums.length];
      int n = nums.length;

    //   int [] left = new int[n];
    //   int [] right = new int[n];

    //    left[0]=1;
    //   for (int i=1;i<n;i++){
    //     left[i]= left[i-1]*nums[i-1];
    //   }  
    //    right[n-1]=1;
    // for(int i= n-2;i>-1;i--){
    //     right[i]=right[i+1]*nums[i+1];
    // }
    // for(int i = 0; i<n; i++){                        // it takes extra o(n) space ----------
    //     answer[i]= left[i]*right[i];
    answer[0]=1;
    for (int i=1;i<n; i++){
        answer[i]=answer[i-1]*nums[i-1];
    }
    int rightProduct =1;
    for (int i = n-1; i>=0;i--){
        answer[i]= answer[i]*rightProduct;
        rightProduct= rightProduct*nums[i];
    }
    return answer;
    }
}