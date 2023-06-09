public class App {
    public static void main(String[] args) {
//        String[][] array = {
//                {"1", "3", "4", "7"},
//                {"10", "4", "2", "8"},
//                {"13", "5", "23", "65"},
//                {"41", "A", "23", "45"},
//        };
        String[][] array = {
                {"1", "3", "4", "7", "4"},
                {"10", "4", "2", "8", "4"},
                {"13", "5", "23", "65", "4"},
                {"41", "A", "23", "45", "4"},
        };
        System.out.println(createArray(array));
    }

    public static int createArray(String[][] array){
        int res = 0;
        try{
            if (array.length != 4 || array[0].length != 4){
                throw new MyArraySizeException();
            }

            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array.length; j++) {
                    if (array[i][j].matches("\\D")){
                        throw new MyArrayDataException(i , j);
                    }else {
                        res += Integer.parseInt(array[i][j]);
                    }
                }
            }
        }catch (MyArraySizeException ex){
            ex.getMessages();
        }catch (MyArrayDataException ex){
            ex.getMessages();
        }
        return res;
    }
}
