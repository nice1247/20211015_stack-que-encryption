package co.nero.prj.stack;

public class Stack {		// 잠깐 다른 업무 나갔다가 복귀할때 많이 사용 / LIFO
	private char[] stack = new char[10]; // 문자 스택
	private int top = -1;

	public void push(char c) {
		if (top > stack.length - 1) {
			System.out.println("스택에 더이상 데이터를 입력할 수 없습니다.");
		} else {
			stack[++top] = c;
		}

	}

	public char pop() {
		char data = ' ';
		if (top < 0) {
			System.out.println("스택에 데이터가 없습니다.");
		} else {
			data = stack[top--];

		}
		return data;
	}

}
