package Step1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class CompanyTest {

    private static Company company = new Company("First Company");

    public static void main(String[] args) throws Exception {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int exitMenu = 0;
        while (exitMenu == 0) {

            try {
                System.out.println("Welcome to our Application");
                System.out.println("1) Add new project to system");
                System.out.println("2) Find and Display specific project");
                System.out.println("3) Remove specific project");
                System.out.println("4) Display ALL projects");
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
                        company.findAndDisplayByTitle(getUserInputAsString("Input title of new project"));

                        break;
                    case 3:
                        System.out.println("Removing an specific project");
                        company.removeProject();

                        break;
                    case 4:
                        System.out.println("Displaying ALL projects");
                        company.displayAllProjects();
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
    
    //function to get Users Input as string and return it
    private static String getUserInputAsString(String prompt) {
        return new Scanner(System.in).nextLine();
    }


}


