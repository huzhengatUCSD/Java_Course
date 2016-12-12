package ch19;

public class TestGenericStack {

	public static void main(String[] args) {
		GenericStack<String> stack1= new GenericStack<>();
		stack1.push("London");
		stack1.push("Paris");
		stack1.push("Beijing");
		//stack1.push(new Integer(1));
		
		stack1.pop();
		
		System.out.println(stack1);
		
		GenericStack<Integer> stack2= new GenericStack<>();
		stack2.push(1);
		stack2.push(2);
		stack2.push(3);
		stack2.pop();
		stack2.push(4);
		
		System.out.println(stack2);
		
		GenericStack<Integer> stack3;
		stack3=new GenericStack<>();
		//stack3.push("Welcome to Java");
		stack3.push(2);
		
		System.out.println(stack1 instanceof GenericStack);
		System.out.println(stack2 instanceof GenericStack);
		System.out.println(stack3 instanceof GenericStack);
	}

}
