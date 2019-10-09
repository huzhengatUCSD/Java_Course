package ch07;

public class TestSwap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] list= {1,2,3,4,5};
		for(int i=0,j=list.length-1;i<j;i++,j--) {
			int temp=list[i];
			list[i]=list[j];
			list[j]=temp;
		}
		for(int e:list) {
			System.out.println(e);
		};
		list=reverse(list);
		for(int e:list) {
			System.out.println(e);
		};
	}
	
	public static int[] reverse(int[] list) {
		int[] result=new int[list.length];
		for(int i=0, j=list.length-1;i<list.length;i++,j--) {
			result[j]=list[i];
		}
		return result;
	}

}
