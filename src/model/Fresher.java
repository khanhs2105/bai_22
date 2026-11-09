/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDate;

/**
 *
 * @author nguye
 */
public class Fresher extends Candidate{
    private int graduateTime;
    private String graduateRank;
    private String education;

    public Fresher(String id, String firstName, String lastName, String address, String phone,
            String email, int birthDate,int graduateTime,String graduateRank,String education) {
        super(id, firstName, lastName, address, phone, email, birthDate,1);
        this.education=education;
        this.graduateRank=graduateRank;
        this.graduateTime=graduateTime;
    }

    public int getGraduateTime() {
        return graduateTime;
    }

    public void setGraduateTime(int graduateTime) {
        this.graduateTime = graduateTime;
    }

    public String getGraduateRank() {
        return graduateRank;
    }

    public void setGraduateRank(String graduateRank) {
        this.graduateRank = graduateRank;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }
    
}
