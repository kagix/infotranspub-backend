package ro.gov.ithub.infotranspub.tools.transcoder.metrorex.gtfs;


import java.util.Comparator;

public class TrainTripComparator implements Comparator<TrainTrip> {
    public static final int SMALLER = -1;
    public static final int BIGGER = 1;
    public static final int EQUAL = 0;

    @Override
    public int compare(TrainTrip trip1, TrainTrip trip2) {

        if (trip1.getRouteId() != trip2.getRouteId() )
            return trip1.getRouteId().compareTo(trip2.getRouteId());

        if (trip1.getDirectionId() != trip2.getDirectionId() ) {
            if (trip1.getDirectionId() < trip2.getDirectionId())
                return SMALLER;
            else
                return BIGGER;
        }

        if ( trip1.getDepartureTime().before(trip2.getDepartureTime()))
            return SMALLER;
        if (trip1.getDepartureTime().after(trip2.getDepartureTime()))
            return BIGGER;
        return EQUAL;
    }
}
