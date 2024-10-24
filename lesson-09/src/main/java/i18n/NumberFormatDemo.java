package i18n;

import java.text.NumberFormat;
import java.util.Locale;

public class NumberFormatDemo {
    public static void main(String[] args) {
        Locale vi = new Locale("vi", "VN");
        Locale ja = new Locale("ja", "JP");
        double n = 123456.789;

        String s1 = formatNumber(n, vi);
        String s2 = formatNumber(n, ja);

        System.out.println("s1 = " + s1);
        System.out.println("s2 = " + s2);
    }

    public static String formatNumber(double n, Locale locale) {
        NumberFormat formatter = NumberFormat.getInstance(locale);
        return formatter.format(n);
    }
}
