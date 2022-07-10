import java.time.Duration;
import java.time.Instant;
import java.util.Scanner;

public class WorkingTime {
    static Instant stop;
    static Instant start;
    static Scanner scanner = new Scanner(System.in);

    public static void workingTime() {
        System.out.println("""
                Введи "start" для начала отсчета,\s
                "stop" для окончания работы или\s
                "time" для получения текущего времени работы\s""");
        boolean youWorking = true;
        while (youWorking) {
            String line = scanner.nextLine();
            if (line.equalsIgnoreCase("start") || line.equals("s")) {
                start = Instant.now();
                System.out.println("Отсчет начался. На галеру!");
                while (true) {
                    line = scanner.nextLine();
                    if (line.equalsIgnoreCase("time") || line.equals("t")) {
                        stop = Instant.now();
                        Duration d = Duration.between(start, stop);
                        if (getHours(d) > 8 && getMinutes(d) > 30) {
                            System.out.println("ИДИ ДОМОООООЙ!" + "\n" + "Ты отработал: " + getHours(d) + "ч " + getMinutes(d) + "м");
                        }
                        System.out.println("Ты отработал: " + getHours(d) + "ч " + getMinutes(d) + "м");
                    } else if (line.equalsIgnoreCase("stop") || line.equals("q")) {
                        Duration d = Duration.between(start, stop);
                        System.out.println("Заходи еще поработать");
                        System.out.println("Ты отработал: " + getHours(d) + "ч " + getMinutes(d) + "м");
                        youWorking = false;
                        break;
                    } else {
                        System.out.println("""
                                "stop" - окончание работы\s
                                "time" - текущее время работы\s""");
                    }
                }
            }
        }
    }

    public static int getHours(Duration d) {
        return d.toHoursPart();
    }

    public static int getMinutes(Duration d) {
        return d.toMinutesPart();
    }
}