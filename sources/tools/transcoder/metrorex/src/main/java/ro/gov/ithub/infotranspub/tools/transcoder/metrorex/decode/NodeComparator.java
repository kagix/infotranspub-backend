package ro.gov.ithub.infotranspub.tools.transcoder.metrorex.decode;

import java.util.Comparator;

public class NodeComparator implements Comparator<Node> {
    @Override
    public int compare(Node o1, Node o2) {
        return o1.getPosition().getRow() - o2.getPosition().getRow();
    }
}
