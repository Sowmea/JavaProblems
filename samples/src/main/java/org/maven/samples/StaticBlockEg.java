package org.maven.samples;

public class StaticBlockEg {
   
	public static void main(String[] args) {
		int[] game = { 0, 0, 0, 1, 1, 1 };
		Parent1 p = new Child1();
		p.m1();
		
		
	}
}


abstract class Parent1 {   
	 void m1() {   
        System.out.println("PARENT");   
    }  
}  
   
class Child1 extends Parent1 {  
	 void m1() {
		System.out.println("Child");
	}
      
}  

class MyRegex {
	public String pattern = "^((25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$";
}
