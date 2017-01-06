package ro.gov.ithub.infotranspub.tools.transcoder.metrorex.decode;

import java.util.HashMap;
import java.util.Vector;

public class TableHeader {

    public static final String FIRST_COLUMN = "First";
    public static final String LAST_COLUMN = "Last";


    public static final int FIRST_COLUMN_POSITION = 1000;
    public static final int LAST_COLUMN_POSITION = -1000;

    private Vector<Node> columns = null;
    private HashMap<String, String>  columnPositions;
    private HashMap<String, String>  reverseColumnPositions;


    private int firstColumn = FIRST_COLUMN_POSITION;
    private int lastColumn = LAST_COLUMN_POSITION;

    {
        columns = new Vector<Node>();
        columnPositions = new HashMap<String, String>();
        reverseColumnPositions = new HashMap<String,String>();
    }

    public TableHeader(){
    }

    public void add(Node column, int columnPosition){
        columns.add(column);
        columnPositions.put(column.getValue(), Integer.toString(columnPosition));
        reverseColumnPositions.put(Integer.toString(columnPosition),column.getValue());
    }

    public void recalcColumnPositions(){
        Node firstNode = null;
        Node lastNode = null;

        for  (Node node:columns){
            if ( node.getPosition().getCol() < firstColumn){
                firstColumn = node.getPosition().getCol();
                firstNode = node;
                firstNode.setValue(FIRST_COLUMN);
            }

            if ( node.getPosition().getCol() > lastColumn) {
                lastColumn = node.getPosition().getCol();
                lastNode = node;
                lastNode.setValue(LAST_COLUMN);
            }
        }

        columnPositions = new HashMap<String, String>();
        reverseColumnPositions = new HashMap<String,String>();

        columnPositions.put(FIRST_COLUMN, Integer.toString(firstNode.getPosition().getCol()));
        columnPositions.put(LAST_COLUMN, Integer.toString(lastNode.getPosition().getCol()));

        reverseColumnPositions.put(Integer.toString(firstNode.getPosition().getCol()),FIRST_COLUMN);
        reverseColumnPositions.put(Integer.toString(lastNode.getPosition().getCol()),LAST_COLUMN);

    }

    public int getFirstColumn(){ return firstColumn; }
    public int getLastColumn() { return lastColumn; }

    public Vector<Node> getColumns(){
        return columns;
    }
    public int positionByName(String name){
        return Integer.parseInt(columnPositions.get(name));
    }
    public String nameByPosition(int position){
        return reverseColumnPositions.get(Integer.toString(position));
    }


    public boolean isValidColumn( int columnPosition){
        if ( columnPosition == firstColumn || columnPosition == lastColumn)
            return true;
        return false;
    }
}

