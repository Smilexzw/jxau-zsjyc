package cn.jxau.zsjyc.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.apache.commons.codec.binary.Base64;

public class PasswordEncoder {
	public static String decodeStr(String pwd)
    {
        Base64 base64 = new Base64();
        byte[] debytes = base64.decodeBase64(new String(pwd).getBytes());
        debytes = base64.decodeBase64(debytes);
        String str=new String(debytes);
        return str.substring(0,str.length()-6);
    }
	
	public static String encodeStr(String pwd)
    {
        Base64 base64 = new Base64();
        byte[] enbytes = base64.encodeBase64Chunked(new String(pwd+"l.s123").getBytes());
        enbytes = base64.encodeBase64Chunked(enbytes);
        return new String(enbytes);
    }
	
}
