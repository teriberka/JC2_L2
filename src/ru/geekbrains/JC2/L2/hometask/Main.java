package ru.geekbrains.JC2.L2.hometask;

public class Main {
    public static void main(String[] args){
        String inputString = "10 3 1 2\n2 3 2 2\n5 6 7 1\n300 3 1 test";

        String[][] stringArray;
        int[][] intArray;

        stringArray = parseString(inputString);
        printArray(stringArray);

        intArray = changeArray(stringArray);

        System.out.println("sum = " + countSum(intArray));
    }

    public static String[][] parseString(String inputString) {
        String[] subArray1;
        String[] subArray2;

        subArray1 = inputString.split("\n");

        int n = subArray1.length;

        String[][] resultArray = new String[n][n];

        for (int i = 0; i < subArray1.length; i++) {
//            System.out.println(subArray1[i]);
            subArray2 = subArray1[i].split(" ");

            if (subArray1.length != 4 || subArray2.length != 4) throw new MyArraySizeException("Размер матрицы не 4x4", subArray1.length);

            for (int j = 0; j < subArray2.length; j++) {
//                System.out.println(subArray2[j]);
                resultArray[i][j] = subArray2[j];
            }
        }

        return resultArray;
    }


    public static void printArray(String[][] incomeArray){
        for (int i = 0; i < incomeArray.length; i++){
            for(int j = 0; j < incomeArray.length; j++){
                System.out.print(incomeArray[i][j] + " ");
            }
            System.out.println(" ");
        }
    }


    public static int[][] changeArray(String[][] incomeArray){
        int n = incomeArray.length;
        int[][] resultArray = new int[n][n];

        for (int i = 0; i < incomeArray.length; i++){
            for(int j = 0; j < incomeArray.length; j++){
//                resultArray[i][j] = Integer.parseInt(incomeArray[i][j].trim());
                try
                {
                    resultArray[i][j] = Integer.parseInt(incomeArray[i][j].trim());
                }
                catch (NumberFormatException nfe)
                {
                    System.out.println("Мы не смогли перевести строку в число!");
                    System.out.println("В данном значении массива хранится строка: " + incomeArray[i][j]);
                }

            }
        }

        return resultArray;
    }

    public static int countSum(int[][] incomeArray){
        int sum = 0;

        for (int i=0; i < incomeArray.length; i++){
            for (int j=0; j< incomeArray.length; j++){
                sum = sum + incomeArray[i][j];
            }
        }
        return sum / 2;
    }
}