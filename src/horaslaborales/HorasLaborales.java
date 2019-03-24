/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package horaslaborales;

import Interface.MainWindow;
import Interface.SesionWindow;


/**
 *
 * @author Alejandro
 */
public class HorasLaborales {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
            // TODO code application logic here
            /*ViewHistory ventana = new ViewHistory();
            ventana.setLocationRelativeTo(null);
            ventana.setVisible(true);*/
            
            /*MainWindow window = new MainWindow();
            window.setLocationRelativeTo(null);
            window.setVisible(true);*/
            
            SesionWindow ses = new SesionWindow();
            ses.setLocationRelativeTo(null);
            ses.setVisible(true);
            
            /*Date h = new Date("2018/10/11");
            System.out.println(h.getTime());
            Date f = new Date(h.getTime());
            cal.setTime(cal.getTime());*/
            //System.out.println(cal.getTime());
            //System.out.println(Calendar.getInstance().getTime());
            
            //ArrayList<String> a =conect.selectDate();
            //System.out.println(a);
        
    }
    
    
     
    
}
