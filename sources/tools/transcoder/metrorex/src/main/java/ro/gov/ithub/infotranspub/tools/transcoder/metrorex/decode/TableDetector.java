package ro.gov.ithub.infotranspub.tools.transcoder.metrorex.decode;
import java.util.HashSet;


public class TableDetector {

    public static  int INFINITY = 100000;
    public static  int ONE_COLUMN_BEFORE = 1;
    public static  int TWO_ROWS_BEFORE = 2;

    private HashSet<TablePosition> positions;

    {
        positions = new HashSet<TablePosition>();
    }

    public TableDetector(NodeMap nodes){

        this.detect(nodes);
        this.adjust();
    }

    public int getLeftmostColumn(NodeMap nodes){
        int columnPosition = INFINITY;
        for (String key:nodes.keySet()) {
            Node n = nodes.get(key);
            if ( n.getPosition().getCol() < columnPosition ){
                columnPosition = n.getPosition().getCol();
            }
        }
        return columnPosition;
    }

    public int getTopmostRow(NodeMap nodes, int columnPosition){
        int rowNumber = INFINITY;
        for (String key:nodes.keySet()) {
            Node n = nodes.get(key);
            if (n.getPosition().getCol() == columnPosition){
                if ( n.getPosition().getRow() < rowNumber ){
                    rowNumber = n.getPosition().getRow();
                }
            }
        }
        return rowNumber;
    }

    public String getTopLeftTag(NodeMap nodes){
        int leftmostColumn = getLeftmostColumn(nodes);
        int topmostRow = getTopmostRow(nodes, leftmostColumn);
        for (String key:nodes.keySet()) {
            Node n = nodes.get(key);
            if (  ( n.getPosition().getRow() == topmostRow )
                &&( n.getPosition().getCol() == leftmostColumn)){
                return n.getValue();
            }
        }
        return null;
    }

    private void detect(NodeMap nodes){
        String topLeftTag = getTopLeftTag(nodes);
        RowCol rightBottom = getRightBottomPoint(nodes);
        for (String key:nodes.keySet()) {
            Node n = nodes.get(key);

            if (! n.getValue().equals(topLeftTag))
                continue;
            TablePosition position = new TablePosition( new RowCol(n.getPosition()),
                                                        new RowCol(rightBottom));
            this.positions.add(position);
        }
    }

    void adjust(){
        for (TablePosition position:positions){
            for (TablePosition other:positions){
                if (position == other)
                    continue;

                if ( other.getTopLeft().getCol() > position.getTopLeft().getCol() ) {
                    if ( position.getRightBottom().getCol() > (other.getTopLeft().getCol() -ONE_COLUMN_BEFORE) ){
                        position.getRightBottom().setCol(other.getTopLeft().getCol() -ONE_COLUMN_BEFORE);
                    }
                }

                if ( other.getTopLeft().getCol() ==  position.getTopLeft().getCol() ) {
                    if ( other.getTopLeft().getRow() > position.getTopLeft().getRow() ) {
                        if ( position.getRightBottom().getRow() > (other.getTopLeft().getRow() -TWO_ROWS_BEFORE) ){
                            position.getRightBottom().setRow(other.getTopLeft().getRow() -TWO_ROWS_BEFORE);
                        }
                    }
                }
            }
        }
    }

    public HashSet<TablePosition> getPositions(){
        return this.positions;
    }

    private RowCol getRightBottomPoint(NodeMap nodes){
        RowCol rightBottom = new RowCol(0,0);
        for (String key:nodes.keySet()) {
            Node n = nodes.get(key);

            if ( n.getPosition().getCol() > rightBottom.getCol())
                rightBottom.setCol(n.getPosition().getCol());

            if ( n.getPosition().getRow() > rightBottom.getRow())
            rightBottom.setRow(n.getPosition().getRow());
        }

        return rightBottom;
    }
}
