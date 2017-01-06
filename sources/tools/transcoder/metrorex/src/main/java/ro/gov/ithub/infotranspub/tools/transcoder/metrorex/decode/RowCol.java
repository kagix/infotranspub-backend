package ro.gov.ithub.infotranspub.tools.transcoder.metrorex.decode;

public class RowCol {
    public static final int     ROWCOL_ENCODE_FACTOR = 1000;
    public static final int     ROWCOL_COMPARE_FACTOR = 10000;

    public static final int     UNUSED = -1;
    public static final String  FIELD_SEPARATOR = ":";

    private int row = UNUSED;
    private int col = UNUSED;

    public RowCol( RowCol source){
        this.row = source.getRow();
        this.col = source.getCol();
    }

    public RowCol( int row, int col){
        this.row = row;
        this.col = col;
     }

    public int getRow() {
        return row;
     }
    public int getCol() {
        return col;
    }

    public void setRow(int row) {
        this.row = row;
    }
    public void setCol(int col) {
        this.col = col;
    }

    public String getKey(){
        return Integer.toString(getIntKey());
    }
    public int getIntKey(){
        return row * ROWCOL_ENCODE_FACTOR + col;
    }
    public int getCompareKey(){
        return col * ROWCOL_COMPARE_FACTOR + row;
    }



    public String toString(){
        return new StringBuilder().append(Integer.toString(row))
                                  .append(FIELD_SEPARATOR)
                                  .append(Integer.toString(col))
                                  .toString();
    }

}
