package employee;

public abstract class BaseEmployee implements Comparable<BaseEmployee>{
    private String name;

    private int hourBid;

    public String getName() {
        return name;
    }

    public abstract int salaryCalculation();

}


