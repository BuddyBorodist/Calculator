public class Main {

    public static void main(String[] args) {
        Reader reader = new Reader();
        System.out.println("Введите римские цифры от I до X или арабские цифры от 1 до 10. Для выхода введите \"!\".");

        while (true) {
            reader.read();

            if (reader.getFirstNum().equals("!")) {
                System.out.println("Калькулятор остановлен.");
                return;
            }

            if (reader.isRomanToArabicSwitch()) {
                int firstArabicNumber = RomanToArabic.romanToArabic(reader.getFirstNum());
                int secondArabicNumber = RomanToArabic.romanToArabic(reader.getSecondNum());
                String operator = reader.getOperator();

                int result = calculate(firstArabicNumber, secondArabicNumber, operator);

                String resultInRoman = ArabicToRoman.arabicToRoman(result);
                System.out.println(resultInRoman);

            } else {
                int firstIntNumber = Integer.parseInt(reader.getFirstNum());
                int secondIntNumber = Integer.parseInt(reader.getSecondNum());
                String operator = reader.getOperator();

                try {
                    if (firstIntNumber < 1 || firstIntNumber > 10 || secondIntNumber < 1 || secondIntNumber > 10) {
                        throw new IllegalArgumentException();
                    }
                } catch (RuntimeException e) {
                    throw new IllegalArgumentException("Неправильный номер! Пожалуйста, введите числа от 1 до 10.");
                }

                int result = calculate(firstIntNumber, secondIntNumber, operator);
                System.out.println(result);
            }
        }
    }

    public static int calculate(int firstNum, int secondNum, String operator) {
        int result;
        switch (operator) {
            case "+":
                result = firstNum + secondNum;
                break;
            case "-":
                result = firstNum - secondNum;
                break;
            case "/":
                result = firstNum / secondNum;
                break;
            case "*":
                result = firstNum * secondNum;
                break;
            default:
                throw new IllegalArgumentException("Неправильный оператор!");
        }
        return result;
    }



}

