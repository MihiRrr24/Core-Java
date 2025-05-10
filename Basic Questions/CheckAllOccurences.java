// https://leetcode.com/problems/check-if-all-characters-have-equal-number-of-occurrences/

class Solution {
	public static boolean areOccurrencesEqual(String s) {

		HashMap<Character, Integer> hm = new HashMap<>();

		for (int i = 0; i < s.length(); i++) {

			char ch = s.charAt(i);

			hm.put(ch, hm.getOrDefault(ch, 0)+1);
		} 

		HashSet<Integer> hs = new HashSet<Integer>();
		
		for(char ch : hm.keySet()) {
			hs.add(hm.get(ch));
		}

		return hs.size() == 1;
	}
}
