package Step2;

import java.util.Scanner;

public class TeamMember {
    private String name;
    private String employeeNumber;
    private String division;

    void input(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Name : ");
        name = scanner.nextLine();
        System.out.print("Enter Employee Number : ");
        employeeNumber = scanner.nextLine();
        System.out.print("Enter Division : ");
        division = scanner.nextLine();
    }
    //getters
    public String getName() {
        return name;
    }
    //setters
    public void setName(String name) {
        this.name = name;
    }

    public String getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(String employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    @Override
    public String toString() {
        return "TeamMember{" +
                "Name = '" + name + '\'' +
                ", EmployeeNumber = '" + employeeNumber + '\'' +
                ", Division = '" + division + '\'' +
                '}';
    }
}
