package ro.gov.ithub.infotranspub.tools.transcoder.metrorex.decode;

import java.util.ArrayList;

public class TableSegmentJoiner {
    Table table;

    {
        table = new Table();
    }

    public TableSegmentJoiner(){
    }

    public TableSegmentJoiner append(TableSegment segment){
        TableBody body = segment.getBody();
        ArrayList<Node> firstColumnValues =  body.getColumn(TableHeader.FIRST_COLUMN);
        ArrayList<Node> lastColumnValues =  body.getColumn(TableHeader.LAST_COLUMN);
        TextColumn firstColumn = table.getColumn(TableHeader.FIRST_COLUMN);
        TextColumn lastColumn = table.getColumn(TableHeader.LAST_COLUMN);

        appendColumn(firstColumn,firstColumnValues);
        appendColumn(lastColumn,lastColumnValues);


        return this;
    }


    public void appendColumn(TextColumn column, ArrayList<Node>  columnValues) {
        for (Node node : columnValues) {
            column.add(node.getValue());
        }
    }

    public Table getJoinTable(){
         return table;
    }


}
