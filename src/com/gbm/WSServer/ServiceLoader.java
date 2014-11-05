/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gbm.WSServer;

import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

/**
 *
 * @author mfigueroa
 */
public class ServiceLoader {
    
    public  void addSoftwareLibrary(File file) throws Exception {
    Method method = URLClassLoader.class.getDeclaredMethod("addURL", new Class[]{URL.class});
    method.setAccessible(true);
    method.invoke(ClassLoader.getSystemClassLoader(), new Object[]{file.toURI().toURL()});
}
    
}
