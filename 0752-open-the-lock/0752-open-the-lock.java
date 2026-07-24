class Solution {
    public int openLock(String[] dead, String target) {

        Queue<String> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        Set<String> deadSet = new HashSet<>();

        for (String s : dead) {
            deadSet.add(s);
        }

        if (deadSet.contains("0000"))
            return -1;

        q.offer("0000");
        visited.add("0000");

        int moves = 0;

        while (!q.isEmpty()) {

            int size = q.size();

            while (size-- > 0) {

                String curr = q.poll();

                if (curr.equals(target))
                    return moves;

                for (int i = 0; i < 4; i++) {

                    char[] arr = curr.toCharArray();
                    arr[i] = (char) ((arr[i] - '0' + 1) % 10 + '0');
                    String next = new String(arr);

                    if (!visited.contains(next) && !deadSet.contains(next)) {
                        visited.add(next);
                        q.offer(next);
                    }
                    arr = curr.toCharArray();
                    arr[i] = (char) ((arr[i] - '0' + 9) % 10 + '0');
                    String next1 = new String(arr);

                    if (!visited.contains(next1) && !deadSet.contains(next1)) {
                        visited.add(next1);
                        q.offer(next1);
                    }
                }
            }

            moves++;
        }

        return -1;
    }
}