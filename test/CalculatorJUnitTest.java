/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import horaslaborales.Calculator;
import java.util.Random;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

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
    public void test(){
        
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
      
       Random r = new Random();
       int hora1 = r.nextInt(24)+1;
       int hora2 = r.nextInt(24)+1;
       //System.out.println("hora 1: "+hora1+" hora2 "+hora2);
       
       
        
    }
    
    
    public void test1Calculator(int i, int j, int day,  boolean d){
        Calculator cal = new Calculator(i,j, 1000000);
        cal.setDia(day);
        cal.setNextDay(d);
        int [] h =  cal.calcularHoras();
        cal.setNextDay(d);
        double [] s = cal.calcularSueldo();   
        
        mostrar(h);
        mostrarSueldo(s);
       //System.out.println();
        
    }

    @Before
    public void setUp() {
    }
    
    public void mostrar(int [] h){
        System.out.println(h[0]);  
        System.out.println(h[1]);  
        System.out.println(h[2]);  
        System.out.println(h[3]);  
        System.out.println("Total dia 1 "+h[4]);  
        if(h.length>5){
            
            System.out.println(h[5]);  
            System.out.println(h[6]);  
            System.out.println(h[7]);  
            System.out.println(h[8]);  
            System.out.println("Total dia 2 "+h[9]);  
            System.out.println("Total  "+h[10]);  
        }
    } 
    
    public void mostrarSueldo(double[] h){
        System.out.println(h[0]);  
        System.out.println(h[1]);  
        System.out.println(h[2]);  
        System.out.println(h[3]);  
        System.out.println("Total dia 1 "+h[4]);  
        if(h.length>5){
            
            System.out.println(h[5]);  
            System.out.println(h[6]);  
            System.out.println(h[7]);  
            System.out.println(h[8]);  
            System.out.println("Total dia 2 "+h[9]);  
            System.out.println("Total "+h[10]);  
        }
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
