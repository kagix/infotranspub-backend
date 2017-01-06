package ro.gov.ithub.infotranspub.tools.transcoder.metrorex.decode;

import java.util.Comparator;

public class SegmentComparator implements Comparator<TableSegment> {
    @Override
    public int compare(TableSegment seg1, TableSegment seg2) {
        return seg1.getTopLeftPosition().getCompareKey() - seg2.getTopLeftPosition().getCompareKey();
    }
}
