package co.nero.prj.encrytion;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class EncryptionSha {
	public String sha512(String pw, String encKey) { 		// 단방향 암호화 모듈 = sha512
		String encStr = null;
		String hash = pw + encKey;
		try {
			MessageDigest messageDigest = MessageDigest.getInstance("SHA-512");
			messageDigest.update(hash.getBytes());
			encStr = String.format("%128x", new BigInteger(1, messageDigest.digest()));

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return encStr;
	}

}
