package folder.Oops.association;

import java.util.HashSet;
import java.util.Set;

public class AssociationMain {
    public static void main(String[] args) {
        Bank bank = new Bank("ICICI");
        Set<Employees> employeesHashSet = new HashSet<>();
        Employees employees = new Employees("Sid");
        employeesHashSet.add(employees);
        bank.setEmployees(employeesHashSet);
        System.out.println(employees.getName() + " belongs to " + bank.getName());
    }
}
