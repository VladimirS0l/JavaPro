package employee;

public class EmployeeSalaryFix extends BaseEmployee {

    private String name;
    private int salary;

    public EmployeeSalaryFix(String name, int salary) {
        this.salary = salary;
        this.name = name;
    }

    @Override
    public int salaryCalculation() {
//        System.out.println("Salary fix = " + salary);
        return salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "EmployeeSalaryFix{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }

    @Override
    public int compareTo(BaseEmployee o) {
        return this.name.compareTo(o.getName());
    }
}
