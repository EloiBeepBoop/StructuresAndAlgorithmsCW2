package Step3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
        Company company = new Company("THE COMPANY");
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int exitMenu = 0;
        while (exitMenu == 0) {

            try {
                System.out.println("Welcome to our Application");
                System.out.println("1)  Add new project to system");
                System.out.println("2)  Find and Display specific project");
                System.out.println("3)  Remove specific project");
                System.out.println("4)  Display ALL projects");
                System.out.println("5)  Add new Team Member to system");
                System.out.println("6)  Find and Display specific Team Member");
                System.out.println("7)  Remove specific Team Member");
                System.out.println("8)  Display ALL Team Member");
                System.out.println("9)  To allocate Team Member To a Project");
                System.out.println("10) To Remove Team Member from a Project");
                System.out.println("0) Quit program");

                int userChoice = Integer.parseInt(bf.readLine());
                switch (userChoice) {
                    case 0:
                        System.out.println("Are you sure you want to exit");
                        if (bf.readLine().equalsIgnoreCase("Y")) {
                            exitMenu = 1;
                            System.out.println("Closing Application, bye bye!");
                            System.exit(0);
                            return;
                        }
                        break;
                    case 1:
                        System.out.println("Adding new project");
                        company.addProject();
                        break;
                    case 2:
                        System.out.println("Searching a project");
                        company.findProjectByTitle(bf.readLine());
                        break;
                    case 3:
                        System.out.println("Removing an specific project");
                        company.removeProject();
                        break;
                    case 4:
                        System.out.println("Displaying ALL projects");
                        company.displayAllProjects();
                        break;
                    case 5:
                        System.out.println("Displaying Add Team Member");
                        company.teamMemberList.addMember();
                        break;
                    case 6:
                        System.out.println("Find and Display specific Team Member");
                        company.teamMemberList.findAndDisplay();
                        break;
                    case 7:
                        System.out.println("Removing Team member");
                        company.teamMemberList.removeMember();
                        break;
                    case 8:
                        System.out.println("Displaying all Team member");
                        company.teamMemberList.displayAll();
                        break;
                    case 9:
                        System.out.println("Allocate TeamMember to projects");
                        company.allocateTeamMemberToProject();
                        break;
                    case 10:
                        System.out.println("Remove TeamMember from projects");
                        company.removeTeamMemberToProject();
                        break;
                    default:
                        System.out.println("Please enter a Valid Menu Option!");
                        break;
                } //end switch
            } catch (IOException e) {
                System.out.println("Failed to get input");
            }
        } //end while
    }
}
