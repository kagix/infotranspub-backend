package ro.gov.ithub.infotranspub.tools.transcoder.metrorex.decode;
import java.util.HashSet;

public class TableParser {


    TableHeader header;
    TableBody body;

    public TableParser(NodeMap nodes, HashSet<TablePosition> positions){
        parseAll(nodes,positions);
    }

    public TableHeader getHeader() { return header;}
    public TableBody getBody() { return body;}

    public void parseAll(NodeMap nodes, HashSet<TablePosition> positions){
        for (TablePosition position:positions){
            header = parseHeader(nodes, position);
            body = parseBody(nodes, position);
        }
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

    public TableBody parseBody(NodeMap nodes, TablePosition position){
        TableBody body = new   TableBody();

        for ( String key:nodes.keySet()){
            Node n = nodes.get(key);
            if (   nodeInTable(n,position)
                && header.isValidColumn(n.getPosition().getCol())){

                if (position.getTopLeft().getRow() < n.getPosition().getRow()) {
                    String columnName = header.nameByPosition(n.getPosition().getCol());
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
