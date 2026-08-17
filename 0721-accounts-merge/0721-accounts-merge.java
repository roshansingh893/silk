class Solution {

    public List<List<String>> accountsMerge(List<List<String>> accounts) {

        Map<String,Integer> emailToId = new HashMap<>();
        Map<String,String> emailToName = new HashMap<>();

        int id = 0;

        for(List<String> account : accounts){

            String name = account.get(0);

            for(int i=1;i<account.size();i++){

                String email = account.get(i);

                if(!emailToId.containsKey(email)){
                    emailToId.put(email,id++);
                }

                emailToName.put(email,name);
            }
        }

        DSU dsu = new DSU(id);

        for(List<String> account : accounts){

            String firstEmail = account.get(1);

            int firstId = emailToId.get(firstEmail);

            for(int i=2;i<account.size();i++){

                dsu.union(
                    firstId,
                    emailToId.get(account.get(i))
                );
            }
        }

        Map<Integer,List<String>> groups = new HashMap<>();

        for(String email : emailToId.keySet()){

            int root = dsu.find(emailToId.get(email));

            groups
                .computeIfAbsent(root,k->new ArrayList<>())
                .add(email);
        }

        List<List<String>> ans = new ArrayList<>();

        for(List<String> emails : groups.values()){

            Collections.sort(emails);

            List<String> account = new ArrayList<>();

            account.add(
                emailToName.get(emails.get(0))
            );

            account.addAll(emails);

            ans.add(account);
        }

        return ans;
    }

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

        if(size[pa]<size[pb]){

            parent[pa]=pb;
            size[pb]+=size[pa];
        }else{

            parent[pb]=pa;
            size[pa]+=size[pb];
        }
    }
}
}