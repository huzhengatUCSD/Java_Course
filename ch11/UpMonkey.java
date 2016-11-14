package ch11;

class Mammal { // 哺乳动物类
	private int n = 40;

	void crySpeak(String s) {
		System.out.println(s);
	}
}

public class UpMonkey extends Mammal { //猴子类
	void computer(int aa, int bb) {
		int cc = aa * bb;
		System.out.println(cc);
	}

	void crySpeak(String s) { //子类方法覆盖
		System.out.println("**" + s + "**");
	}

	public static void main(String args[]) {
		Mammal mammal = new UpMonkey(); // mammal是Monkey类的对象的向上转型对象.
		mammal.crySpeak("I love this game");
	    //mammal.computer(10,10);
		UpMonkey monkey = (UpMonkey) mammal; // 把向上转型对象强制转化为子类的对象.
		monkey.computer(10, 10);
	}
}
