package ru.geekbrains.JC2.L2.hometask;

// 1. Напишите метод, на вход которого подается двумерный строковый массив размером 4х4,
// при подаче массива другого размера необходимо бросить исключение MyArraySizeException.
//
// 2. Далее метод должен пройтись по всем элементам массива, преобразовать в int, и просуммировать.
// Если в каком-то элементе массива преобразование не удалось (например, в ячейке лежит символ или текст вместо числа),
// должно быть брошено исключение MyArrayDataException – с детализацией, в какой именно ячейке лежат неверные данные.
//
// 3. В методе main() вызвать полученный метод, обработать возможные исключения MySizeArrayException и
// MyArrayDataException и вывести результат расчета.


import java.util.Arrays;

public class Main {
    private static final int NORMAL_LENGTH = 4;

    public static void main(String[] args) throws MyArraySizeException, MyArrayDataException {
        String inputString = "10 3 1 2\n2 3 2 2\n5 6 7 1\n300 3 1 0";
//        String inputString = "10 3 1 2\n2 3 2 2\n5 6 7 1\n300 3 1 test";

        String[][] stringArray;
        int[][] intArray;

        stringArray = parseString(inputString);
        printArray(stringArray);

        intArray = changeArray(stringArray);

        System.out.println("sum = " + countSum(intArray));
    }

    public static String[][] parseString(String inputString) throws MyArraySizeException {
        String[] subArray1 = inputString.split("\n");

        int n = subArray1.length;
        if (n != NORMAL_LENGTH) throw new MyArraySizeException("Размер матрицы не 4x4", subArray1.length);

        String[][] resultArray = new String[n][];

        for (int i = 0; i < subArray1.length; i++) {
            resultArray[i] = subArray1[i].split(" ");
        }

        return resultArray;
    }


    public static void printArray(String[][] incomeArray){
        for (int i = 0; i < incomeArray.length; i++){
//            for(int j = 0; j < incomeArray.length; j++){
//                System.out.print(incomeArray[i][j] + " ");
//            }
//            System.out.println(" ");

            System.out.println(Arrays.toString(incomeArray[i]));
        }
    }


    public static int[][] changeArray(String[][] incomeArray) throws MyArrayDataException{
        int n = incomeArray.length;
        int[][] resultArray = new int[n][n];

        for (int i = 0; i < incomeArray.length; i++){
            for(int j = 0; j < incomeArray.length; j++){
//                resultArray[i][j] = Integer.parseInt(incomeArray[i][j].trim());

//                try
//                {
//                    resultArray[i][j] = Integer.parseInt(incomeArray[i][j].trim());
//                }
//                catch (NumberFormatException nfe)
//                {
//                    System.out.println("Мы не смогли перевести строку в число!");
//                    System.out.println("В данном значении массива хранится строка: " + incomeArray[i][j]);
//                }

                try {
                    resultArray[i][j] = Integer.parseInt(incomeArray[i][j].trim());
                } catch (RuntimeException e) {
                    throw new MyArrayDataException("В d[jlzotv в ячейке [" + i + "],[" + j + "] находится значение с типом данных отличным от int!" );
                }
            }
        }

        return resultArray;
    }

    public static int countSum(int[][] incomeArray){
        int sum = 0;

        for (int i=0; i < incomeArray.length; i++){
            for (int j=0; j< incomeArray.length; j++){
//                sum = sum + incomeArray[i][j];
                sum += incomeArray[i][j];

            }
        }
        return sum / 2;
    }
}