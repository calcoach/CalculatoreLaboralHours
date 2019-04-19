
import java.time.LocalDate;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Alejandro
 */
public class NewClass {

    public void testCalculaSalarioBruto2() {
        System.out.println(3 + 4);

    }

    public static void main(String[] args) {

        LocalDate localDate = LocalDate.now();
        int day = localDate.getDayOfMonth();
        System.out.println(localDate.withDayOfMonth(15).toString());
    }

}
