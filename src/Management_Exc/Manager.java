package Management_Exc;

public class Manager extends Employee {

    public Manager(String name, int age, double salary) {
        super(name, age, salary);
    }

    /**
     * Gives a raise to the given employee. If the employee is not the manager,
     * half of the raise is added to the manager's own salary.
     *
     * @param e     the employee to be given the raise
     * @param raise the raise amount
     * @throws IllegalArgumentException if the raise is negative
     */
    public void giveRaise(Employee e, double raise) {
        if (raise < 0) {
            throw new IllegalArgumentException("Raise must be non-negative");
        }

        // Use the setter to update the employee's salary
        e.setSalary(e.getSalary() + raise);

        // If the employee is not the manager, the manager gets half the raise
        if (e != this) {
            this.setSalary(this.getSalary() + raise / 2);
        }
    }

    @Override
    public String toString() {
        return "Mgr. " + super.toString();
    }
}