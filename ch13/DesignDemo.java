package ch13;

public class DesignDemo {
	  public static void main(String[] args) {
	    Edible stuff = new Chickenn();
	    eat(stuff);

	    stuff = new Duck();
	    eat(stuff);

	    stuff = new Broccoli();
	    eat(stuff);
	  }

	  public static void eat(Edible stuff) {
	    System.out.println(stuff.howToEat());
	  }
	}


	class Chickenn implements Edible {
	  @Override
	  public String howToEat() {
	    return "Fry it";
	  }
	}

	class Duck implements Edible {
	  @Override
	  public String howToEat() {
	    return "Roast it";
	  }
	}

	class Broccoli implements Edible {
	  @Override
	  public String howToEat() {
	    return "Stir-fry it";
	  }
	}