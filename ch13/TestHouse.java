package ch13;

public class TestHouse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        House house1=new House(1,1750.5);
        House house2=(House)house1.clone();
        System.out.println(house1==house2);
        System.out.println(house1.getWhenBuilt()==house2.getWhenBuilt());
        
	}

}
