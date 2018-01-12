package org.oldcode.javaweb;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.InputStream;
import java.io.IOException;
import java.util.Properties;

public class Settings {

    private static final Logger log = LogManager.getLogger(Settings.class);

    public void read() {
        Properties props = new Properties();
        InputStream in = null;

    	try {

    		String filename = "settings.properties";
    		in = Settings.class.getClassLoader().getResourceAsStream(filename);
    		if (in == null)  {
    	        System.out.println("Sorry, unable to find " + filename);
    		    return;
    		}

    		//load a properties file from class path, inside static method
    		props.load(in);

            //get the property value and print it out
    	    System.out.println(props.getProperty("db_user"));
    	    System.out.println(props.getProperty("db_password"));

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

