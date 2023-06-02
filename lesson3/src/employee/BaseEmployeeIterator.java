package employee;

import java.util.Iterator;
import java.util.List;

public class BaseEmployeeIterator implements Iterator {

    private List<BaseEmployee> listEmployee;
    private int index = 0;

    public BaseEmployeeIterator(List<BaseEmployee> listEmployee) {
        this.listEmployee = listEmployee;
    }

    @Override
    public boolean hasNext() {
        return index < listEmployee.size();
    }

    @Override
    public Object next() {
        return listEmployee.get(index++);
    }
}
