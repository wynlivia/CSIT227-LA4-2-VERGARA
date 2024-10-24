package Management_Exc;

public class Employee extends Person {
    private double salary;

    /**
     * Constructs an Employee with the given name, age, and salary.
     *
     * @param name   the name of the employee
     * @param age    the age of the employee
     * @param salary the salary of the employee
     * @throws IllegalArgumentException if the salary is less than 30,000
     */
    public Employee(String name, int age, double salary) {
        super(name, age);
        if (salary < 30000) {
            throw new IllegalArgumentException("Salary must be greater than or equal to 30000");
        }
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    protected void setSalary(double salary) {
        if (salary < 30000) {
            throw new IllegalArgumentException("Salary must be greater than or equal to 30000");
        }
        this.salary = salary;
    }

    @Override
    public String toString() {
        return super.toString() + " - " + salary;
    }

    @Override
    public void performTask() {
        System.out.println(getName() + " is working");
    }
}