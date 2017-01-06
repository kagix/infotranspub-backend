package ro.gov.ithub.infotranspub.tools.transcoder.metrorex.decode;

public class StationNameDetector {
    public static final String STATION_NAME_KEY="4014";
    public String detectName(NodeMap nodes){
        return nodes.get(STATION_NAME_KEY).getValue();
    }
}
