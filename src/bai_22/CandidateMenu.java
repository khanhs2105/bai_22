/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bai_22;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import manager.CandidateManager;
import model.Candidate;
import model.Experience;
import model.Fresher;
import model.Intern;
import validation.Validation;

/**
 *
 * @author nguye
 */
public class CandidateMenu {

    private final Validation v = new Validation();
    private final CandidateManager manager = new CandidateManager();

    public void run() {
        while (true) {
            System.out.println("\nCANDIDATE MANGEMENT SYSTEM");
            System.out.println("1. Experience");
            System.out.println("2. Fresher");
            System.out.println("3. Internship");
            System.out.println("4. Searching");
            System.out.println("5. Exit");
            int choice = v.getInt("Your choice: ", 1, 5);
            switch (choice) {
                case 1:
                case 2:
                case 3:
                    createCandidate(choice - 1); //1->type0,2->type 1,3->type2
                    break;
                case 4:
                    search();
                    break;
                case 5:
                    return;
            }
        }
    }

    private void createCandidate(int type) {
        do {
            // phan chung ---
            String id;
            while (true) {
                id = v.getString("Id: ");
                if (!manager.isIdExist(id)) {
                    break;
                }
                System.out.println("Id is exist,try again !");
            }
            String firstName = v.getString("First name: ");
            String lastName = v.getString("Last name: ");
            int brithDate = v.getBirthDate("Birth date(year): ");
            String address = v.getString("Address: ");
            String phone = v.getPhone("Phone: ");
            String email = v.getEmail("Email: ");

            //---phan rieng 
            Candidate c;
            if (type == 0) {
                int exp = v.getInt("Year of experience: ", 0, 100);
                String skill = v.getString("Professional skill: ");
                c = new Experience(id, firstName, lastName, address, phone, email, brithDate, exp, skill);

            } else if (type == 1) {
                int gradDate = v.getInt("Graduation year: ", brithDate, java.time.Year.now().getValue());
                String rank = v.getRank("Graduation rank: ");
                String edu = v.getString("Education (university): ");
                c = new Fresher(id, firstName, lastName, address, phone, email, brithDate, gradDate, rank, edu);
            } else {
                String major = v.getString("Major: ");
                String semester = v.getString("Semester: ");
                String uni = v.getString("Unversity name: ");
                c = new Intern(id, firstName, lastName, address, phone, email, brithDate,major, semester, uni);

            }
            manager.addCandidate(c);
            System.out.println("Create suceess!");
        } while (v.getYesNo("Do you want to continue (Y/N)? "));
        displayAll(); // Chon N: quay ve menu va in toan bo
    }

    private void displayAll() {
        System.out.println("List of candidate:");
        for (Candidate c : manager.getAll()) {
            System.out.println(c.toString());
        }
    }

    private void search() {
        System.out.println("List of candidate:");
        displayByType();
        String name = v.getString("Input Candidate name(First name or last name): ");
        int type = v.getInt("Input type of candidate: ", 0, 2);
        List<Candidate> rs = manager.search(name, type);
        if(rs.isEmpty()){
            System.out.println("Not found!");
            return;
        }
        System.out.println("The candidates found:");
        for(Candidate c : rs){
            System.out.println(c);
        }
    }

    private void displayByType() {
        String[] titles = {
            "=================EXPERIENCE CANDIDATE====================",
            "=================FRESHER CANDIDATE=======================",
            "=================INTERN CANDIDATE========================"
        };
        for (int type = 0; type <= 2; type++) {
            System.out.println(titles[type]);
            for (Candidate c : manager.getByType(type)) {
                System.out.println(c.getFullName());
            }
        }
    }
}
