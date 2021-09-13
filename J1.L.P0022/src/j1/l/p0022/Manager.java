/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.l.p0022;

import java.util.ArrayList;
import validation.CheckValid;

/**
 *
 * @author asus
 */
public class Manager {

    ArrayList<Experience> ec = new ArrayList<>();
    ArrayList<Intern> ic = new ArrayList<>();
    ArrayList<Fresher> fc = new ArrayList<>();

    CheckValid check = new CheckValid();

    public void menu() {
        System.out.println("=================");
        System.out.println("1- Experience    ");
        System.out.println("2- Fresher       ");
        System.out.println("3- Internship    ");
        System.out.println("4- Searching     ");
        System.out.println("5- Exit          ");
        System.out.println("=================");
        System.out.print("Enter your choice: ");
    }

    public boolean checkIDExisted(String idCheck) {
        for (Experience experience : ec) {
            if (idCheck.equalsIgnoreCase(experience.getCandidateId())) {
                return true;
            }
        }
        for (Fresher fresher : fc) {
            if (idCheck.equalsIgnoreCase(fresher.getCandidateId())) {
                return true;
            }
        }
        for (Intern internship : ic) {
            if (idCheck.equalsIgnoreCase(internship.getCandidateId())) {
                return true;
            }
        }
        return false;
    }

    public void createCandidate(int type) {
        boolean valid = false;
        String candidateID = null;

        do {
            System.out.println("Enter candidate ID:");
            candidateID = check.checkInputString();

            if (checkIDExisted(candidateID)) {
                System.err.println("Id has exist student. Pleas re-input.");
                valid = true;
            } else {
                valid = false;
            }
        } while (valid == true);

        System.out.println("Enter first name: ");
        String firstName = check.checkInputString();
        System.out.println("Enter last name: ");
        String lastName = check.checkInputString();
        System.out.println("Enter birth date: ");
        int birthDate = check.checkInputNumber(1900, 2020);
        System.out.println("Enter address: ");
        String address = check.checkInputString();
        System.out.println("Enter phone number: ");
        String phoneNumber = check.checkInputPhone();
        System.out.println("Enter email: ");
        String email = check.checkInputEmail();

        Candidate candidates = new Candidate(candidateID, firstName, lastName, birthDate, address, phoneNumber, email, type);
        switch (type) {
            case 0:
                createExperience(candidates);
                break;
            case 1:
                createFresher(candidates);
                break;
            case 2:
                createInternShip(candidates);
                break;
        }

    }

    public void createExperience(Candidate c) {
        String proSkill = null;
        System.out.print("Enter year of experience: ");
        int yearExperience = check.checkInputNumber(0, 100);
        System.out.println("1. Junior");
        System.out.println("2. Senior");
        System.out.println("3. Master");
        System.out.print("Enter professional skill: ");
        int choice = check.checkInputNumber(1, 3);
        switch (choice) {
            case 1:
                proSkill = "Junior";
                break;
            case 2:
                proSkill = "Senior";
                break;
            case 3:
                proSkill = "Master";
                break;
        }

        ec.add(new Experience(yearExperience, proSkill, c.getCandidateId(), c.getFirstName(), c.getLastName(), c.getBirthDate(),
                c.getAddress(), c.getPhone(), c.getEmail(), c.getCandidateType()));
    }

    public void createFresher(Candidate c) {
        System.out.print("Enter graduation date(dd//mm//yy): ");
        String graduationDate = check.checkDate();
        System.out.println("1. Excellence");
        System.out.println("2. Good");
        System.out.println("3. Fair");
        System.out.println("4. Foor");
        System.out.print("Enter graduation rank: ");
        int graduationRank = check.checkInputNumber(1, 4);
        System.out.println("Enter education");
        String education = check.checkInputString();

        fc.add(new Fresher(graduationDate, graduationRank, education, c.getCandidateId(), c.getFirstName(), c.getLastName(),
                c.getBirthDate(), c.getAddress(), c.getPhone(), c.getEmail(), c.getCandidateType()));
    }

    public void createInternShip(Candidate c) {
        System.out.print("Enter major: ");
        String major = check.checkInputString();
        System.out.print("Enter semester: ");
        String semester = check.checkInputString();
        System.out.print("Enter university: ");
        String university = check.checkInputString();

        ic.add(new Intern(major, semester, university, c.getCandidateId(), c.getFirstName(), c.getLastName(),
                c.getBirthDate(), c.getAddress(), c.getPhone(), c.getEmail(), c.getCandidateType()));
    }

    public void showList() {
        System.out.println("====EXPERIENCE CANDIDATE====");
        for (int i = 0; i < ec.size(); i++) {
            System.out.println(ec.get(i).getFirstName() + " " + ec.get(i).getLastName());
        }
        System.out.println("====FRESHER CANDIDATE====");
        for (int i = 0; i < fc.size(); i++) {
            System.out.println(fc.get(i).getFirstName() + " " + fc.get(i).getLastName());
        }
        System.out.println("====INTERN CANDIDATE====");
        for (int i = 0; i < ic.size(); i++) {
            System.out.println(ic.get(i).getFirstName() + " " + ic.get(i).getLastName());
        }
    }

    public void searchCandidate() {

        System.out.println("Enter name for search :");
        String searchName = check.checkInputString();
        System.out.println("Enter type of candidate(0,2) :");
        int type = check.checkInputNumber(0, 2);

        switch (type) {
            case 0:
                for (int i = 0; i < ec.size(); i++) {
                    String fullName = ec.get(i).getFirstName() + " " + ec.get(i).getLastName();
                    if (fullName.toLowerCase().contains(searchName.toLowerCase())) {
                        System.out.println(ec.get(i).toString());
                    }
                }
                break;
            case 1:
                for (int i = 0; i < fc.size(); i++) {
                    String fullName = fc.get(i).getFirstName() + " " + fc.get(i).getLastName();
                    if (fullName.toLowerCase().contains(searchName.toLowerCase())) {
                        System.out.println(fc.get(i).toString());
                    }
                }
                break;
            case 2:
                for (int i = 0; i < ic.size(); i++) {
                    String fullName = ic.get(i).getFirstName() + " " + ic.get(i).getLastName();
                    if (fullName.toLowerCase().contains(searchName.toLowerCase())) {
                        System.out.println(ic.get(i).toString());
                    }
                }
                break;
        }
    }
}
