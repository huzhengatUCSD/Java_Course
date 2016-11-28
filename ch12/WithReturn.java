package ch12;

public class WithReturn{
     public int methodA(int money)throws Exception{
       if(--money<=0) throw new Exception("Out of money");
             return money;}
     public int methodB(int money){
       int a=-100;
       try{
          System.out.println("Begin");
         int result=methodA(money);  
         return result;
      }catch(Exception e){
         System.out.println(e.getMessage());
         return a;  
      }finally{
         a=100;
         System.out.println("Finally");} }
     public static void main(String args[]){
         System.out.println(new WithReturn().methodB(1)); 
      }}
