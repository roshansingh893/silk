class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        if(stones.length == 1) return stones[0];
        for(int num : stones){
            pq.add(num);
        }
        while(!pq.isEmpty()){
            if(pq.size() == 1){
                return pq.poll();
            }

            int num1 = pq.poll();
            int num2 = pq.poll();

            if(num1 > num2 || num2 < num1){
                pq.offer(Math.abs(num2 - num1));
            }   
        }
        return 0;
    }
}