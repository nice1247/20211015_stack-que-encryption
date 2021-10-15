package co.nero.prj.queue;

public class Queue { // 스케쥴링에 많이 사용 / FIFO
	// f=r >> nodata // r = queue size >> full // f = queue size >> nothing
	private int[] queue = new int[10];
	private int rear = -1; // 인덱스 0에 데이터가 있는 것 감안하여 미연에 방지
	private int front = -1;

	public void put(int n) {
		if (rear > queue.length - 1) {
			System.out.println("Queue Full");
		} else {
			queue[++rear] = n;
		}
	}

	public int get() {
		if (front == rear || front > queue.length - 1) {
			System.out.println("Queue Empty");
			return -1;
		}
		return queue[++front];

//		if (front < 0) {
//			System.out.println("Nothing in Queue");
//
//		} else {
//			System.out.println(queue[front++]);
//		}
//		return queue[front];
	}

}
