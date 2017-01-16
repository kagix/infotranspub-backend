package ro.gov.ithub.infotranspub.tools.transcoder.metrorex.gtfs;

import java.util.Comparator;

public class StopTimeEntryComparator implements Comparator<StopTimeEntry> {
    @Override
    public int compare(StopTimeEntry e1, StopTimeEntry e2) {
        if (e1.getDepartureTime().before(e2.getDepartureTime()))
            return -1;
        if (e1.getDepartureTime().after(e2.getDepartureTime()))
            return 1;
        return 0;
    }
}