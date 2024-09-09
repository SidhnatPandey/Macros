public static void spiralPrint(int m, int n, int[][] a)
    {
        // Initialize boundaries
        int top = 0, bottom = m - 1, left = 0,
            right = n - 1;

        // Iterate until all elements are printed
        while (top <= bottom && left <= right) {
            // Print top row from left to right
            for (int i = left; i <= right; ++i) {
                System.out.print(a[top][i] + " ");
            }
            top++;

            // Print right column from top to bottom
            for (int i = top; i <= bottom; ++i) {
                System.out.print(a[i][right] + " ");
            }
            right--;

            // Print bottom row from right to left (if
            // exists)
            if (top <= bottom) {
                for (int i = right; i >= left; --i) {
                    System.out.print(a[bottom][i] + " ");
                }
                bottom--;
            }

            // Print left column from bottom to top (if
            // exists)
            if (left <= right) {
                for (int i = bottom; i >= top; --i) {
                    System.out.print(a[i][left] + " ");
                }
                left++;
            }
        }
    }