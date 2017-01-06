package ro.gov.ithub.infotranspub.tools.transcoder.metrorex.decode;

import java.util.HashMap;

public class Table {
    private HashMap<String,TextColumn> columns;
    {
        columns = new HashMap<String, TextColumn>();
    }

    private void initColumns(){ 
        addColumn(TableHeader.FIRST_COLUMN);
        addColumn(TableHeader.LAST_COLUMN);
    }

    private void addColumn(String name){
        columns.put(name, new TextColumn());
    }

    public Table(){
        initColumns();
    }

    public int getColumnCount(){
        return columns.size();
    }

    public TextColumn getColumn(String columnName){
        return columns.get(columnName);
    }


    public void print(){
        TextColumn firstColumn = getColumn(TableHeader.FIRST_COLUMN);
        TextColumn lastColumn = getColumn(TableHeader.LAST_COLUMN);
        for ( int rowId = 0; rowId < firstColumn.size(); rowId ++){
            System.out.println(firstColumn.get(rowId) + "\t" + lastColumn.get(rowId));
        }
    }
}
