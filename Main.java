import java.util.*;
public class Main
{
	public static void main(String[] args) {
		int maze[][] = {{1, 0, 0, 0}, {1, 1, 0, 1}, {1, 1, 0, 0}, {0, 1, 1, 1}};
		ArrayList<String> ans = ratInMaze(maze);
		for (String str : ans) {
		    System.out.println(str);
		}
	}
	
    public static ArrayList<String> ratInMaze(int[][] maze) {
        int m = maze.length, n = maze[0].length;
        ArrayList<String> ans = new ArrayList<>();
        
        if (maze[0][0] == 0) return ans;

        boolean vis[][] = new boolean[m][n];
        vis[0][0] = true;

        solve(maze, vis, 0, 0, "", ans);
        return ans;
    }
    
    public static void solve(int[][] maze, boolean[][] vis, int x, int y, String path, ArrayList<String> ans) {
        
        if (x == maze.length - 1 && y == maze[0].length - 1) {
            ans.add(path);
            return;
        }
        
        int dx[] = {-1, 1, 0, 0}, dy[] = {0, 0, -1, 1};
        char direction[] = {'U', 'D', 'L', 'R'};
        
        for (int i = 0; i < 4; i++) {
            int newX = x + dx[i], newY = y + dy[i];
            if (isValid(newX, newY, maze, vis)) {
                vis[newX][newY] = true;
                solve(maze, vis, newX, newY, path + direction[i], ans);
                vis[newX][newY] = false;
            }
        }
    }
    
    public static boolean isValid(int x, int y, int[][] maze, boolean[][] vis) {
        int m = maze.length, n = maze[0].length;
        return (x >= 0 && x < m &&
                y >= 0 && y < n &&
                !vis[x][y] &&
                maze[x][y] == 1);
    }
}
