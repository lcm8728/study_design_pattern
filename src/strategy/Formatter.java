package strategy;

interface StringFormatter {
    String format(String str);
}

class UpperCaseFormatter implements StringFormatter {

    @Override
    public String format(String str) {
        return str.toUpperCase();
    }
}

class LowerCaseFormatter implements StringFormatter {

    @Override
    public String format(String str) {
        return str.toLowerCase();
    }
}

class NoFormatFormatter implements StringFormatter {

    @Override
    public String format(String str) {
        return str;
    }
}