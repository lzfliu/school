package com.lzf.utils;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.zip.CRC32;
import java.util.zip.CheckedInputStream;

public class CryptoUtils {
	private static final String	DEFAULT_CHARSET	= "UTF-8";

	/**
	 * MD5加密
	 * 
	 * @param bytes
	 *            an array of byte.
	 * @return a {@link String} object.
	 */
	public static String encodeMD5(final byte[] bytes) {
		return DigestUtils.md5Hex( bytes );
	}
	public static String generateSalt(String key){
	    return encodeMD5(key+System.currentTimeMillis());
    }
    public static String encodeMD5(final String str,String salt,int hashIterations) {
        MessageDigest digest= null;
        try {
            digest = MessageDigest.getInstance("MD5");
            digest.update(salt.getBytes());
            byte[] hashed = digest.digest(str.getBytes());
            int iterations = hashIterations - 1; //already hashed once above
            //iterate remaining number:
            for (int i = 0; i < iterations; i++) {
                digest.reset();
                hashed = digest.digest(hashed);
            }
            return Hex.encodeHexString(hashed);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }

    }
	/**
	 * MD5加密，默认UTF-8
	 *
	 * @param str
	 *            a {@link String} object.
	 * @return a {@link String} object.
	 */
	public static String encodeMD5(final String str) {
		return encodeMD5( str, DEFAULT_CHARSET );
	}

	/**
	 * MD5加密
	 *
	 * @param str
	 *            a {@link String} object.
	 * @param charset
	 *            a {@link String} object.
	 * @return a {@link String} object.
	 */
	public static String encodeMD5(final String str, final String charset) {
		if (str == null) {
			return null;
		}
		try {
			byte[] bytes = str.getBytes( charset );
			return encodeMD5( bytes );
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException( e );
		}
	}

	/**
	 * SHA加密
	 *
	 * @param bytes
	 *            an array of byte.
	 * @return a {@link String} object.
	 */
	public static String encodeSHA(final byte[] bytes) {
		return DigestUtils.sha512Hex( bytes );
	}

	/**
	 * SHA加密
	 *
	 * @param str
	 *            a {@link String} object.
	 * @param charset
	 *            a {@link String} object.
	 * @return a {@link String} object.
	 */
	public static String encodeSHA(final String str, final String charset) {
		if (str == null) {
			return null;
		}
		try {
			byte[] bytes = str.getBytes( charset );
			return encodeSHA( bytes );
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException( e );
		}
	}

	/**T
	 * SHA加密,默认utf-8
	 *
	 * @param str
	 *            a {@link String} object.
	 * @return a {@link String} object.
	 */
	public static String encodeSHA(final String str) {
		return encodeSHA( str, DEFAULT_CHARSET );
	}

	/**
	 * BASE64加密
	 *
	 * @param bytes
	 *            an array of byte.
	 * @return a {@link String} object.
	 */
	public static String encodeBASE64(final byte[] bytes) {
		return new String( Base64.encodeBase64String( bytes ) );
	}

	/**
	 * BASE64加密
	 *
	 * @param str
	 *            a {@link String} object.
	 * @param charset
	 *            a {@link String} object.
	 * @return a {@link String} object.
	 */
	public static String encodeBASE64(final String str, String charset) {
		if (str == null) {
			return null;
		}
		try {
			byte[] bytes = str.getBytes( charset );
			return encodeBASE64( bytes );
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException( e );
		}
	}

	/**
	 * BASE64加密,默认UTF-8
	 *
	 * @param str
	 *            a {@link String} object.
	 * @return a {@link String} object.
	 */
	public static String encodeBASE64(final String str) {
		return encodeBASE64( str, DEFAULT_CHARSET );
	}

	/**
	 * BASE64解密,默认UTF-8
	 *
	 * @param str
	 *            a {@link String} object.
	 * @return a {@link String} object.
	 */
	public static byte[] decodeBASE64(String str) {
		return decodeBASE64( str, DEFAULT_CHARSET );
	}

	/**
	 * BASE64解密
	 *
	 * @param str
	 *            a {@link String} object.
	 * @param charset
	 *            字符编码
	 * @return a {@link String} object.
	 */
	public static byte[] decodeBASE64(String str, String charset) {
		try {
			byte[] bytes = str.getBytes( charset );
			return Base64.decodeBase64( bytes );
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException( e );
		}
	}
	/**
	 * BASE64解密
	 *
	 * @param str
	 *            a {@link String} object.
	 * @param charset
	 *            字符编码
	 * @return a {@link String} object.
	 */
	// public static String decodeBASE64(String str, String charset) {
	// try {
	// byte[] bytes = str.getBytes(charset);
	// return new String(Base64.decodeBase64(bytes));
	// } catch (UnsupportedEncodingException e) {
	// throw new RuntimeException(e);
	// }
	// }

	/**
	 * CRC32字节校验
	 *
	 * @param bytes
	 *            an array of byte.
	 * @return a {@link String} object.
	 */
	public static String crc32(byte[] bytes) {
		CRC32 crc32 = new CRC32();
		crc32.update( bytes );
		return Long.toHexString( crc32.getValue() );
	}

	/**
	 * CRC32字符串校验
	 *
	 * @param str
	 *            a {@link String} object.
	 * @param charset
	 *            a {@link String} object.
	 * @return a {@link String} object.
	 */
	public static String crc32(final String str, String charset) {
		try {
			byte[] bytes = str.getBytes( charset );
			return crc32( bytes );
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException( e );
		}
	}

	/**
	 * CRC32字符串校验,默认UTF-8编码读取
	 *
	 * @param str
	 *            a {@link String} object.
	 * @return a {@link String} object.
	 */
	public static String crc32(final String str) {
		return crc32( str, DEFAULT_CHARSET );
	}

	/**
	 * CRC32流校验
	 *
	 * @param input
	 *            a {@link InputStream} object.
	 * @return a {@link String} object.
	 */
	public static String crc32(InputStream input) {
		CRC32 crc32 = new CRC32();
		CheckedInputStream checkInputStream = null;
		int test = 0;
		try {
			checkInputStream = new CheckedInputStream( input, crc32 );
			do {
				test = checkInputStream.read();
			} while (test != -1);
			return Long.toHexString( crc32.getValue() );
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException( e );
		}
	}


	public static byte[] MD5(String str){
		return MD5(str,DEFAULT_CHARSET);
	}
	public static byte[] MD5(String str,String charset){
		try {
			byte[] bytes = str.getBytes( charset );
			return DigestUtils.md5(bytes);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return null;
		}
	}


}
