package org.maven.samples;

public class SingaporeAirlines {
	public static void main(String[] args) {
		Thread a = new Thread(new A(1));
		Thread b = new Thread(new A(2));
		Thread c = new Thread(new A(5));

		try {
			c.start();
			b.start();
			c.join();
			a.start();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			throw new Exception("exception thrown");
		} catch(Exception ex) {
			System.out.println("Catch");
		} finally {
			System.out.println("Finally");
		}
		System.out.println("outside");
	}
}

class A implements Runnable {
	int num;

	public A(int param) {
		this.num = param;
	}

	public void run() {
		try {
			Thread.currentThread().sleep((long) (1000 * num));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(this.num);
	}
}