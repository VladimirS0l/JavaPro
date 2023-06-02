package employee;

import java.util.Comparator;

public class ComporatorByMaxSalary implements Comparator<BaseEmployee> {
    @Override
    public int compare(BaseEmployee o1, BaseEmployee o2) {
        return Integer.compare(o1.salaryCalculation(), o2.salaryCalculation());
    }
}
