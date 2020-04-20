package Step2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TeamMemberTest {

    public static void main(String[] args) {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int exitMenu = 0;
        TeamMemberList memberList = new TeamMemberList();
        while (exitMenu == 0) {

            try {
                System.out.println("Welcome to our Application");
                System.out.println("1) Add new TeamMember to system");
                System.out.println("2) Find and Display specific TeamMember");
                System.out.println("3) Remove specific Team Member");
                System.out.println("4) Display ALL Team Member");
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
                        System.out.println("Adding new Team Member");
                        memberList.addMember();
                        break;
                    case 2:
                        System.out.println("Searching a Team Member");
                        memberList.findAndDisplay();
                        break;
                    case 3:
                        System.out.println("Removing an specific Team Member");
                        memberList.removeMember();
                        break;
                    case 4:
                        System.out.println("Displaying ALL Team Member");
                        memberList.displayAll();
                        break;
                    default:
                        System.out.println("Please enter a Valid Menu Option!");
                        break;
                } //end switch
            } catch (NumberFormatException ex) {
                System.err.println("Please enter a Valid Menu Option!");
            } catch (IOException e) {
                System.out.println("Failed to get input");
            }
        } //end while
    }
}
