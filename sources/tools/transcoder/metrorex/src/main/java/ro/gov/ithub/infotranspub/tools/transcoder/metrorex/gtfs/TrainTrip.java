package ro.gov.ithub.infotranspub.tools.transcoder.metrorex.gtfs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

public class TrainTrip {
    private ArrayList<StopTimeEntry> tripStops;
    private String tripNumber;
    private String routeId;
    private int directionId;
    {
        tripStops = new ArrayList<StopTimeEntry>();
    }

    public TrainTrip(String number, String route, int dirId){
        tripNumber = number;
        routeId = route;
        directionId = dirId;
    }

    public void addStop(String code, String time){
        StopTimeEntry entry = new StopTimeEntry(code,time);
        tripStops.add(entry);
    }

    public void sortStopsByTime(){
        Collections.sort(tripStops, new StopTimeEntryComparator());
    }

    public String getTripNumber(){
        return tripNumber;
    }

    public String getRouteId(){
        return routeId;
    }

    public int getDirectionId(){
        return directionId;
    }


    public ArrayList<StopTimeEntry> getStopTimes(){
        return tripStops;
    }

    public Date getDepartureTime(){
        return tripStops.get(0).getDepartureTime();
    }
}
