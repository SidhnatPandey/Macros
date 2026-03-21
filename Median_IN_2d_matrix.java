class Solution {
    public int median(int[][] mat) {
        int n = mat.length * mat[0].length, medianIndex = n/2;
        int st = 1, ed = 2000;
        while (st <= ed) {
            int assumeme = st + (ed-st) / 2;
            int le = findSmaller(mat, assumeme);
            if (le <= medianIndex) {
                st = assumeme + 1;
            } else {
                ed = assumeme - 1;
            }
        }
        return st;
    }
    
    public int findSmaller(int[][] mat, int assumeme) {
        int no = 0;
        for (int i = 0; i < mat.length; i++) {
            int st = 0, ed = mat[i].length - 1;
            while (st <= ed) {
                int mid = st + (ed - st) / 2;
                if (mat[i][mid] <= assumeme) {
                    st = mid + 1;
                } else {
                    ed = mid - 1;
                }
            }
            no += st;
        }
        return no;
    }
}