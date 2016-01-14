package com.joker.common.helper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesHelper {

    private Properties _properties;

    private volatile static PropertiesHelper _instance = null;

    private PropertiesHelper() {
        _properties = new Properties();
    }

    public static PropertiesHelper getInstance() {
        if (null == _instance) {
            synchronized (PropertiesHelper.class) {
                if (_instance == null)
                    _instance = new PropertiesHelper();
            }
        }
        return _instance;
    }

    public void load(String filePath) throws FileNotFoundException, IOException {
        FileInputStream fis = null;
        File file = new File(filePath);
        if (!file.exists()) {
            throw new FileNotFoundException(filePath + "not exists");
        }
        try {
            fis = new FileInputStream(file);
            _properties.load(fis);
        } catch (FileNotFoundException e) {
            throw e;
        } catch (IOException e) {
            throw e;
        } finally {
            try {
                fis.close();
            } catch (IOException e) {
                throw e;
            }
        }

    }

    public String getString(String key) throws NullPointerException {
        if (null == key || key.equals("") || key.equals("null")) {
            return "";
        }
        String result = "";
        try {
            result = _properties.getProperty(key);
        } catch (Exception e) {
            throw new NullPointerException(e.getMessage());
        }
        return result;
    }

    public Properties getProperties() {
        return _properties;
    }
}