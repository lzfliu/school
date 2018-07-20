package com.lzf.utils;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.UUID;

public class IdGenerater {
	public static final String MIX_CHARATER="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	public static final String LOWER_CHARATER="abcdefghijklmnopqrstuvwxyz";
	public static final String UPPER_CHARATER="ABCDEFGHIJKLMNOPQRSTUVWXYZ";

	public static final String NUMBER="1234567890";


	public static String nextId(){
		String uuid=UUID.randomUUID().toString();
		return CryptoUtils.encodeMD5( uuid ).toLowerCase();
	}
	public static String uuid(){
		String uuid=UUID.randomUUID().toString();
		return uuid.replaceAll( "-", "" );
	}

	public static String RandomLowerCharater(int length){
		return RandomStringUtils.random(length,"abcdefghijklmnopqrstuvwxyz");
	}
	public static String RandomUpperCharater(int length){
		return RandomString(length,"abcdefghijklmnopqrstuvwxyz".toUpperCase());
	}
	public static String RandomMixCharater(int length){
		return RandomString(length,MIX_CHARATER);
	}
	public static String RandomNumberStr(int length){
		return RandomString(length,NUMBER);
	}

	public static String RandomString(int length,String character){
		return RandomStringUtils.random(length,character);
	}
}
