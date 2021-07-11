import java.util.Scanner;

public class Reader {
    private String[] numerals;
    private String firstNum;
    private String operator;
    private String secondNum;

    public void read() {

        Scanner scanner = new Scanner(System.in);

        try {
            numerals = scanner.nextLine().toUpperCase().toUpperCase().split(" ");
        } catch (RuntimeException e) {
            throw new IllegalArgumentException("Неверный ввод данных (Допустимый ввод: \"1 + 5\", \"V * X\").");
        }

    }

    public boolean isRomanToArabicSwitch() {
        boolean firstNum = true;
        try {
            RomanNum.valueOf(getFirstNum());
        } catch (IllegalArgumentException e) {
            firstNum = false;
        }
        boolean secondNum = true;
        try {
            RomanNum.valueOf(getSecondNum());
        } catch (IllegalArgumentException e) {
            secondNum = false;
        }

        return (firstNum && secondNum);
    }

    public String getFirstNum() {
        this.firstNum = numerals[0];
        return firstNum;
    }

    public String getOperator() {
        this.operator = numerals[1];
        return operator;
    }

    public String getSecondNum() {
        this.secondNum = numerals[2];
        return secondNum;
    }

}
