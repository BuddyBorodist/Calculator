import java.util.List;

public class ArabicToRoman {
    public static String arabicToRoman(int number) {
        if ((number <= 0) || (number > 100)) {
            throw new IllegalArgumentException("Неправильная цифра или результат! Римские цифры - только целые положительные числа.");
        }

        List<RomanNum> romanNum = RomanNum.getReverseSortedValues();

        int i = 0;
        StringBuilder sb = new StringBuilder();

        while ((number > 0) && (i < romanNum.size())) {
            RomanNum currentSymbol = romanNum.get(i);
            if (currentSymbol.getValue() <= number) {
                sb.append(currentSymbol.name());
                number -= currentSymbol.getValue();
            } else {
                i++;
            }
        }

        return sb.toString();
    }
}
