package ro.gov.ithub.infotranspub.tools.transcoder.metrorex.decode;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Collections;
import java.util.Comparator;



public class TableBody {
    private HashMap < String, ArrayList<Node>> columns = null;

    {
        columns = new HashMap < String, ArrayList<Node>>();
    }

    public TableBody(){

    }

    private void initColumns(){
        addColumn(TableHeader.FIRST_COLUMN);
        addColumn(TableHeader.LASTT_COLUMN);
    }

    private void addColumn(String name){
        columns.put(name, new ArrayList<Node>());
    }

    public void add(String columnName, Node node){
        if (columnName != null)
            columns.get(columnName).add(node);
    }

    public ArrayList<Node> getColumn(String name){
        return columns.get(name);
    }


    public void sortVectors(){
        sortVector(TableHeader.FIRST_COLUMN);
        sortVector(TableHeader.LASTT_COLUMN);
    }

    public void sortVector(String name){
        Collections.sort(getColumn(name),
                new Comparator<Node>() {
                    @Override
                    public int compare(Node o1, Node o2) {
                        return o1.getPosition().getRow() - o2.getPosition().getRow();
                    }
                });
    }


}

