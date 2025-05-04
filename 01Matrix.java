class Solution {
    
    class Pair {
        int row;
        int col;
        int level;
        Pair(int row, int col, int level) {
            this.row = row;
            this.col = col;
            this.level = level;
        }
    }

    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int ans[][] = new int[m][n];
        boolean vis[][] = new boolean[m][n];
        Queue<Pair> q = new LinkedList<>();
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 0) {
                    q.add(new Pair(i, j, 0));
                    vis[i][j] = true;
                }
            }
        }
        int ro[] = {-1, 1, 0, 0};
        int co[] = {0, 0, -1, 1};
        while (!q.isEmpty()) {
            Pair temp = q.poll();
            ans[temp.row][temp.col] = temp.level;
            for (int i = 0; i < 4; i++) {
                int uRow = ro[i] + temp.row;
                int uCol = co[i] + temp.col;
                if (uRow >= 0 && uRow < m && uCol >= 0 && uCol < n && !vis[uRow][uCol]) {
                    q.add(new Pair(uRow, uCol, temp.level+1));
                    vis[uRow][uCol] = true;
                }
            }
        }
        return ans;
    }
}