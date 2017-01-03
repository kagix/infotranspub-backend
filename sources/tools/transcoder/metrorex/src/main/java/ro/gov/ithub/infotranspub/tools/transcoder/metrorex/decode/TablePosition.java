package ro.gov.ithub.infotranspub.tools.transcoder.metrorex.decode;

public class TablePosition {
    RowCol topLeft = null;
    RowCol rightBottom = null;

    TablePosition(RowCol topLeft, RowCol rightBottom){
        this.topLeft = topLeft;
        this.rightBottom = rightBottom;
    }

    RowCol getTopLeft(){
        return topLeft;
    }
    RowCol getRightBottom(){ return rightBottom; }

    void setTopLeft(RowCol topLeft){
        this.topLeft = topLeft;
    }
    void setRightBottom(RowCol rightBottom){
        this.rightBottom = rightBottom;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder().append("[")
                                              .append(topLeft)
                                              .append("]x[")
                                              .append(rightBottom)
                                              .append("]");
        return sb.toString();
    }
}

