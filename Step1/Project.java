package Step1;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Project implements Comparable<Project> {

    //setup variables of a project
    private String title;
    private Date startingDate, endingDate;


    //instantiate project with a name string passed parameter
    public Project(String title, Date startingDate, Date endingDate) {
        this.title = title;
        this.startingDate = startingDate;
        this.endingDate = endingDate;
    }

    public Project(String title) {
        this.title = title;
    }
	public Project(){

	}

    //getters
    public String getTitle() {
        return title;
    }

    //setters
    public void setTitle(String title) {
        this.title = title;
    }
    
    //function that checks User Input for Date
    public void input() {
		boolean correct = false;
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the title : ");
		this.title = scanner.nextLine();
		while (!correct) {
			try {

				System.out.print("Enter Start Date : (dd/MM/yyyy) ");
				startingDate = new SimpleDateFormat("dd/MM/yyyy").parse(scanner.nextLine());
				System.out.print("Enter End Date : (dd/MM/yyyy) ");
				endingDate = new SimpleDateFormat("dd/MM/yyyy").parse(scanner.nextLine());
				correct = true;
			} catch (Exception e) {
				System.out.println(e.getMessage());
				correct = false;
			}
		}
	}
        @Override
        public String toString () {
            return "Project{" +
                    "Title = '" + title + '\'' +
                    ", StartingDate = " + startingDate +
                    ", EndingDate = " + endingDate +
                    '}';
        }

        @Override
        public int compareTo (Project project) {
			return this.title.compareTo(project.title);
		}
    }


