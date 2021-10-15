package co.nero.prj;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

import co.nero.prj.encrytion.EncryptionAes;
import co.nero.prj.member.service.MemberService;
import co.nero.prj.member.service.MemberVO;
import co.nero.prj.member.serviceImpl.MemberServiceImpl;

public class MainAppAes {
	public static void main(String[] args)
			throws UnsupportedEncodingException, NoSuchAlgorithmException, GeneralSecurityException {
		Scanner sc = new Scanner(System.in);
		EncryptionAes aes = new EncryptionAes();
		MemberService memberDao = new MemberServiceImpl();
		MemberVO member = new MemberVO();

		System.out.print("ID : ");
		member.setId(sc.nextLine());
		System.out.print("Password : ");
		member.setPassword(sc.nextLine());
		memberDao.memberLogin(member);

		System.out.println("ADMIN의 암호화 = " + aes.encrypt("ADMIN"));
		System.out.println("USER의 암호화 = " + aes.encrypt("USER"));
		if (member.getName() != null) {
			System.out.print(member.getName());
			System.out.println("님 환영합니다.");

			System.out.println("\n###암호화 되기 전 author###");
			System.out.println(member.getAuthor());

			member.setAuthor(aes.encrypt(member.getAuthor()));
			System.out.println("\n###암호화 된 후 author###");
			System.out.println(member.getAuthor());

			member.setAuthor(aes.decrypt(member.getAuthor()));
			System.out.println("\n###복호화 된 후 author###");
			System.out.println(member.getAuthor());
		} else {
			System.out.println("아이디 또는 패스워드가 틀렸습니다.");
		}
		sc.close();

	}

}
