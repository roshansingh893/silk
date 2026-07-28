/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
     public Node cloneGraph(Node node) {
        if (node==null) return null;

        HashMap<Node, Node> vis = new HashMap<>();
        util(node, vis);

        return vis.get(node);
    }
    public void util(Node u, HashMap<Node, Node> vis) {
        Node uc = new Node(u.val);
        vis.put(u, uc);
        for (Node v : u.neighbors) {
            if (!vis.containsKey(v)) {
                util(v, vis);
            }
            vis.get(u).neighbors.add(vis.get(v));
        }//
        
    }
}