package org.oldcode.javaweb;

import java.io.InputStream;
import java.io.IOException;
import java.util.Properties;

public class Settings {
    private Properties props;

    public Settings() {
        props = new Properties();
    }

    public String get(String key) {
        String val = props.getProperty(key); // returns null if not found
        return val;
    }

    public void read() {
        InputStream in = null;
        String filename = "settings.properties";

    	try {
    		in = Settings.class.getClassLoader().getResourceAsStream(filename);
    		if (in == null)  {
    	        System.out.println("Sorry, unable to find " + filename);
    		}

    		props.load(in);

            //get the property value and print it out
            /*
    	    System.out.println(props.getProperty("db_user"));
    	    System.out.println(props.getProperty("db_password"));
    	    */

    	} catch (IOException ex) {
    		ex.printStackTrace();
        } finally {
        	if (in != null) {
        	    try {
				    in.close();
			    } catch (IOException e) {
				    e.printStackTrace();
			    }
        	}
        }
    }


}

