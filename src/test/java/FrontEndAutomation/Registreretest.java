package FrontEndAutomation;

import java.io.IOException;

import org.testng.annotations.Test;

import GeericLiraries.BaseClass;
import objectRepoClasses.RegisterPage;

public class Registreretest extends BaseClass{
	@Test
	public void registrer() throws IOException {
		String email = fUtil.readdatafromPropertyfile("email");
		 String password = fUtil.readdatafromPropertyfile("password");
		RegisterPage register = new RegisterPage(driver);

	//String email = "test" + System.currentTimeMillis() + "@gmail.com";

	register.registerUser(email, password);
}
}