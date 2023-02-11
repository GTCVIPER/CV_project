package SSM.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * java web token 工具类
 */
public class JwtUtils {

    /*
    过期时间一天
     */
    private static final long EXPIRE_TIME = 24 * 60 * 60 * 1000;

    /*
    token 私钥
     */
    private static final String TOKEN_SECRET = "f26e587c28064d0e855e72c0a6a0e618";

    /*
    校验 token 是否正确
     */
    public static boolean verify(String token) {
        try {
            final Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
            final JWTVerifier jwtVerifier = JWT.require(algorithm).build();
            jwtVerifier.verify(token);

            // 校验成功
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            // 校验失败
            return false;
        }
    }

    /*
    获取登录用户 ID
     */
    public static String getUserId(String token) {
        try {
            final DecodedJWT jwt = JWT.decode(token);

            return jwt.getClaim("userId").asString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /*
    生成签名，一天后过期
     */
    public static String sign(String userId,String username){

        try {
            // 过期时间
            final Date date = new Date(System.currentTimeMillis() + EXPIRE_TIME);

            // 私钥及加密算法
            final Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);

            // 设置头部信息
            Map<String,Object> header = new HashMap<>(2);
            header.put("typ","JWT");
            header.put("alg","HS256");

            // 附带 username，userId 信息，生成签名
            return JWT.create().withHeader(header).withClaim("loginName",username)
                    .withClaim("userId",userId).withExpiresAt(date)
                    .sign(algorithm);
        } catch (Exception e){
            e.printStackTrace();

            return null;
        }
    }
}
