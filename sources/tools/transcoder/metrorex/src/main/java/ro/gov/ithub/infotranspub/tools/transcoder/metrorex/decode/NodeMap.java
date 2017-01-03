package ro.gov.ithub.infotranspub.tools.transcoder.metrorex.decode;

import java.util.HashMap;

public class NodeMap   extends  HashMap<String, Node> {
    public void addNode(Node node){
        String key = node.getKey();
        this.put(key, node);
    }

}
