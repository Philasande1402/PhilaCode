/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.io.*;
import java.util.List;
import java.util.ArrayList;

import za.tut.models.Announcement;

/**
 *
 * @author fredre
 */
public class AnnounceStore {
    
    private List<Announcement> announcements;
    
    private String filename ="astore.txt"; //Been better to use the File Object
    
    public AnnounceStore()
    {
        announcements = new ArrayList<>();  //Why first a List then ArrayList !
    }
    
    public void addAnnouncement(Announcement announcement)
    {
        announcements.add(announcement);
    }
    
    public void saveAnnouncement()
    {
        try(PrintWriter pw = new PrintWriter(new FileWriter(filename))){
            
            //Some check if the file is valid
            
            for(Announcement announcement : announcements)
            {
                pw.println(announcement.toString());
            }
         
        }
        catch(IOException e)
        {
            //Fail without saying anything
            System.err.print("This should display in red ?");
        }
    }
    
            
            
    
}
