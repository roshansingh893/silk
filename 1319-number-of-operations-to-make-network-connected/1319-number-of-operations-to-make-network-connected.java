class Solution {
    class DSU {

    int[] parent;
    int[] size;

    DSU(int n){

        parent = new int[n];
        size = new int[n];

        for(int i=0;i<n;i++){
            parent[i]=i;
            size[i]=1;
        }
    }

    int find(int x){

        if(parent[x]==x)
            return x;

        return parent[x]=find(parent[x]);
    }

    boolean union(int a,int b){

        int pa=find(a);
        int pb=find(b);

        if(pa==pb)
            return false;

        if(size[pa]<size[pb]){
            parent[pa]=pb;
            size[pb]+=size[pa];
        }else{
            parent[pb]=pa;
            size[pa]+=size[pb];
        }

        return true;
    }
}
    public int makeConnected(int n, int[][] connections) {
        
        if(connections.length < n - 1)
            return -1;

        DSU dsu = new DSU(n);

        int components = n;

        for(int[] edge : connections){

            if(dsu.union(edge[0], edge[1])){
                components--;
            }
        }

        return components - 1;
    }
}