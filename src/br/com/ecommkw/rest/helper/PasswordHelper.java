package br.com.ecommkw.rest.helper;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

import sun.misc.BASE64Encoder;

public final class PasswordHelper {

	private static PasswordHelper instance;

	private PasswordHelper() {
	}

	public synchronized String encrypt(String plaintext) {
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("SHA");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		try {
			md.update(plaintext.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		byte raw[] = md.digest();
		String hash = (new BASE64Encoder()).encode(raw);
		return hash;
	}

	public static synchronized PasswordHelper getInstance() {
		if (instance == null) {
			instance = new PasswordHelper();
		}
		return instance;
	}

	public String generatePassword(int passwordLength) {
		String pass = UUID.randomUUID().toString();
		return pass.substring(0, passwordLength);
	}

}
