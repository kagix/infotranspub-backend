package ro.gov.ithub.infotranspub.tools.transcoder.metrorex.decode;

public class TableSegment {
    private TableHeader header;
    private TableBody body;

    public TableSegment(TableHeader  header, TableBody body){
        this.header = header;
        this.body = body;
    }

    public TableHeader getHeader() { return header; }
    public TableBody getBody(){ return body; }
    public RowCol getTopLeftPosition(){
        return body.getColumn(TableHeader.FIRST_COLUMN).get(0).getPosition();
    }

}
