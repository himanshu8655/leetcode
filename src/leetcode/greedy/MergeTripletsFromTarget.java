package leetcode.greedy;

import java.util.HashSet;
import java.util.Set;

public class MergeTripletsFromTarget {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        int n = triplets.length;
        Set<Integer> unique = new HashSet<>();
        for(int i = 0; i<n; i++) {
    if(triplets[i][0]>target[0] || triplets[i][1]>target[1] || triplets[i][2]>target[2])
        continue;

            for(int j = 0; j<target.length; j++){
                if(target[j] == triplets[i][j])
                    unique.add(j);
            }
        }

        return unique.size() == target.length;
    }
}
