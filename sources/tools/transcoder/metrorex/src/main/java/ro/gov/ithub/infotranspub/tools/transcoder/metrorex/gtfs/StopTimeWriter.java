package ro.gov.ithub.infotranspub.tools.transcoder.metrorex.gtfs;

import ro.gov.ithub.infotranspub.tools.transcoder.metrorex.decode.Stops;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class StopTimeWriter {

    public void writeStopTimes(TrainList trips, Stops stops, String path){

        try
        {
            DateFormat format = new SimpleDateFormat(StopTimeEntry.FORMAT_STRING_TIME);

            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(path), "utf-8"));
            writer.write("trip_id,arrival_time,departure_time,stop_id,stop_sequence\n");

            for (String tripNumber:trips.keySet()){
                int stopSeq = 0;
                TrainTrip trip = trips.get(tripNumber);
                for (StopTimeEntry stopTime:trip.getStopTimes()){
                    stopSeq++;
                    StringBuilder  row = new StringBuilder();
                    row.append(tripNumber);
                    row.append(",");
                    row.append(format.format(stopTime.getDepartureTime()));
                    row.append(",");
                    row.append(format.format(stopTime.getDepartureTime()));
                    row.append(",");
                    row.append(stopTime.getStopCode());
                    row.append(",");
                    row.append(Integer.toString(stopSeq));
                    row.append("\n");
                    writer.write(row.toString());
                }
            }
            writer.close();
        } catch ( Exception e){
            e.printStackTrace();
        }

    }

}
