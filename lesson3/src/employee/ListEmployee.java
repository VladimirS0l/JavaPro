package employee;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ListEmployee implements Iterable<BaseEmployee>{
    private List<BaseEmployee> listEmployee;

    public ListEmployee() {
        listEmployee = new ArrayList<>();
        BaseEmployee baseEmployee = new EmployeeSalaryFix("Vasya", 15000);
        BaseEmployee baseEmployee1 = new EmployeeSalaryFix("Petr",16500);
        BaseEmployee baseEmployee2 = new EmployeeSalaryFix("Danila",17000);
        BaseEmployee baseEmployee3 = new EmployeeSalaryForHour("Vladimir",135);
        BaseEmployee baseEmployee4 = new EmployeeSalaryForHour("Sergey",148);
        BaseEmployee baseEmployee5 = new EmployeeSalaryForHour("Sveta",120);

        listEmployee.add(baseEmployee);
        listEmployee.add(baseEmployee1);
        listEmployee.add(baseEmployee2);
        listEmployee.add(baseEmployee3);
        listEmployee.add(baseEmployee4);
        listEmployee.add(baseEmployee5);
    }


    public List<BaseEmployee> getListEmployee() {
        return listEmployee;
    }

    public void setListEmployee(List<BaseEmployee> listEmployee) {
        this.listEmployee = listEmployee;
    }

    @Override
    public Iterator<BaseEmployee> iterator() {
        return new BaseEmployeeIterator(listEmployee);
    }

    public void sortByName(){
        Collections.sort(listEmployee, new ComporatorEmployeeName());
    }

    public void sortByMaxSalary(){
        Collections.sort(listEmployee, new ComporatorByMaxSalary());
    }
}
