package ro.gov.ithub.infotranspub.tools.transcoder.metrorex.gtfs;

import java.text.ParseException;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;


public class StopTimeEntry {
    private String stopCode;
    private Date departureTime;
    public static final String FORMAT_STRING_TIME = "HH:mm:ss";

    public StopTimeEntry(String code, String time){
        stopCode = code;
        departureTime = convertTimeFromString(time);
    }

    private Date convertTimeFromString(String time){
        DateFormat format = new SimpleDateFormat(FORMAT_STRING_TIME);
        Date date = null;
        try {
            date = format.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }


    public String getStopCode(){
        return stopCode;
    }

    public Date getDepartureTime(){
        return departureTime;
    }
}
