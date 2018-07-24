package com.longfeng.panda.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by WuJingCheng on 2018/5/8.
 */

public class CheckHelper {
    //中文字母下划线长度4到10
    public static final String NAME ="[\\u4e00-\\u9fa5_a-zA-Z0-9_]{2,8}";
    public static final String PSS ="[_a-zA-Z0-9_]{4,10}";
    /**
     * 判断输入用户名是否合法
     * @param name
     * @return
     */
    public static boolean isValidName(String name){
        Pattern p = Pattern.compile(NAME);
        Matcher m = p.matcher(name);
        return m.matches();
    }
    public static boolean isValidPss(String pss){
        Pattern p = Pattern.compile(PSS);
        Matcher m = p.matcher(pss);
        return m.matches();
    }
}
