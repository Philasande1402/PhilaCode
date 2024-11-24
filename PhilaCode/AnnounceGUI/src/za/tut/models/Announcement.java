/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.tut.models;

/**
 *
 * @author fredre
 */
public class Announcement {
    private String announcementText;
    private String course;
    private String campus;

    public Announcement(String announcementText, String course, String campus) {
        this.announcementText = announcementText;
        this.course = course;
        this.campus = campus;
    }

    @Override
    public String toString() {
        return "Announcement{" +
                "announcementText='" + announcementText + '\'' +
                ", course='" + course + '\'' +
                ", campus='" + campus + '\'' +
                '}';
    }
}
