package ConfigReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {

	Properties prop;
	FileInputStream fis;
	File f;
	
/*	public ConfigFileReader() throws IOException
	{
		f= new File(System.getProperty("user.dir")+"/src/test/resources/globalData.properties");
		fis = new FileInputStream(f);
		prop = new Properties();
		prop.load(fis);
		
	}	*/
	
	public Properties initializePropFile() throws Exception
	{
		f= new File(System.getProperty("user.dir")+"/src/test/resources/globalData.properties");
		fis = new FileInputStream(f);
		prop = new Properties();
		prop.load(fis);
		
		return prop;
	}

	
}
