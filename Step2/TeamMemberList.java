package Step2;

import java.util.HashSet;
import java.util.Scanner;

public class TeamMemberList {
    HashSet<TeamMember> teamMembers = new HashSet<>();

    //function that allows the User to add a Team Member, it will check if the same Team Member already exists before adding another
    void addMember() {
        TeamMember teamMember = new TeamMember();
        teamMember.input();
        boolean exist = false;
        for (TeamMember t : teamMembers) {
            if (t.getEmployeeNumber().equalsIgnoreCase( teamMember.getEmployeeNumber())) {
                exist = true;
                break;
            }
        }
        if (exist) {
            System.out.println("Team Member Already Exist");
        } else {
            teamMembers.add(teamMember);
        }
    }
    
    //function that allows the User to delete a team member that exists, it will not remove a team member that doesn't exist
    void removeMember() {
        Scanner scanner = new Scanner(System.in);
        String e = scanner.nextLine();
        TeamMember rt = null;
        for (TeamMember teamMember : teamMembers) {
            if (teamMember.getEmployeeNumber().equalsIgnoreCase(e)) {
                rt = teamMember;
            }
        }
        if (rt == null) {
            System.out.println("No TeamMember exist");
        } else {
            teamMembers.remove(rt);
            System.out.println("Team member removed");
        }
    }
    
    //function that allows the User to display all existing team members 
    void displayAll() {
        if(teamMembers.size()==0)
            System.out.println("There Are not ant Team Members");
        for (TeamMember teamMember : teamMembers) {
            System.out.println(teamMember);
        }
    }
    //function that allows the User to search and display a specific team member
    void findAndDisplay() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the Employee id : ");
        TeamMember teamMember = findMember(scanner.nextLine());
        if (teamMember == null) {
            System.out.println("Team Member Don't Exits");
        } else {
            System.out.println(teamMember);
        }
    }

    TeamMember findMember(String eid) {
        TeamMember t = null;
        for (TeamMember teamMember : teamMembers) {
            if (teamMember.getEmployeeNumber().equalsIgnoreCase(eid))
                t = teamMember;
        }
        return t;
    }
}

