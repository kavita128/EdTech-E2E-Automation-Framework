package GeericLiraries;


import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Random;

public class JavaUtils {
	
	/**
	 * GetRandomno
	 * @return
	 */
public int getRandomno()
{
	Random ran = new Random();
	int random = ran.nextInt(1000);
	return random;
}
/**
 * systemDate
 * @return
 */
public String systemDate()
{
	LocalDate date = LocalDate.now();
	DateTimeFormatter d = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	String systemDate = d.format(date);
	return systemDate;
}

public String sysDateSimple() {
    return new SimpleDateFormat("dd-MM-yyyy_HH-mm-ss").format(new Date());
}

/**
 * sysDatewithDate
 * @return
 */
public String sysDate()
{
	Date date = new Date();
	SimpleDateFormat sim = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
	String systemDateInFormat =  sim.format(date);
	return systemDateInFormat;
	
}

/**
 * futureDateIntermsOfMonths
 * @param futureMon
 * @return
 */
public String futureDateIntermsOfMonths(long futureMon)
{
	LocalDate date = LocalDate.now();
	LocalDate future = date.plusMonths(futureMon);
	
	DateTimeFormatter d = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	String futreMonth = d.format(future);
	return futreMonth;
}
}










