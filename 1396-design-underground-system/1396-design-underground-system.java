import java.util.*;

class UndergroundSystem {

    // id -> [stationName, checkInTime]
    private Map<Integer, CheckInData> checkInMap;

    // "start#end" -> [totalTime, numberOfTrips]
    private Map<String, TravelData> travelMap;

    public UndergroundSystem() {
        checkInMap = new HashMap<>();
        travelMap = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        checkInMap.put(id, new CheckInData(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {
        CheckInData data = checkInMap.get(id);

        String startStation = data.station;
        int startTime = data.time;

        int travelTime = t - startTime;

        String route = startStation + "#" + stationName;

        if (!travelMap.containsKey(route)) {
            travelMap.put(route, new TravelData(0, 0));
        }

        TravelData travel = travelMap.get(route);

        travel.totalTime += travelTime;
        travel.trips++;

        // Customer is no longer checked in
        checkInMap.remove(id);
    }

    public double getAverageTime(String startStation, String endStation) {
        String route = startStation + "#" + endStation;

        TravelData travel = travelMap.get(route);

        return (double) travel.totalTime / travel.trips;
    }

    // Stores customer's check-in information
    static class CheckInData {
        String station;
        int time;

        CheckInData(String station, int time) {
            this.station = station;
            this.time = time;
        }
    }

    // Stores total travel time and number of trips
    static class TravelData {
        int totalTime;
        int trips;

        TravelData(int totalTime, int trips) {
            this.totalTime = totalTime;
            this.trips = trips;
        }
    }
}






        


  
        


  











