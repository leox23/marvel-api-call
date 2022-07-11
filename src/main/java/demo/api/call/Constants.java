package demo.api.call;

import javax.swing.*;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class Constants {
    static Properties property = new Properties();
    static InputStream configInput = null;
    public static void loadConfig(){
        try{
            configInput = new FileInputStream("marvel_api_config.properties");
            property.load(configInput);
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error cargando configuración\n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
