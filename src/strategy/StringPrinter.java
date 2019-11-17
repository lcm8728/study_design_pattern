package strategy;

class StringPrinter {
    private StringFormatter formatter;

    StringPrinter(StringFormatter formatter) {
        this.formatter = formatter;
    }

    void print(String str) {
        System.out.println(formatter.format(str));
    }
}