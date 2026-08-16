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

    void union(int a,int b){

        int pa=find(a);
        int pb=find(b);

        if(pa==pb)
            return;

        if(size[pa] < size[pb]){

            parent[pa]=pb;
            size[pb]+=size[pa];
        }
        else{

            parent[pb]=pa;
            size[pa]+=size[pb];
        }
    }
}

    public boolean validPath(
        int n,
        int[][] edges,
        int source,
        int destination
    ) {

        DSU dsu = new DSU(n);

        for(int[] edge : edges){

            dsu.union(edge[0], edge[1]);
        }

        return dsu.find(source)
                == dsu.find(destination);
    }
}