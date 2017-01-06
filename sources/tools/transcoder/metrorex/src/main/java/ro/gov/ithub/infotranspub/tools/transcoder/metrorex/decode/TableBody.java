package ro.gov.ithub.infotranspub.tools.transcoder.metrorex.decode;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;



public class TableBody {
    private HashMap < String, ArrayList<Node>> columns = null;

    {
        columns = new HashMap < String, ArrayList<Node>>();
    }

    public TableBody(){
        initColumns();

    }

    private void initColumns(){
        addColumn(TableHeader.FIRST_COLUMN);
        addColumn(TableHeader.LAST_COLUMN);
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
        sortVector(TableHeader.LAST_COLUMN);
    }

    public void sortVector(String name){
        Collections.sort(getColumn(name), new NodeComparator());
    }


}

