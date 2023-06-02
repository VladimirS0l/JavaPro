package employee;

public class EmployeeSalaryForHour extends BaseEmployee{

    private String name;
    private int salary;

    public EmployeeSalaryForHour(String name, int salary) {
        this.salary = salary;
        this.name = name;
    }

    @Override
    public int salaryCalculation() {
        double salaryB = 20.8 * 8 * salary;
//        System.out.println("Salary employee for hour = " + salaryB);
        return (int) salaryB;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "EmployeeSalaryForHour{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }

    @Override
    public int compareTo(BaseEmployee o) {
        return this.name.compareTo(o.getName());
    }
}
