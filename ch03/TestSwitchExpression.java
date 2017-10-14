package ch03;

public class TestSwitchExpression {

	public static void main(String[] args) {
		int i=40;
        switch (i) {
        case 40:
            System.out.println("40 was printed");
            break;
        case 45:
            System.out.println("45 was printed");//将会打印这句
            break;
        default:
            System.out.println("? ? ?");
            break;
        }
    }

}
