package SSM.utils;

import SSM.pojo.Admin;
import SSM.pojo.Student;

/**
 *  项目系统工具类
 */
public class SysUtils {


    private static int stuCount;


    // 自动 生成 ID
    public static String generateID(Object o,int num){

        if (o instanceof Admin){
            return "ad_" + num;
        } else if (o instanceof Student){
            return "s_" + stuCount ++;
        }
        return "";
    }
}
