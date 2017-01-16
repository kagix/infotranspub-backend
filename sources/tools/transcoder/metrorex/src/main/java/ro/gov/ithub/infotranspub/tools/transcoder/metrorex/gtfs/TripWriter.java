package ro.gov.ithub.infotranspub.tools.transcoder.metrorex.gtfs;
import java.io.*;

public class TripWriter {


    public void writeTrips(TrainList trips, String path){

        try
        {
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(path), "utf-8"));
            writer.write("route_id,service_id,trip_id,direction_id\n");

            for (TrainTrip trip: trips.getRouteAndTimeOrder()){
                StringBuilder sb = new StringBuilder();
                sb.append(trip.getRouteId());
                sb.append(",ALL,");
                sb.append(trip.getTripNumber());
                sb.append(",");
                sb.append(Integer.toString(trip.getDirectionId()));
                sb.append("\n");
                writer.write(sb.toString());

            }
            writer.close();
        } catch ( Exception e){
            e.printStackTrace();
        }

    }
}
