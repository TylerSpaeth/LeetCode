class Solution {
  public int[] twoSum(int[] nums, int target) {
		int[] solution = new int[2];
   	for(int i = 0; i < nums.length; i++) {
			 for(int u = 0; u < nums.length; u++) {
				 if(i != u && nums[i] + nums[u] == target) {
					 solution[0] = i;
					 solution[1] = u;
				 }
			 }
		}
		 return solution;
  }
}
