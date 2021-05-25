import jdk.swing.interop.SwingInterOpUtils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;

public class App {
    Scanner sc = new Scanner(System.in);
    StaffManager manager = new StaffManager();
    SecretSantaAssigner assigner = new SecretSantaAssigner();

    private void start() {
        System.out.println("Please choose your action:\n1. Add Staff Member\n2. Update Staff Information\n3. Assign Secret Santa\n4. Exit\n5. Add saved staff members\n6. save staff members");
        String action = sc.nextLine();
        switch (action) {
            case "1" -> addStaffMember();
            case "2" -> updateStaffInformation();
            case "3" -> assignSecretSanta();
            case "4" -> System.out.println("Thank you for using Secret Santa Assigner!");
            case "5" -> addSavedStaffMembers();
            case "6" -> saveStaffMembers();
            default -> {
                System.out.println("Invalid input!");
                start();
            }
        }
    }

    private void assignSecretSanta() {
        List<StaffMember> staffMembers = manager.getStaffList();
        if (staffMembers.size() < 2) {
            System.out.println("You need to add more staff members!");
            start();
        } else {
            assigner.assignSecretSanta(staffMembers);
            for (StaffMember staffMember : staffMembers) {
                System.out.println(staffMember.generateResult());
            }
        }
    }

    private void updateStaffInformation() {
        System.out.print("Please enter the ID of the staff member: ");
        String staffId = sc.nextLine();
        if (manager.hasStaffMember(staffId)) {
            System.out.println("Please enter the content you want to update:\n1. Name\n2. Email");
            String contentToUpdate = sc.nextLine();
            switch (contentToUpdate) {
                case "1" -> updateStaffName(staffId);
                case "2" -> updateStaffEmail(staffId);
                default -> System.out.println("Invalid content!");
            }
        } else {
            System.out.println("Invalid staff member!");
        }
        start();
    }

    private void updateStaffName(String staffId) {
        System.out.print("Please enter new name: ");
        String newName = sc.nextLine();
        manager.updateStaffName(staffId, newName);
        System.out.println("Name updated successfully for " + newName);
    }

    private void updateStaffEmail(String staffId) {
        System.out.print("Please enter new email: ");
        String newEmail = sc.nextLine();
        manager.updateStaffEmail(staffId, newEmail);
        System.out.println("Email updated successfully for " + manager.getStaffMember(staffId).getName());
    }

    private void addStaffMember() {
        String id = getUserInput("id");
        String name = getUserInput("name");
        String email = getUserInput("email");
        manager.addStaffMember(new StaffMember(id, name, email));
        System.out.println("Staff member " + name + " has been added successfully!");
        start();
    }

    private String getUserInput(String content) {
        System.out.print("Please enter the staff member's " + content + ": ");
        return sc.nextLine();
    }

    private void saveStaffMembers() {
        File staffList = new File("staff.txt");
        try (PrintWriter writer = new PrintWriter(new FileWriter(staffList))) {
            for (StaffMember member : manager.getStaffList()) {
                writer.println(member.getId() + "," + member.getName() + "," + member.getEmail());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void addSavedStaffMembers() {
        File staffList = new File("staff.txt");
        try (Scanner sc = new Scanner(staffList)) {
            while (sc.hasNextLine()) {
                System.out.println("Member: " + sc.nextLine());
                String[] userInfo = sc.nextLine().split(",");
                manager.addStaffMember(new StaffMember(userInfo[0], userInfo[1], userInfo[2]));
            }
        } catch (IOException e) {
            System.out.println("You have not saved any staff members!");
        }
    }

    public static void main(String[] args) {
        new App().start();
    }
}
