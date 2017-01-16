package ro.gov.ithub.infotranspub.tools.transcoder.metrorex.gtfs;

import java.util.Collections;
import java.util.HashMap;
import java.util.ArrayList;


public class TrainList extends HashMap<String, TrainTrip> {


    private ArrayList<TrainTrip> routeAndTimeOrder;
    public TrainList (){

    }

    public TrainTrip getGuaranteedTrip(String number, String route, int dirId){
        if (  false == containsKey(number) ){
            put(number, new TrainTrip(number, route, dirId));
        }

        return get(number);
    }

    public void reorderStationsInTrips(){
        for (String tripNumber : keySet()){
            TrainTrip trip = get(tripNumber);
            trip.sortStopsByTime();
        }
    }


    public void reorderRouteAndTime() {
        routeAndTimeOrder = new ArrayList<TrainTrip>();
        for (String tripNumber:keySet())
            routeAndTimeOrder.add(get(tripNumber));
        Collections.sort(routeAndTimeOrder, new TrainTripComparator());

    }


    public ArrayList<TrainTrip> getRouteAndTimeOrder(){
        return routeAndTimeOrder;
    }
}
