package ch13;

import java.util.Comparator;

/**
 * 面积降序排序器
 */
public class GeometricObjectDescendingComparator
    implements Comparator<Rectangle>, java.io.Serializable {
  public int compare(Rectangle o1, Rectangle o2) {
    double area1 = o1.getArea();
    double area2 = o2.getArea();

    /*if (area1 < area2)
      return 1;
    else if (area1 == area2)
      return 0;
    else
      return -1;*/
    return (-1)*Double.compare(area1,area2);
  }
}
