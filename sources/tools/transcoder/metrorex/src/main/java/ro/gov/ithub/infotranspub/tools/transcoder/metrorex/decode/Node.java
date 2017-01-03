package ro.gov.ithub.infotranspub.tools.transcoder.metrorex.decode;

public class Node {

    private RowCol position = null;
    private String value = null;
    private int color = -1;

    public Node(String value){
        this.value = value;
    }

    public String getKey() {
        return position.getKey();
    }

    public void setPosition(RowCol position){
        this.position = position;
        color = position.getIntKey();
    }

    public RowCol getPosition() {
        return position;
    }

    public int getColor(){
            return color;
    }
    public void setColor( int color){
        this.color = color;
    }

    public void setValue(String value){
        this.value = value;
    }
    public String getValue(){
        return value;
    }


}
