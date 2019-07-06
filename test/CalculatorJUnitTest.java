/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import horaslaborales.Calculator;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Alejandro
 */
public class CalculatorJUnitTest {

    public CalculatorJUnitTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void test() {

        //test1Calculator(23,24,1, true); fn fs
        //test1Calculator(23,24,1, false); 
        //test1Calculator(20,2, 1, true); fn fs
        //test1Calculator(10,6,1, true);  fn fs 
        //test1Calculator(10,6,1, false); error hora ininio menor q hora fin
        //test1Calculator(24,6,1, false); fn fs
        //test1Calculator(24,23,1, false); fn fs
        //test1Calculator(24,24,3, true); fn fs
        //test1Calculator(24,1,3, true);
        //test1Calculator(22,24,3, true);
        test1Calculator();
        Random r = new Random();
        int hora1 = r.nextInt(24) + 1;
        int hora2 = r.nextInt(24) + 1;
        //System.out.println("hora 1: "+hora1+" hora2 "+hora2);

    }

    public void test1Calculator() {

        File file = new File("test2.txt");

        try (FileReader freader = new FileReader(file);
                BufferedReader reader = new BufferedReader(freader)) {

            reader.readLine();

            while (reader.ready()) {

                String test = reader.readLine();

                String[] split = test.split(",");

                Calculator cal = new Calculator(Integer.valueOf(split[0]), Integer.valueOf(split[1]), 2000000);

                if (Boolean.valueOf(split[3]) == false) {

                    cal.setDia(Integer.valueOf(split[2]));

                    cal.setNextDay(false);
                    int[] h = cal.calcularHoras();
                    cal.setNextDay(false);
                    double[] s = cal.calcularSueldo();

                    int[] h1 = new int[5];
                    h1[0] = Integer.valueOf(split[4]);
                    h1[1] = Integer.valueOf(split[5]);
                    h1[2] = Integer.valueOf(split[6]);
                    h1[3] = Integer.valueOf(split[7]);
                    h1[4] = Integer.valueOf(split[8]);

                    mostrar(h, h1);

                    double[] s1 = new double[5];
                    s1[0] = Double.valueOf(split[9]);
                    s1[1] = Double.valueOf(split[10]);
                    s1[2] = Double.valueOf(split[11]);
                    s1[3] = Double.valueOf(split[12]);
                    s1[4] = Double.valueOf(split[13]);
                    mostrarSueldo(s, s1);
                } else {

                        cal.setDia(Integer.valueOf(split[2]));

                        cal.setNextDay(true);
                        int[] h = cal.calcularHoras();
                        cal.setNextDay(true);
                        double[] s = cal.calcularSueldo();

                        int[] h1 = new int[11];
                        h1[0] = Integer.valueOf(split[4]);
                        h1[1] = Integer.valueOf(split[5]);
                        h1[2] = Integer.valueOf(split[6]);
                        h1[3] = Integer.valueOf(split[7]);
                        h1[4] = Integer.valueOf(split[8]);
                        h1[5] = Integer.valueOf(split[9]);
                        h1[6] = Integer.valueOf(split[10]);
                        h1[7] = Integer.valueOf(split[11]);
                        h1[8] = Integer.valueOf(split[12]);
                        h1[9] = Integer.valueOf(split[13]);
                        h1[10] = h1[5]+h1[9];
                       
                        mostrar(h, h1);

                        double[] s1 = new double[11];
                        s1[0] = Double.valueOf(split[14]);
                        s1[1] = Double.valueOf(split[15]);
                        s1[2] = Double.valueOf(split[16]);
                        s1[3] = Double.valueOf(split[17]);
                        s1[4] = Double.valueOf(split[18]);
                        s1[5] = Double.valueOf(split[19]);
                        s1[6] = Double.valueOf(split[20]);
                        s1[7] = Double.valueOf(split[21]);
                        s1[8] = Double.valueOf(split[22]);
                        s1[9] = Double.valueOf(split[23]);
                        s1[10] = s1[4]+s1[9];
                          
                        mostrarSueldo(s, s1);
                    
                }
            }

            //System.out.println();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CalculatorJUnitTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CalculatorJUnitTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Before
    public void setUp() {
    }

    public void mostrar(int[] h, int[] h2) {
        System.out.println(h[0] + " " + h2[0]);
        System.out.println(h[1] + " " + h2[1]);
        System.out.println(h[2] + " " + h2[2]);
        System.out.println(h[3] + " " + h2[3]);
        System.out.println("Total dia 1 " + h[4] + " " + h2[4]);
        if (h.length > 5) {

            System.out.println(h[5] + " " + h2[5]);
            System.out.println(h[6] + " " + h2[6]);
            System.out.println(h[7] + " " + h2[7]);
            System.out.println(h[8] + " " + h2[8]);
            System.out.println("Total dia 2 " + h[9] + " " + h2[9]);
            System.out.println("Total  " + h[10] + " " + h2[10]);
        }
    }

    public void mostrarSueldo(double[] h, double h1[]) {
        System.out.println(h[0] + " " + h1[0]);
        System.out.println(h[1] + " " + h1[1]);
        System.out.println(h[2] + " " + h1[2]);
        System.out.println(h[3] + " " + h1[3]);
        System.out.println("Total dia 1 " + h[4] + " " + h1[4]);
        if (h.length > 5) {

            System.out.println(h[5] + " " + h1[5]);
            System.out.println(h[6] +" " + h1[6]);
            System.out.println(h[7] + " " + h1[7]);
            System.out.println(h[8] + " " + h1[8]);
            System.out.println("Total dia 2 " + h[9]+ " " + h1[9]);
            System.out.println("Total " + h[10] + " " + h1[10]);
            Assert.assertEquals(h1[10],h[10], 0.9);
        }
        Assert.assertEquals(h1[4], h[4], 0.9);
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
