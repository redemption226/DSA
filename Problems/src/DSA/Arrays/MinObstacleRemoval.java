package DSA.Arrays;

public class MinObstacleRemoval {

    public static void main(String[] args) {
        char[][] matrix = {
                {'*', '*', '*', '*'},
                {'#', '*', '.', '*'},
                {'.', '.', '#', '.'},
                {'.', '#', '.', '#'}
        };

        int result = minObstaclesToRemove(matrix);
        System.out.println("Minimum obstacles to remove: " + result);
    }

    public static int minObstaclesToRemove(char[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int removeCount = 0;

        for (int c = 0; c < cols; c++) {
            boolean obstacleBelow = false;

            // Traverse from bottom to top
            for (int r = rows - 1; r >= 0; r--) {
                char cell = matrix[r][c];

                if (cell == '#') {
                    obstacleBelow = true;
                } else if (cell == '*') {
                    if (obstacleBelow) {
                        // Need to remove the blocking obstacle below this '*'
                        removeCount++;
                        obstacleBelow = false; // Assume obstacle removed
                    }
                }
            }
        }
        return removeCount;
    }
}
