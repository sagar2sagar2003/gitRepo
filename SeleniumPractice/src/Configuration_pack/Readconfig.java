package Configuration_pack;

import java.io.FileInputStream;
import java.util.Properties;

public class Readconfig {

	Properties pro;
	public Readconfig() throws Exception
	{
		FileInputStream confile = new FileInputStream("./Configuration/Configurations.property");
		pro = new Properties();
		pro.load(confile);
	}
	
	public String getChromepath()
	{
		String ChrmPath = pro.getProperty("ChromeDriver");
		return ChrmPath;
	}
	public String getIEpath()
	{
		String IEpath = pro.getProperty("IEDriver");
		return IEpath;
	}
	public String getURL()
	{
		String Url = pro.getProperty("URL");
		return Url;
	}
	
}
