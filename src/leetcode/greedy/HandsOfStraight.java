package leetcode.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class HandsOfStraight {
	public static void main(String args[]) {
		int[] hands = { 1, 2, 4, 2, 3, 5, 3, 4 };
		isNStraightHand(hands, 4);
	}

	public static boolean isNStraightHand(int[] hand, int groupSize) {
		if (hand.length % groupSize != 0)
			return false;
		Arrays.sort(hand);
		int n = hand.length;
		LinkedList<List<Integer>> grps = new LinkedList<>();

		for (int j = 0; j < n; j++) {
			int num = hand[j];
			boolean isUsed = false;
			int m = grps.size();
 			for (int i = 0; i<m; i++) {
				List<Integer> grp = grps.get(i);
				if (grp.get(grp.size() - 1) + 1 == num) {
					isUsed = true;
					grp.add(num);
					if (grp.size() == groupSize) {
						grps.remove(i);
					}
					break;
				}
			}
			if (!isUsed) {
				grps.add(new ArrayList<>(Arrays.asList(num)));
			}
			isUsed = false;
		}

		return grps.isEmpty();
	}
}
