package util;


import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;


public class ConfigurationReader {
	private Properties PRO;
	
	public Properties init_prop() {
		
		FileInputStream FIS;
		PRO= new Properties();	
		try {
			File src=new File("Configuration/config.properties");
			FIS = new FileInputStream(src);		
			PRO= new Properties();	
			PRO.load(FIS);
		} catch (Exception e) {
			
			System.out.println("Exception is: "+ e.getMessage());
		}
		return PRO;
	}
}
	

