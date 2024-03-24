import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Введите фамилию, имя, отчество и дату в формате ДД.ММ.ГГГГ");
        Scanner scanner = new Scanner(System.in);
        String surname = scanner.next();
        String name = scanner.next();
        String midname = scanner.next();
        String date = scanner.next();
        System.out.println("Фамилия и инициалы: "+surname+" "+name.charAt(0)+". "+midname.charAt(0)+". ");
        if (midname.endsWith("а"))
            System.out.println("Пол: женский");
        else
            System.out.println("Пол: мужской");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate startDate = LocalDate.now();
        try {
            LocalDate endDate = LocalDate.parse(date, formatter);
            Period period = Period.between(endDate,startDate);
            System.out.println("Возраст: "+period.getYears());
        }catch (DateTimeParseException e) {
            System.out.println("Date in wrong format");
        }
    }
}