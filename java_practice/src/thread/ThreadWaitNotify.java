package thread;

import java.util.ArrayList;

public class ThreadWaitNotify {
	
	// synchronized 로 동기화하여 공유 데이터를 보호하는 것 까지는 좋은데, 특정 쓰레드가 객체의 락을 
	// 가진 상태로 오랜 시간을 보내지 않도록 하는 것도 중요한데 (만일 계좌에 출금할 돈이 부족하여 돈이 입금 될 떄 까지  오랜 시간을 보낸다면
	// 다른 쓰레드 들도 모두 해당 객체의 락을 기다리느라 다른 작업들도 원할히 진행되지 않을 것임)
	// 이러한 상황을 개선하기 위하여 고안 된 것이 바로
	// wait() notify() 이다
	
	// wait() - 쓰레드가 락을 반납을 하고 기다리게 함
	// notify() - 작업을 중단하였던 쓰레드를 다시 락을 얻어 작업을 진행할 수 있게 해줌

	public static void main(String[] args) throws Exception {
		Table table = new Table();
		
		// 예외 발생 가능성은 요리사 Cook 쓰레드가 테이블에 음식을 놓는 도중에 손님 (Customer) 쓰레드가 음식을 가져가려 했기 때문에
		// 발생 하는 예외 (ConcurrentModificationException) 다른 하나는 손님 쓰레드가 테이블의 마지막 남은 음식을 가져가는 도중에
		// 다른 손님 쓰레드가 먼저 음식을 낚아 채 버려서 존재 하지 않는 음식을 테이블에서 제거하려 했기 때문에 발생하는 예외 (IndexOutOfBoundsException)
		// 이러한 예외가 발생하는 경우는 동기화를 하지 않아서 이다.
		
		
		new Thread(new Cook(table), "COOK1").start();
		new Thread(new Customer(table, "donut"), "CUST1").start();
		new Thread(new Customer(table, "burger"), "CUST2").start();
		
		Thread.sleep(100);	// 0.1 초 (100 밀리 세컨드) 후에 강제 종료 시킨다.
		
		System.exit(0);
	}
	
}


class Customer implements Runnable {
	private Table table;
	private String food;
	
	Customer(Table table, String food) {
		this.table = table;
		this.food = food;
	}
	
	@Override
	public void run() {
		while(true) {
			try {
				Thread.sleep(10);
			} catch(Exception e) {
				e.printStackTrace();
			}
			
			String name = Thread.currentThread().getName();
			if(eatFood()) {
				System.out.println(name + " ate a " + food);
			} else {
				System.out.println(name + " failed to eat . : ( ");
			}
		}
	}
	
	public boolean eatFood() {
		return table.remove(food);
	}
}

class Cook implements Runnable {
	private Table table;
	
	Cook(Table table) {
		this.table = table;
	}
	
	@Override
	public void run() {
		while(true) {
			int idx = (int)(Math.random() * table.dishNum());
			table.add(table.dishNames[idx]);
			try {
				Thread.sleep(1);
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}


class Table {
	String[] dishNames = {"donut", "donut", "burger"};
	final int MAX_FOOD = 6;	// 테이블에 놓을 수 있는 최대 음식 수
	
	private ArrayList<String> dishes = new ArrayList<>();
	
	// 동기화를 위하여 synchronized 키워드를 추가
	public synchronized void add(String dish) {
		if(dishes.size() >= MAX_FOOD) {
			return;
		} 
		dishes.add(dish);
		System.out.println("DISHES DATA CHECK : " + dishes.toString());
	}
	
	// 지정된 요리와 일치하는 요리를 테이블에서 제거
	public boolean remove(String dishName) {
		// 동기화를 위하여 추가
		synchronized (this) {
			while(dishes.size() == 0) {
				String name = Thread.currentThread().getName();
				System.out.println(name + " is Waiting !!!");
				try {
					Thread.sleep(500);
				} catch(InterruptedException e) {
					e.printStackTrace();
				}
			}
			for(int i=0; i<dishes.size(); i++) {
				if(dishName.equals(dishes.get(i))) {
					dishes.remove(i);
					return true;
				}
			}
			
		}
		return false;
	}
	
	public int dishNum() {
		return dishNames.length;
	}
	
}

