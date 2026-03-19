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

        // D L R U
        if (isValid(x + 1, y, maze, vis)) {
            vis[x + 1][y] = true;
            solve(maze, vis, x + 1, y, path + "D", ans);
            vis[x + 1][y] = false;
        }

        if (isValid(x, y - 1, maze, vis)) {
            vis[x][y - 1] = true;
            solve(maze, vis, x, y - 1, path + "L", ans);
            vis[x][y - 1] = false;
        }

        if (isValid(x, y + 1, maze, vis)) {
            vis[x][y + 1] = true;
            solve(maze, vis, x, y + 1, path + "R", ans);
            vis[x][y + 1] = false;
        }

        if (isValid(x - 1, y, maze, vis)) {
            vis[x - 1][y] = true;
            solve(maze, vis, x - 1, y, path + "U", ans);
            vis[x - 1][y] = false;
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
