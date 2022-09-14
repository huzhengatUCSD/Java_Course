package ch19;

import java.util.ArrayList;


class A{}
class B extends A implements F{}
class C extends A{}
class D extends A{}
class E{}
class G extends B{}
interface F{}

public class WildCardDemo {

     public static void main(String[] args) {        
 
    	 ArrayList<? extends A> listA = new ArrayList<A>();
    	 ArrayList<? extends A> listB = new ArrayList<B>();
    	 ArrayList<? extends A> listC = new ArrayList<C>();
    	 ArrayList<? extends A> listD = new ArrayList<D>();
    	 ArrayList<A> listE = new ArrayList<B>();
    	 ArrayList<? extends A> listF = new ArrayList<E>();  //

    	 ArrayList<? super B> listA1 = new ArrayList<A>();
    	 ArrayList<? super B> listA2 = new ArrayList<B>();
    	 ArrayList<? super B> listF = new ArrayList<F>();
    	// ArrayList<? super B> listG = new ArrayList<G>();  //
	     }
 }