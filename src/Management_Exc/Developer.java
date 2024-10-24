package Management_Exc;

public class Developer extends Employee {
    private Manager projectManager;

    public Developer(String name, int age, double salary) {
        super(name, age, salary);
        projectManager = null;
    }

    public Manager getProjectManager() {
        return projectManager;
    }

    /**
     * Sets the project manager for this developer.
     *
     * @param projectManager the manager to be assigned
     * @throws IllegalStateException if the developer already has a manager
     */
    protected void setProjectManager(Manager projectManager) throws IllegalStateException {
        if (this.projectManager != null) {
            throw new IllegalStateException(getName() + " already has a manager: "
                    + this.projectManager.getName());
        }
        this.projectManager = projectManager;
    }

    /**
     * Removes the current project manager.
     */
    public void removePM() {
        projectManager = null;
    }

    /**
     * On the developer's birthday, if a project manager exists, give the developer a 5% raise.
     */
    @Override
    public void birthday() {
        super.birthday(); // Call Employee's birthday to handle age increment
        if (projectManager != null) {
            double raise = this.getSalary() * 0.05;
            projectManager.giveRaise(this, raise);
        }
    }

    @Override
    public void performTask() {
        System.out.println(getName() + " is coding");
    }

    @Override
    public String toString() {
        if (projectManager != null) {
            return super.toString() + " [" + projectManager.getName() + "]";
        }
        return super.toString();
    }
}