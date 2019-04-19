public class PrintDate {

	private Printer printer;
	private Calendar calendar;

	public PrintDate(Printer printer, Calendar calendar) {
		this.printer = printer;
		this.calendar = calendar;
	}

	public PrintDate() {
		this.printer = new ConsolePrinter();
		this.calendar = new Calendar();
	}

	public void printCurrentDate() {
		printer.print(calendar.getCurrentDate());
	}
}
