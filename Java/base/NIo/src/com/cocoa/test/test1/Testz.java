package com.cocoa.test.test1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/**
 * Created by Administrator on 2016/5/23.
 */
public class Testz {

    public static void main(String args[]){

        System.out.println(StringFilter1("aaaaaa！@#！@#！￥%￥*&……%）（*&））（%……aaaaaa"));

    }


    public static  boolean   StringFilter(String   str)   throws PatternSyntaxException {
        String regEx="[`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~!@#￥%……&*（）——+|{}【】‘；：”“’。，、？]";
        Pattern   p   =   Pattern.compile(regEx);
        Matcher matcher  =    p.matcher(str);
        return matcher.matches();

    }

    public   static   String StringFilter1(String   str)   throws   PatternSyntaxException   {
        // 只允许字母和数字
        // String   regEx  =  "[^a-zA-Z0-9]";
        // 清除掉所有特殊字符
        String regEx="[`~!@#$%^&*()+=|{}':;',//[//].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]";
        Pattern   p   =   Pattern.compile(regEx);
        Matcher   m   =   p.matcher(str);
        return   m.replaceAll("").trim();
    }
}
