class Solution {

    // Function to find the subsets of the given array
    static ArrayList<ArrayList<Integer>> subsets(int[] arr) {
        Arrays.sort(arr); 
        
        int n = arr.length;
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();

        // Loop through all possible subsets using bitmasking
        for (int i = 0; i < (1 << n); i++) {
            ArrayList<Integer> subset = new ArrayList<>();

            for (int j = 0; j < n; j++) {
                // Check if j-th bit is set in i
                if ((i & (1 << j)) != 0) {
                    subset.add(arr[j]);
                }
            }

            res.add(subset);
        }
    }
}