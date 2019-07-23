package com.cocoa.shiji.util;

import com.cocoa.shiji.Main;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Enumeration;
import java.util.Properties;

public class PropretyUtil {

    public static Properties getPps() {

        InputStream inputStream = PropretyUtil.class.getClassLoader().getResourceAsStream("application.properties");

        Properties pps = new Properties();

        try {
            pps.load(new InputStreamReader(inputStream, "utf-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  pps;
    }

}
