/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edd_proyecto2;

import java.time.LocalDate;
import java.util.Calendar;

/**
 *
 * @author MiriamLeticia
 */
public class Obtener_Hora {
    
    public Obtener_Hora(){
        
    }
    
    public String obtener_fecha(){
        Calendar cal = Calendar.getInstance();
        String Hora;
        String hora1="", fecha1="";
        String Fecha_Completa="";
        if(cal.get(Calendar.HOUR)>=10 && cal.get(Calendar.MINUTE)>=10 && cal.get(Calendar.SECOND)>=10){
        Hora="    "+cal.get(Calendar.HOUR)+":"+cal.get(Calendar.MINUTE)+":"+cal.get(Calendar.SECOND)+" "+(cal.get(Calendar.AM_PM)==Calendar.AM?"am":"pm");
        hora1 = Hora;
        }
        if(cal.get(Calendar.HOUR)<10 && cal.get(Calendar.MINUTE)<10 && cal.get(Calendar.SECOND)<10){
        Hora="    "+"0"+cal.get(Calendar.HOUR)+":"+"0"+cal.get(Calendar.MINUTE)+":"+"0"+cal.get(Calendar.SECOND)+" "+(cal.get(Calendar.AM_PM)==Calendar.AM?"am":"pm"); 
        hora1 = Hora;
        }
        if(cal.get(Calendar.HOUR)>=10 && cal.get(Calendar.MINUTE)>=10 && cal.get(Calendar.SECOND)<10){
        Hora="    "+cal.get(Calendar.HOUR)+":"+cal.get(Calendar.MINUTE)+":"+"0"+cal.get(Calendar.SECOND)+" "+(cal.get(Calendar.AM_PM)==Calendar.AM?"am":"pm"); 
        hora1 = Hora;
        }
        if(cal.get(Calendar.HOUR)>=10 && cal.get(Calendar.MINUTE)<10 && cal.get(Calendar.SECOND)>=10){
        Hora="    "+cal.get(Calendar.HOUR)+":"+"0"+cal.get(Calendar.MINUTE)+":"+cal.get(Calendar.SECOND)+" "+(cal.get(Calendar.AM_PM)==Calendar.AM?"am":"pm"); 
        hora1 = Hora;
        }
        if(cal.get(Calendar.HOUR)<10 && cal.get(Calendar.MINUTE)>=10 && cal.get(Calendar.SECOND)>=10){
        Hora="    "+"0"+cal.get(Calendar.HOUR)+":"+cal.get(Calendar.MINUTE)+":"+cal.get(Calendar.SECOND)+" "+(cal.get(Calendar.AM_PM)==Calendar.AM?"am":"pm"); 
        hora1 = Hora;
        }
        LocalDate fechaact = LocalDate.now();
        
        if (fechaact.getMonthValue()<10) {
            String fechita= fechaact.getDayOfMonth() + "-0" +fechaact.getMonthValue() + "-" + fechaact.getYear();
            fecha1 = fechita;
        }else{
            String fechita= fechaact.getDayOfMonth() + "-" +fechaact.getMonthValue() + "-" + fechaact.getYear();
            fecha1 = fechita;
        }
        
        Fecha_Completa = fecha1 + " -::-" + hora1;
        
        return Fecha_Completa;
    }
}
