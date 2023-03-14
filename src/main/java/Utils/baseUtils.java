package Utils;

//import org.apache.commons.RandomStringUtils;
import java.util.Random;

//import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang3.RandomStringUtils;

import BaseTest.baseTest;

public class baseUtils extends baseTest{

	private String countryName = "India";
	private String confirmPassword = "";
	private String passengersCount = "3";
	
	public String firstName()
	{
		return "Shiv "+RandomStringUtils.randomAlphabetic(3);
	}
	
	public String lastName()
	{
		return "Shambhu "+RandomStringUtils.randomAlphabetic(3);
	}
	
	public String phone()
	{
		String num= RandomStringUtils.randomNumeric(10);
		log.info("phone----> " + num);
		return num;
	}
	
	public String country()
	{
		return countryName;
	}
	
	public String email()
	{
		String email = "bholenath"+RandomStringUtils.randomAlphabetic(5) + "@bharat.co.in";
		log.info("email----> " + email);
		return email;	
	}
	
	public String userName()
	{
		return "bholenath "+RandomStringUtils.randomAlphabetic(5);
	}
	
	public String password()
	{
		confirmPassword = "Kashi "+RandomStringUtils.randomAlphanumeric(5);
		log.info("Password---> " + confirmPassword);
		return confirmPassword;
	}
	
	public String confirmPassword()
	{
		log.info("confirmPassword---> " + confirmPassword);
		return confirmPassword;
	}
	
	public String passengers()
	{
		return passengersCount;
	}
}
