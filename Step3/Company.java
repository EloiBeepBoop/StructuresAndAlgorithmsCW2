package Step3;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class Company {

    //setup variables of a company
    private String name;
    private Queue<Project> projects = new LinkedList<>();
    public TeamMemberList teamMemberList = new TeamMemberList();

    //instantiate company with a name string passed parameter
    public Company(String name) {
        this.name = name;
    }
    
    //function that allows the User to add a project, it will check if project already exists before adding it
    public void addProject() {
        Project p = new Project();
        p.input();
        Project temp = findProjectByTitle(p.getTitle());
        if (temp != null) {
            System.out.println("Project Already Exist");
        } else {
            this.projects.add(p);
            System.out.println("Project added successfully");
        }
    }

    //function that allows the User to delete a project that exists, it will not remove a project that doesn't exist
    public void removeProject() {
        Scanner scanner = new Scanner(System.in);
        Project p = findProjectByTitle(scanner.nextLine());
        if (p == null) {
            System.out.println("The Project don't Exist");
            return;
        }
        removeProject(p);
    }

    public boolean removeProject(Project p) {
        if (this.projects.remove(p)) {
            System.out.println(p.getTitle() + " removed successfully");
            return true;
        } else {
            System.out.println(p.getTitle() + " not found");
            return false;
        }
    }
    
    //function that allows the User to search and display a specific project
    public void findAndDisplayByTitle(String s) {
        Project p = findProjectByTitle(s);
        if (p != null) {
        System.out.println("TITLE\n" + p.toString());
        }else{
        	System.out.println("Project " + s + " not found");
        }
    }

    public Project findProjectByTitle(String s) {
        for (Project p : projects) {
            if (p.getTitle().toLowerCase().equals(s.toLowerCase())) return p;
        }
        return null;
    }

    public void displayProject(String title) {
        System.out.println(findProjectByTitle(title));
    }

    public void displayProject(Project p) {
        System.out.println(p.toString());
    }
    
    //function that allows the User to display all existing projects and team members of projects if desired
    public void displayAllProjects() {
        System.out.println("Project Title");
        Arrays.sort(projects.toArray());
        boolean x = false;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Do you wish to View Team Members (Y/N) : ");
        if (scanner.nextLine().equalsIgnoreCase("Y")) {
            x = true;
        }
        for (Project p : projects) {
            System.out.println(p.toString());
            if (x)
                p.printTeamMembers();
        }
    }

    //getters
    public String getName() {
        return name;
    }

    //setters
    public void setName(String name) {
        this.name = name;
    }

    public Queue<Project> getProjects() {
        return projects;
    }

    public void setProjects(Queue<Project> projects) {
        this.projects = projects;
    }
    
    //function that allows the User to allocate an existing team member to an existing project
    void allocateTeamMemberToProject() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Project Title : ");
        Project project = findProjectByTitle(scanner.nextLine());
        if (project == null) {
            System.out.println("Project Don't Exist");
            return;
        }
        System.out.println("Enter Team Member id Title : ");
        TeamMember teamMember = teamMemberList.findMember(scanner.nextLine());
        if (teamMember == null) {
            System.out.println("Team Member Don't Exist");
            return;
        }
        project.addTeamMember(teamMember);
    }
    
  //function that allows the User to remove an existing team member from a project
    public void removeTeamMemberToProject() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Project Title : ");
        Project project = findProjectByTitle(scanner.nextLine());
        if (project == null) {
            System.out.println("Project Don't Exist");
            return;
        }
        System.out.println("Enter Team Member id Title : ");
        TeamMember teamMember = teamMemberList.findMember(scanner.nextLine());
        if (teamMember == null) {
            System.out.println("Team Member Don't Exist");
            return;
        }
        project.removeTeamMember(teamMember);
    }
}
