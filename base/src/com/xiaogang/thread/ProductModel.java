package com.xiaogang.thread;

class Clerk {

	private int productNumber = 1;

	public synchronized void buy() {

		notify();
		if (productNumber > 1) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + "消费第" + productNumber + "个商品");
			productNumber--;
		} else {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public synchronized void produce() {

		notify();
		if (productNumber < 20) {
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + "生产第" + productNumber + "个商品");
			productNumber++;
		} else {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}

class Producer implements Runnable {

	private Clerk clerk;

	public Producer(Clerk clerk) {
		this.clerk = clerk;
	}

	@Override
	public void run() {

		while (true) {
			clerk.produce();

		}

	}
}

class Customer implements Runnable {

	private Clerk clerk;

	public Customer(Clerk clerk) {
		this.clerk = clerk;
	}

	@Override
	public void run() {
		while (true) {
			clerk.buy();

		}

	}
}

public class ProductModel {

	public static void main(String[] args) {

		Clerk clerk = new Clerk();
		Producer p1 = new Producer(clerk);
		Producer p2 = new Producer(clerk);
		Customer c1 = new Customer(clerk);

		Thread thread1 = new Thread(p1);
		Thread thread2 = new Thread(c1);
		Thread thread3 = new Thread(p2);
		thread1.setName("生产者1");
		thread2.setName("消费者1");
		thread3.setName("生产者2");
		thread1.start();
		thread2.start();

		thread3.start();
	}

}
