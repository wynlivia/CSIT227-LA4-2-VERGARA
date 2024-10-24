package Management_Exc;

import java.util.List;
import java.util.NoSuchElementException;

public class Main {

    /**
     * Gives a raise from the manager to the employee.
     *
     * @param persons  the list of persons
     * @param manager  the manager giving the raise
     * @param employee the employee receiving the raise
     * @param salary   the salary increase to be given
     * @throws ClassCastException      if manager or employee is not of the correct type
     * @throws IllegalArgumentException if the salary increase is invalid
     * @throws NoSuchElementException  if manager or employee is not found in the list
     */
    public static void giveRaise(List<Person> persons, String manager, String employee, double salary) {
        Manager mgr = findPersonAsType(persons, manager, Manager.class);
        Employee emp = findPersonAsType(persons, employee, Employee.class);

        if (salary < 0) {
            throw new IllegalArgumentException("Raise must be non-negative");
        }

        mgr.giveRaise(emp, salary);
    }

    /**
     * Assigns a project manager to a developer.
     *
     * @param persons  the list of persons
     * @param developer the developer to be assigned a manager
     * @param manager  the manager to assign to the developer
     * @throws ClassCastException      if manager or developer is not of the correct type
     * @throws NoSuchElementException  if manager or developer is not found in the list
     * @throws IllegalStateException   if the developer already has a manager
     */
    public static void assignPM(List<Person> persons, String developer, String manager) {
        Developer dev = findPersonAsType(persons, developer, Developer.class);
        Manager mgr = findPersonAsType(persons, manager, Manager.class);

        dev.setProjectManager(mgr);
    }

    /**
     * Facilitates a conversation between a customer and an employee.
     *
     * @param persons  the list of persons
     * @param customer the customer speaking
     * @param employee the employee being spoken to
     * @return the dialogue from the customer to the employee
     * @throws IllegalArgumentException if the customer or employee is of the wrong type
     * @throws NoSuchElementException  if customer or employee is not found in the list
     */
    public static String customerSpeak(List<Person> persons, String customer, String employee) {
        Customer cust = findPersonAsType(persons, customer, Customer.class);
        Employee emp = findPersonAsType(persons, employee, Employee.class);

        return cust.getName() + " speaks to " + emp.getName();
    }

    /**
     * Helper method to find a person by name and cast them to the desired type.
     *
     * @param persons the list of persons
     * @param name    the name of the person to find
     * @param type    the expected class type of the person
     * @param <T>     the generic type
     * @return the person cast to the desired type
     * @throws ClassCastException     if the person is not of the desired type
     * @throws NoSuchElementException if the person is not found
     */
    private static <T> T findPersonAsType(List<Person> persons, String name, Class<T> type) {
        Person person = persons.stream()
                .filter(p -> p.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException(name + " does not exist"));

        if (!type.isInstance(person)) {
            throw new ClassCastException(name + " is not a " + type.getSimpleName());
        }

        return type.cast(person);
    }
}
