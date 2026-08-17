class Solution {

    class DSU {
        int[] parent;
        int[] rank;

        DSU(int n) {
            parent = new int[n];
            rank = new int[n];

            for(int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        int find(int x) {
            if(parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        boolean union(int a, int b) {
            int pa = find(a);
            int pb = find(b);

            if(pa == pb) return false;

            if(rank[pa] < rank[pb]) {
                parent[pa] = pb;
            }
            else if(rank[pb] < rank[pa]) {
                parent[pb] = pa;
            }
            else {
                parent[pb] = pa;
                rank[pa]++;
            }

            return true;
        }
    }

    public int removeStones(int[][] stones) {

        int n = stones.length;

        DSU dsu = new DSU(n);

        int components = n;

        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {

                if(stones[i][0] == stones[j][0] ||
                   stones[i][1] == stones[j][1]) {

                    if(dsu.union(i, j)) {
                        components--;
                    }
                }
            }
        }

        return n - components;
    }
}