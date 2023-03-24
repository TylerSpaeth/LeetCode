class Solution {
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		float medianIndex = (nums1.length + nums2.length - 1) / 2f;
		if(medianIndex % 1 == 0) {
			return helper(nums1, nums2, (int) medianIndex);
		}
		return (helper(nums1, nums2, (int) (medianIndex + .5f)) + helper(nums1, nums2, (int) (medianIndex - .5f))) / 2f;
	}
 
	private int helper(int[] nums1, int[] nums2, int medianIndex) {
		int totalIndex = 0;
		int firstIndex = 0;
		int secondIndex = 0;
		while(true) {
			if(firstIndex < nums1.length && secondIndex < nums2.length) { // If there are still numbers in both array
				if(nums1[firstIndex] <= nums2[secondIndex]) { // If the smallest number in the first array is smaller than the smallest in the second
					if(totalIndex == medianIndex) { // If the total index is equal to the median index, return the value at the first index
						return nums1[firstIndex];
					}
					totalIndex++; // Increase the total index
					firstIndex++; // Increase the first index
				}
				else { // If the smallest number in the first array is larger than the smallest value in the second
					if(totalIndex == medianIndex) { // If the total index  is equal to the median index, return the value at the second index
						return nums2[secondIndex];
					}
					totalIndex++;
					secondIndex++;
				}
			}
			else if(firstIndex < nums1.length) { // If there are no numbers left in the second array
				if(totalIndex == medianIndex) {
					return nums1[firstIndex];
				}
				totalIndex++;
				firstIndex++;
			}
			else { // If there are no numbers left in the first array
				if(totalIndex == medianIndex) {
					return nums2[secondIndex];
				}
				totalIndex++;
				secondIndex++;
			}
		}
	}
}
