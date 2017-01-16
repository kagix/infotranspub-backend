package ro.gov.ithub.infotranspub.tools.transcoder.metrorex.decode;
import ro.gov.ithub.infotranspub.tools.transcoder.metrorex.temp.TempTextFile;

public class StationTextReader {

    NodeMap nodes = null;

    public StationTextReader(TempTextFile memoryFile){
        nodes = new NodeMap();
        readTextFile(memoryFile);
    }

    public StationTextReader(){
        nodes = new NodeMap();
    }

    private void readTextFile(TempTextFile memoryFile ){
        String currentLine;
        memoryFile.open(TempTextFile.READ);

        while ((currentLine = memoryFile.read()) != null) {
            String[] elts = currentLine.split("=");
            String rowAndCol[] = elts[0].split(",");
            int row = Integer.parseInt(rowAndCol[0]);
            int col = Integer.parseInt(rowAndCol[1]);
            RowCol position = new RowCol(row, col);
            Node node = new Node(elts[1]);
            node.setPosition(position);
            nodes.addNode(node);

        }

    }

    public NodeMap getNodes(){
        return nodes;
    }
}
