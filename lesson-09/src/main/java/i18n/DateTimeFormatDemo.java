package i18n;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class DateTimeFormatDemo {
    public static void main(String[] args) {
        Locale vi = new Locale("vi", "VN");
        Locale ja = new Locale("ja", "JP");
        LocalDate today = LocalDate.now();

        String s1 = formatDateByLocale(today, vi);
        String s2 = formatDateByLocale(today, ja);
        System.out.println("s1 = " + s1);
        System.out.println("s2 = " + s2);

        String pattern = "EEE, MMM dd, yyyy";
        String s3 = formatDateByPattern(today, pattern);
        System.out.println("s3 = " + s3);
    }

    public static String formatDateByLocale(LocalDate date, Locale locale) {
        DateTimeFormatter formatter = DateTimeFormatter
                .ofLocalizedDate(FormatStyle.FULL)
                .withLocale(locale);
        return formatter.format(date);
    }

    public static String formatDateByPattern(LocalDate date, String pattern) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return formatter.format(date);
    }
}
