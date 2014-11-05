/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.gbm.WSServer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import javax.xml.ws.Endpoint;

/**
 *
 * @author mfigueroa
 */
public class WSServer {
    
    public String loadClasses(File file){
        try{
        //Class loader Reflection 
		ClassLoader myClassLoader = ClassLoader.getSystemClassLoader();
		
		BufferedReader br = new BufferedReader(new FileReader(file));
		String line = "";
		while ((line = br.readLine()) != null) {
			String classNameToBeLoaded = line;
			Class myClass = myClassLoader.loadClass(classNameToBeLoaded);
			Endpoint.publish("http://localhost:8080/"+line, myClass.newInstance());
		}
		br.close();
		System.out.println("WebServer started");
		
	}
        
        catch(Exception e){
            System.out.println("Something failed");
            e.printStackTrace();
            return "Error";
        }
        
        
        return "Successful";
    }
    
    public void stopServer(){
        
    }
    
}
