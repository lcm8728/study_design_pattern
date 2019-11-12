package strategy;

public class PrintService {

    public static void main(String[] args) {
        StringPrinter printer1 = new StringPrinter(new UpperCaseFormatter());
        printer1.print("This Is Important Data");

        StringPrinter printer2 = new StringPrinter(new LowerCaseFormatter());
        printer2.print("This Is Important Data");

        StringPrinter printer3 = new StringPrinter(new NoFormatFormatter());
        printer3.print("This Is Important Data");
    }

}
