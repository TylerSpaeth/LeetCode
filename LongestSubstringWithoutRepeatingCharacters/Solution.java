class Solution {
	public int lengthOfLongestSubstring(String s) {
		int longest = 0;
		String current = "";
		for(int i = 0; i < s.length(); i++) {
			for(int u = i; u < s.length(); u++) {
				if(current.contains(Character.toString(s.charAt(u)))) {
					longest = Math.max(current.length(), longest);
					current = "";
					break;
				}
				else {
					current += s.charAt(u);
					longest = Math.max(current.length(), longest);
				}
			}
		}
		return longest;
	}
}
