class Solution {
    public List<String> FindStringPermutations(String num) {
        List<String> ans = permute(num.toCharArray());
        return ans;
    }
    public List<String> permute(char[] nums) {
        List<String> ans = new ArrayList<>();
        recurPermute(0, nums, ans);
        return ans;
    }
    public void recurPermute(int index, char[] nums, List<String> ans) {
        if (index == nums.length) {
            if (!ans.contains(new String(nums))) {
                ans.add(new String(nums));
            }
            return;
        }
        for (int i = index; i < nums.length; i++) {
            swap(i, index, nums);
            recurPermute(index + 1, nums, ans);
            swap(i, index, nums);
        }
    }

    private void swap(int i, int j, char[] nums) {
        char temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}