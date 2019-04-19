import java.util.Date;

public class DoublePrinter implements Printer {

    private boolean printerCalled;
    private Date printedDate;

    public DoublePrinter() {
        printerCalled = false;
        printedDate = null;
    }

    @Override
    public void print(Date date) {
        printerCalled = true;
        printedDate = date;
    }

    public boolean isPrinterCalled() {
        return printerCalled;
    }

    public Date getPrintedDate() {
        return printedDate;
    }
}
