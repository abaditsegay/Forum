package cs544.onlineforumproject.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import sun.misc.BASE64Encoder;

public class Utils {

    public static String getMD5Hash(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            byte[] hash = messageDigest.digest(str.getBytes());
            return new BASE64Encoder().encode(hash);
        } catch (NoSuchAlgorithmException ex) {
          
        }
        return null;
    }

}
