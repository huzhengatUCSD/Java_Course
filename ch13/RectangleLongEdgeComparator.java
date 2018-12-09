package ch13;

import java.util.Comparator;

public class RectangleLongEdgeComparator
        implements Comparator<Rectangle>, java.io.Serializable {
    public int compare(Rectangle o1, Rectangle o2) {
        double edge1 = Math.max(o1.getWidth(),o1.getHeight());
        double edge2 = Math.max(o2.getWidth(),o2.getHeight());

        /*if (edge1 < edge2)
            return -1;
        else if (edge1 == edge2)
            return 0;
        else
            return 1;*/
        return Double.compare(edge1,edge2);
    }
}
