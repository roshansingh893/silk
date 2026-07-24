import java.util.*;

class Solution {

    class Pair {
        int freq;
        int availableTime;

        Pair(int freq, int availableTime) {
            this.freq = freq;
            this.availableTime = availableTime;
        }
    }

    public int leastInterval(char[] tasks, int n) {

        Map<Character, Integer> map = new HashMap<>();

        for (char task : tasks) {
            map.put(task, map.getOrDefault(task, 0) + 1);
        }

        PriorityQueue<Integer> maxHeap =
                new PriorityQueue<>(Collections.reverseOrder());

        for (int freq : map.values()) {
            maxHeap.offer(freq);
        }

        Queue<Pair> cooldown = new LinkedList<>();

        int time = 0;

        while (!maxHeap.isEmpty() || !cooldown.isEmpty()) {

            time++;
           
            if (!cooldown.isEmpty() &&
                cooldown.peek().availableTime == time) {

                maxHeap.offer(cooldown.poll().freq);
            }
        

         if (!maxHeap.isEmpty()) {

                int freq = maxHeap.poll();
                freq--;

                if (freq > 0) {
                    cooldown.offer(new Pair(freq, time + n + 1));
                }
            }
    }
        return time;
    }
}