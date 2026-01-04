package leetcode.practice;

public class Array2DMaxSum {

    public static void main(String[] args) {
        char[][] arr = {
            {'1', '+', '9', '-', '3'},
            {'+', '+', '9', '4', '-'},
            {'5', '-', '+', '-', '9'},
            {'7', '+', '8', '+', '+'},
            {'-', '9', '-', '1', '9'},
            {'-', '9', '-', '1', '-'},
            {'-', '9', '-', '1', '9'}
        };

        System.out.println(maxExpression(arr)); // should print 15
    }

    public static int maxExpression(char[][] grid) {
        int max = Integer.MIN_VALUE;
        int r = grid.length, c = grid[0].length;

        // Horizontal
        for (int i = 0; i < r; i++) {
            max = Math.max(max, maxInLine(grid[i]));
        }

        // Vertical
        for (int j = 0; j < c; j++) {
            char[] col = new char[r];
            for (int i = 0; i < r; i++) col[i] = grid[i][j];
            max = Math.max(max, maxInLine(col));
        }

        return max;
    }

    private static int maxInLine(char[] line) {
        int max = Integer.MIN_VALUE;
        int n = line.length;

        for (int start = 0; start < n; start++) {
            if (!Character.isDigit(line[start])) continue;

            int val = line[start] - '0';
            max = Math.max(max, val);

            for (int i = start + 1; i + 1 < n; i += 2) {
                char op = line[i];
                char next = line[i + 1];

                if (!isOperator(op) || !Character.isDigit(next)) break;

                int num = next - '0';
                val = (op == '+') ? val + num : val - num;
                max = Math.max(max, val);
            }
        }
        return max;
    }

    private static boolean isOperator(char c) {
        return c == '+' || c == '-';
    }
}
