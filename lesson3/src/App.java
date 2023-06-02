import employee.BaseEmployee;
import employee.EmployeeSalaryFix;
import employee.EmployeeSalaryForHour;
import employee.ListEmployee;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {

        ListEmployee le = new ListEmployee();
        for (BaseEmployee be:
             le) {
            System.out.println(be);
        }
        System.out.println();

        le.sortByName();
        for (BaseEmployee be:
                le) {
            System.out.println(be.getName());
        }
        System.out.println();
        le.sortByMaxSalary();
        for (BaseEmployee be:
                le) {
            System.out.println(be.getName() + " final salary: " + be.salaryCalculation());
        }

        /**
         * Первая часть ДЗ без звездочек
         */

//        BaseEmployee baseEmployee = new EmployeeSalaryFix("Test1", 15000);
//        BaseEmployee baseEmployee2 = new EmployeeSalaryFix("Test2",16500);
//        BaseEmployee baseEmployee5 = new EmployeeSalaryFix("Test3",17000);
//        BaseEmployee baseEmployee3 = new EmployeeSalaryForHour("Test4",135);
//        BaseEmployee baseEmployee4 = new EmployeeSalaryForHour("Test5",148);
//        BaseEmployee baseEmployee1 = new EmployeeSalaryForHour("Test6",120);
//        List<BaseEmployee> baseEmployees = new ArrayList<>();
//        baseEmployees.add(baseEmployee);
//        baseEmployees.add(baseEmployee1);
//        baseEmployees.add(baseEmployee2);
//        baseEmployees.add(baseEmployee3);
//        baseEmployees.add(baseEmployee4);
//        baseEmployees.add(baseEmployee5);
//
//        for (BaseEmployee be:
//             baseEmployees) {
//            System.out.println(be);
//            be.salaryCalculation();
//            System.out.println();
//
//        }

    }
}
