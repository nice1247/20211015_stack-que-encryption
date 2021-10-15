package co.nero.prj;

import java.util.Scanner;

import co.nero.prj.cryp.DB;
import co.nero.prj.encrytion.EncryptionSha;
import co.nero.prj.member.service.MemberService;
import co.nero.prj.member.service.MemberVO;
import co.nero.prj.member.serviceImpl.MemberServiceImpl;
import co.nero.prj.queue.Queue;
import co.nero.prj.stack.Stack;

public class MainApp {
	public static void main(String[] args) {
//		Stack stack = new Stack();
//		stack.push('a');
//		stack.push('b');
//		stack.push('c');
//		System.out.println(stack.pop());
//		stack.pop();
//		System.out.println(stack.pop());
//		System.out.println(stack.pop());
//		System.out.println(stack.pop());
		
		
//		Queue que = new Queue();
//		que.put(1);
//		que.put(2);
//		que.put(3);
//		que.put(4);
//		que.put(5);
//		System.out.println(que.get());
//		System.out.println(que.get());
//		System.out.println(que.get());
//		System.out.println(que.get());
//		System.out.println(que.get());
//		System.out.println(que.get());
//		
//		que.put(8);
//		que.put(9);
//		
//		System.out.println(que.get());
//		System.out.println(que.get());
		
		
			Scanner sc = new Scanner(System.in);
			EncryptionSha enc = new EncryptionSha();
//			String password = "1111";
//			String encKey = "$%#$%12039!@#*123($6";
//			System.out.println(enc.sha512(password, encKey));
		
			MemberService memberDao = new MemberServiceImpl();
			MemberVO member = new MemberVO();
			String encKey = memberDao.encKey();
			
			System.out.println("### 아이디를 입력하세요. ###");
			member.setId(sc.nextLine());
			System.out.println("### 비밀번호를 입력하세요. ###");
			String password = sc.nextLine();
			member.setPassword(enc.sha512(password, encKey));
			
			
			member = memberDao.memberLogin(member);
			if(member.getName() != null) {
				System.out.print(member.getName());
				System.out.println("님 환영합니다.");
			} else {
				System.out.println("아이디 또는 패스워드가 틀렸습니다.");
			}
			sc.close();
			
		
	}
}
