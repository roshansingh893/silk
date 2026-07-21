class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = speed.length;
        double[] time = new double[n];

for (int i = 0; i < n; i++) {
    time[i] = (double)(target - position[i]) / speed[i];
}

TreeMap<Integer, Double> map = new TreeMap<>();

for (int i = 0; i < n; i++) {
    map.put(position[i], time[i]);
}
     
     int fleets = 0;
double lastFleetTime = 0;
     for (Map.Entry<Integer, Double> entry : map.descendingMap().entrySet()) {
      double currTime = entry.getValue();
      if(currTime > lastFleetTime){
         fleets = fleets + 1;
         lastFleetTime = currTime;}
    //   } else {
    //      //no change on fleets
    //      lastFleetTime = currTime;
    //   }
}
        return fleets;
    }
}