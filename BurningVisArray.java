class Solution {
    public static int minTime(Node root, int target) {
        Queue<Node> q = new LinkedList<>();
        Node start = null;
        HashMap<Node, ArrayList<Node>> map = new HashMap<>();
        q.add(root);
        while (q.size() > 0) {
            Node temp = q.poll();
            if (temp.data == target) start = temp;
            if (temp.left != null) {
                q.add(temp.left);
                if(!map.containsKey(temp)){
                   map.put(temp,new ArrayList<>());
                }
                map.get(temp).add(temp.left);
               
                if(!map.containsKey(temp.left)){
                   map.put(temp.left,new ArrayList<>());
                }
               map.get(temp.left).add(temp);
            }
            if (temp.right != null) {
                q.add(temp.right);
                if(!map.containsKey(temp)){
                   map.put(temp,new ArrayList<>());
                }
                map.get(temp).add(temp.right);
               
                if(!map.containsKey(temp.right)){
                   map.put(temp.right,new ArrayList<>());
               }
               map.get(temp.right).add(temp);
            }
        }
        start.data = 0;
        q.add(start);
        int max = 0;
        
        HashMap<Node, Integer> vis = new HashMap<>();
        while (q.size() > 0) {
            Node temp = q.poll();
            if (max < temp.data) max = temp.data;
            if (map.get(temp) != null) {
                vis.put(temp, 1);
                for (Node i : map.get(temp)) {
                    if (vis.get(i) == null) {
                        vis.put(i, 1);
                        i.data = temp.data+1;
                        q.add(i);
                    }
                }
            }
        }
        return max;
    }
}