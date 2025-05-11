class Solution {
    public int findTarget(int arr[], int target) {
        int l = 0, r = arr.length-1;
        while (l <= r) {
            int mid = l + (r-l)/2;
            if (arr[mid] == target) return mid;
            if (mid - 1 >= 0 && arr[mid-1] == target) return mid-1;
            if (mid + 1 < arr.length && arr[mid+1] == target) return mid+1;
            if (arr[mid] > target) {
                r = mid - 2;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }
}


/*
    Time Complexity : O(log(N))
    Space Complexity : O(N)
 */