package com.cr.common;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;



/**
 * MD5加密工具类
 *
 * @author pengzhengming
 * @version 1.0 2015/05/25
 */
public class MD5Utils {

   // private static Logger log = LoggerFactory.getLogger(MD5Utils.class);

    /**
     * md5加密
     *
     * @param str
     * @return
     */
    public static String md5(String str) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(str.getBytes());
            byte[] byteDigest = md.digest();
            int i;
            StringBuffer buf = new StringBuffer("");
            for (int offset = 0; offset < byteDigest.length; offset++) {
                i = byteDigest[offset];
                if (i < 0)
                    i += 256;
                if (i < 16)
                    buf.append("0");
                buf.append(Integer.toHexString(i));
            }
            // 32位加密
            return buf.toString();
        } catch (NoSuchAlgorithmException e) {
            
            return null;
        }
    }

    /**
     * md5加密
     *
     * @param chars
     * @return
     */
    public static String md5(char[] chars) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(String.valueOf(chars).getBytes());
            byte[] byteDigest = md.digest();
            int i;
            StringBuffer buf = new StringBuffer("");
            for (int offset = 0; offset < byteDigest.length; offset++) {
                i = byteDigest[offset];
                if (i < 0)
                    i += 256;
                if (i < 16)
                    buf.append("0");
                buf.append(Integer.toHexString(i));
            }
            // 32位加密
            return buf.toString();
        } catch (NoSuchAlgorithmException e) {
          
            return null;
        }
    }

}
