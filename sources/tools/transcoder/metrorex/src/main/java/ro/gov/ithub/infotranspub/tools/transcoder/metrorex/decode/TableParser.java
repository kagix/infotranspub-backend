package ro.gov.ithub.infotranspub.tools.transcoder.metrorex.decode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class TableParser {


    ArrayList<TableSegment> segments;

    public TableParser(NodeMap nodes, HashSet<TablePosition> positions){
        segments = new ArrayList<TableSegment>();
        parseAll(nodes,positions);
    }

    public ArrayList<TableSegment> getSegments() { return segments;}

    public void parseAll(NodeMap nodes, HashSet<TablePosition> positions){
        for (TablePosition position:positions){
            TableHeader header = parseHeader(nodes, position);
            TableBody body = parseBody(nodes, position,header);
            TableSegment segment = new TableSegment(header, body);
            if (segment.getBody().getColumn(TableHeader.FIRST_COLUMN).size() > 0)
                segments.add(segment);
        }
        sortSegments();
    }


    public void sortSegments(){
        Collections.sort(segments, new SegmentComparator());
    }

    public TableHeader parseHeader(NodeMap nodes, TablePosition position){
        TableHeader header = new   TableHeader();

        for ( String key:nodes.keySet()){
            Node n = nodes.get(key);
            if (nodeInTable(n,position)){
                if (position.getTopLeft().getRow() == n.getPosition().getRow()) {
                    header.add(n, n.getPosition().getCol());
                }
            }
        }

        header.recalcColumnPositions();
        return header;
    }

    public TableBody parseBody(NodeMap nodes, TablePosition position, TableHeader header ){
        TableBody body = new   TableBody();

        for ( String key:nodes.keySet()){
            Node n = nodes.get(key);
            if (   nodeInTable(n,position)
                && header.isValidColumn(n.getPosition().getCol())){

                if (position.getTopLeft().getRow() < n.getPosition().getRow()) {
                    String columnName = header.nameByPosition(n.getPosition().getCol());
                    //System.out.println("Node=" + n.getKey() + " --> col=" + columnName);

                    body.add(columnName, n);
                }
            }
        }
        body.sortVectors();
        return body;
    }



    public boolean nodeInTable(Node node, TablePosition position){
        if (node.getPosition().getCol() < position.getTopLeft().getCol())
            return false;

        if (node.getPosition().getCol() > position.getRightBottom().getCol())
            return false;

        if (node.getPosition().getRow() < position.getTopLeft().getRow())
            return false;

        if (node.getPosition().getRow() > position.getRightBottom().getRow())
            return false;

        return true;
    }


}
