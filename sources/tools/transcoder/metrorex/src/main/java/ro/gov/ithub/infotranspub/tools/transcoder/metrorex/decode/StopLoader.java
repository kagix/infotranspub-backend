package ro.gov.ithub.infotranspub.tools.transcoder.metrorex.decode;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

public class StopLoader {

    public static Stops load(String path){
        try
        {
            Stops stops = new Stops();
            String currentLine;
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    new FileInputStream(path), "utf-8"));

            currentLine = reader.readLine();
            while ((currentLine = reader.readLine()) != null) {
                String[] cells = currentLine.split(",");
                stops.addStation(cells[0], cells[1]);
                //System.out.println(currentLine);
            }

            return stops;
        } catch ( FileNotFoundException exception){
            exception.printStackTrace();
        } catch (UnsupportedEncodingException exception) {
            exception.printStackTrace();
        } catch ( IOException  exception) {
            exception.printStackTrace();
        }

        return null;
    }
}
