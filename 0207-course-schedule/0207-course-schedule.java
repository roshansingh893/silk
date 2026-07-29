class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for(int i = 0; i< numCourses; i++) adj.add(new ArrayList<>());
            for(int[] a : prerequisites){
                  int course = a[0];
                  int prereq = a[1];
                  adj.get(prereq).add(course);            
             }
             int V = numCourses;
            int[] indegree  = new int[V];
           
           for(int i = 0; i<V; i++){
              for(int nei : adj.get(i)){
                   indegree[nei]++;
              }
           }
          Queue<Integer> q = new LinkedList<>();
          
          for(int i = 0; i < V; i++ ){
             if(indegree[i] == 0){
                q.offer(i);
             }
          }

          int idx = 0;

          while(!q.isEmpty()){
             int node = q.poll();
             idx++;
           for (int neigh : adj.get(node)) {
                indegree[neigh]--;
                if (indegree[neigh] == 0) {
                    q.offer(neigh);
                }
            }

          }

         return idx == V;
        }
}