package UtilityPackage;

	import java.io.FileInputStream;
	import java.util.Properties;

	public class ConfigProperty {
		
	static Properties prop;
		
		private static void loadProperty()
		{
			prop = new Properties();
			 
			 try {
					
					FileInputStream	stream = new FileInputStream(System.getProperty("user.dir")+"\\Properties\\ConfigPropertyPackage\\Config.Properties");
					 prop.load(stream);
					 
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
		public static String getKeyValue(String key)
		{
			String value;
			
			if(prop != null)
			{
				value = prop.getProperty(key);
				
			}
			else
			{
				loadProperty();
				value = prop.getProperty(key);
			}
			
			return value;
		}
		

	}


