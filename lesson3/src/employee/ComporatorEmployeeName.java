package employee;

import java.util.*;

public class ComporatorEmployeeName implements Comparator<BaseEmployee> {

    @Override
    public int compare(BaseEmployee o1, BaseEmployee o2) {
        int one = o1.salaryCalculation();
        int two = o2.salaryCalculation();
        return o1.getName().compareTo(o2.getName());

    }
}
