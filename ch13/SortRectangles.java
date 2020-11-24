package ch13;

public class SortRectangles {
  public static void main(String[] args) {
	  ComparableRectangle[] rectangles = {
			  new ComparableRectangle(3.4, 5.4), 
			  new ComparableRectangle(13.24, 55.4),
			  new ComparableRectangle(7.4, 35.4),
			  new ComparableRectangle(35.4, 7.4),
			  new ComparableRectangle(1.4, 25.4)};
	  System.out.println("面积升序排序"); //也可在ComparableRectangle中修改return使其降序
	  java.util.Arrays.sort(rectangles);
	  for (Rectangle rectangle: rectangles) {
		  System.out.println(rectangle); 
	  }
	  System.out.println("面积降序排序");
	  java.util.Arrays.sort(rectangles,new GeometricObjectDescendingComparator());
	  for (Rectangle rectangle: rectangles) {
		  System.out.println(rectangle);
	  }

	  System.out.println("长边长度升序排序");
	  java.util.Arrays.sort(rectangles,new RectangleLongEdgeComparator());
	  for (Rectangle rectangle: rectangles) {
		  System.out.println(rectangle);
		  //System.out.println(Math.max(rectangle.getWidth(),rectangle.getHeight()));
	  }


	  System.out.println("长边长度降序排序");//匿名类（Comparator子类）且覆盖compare方法
	  java.util.Arrays.sort(rectangles,new java.util.Comparator<Rectangle>(){
		  public int compare(Rectangle o1, Rectangle o2) {
			  double edge1 = Math.max(o1.getWidth(),o1.getHeight());
			  double edge2 = Math.max(o2.getWidth(),o2.getHeight());
			  return (-1)*Double.compare(edge1,edge2);
		  }}); //.reversed()

	  for (Rectangle rectangle: rectangles) {
		  System.out.println(rectangle);
	  }

	  System.out.println("先比较面积再比较长再比较宽"); //Lamda表达式
	  java.util.Arrays.sort(rectangles,
			  java.util.Comparator.comparing(Rectangle::getArea)   //use a method reference
			  .thenComparing(e -> e.getWidth())  //(Rectangle::getWidth)
			  .thenComparing(Rectangle::getHeight));

	  for (Rectangle rectangle: rectangles) {
		  System.out.println(rectangle);
	  }
  }
}
