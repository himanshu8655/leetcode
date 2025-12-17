package com.codesignal;

public class Fragments {

    public static void main(String[] args) {
        int[] fragments = new int[] {1, 212, 12, 12};
        System.out.println(        solution(fragments, 1212));
    }

    public static void helper(int i, int[] fragments, String accessCode, String res) {

        // If we processed all fragments
        if (i == fragments.length) {
            if (res.equals(accessCode))
                System.out.println("solution");
            return;
        }

        // OPTION 1: Skip current fragment
        helper(i + 1, fragments, accessCode, res);

        // OPTION 2: Include current fragment
        helper(i + 1, fragments, accessCode, res + fragments[i]);
    }

    static int solution(int[] fragments, int accessCode) {

        String target = String.valueOf(accessCode);
        int count = 0;

        for (int i = 0; i < fragments.length; i++) {
            for (int j = 0; j < fragments.length; j++) {

                if (i == j) continue; // cannot use same fragment twice

                String combined = String.valueOf(fragments[i]) + fragments[j];

                if (combined.equals(target)) {
                    count++;
                }
            }
        }

        return count;
    }

}
