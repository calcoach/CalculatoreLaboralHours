/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package horaslaborales;

import java.io.File;
import javafx.application.Application;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 *
 * @author Alejandro
 */
public class OpenFile extends Application {

    
    public OpenFile(){
      
        
       //begin();
    }
    
    public static void begin(){
         String [] args = new String[1];
        launch(args);
    }
     public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        FileChooser fileChooser = new FileChooser();
            File file = fileChooser.showSaveDialog(primaryStage);
        
         System.out.println(file);
         primaryStage.setOpacity(0);
          primaryStage.show();
          
        
          primaryStage.close();
    }
    
}
