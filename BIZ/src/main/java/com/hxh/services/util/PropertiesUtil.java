package com.hxh.services.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by think on 2015/4/9.
 */
public class PropertiesUtil {

    private Properties pro = new Properties();

    public PropertiesUtil(String proName) {
        load(proName);
    }

    public void load(String proName) {
        InputStream in = PropertiesUtil.class.getClassLoader().getResourceAsStream(proName);
        try {
            pro.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getValue(String key) {
        return pro.getProperty(key);
    }

    public String getValue(String proName, String key) {
        load(proName);
        return getValue(key);
    }

}
