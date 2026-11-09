/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author nguye
 */
public class Experience extends Candidate {

    private int expInYear;
    private String proSkill;

    public Experience(String id, String firstName, String lastName, String address, String phone, String email, int birthDate,
             int expInYear, String proSkill) {
        super(id, firstName, lastName, address, phone, email, birthDate, 0);
        this.expInYear = expInYear;
        this.proSkill = this.proSkill;

    }

    public int getExpInYear() {
        return expInYear;
    }

    public void setExpInYear(int expInYear) {
        this.expInYear = expInYear;
    }

    public String getProSkill() {
        return proSkill;
    }

    public void setProSkill(String proSkill) {
        this.proSkill = proSkill;
    }

}
