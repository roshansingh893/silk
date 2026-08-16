class Solution {
    class DSU {

    int[] parent;
    int[] size;

    DSU(int n) {

        parent = new int[n + 1];
        size = new int[n + 1];

        for(int i = 0; i <= n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    int find(int x) {

        if(parent[x] == x)
            return x;

        return parent[x] = find(parent[x]);
    }

    boolean union(int a, int b) {

        int pa = find(a);
        int pb = find(b);

        if(pa == pb)
            return false;

        if(size[pa] < size[pb]) {
            parent[pa] = pb;
            size[pb] += size[pa];
        } else {
            parent[pb] = pa;
            size[pa] += size[pb];
        }

        return true;
    }
}
    public int[] findRedundantConnection(int[][] edges) {

        int n = edges.length;

        DSU dsu = new DSU(n);

        for(int[] edge : edges) {

            int u = edge[0];
            int v = edge[1];

            if(dsu.find(u) == dsu.find(v)) {
                return edge;
            }

            dsu.union(u, v);
        }

        return new int[0];
    }
}