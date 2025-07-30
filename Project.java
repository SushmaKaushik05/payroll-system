 import java.util.*;
 abstract class Employee{

    private String name;
    private int id;

    public Employee(String name, int id){
        this.name = name;
        this.id = id;
    }
    public String getName(){
        return name;
    }
    public int getId(){
        return id;
    }
    public abstract double calculateSalary();

    //override
    public String toString(){
        return "Employee[name = "+name+", id = "+id+" , salary="+calculateSalary()+"]";
    }
 }
 class FulltimeEmployee extends Employee{
    private double monthlySalary;
    public FulltimeEmployee(String name, int id, double monthlySalary){
        super(name,id);
        this.monthlySalary = monthlySalary;
    }
    //Override

    public double calculateSalary(){
        return monthlySalary;
    }
 }
 class PartTimeEmployee extends Employee{
    private int hoursWorked;
    private double hoursRate;
    public PartTimeEmployee(String name, int id,  int hoursWorked, double hoursRate){
        super(name,id);
        this.hoursWorked = hoursWorked;
        this.hoursRate = hoursRate;
    }
    //override
    public double calculateSalary(){
        return hoursWorked * hoursRate;
    }
 }
 class PayrollSystem{
    private ArrayList<Employee>employeeList;
    public PayrollSystem(){
        employeeList = new ArrayList<>();
    }
    public void addEmployee(Employee employee){
        employeeList.add(employee);
    }
    public void removeEmployee(int id){
        Employee employeeToremove =null;
        for(Employee employee : employeeList){
            if(employee.getId() == id){
                employeeToremove = employee;
                break;
            }
        }
        if(employeeToremove != null){
            employeeList.remove(employeeToremove);
        }
    }
    public void displayEmployee(){
        for(Employee employee: employeeList){
            System.out.println(employee);
        }
    }
 }

public class Project{
    public static void main(String[] args){
        PayrollSystem payrollSystem = new PayrollSystem();
        FulltimeEmployee emp1 = new FulltimeEmployee("Shivam", 1, 100000);
        PartTimeEmployee emp2 = new PartTimeEmployee("Sushma", 2, 40, 1000);

        payrollSystem.addEmployee(emp1);
        payrollSystem.addEmployee(emp2);
        System.out.println("Initail Employee details:");
        payrollSystem.displayEmployee();
        System.out.println("Removing employees");
        payrollSystem.removeEmployee(2);
        System.out.println("Remaining Employee Deatails: ");
        payrollSystem.displayEmployee();
    }
}