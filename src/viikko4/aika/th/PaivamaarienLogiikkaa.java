package viikko4.aika.th;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class PaivamaarienLogiikkaa {

    public static void main(String[] args) {
        LocalDate tanaan = LocalDate.now();
        System.out.println(tanaan);

        LocalDateTime tanaanKelloKasi = tanaan.atTime(20, 00);
        System.out.println(tanaanKelloKasi);

        LocalDate joulu = LocalDate.of(2020, 12, 24);
        System.out.println(joulu);

        System.out.println("Menikö joulu jo? " + tanaan.isAfter(joulu));

        LocalDate viikonPaasta = tanaan.plusDays(7);
        System.out.println("Viikon päästä: " + viikonPaasta);

        int yksi = Integer.parseInt("1");
        System.out.println(yksi); // 1

        LocalDate parsittu = LocalDate.parse("2020-12-24");
        System.out.println(parsittu.getDayOfMonth() + "." + parsittu.getMonthValue() + "." + parsittu.getYear());
    }
}
