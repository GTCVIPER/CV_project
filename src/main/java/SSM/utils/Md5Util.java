package SSM.utils;

import org.apache.commons.codec.binary.Hex;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Md5Util {

    /**
     * 将数据进行 MD5 加密，并以16进制字符串格式输出
     *
     */
    public static String md5(String data) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            return Hex.encodeHexString(md.digest(data.getBytes(StandardCharsets.UTF_8)));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }

//    public static void main(String[] args) {
//        String password = "43rr45f4g";
//        String md5HexStr = md5(password);
//        System.out.println("==> MD5 加密前: " + password);
//        System.out.println("==> MD5 加密后: " + md5HexStr);
//    }
}