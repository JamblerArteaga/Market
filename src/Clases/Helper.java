/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author chrisloops
 */
public class Helper {
      public static Helper instance;
    
     public static Helper instance(){
        if(instance == null){
            instance = new Helper();
        }
        
        return instance;
    }
     
     public void clean(){
         for(int i=0; i<100 ;i++){
            System.out.println("");
        }
     }
}
