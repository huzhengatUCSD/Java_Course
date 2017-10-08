package ch02;

public class Calculator {
    private static int result; // 静态变量，用于存储运行结果
    public void add(int n) {
        result = result + n;
    }
    public void substract(int n) {
        result = result - n;  
    }
    public void multiply(int n) {
    }         // 此方法尚未写好，请补充
    public void divide(int n) {
        result = result / n;
    }
    public void square(int n) {
        result = n * n;
    }
    public void clear() {     // 将结果清零
        result = 0;
    }
    public int getResult() {
        return result;
    }
}