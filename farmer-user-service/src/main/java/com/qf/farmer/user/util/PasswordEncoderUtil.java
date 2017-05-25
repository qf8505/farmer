package com.qf.farmer.user.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * 密码加密和匹配
 * 
 * @author qinfei
 *
 */
public class PasswordEncoderUtil {
	public static BCryptPasswordEncoder getEncoder() {
		return new BCryptPasswordEncoder(4);
	}

	public static String encode(String rawPassword) {
		return PasswordEncoderUtil.getEncoder().encode(rawPassword);
	}

	public static boolean matches(String rawPassword, String encodedPassword) {
		return getEncoder().matches(rawPassword, encodedPassword);
	}
}
