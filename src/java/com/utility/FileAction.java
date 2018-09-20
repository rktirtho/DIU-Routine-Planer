/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utility;

import javax.servlet.http.Part;

/**
 *
 * @author DELL
 */
public class FileAction {
    
    /**
    * @param part this is file path
    * @return String a file path
    * @author Tirtho
    
    **/
    
    public static String extractFilePart(Part part){
        String contextDist=part.getHeader("content-disposition");
        String[] item=contextDist.split(";");
        for (String s : item) {
            if (s.trim().startsWith("filename")) {
                return s.substring(s.indexOf("=")+2,s.length()-1);
            }
            
        }
        
    
        return "";
    }
    
}
