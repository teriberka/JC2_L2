package ru.geekbrains.JC2.L2.hometask;

public class MyArraySizeException extends Exception{
    private int num;

    public String getNum(){
        return "размер массива = " + num;
    }

    public MyArraySizeException(String message, int num){
        super(message);
        num = num;
    }
}
