package utilities;

import org.apache.commons.lang3.RandomStringUtils;

public class utils {

	public static String getEmpName()
	{
		String empName = RandomStringUtils.randomAlphabetic(3);
		return ("RaOne"+empName);
	}
	
	public static String getEmpSal()
	{
		String Sal = RandomStringUtils.randomNumeric(5);
		return Sal;
	}
	
	public static String getEmpAge()
	{
		String age = RandomStringUtils.randomNumeric(2);
		return age;
	}
}
