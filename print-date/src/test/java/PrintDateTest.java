import org.junit.Before;
import org.junit.Test;

import java.util.Date;
import java.util.GregorianCalendar;

import static java.util.Calendar.JANUARY;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class PrintDateTest {

	private Printer printer;

	@Before
	public void setUp() {
		printer = new DoublePrinter();
	}

	@Test
	public void printDate() throws Exception {
		PrintDate printDate = new PrintDate();

		printDate.printCurrentDate();

		// How can we test this function?
	}

	@Test
	public void calendarCurrentDate_printDate_callsPrint() throws Exception {
		Calendar calendar = new Calendar();
		PrintDate printDate = new PrintDate(printer, calendar);

		printDate.printCurrentDate();

		assert ((DoublePrinter) printer).isPrinterCalled();
	}

	@Test
	public void calendarCustomDate_printDate_usesCustomDate() throws Exception {
		Date doubleDate = getDoubleDate();
		Calendar calendar = getDoubleCalendar(doubleDate);
		PrintDate printDate = new PrintDate(printer, calendar);

		printDate.printCurrentDate();

		assertThat(((DoublePrinter) printer).getPrintedDate(), is(doubleDate));
	}

	private Date getDoubleDate() {
		GregorianCalendar greCalendar = new GregorianCalendar();
		greCalendar.set(2018, JANUARY, 1);
		return greCalendar.getTime();
	}

	private Calendar getDoubleCalendar(Date date) {
		return new Calendar() {
			public Date getCurrentDate() {
				return date;
			}
		};
	}
}
