package ru.geekbrains.JC2.L2.hometask;

public class MyArrayDataException extends Exception {
    private String str;

    public String getStr(){
        return "строка с ошибкой = " + str;
    }

    public MyArrayDataException(String message, String str){
        super(message);
        str = str;
    }
}
