package leetcode.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CourseScheduleII {
	public static void main(String[] args) {
		int[] res1 = new int[4];
        Set<Integer> set = new HashSet<>();
        set.contains(2);
	}

	public static int[] findOrder(int numCourses, int[][] prerequisites) {
		int[] res = new int[numCourses];
		HashMap<Integer, List<Integer>> hmp = new HashMap<>();
		int[] visited = new int[numCourses];
		for (int[] pre : prerequisites) {
			hmp.computeIfAbsent(pre[0], lst -> new ArrayList<Integer>()).add(pre[1]);
		}

		return null;

	}
}
