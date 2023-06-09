public class MyArrayDataException extends Exception{
    private int number;
    private int number2;

    public MyArrayDataException(int number, int number2) {
        this.number = number;
        this.number2 = number2;
    }

    public void getMessages(){
        System.out.printf("В ячейке [%d, %d] лежит не число\n", number, number2);
    }
}
