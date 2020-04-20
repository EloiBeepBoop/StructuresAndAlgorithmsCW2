package Step1;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;



public class Company {

    //setup variables of a company
    private String name;
    private LinkedList<Project> projects = new LinkedList<>();

    //instantiate company with a name string passed parameter
    public Company(String name) {
        this.name = name;
    }
    
    //function that allows the User to add a project, it will check if project already exists before adding it
    public void addProject() {
        Project p = new Project();
        p.input();
        Project temp = findProjectByTitle(p.getTitle());
        if(temp!=null){
            System.out.println("Project Already Exist");           
        }
        else {
        	this.projects.add(p);
        	System.out.println("Project added successfully");
        }
    }
    
    //function that allows the User to delete a project that exists, it will not remove a project that doesn't exist
    public void removeProject(){
        Scanner scanner = new Scanner(System.in);
        Project p = findProjectByTitle(scanner.nextLine());
        if(p==null)
        {
            System.out.println("Cannot delete a Project that doesn't Exist");
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
        }else {
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
    
    //function that allows the User to display all existing projects 
    public void displayAllProjects() {
        System.out.println("Project Title");
        Collections.sort(projects);
        for (Project p : projects) System.out.println(p.toString());
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

    public void setProjects(LinkedList<Project> projects) {
        this.projects = projects;
    }
}

