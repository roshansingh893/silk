import java.util.*;

class Pair {
    int timestamp;
    String value;

    Pair(int timestamp, String value) {
        this.timestamp = timestamp;
        this.value = value;
    }
}

class TimeMap {

    HashMap<String, List<Pair>> map;

    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {

        map.computeIfAbsent(key, k -> new ArrayList<>())
           .add(new Pair(timestamp, value));
    }

    public String get(String key, int timestamp) {

        if (!map.containsKey(key))
            return "";

        return binarySearch(map.get(key), timestamp);
    }

    private String binarySearch(List<Pair> list, int target) {

        int left = 0;
        int right = list.size() - 1;
        int ans = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid).timestamp <= target) {
                ans = mid;
                left = mid + 1;

            } else {
                right = mid - 1;
            }
        }
        if (ans == -1)
            return "";
        return list.get(ans).value;
    }
}
/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */