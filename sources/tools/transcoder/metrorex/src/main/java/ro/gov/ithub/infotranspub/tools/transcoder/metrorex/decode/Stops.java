package ro.gov.ithub.infotranspub.tools.transcoder.metrorex.decode;

import java.util.HashMap;

public class Stops {
    private HashMap<String, String> stationsByName;
    private HashMap<String, String> stationsByCode;

    {
        stationsByName = new HashMap<String, String>();
        stationsByCode = new HashMap<String, String>();
    }

    public void addStation( String code, String name){
        stationsByName.put(name, code);
        stationsByCode.put(code, name);
    }

    public String getStationByCode(String code){
        return stationsByCode.get(code);
    }

    public String getStationByName(String name){
        return stationsByName.get(name);
    }

}
