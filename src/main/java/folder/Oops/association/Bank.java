package folder.Oops.association;

import java.util.Set;

public class Bank {
    private String name;
    private Set<Employees> employees;

    public Bank(String name){
        this.name= name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Employees> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employees> employees) {
        this.employees = employees;
    }
}
