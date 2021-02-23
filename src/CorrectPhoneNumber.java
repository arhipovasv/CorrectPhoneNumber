import java.util.ArrayList;

public class CorrectPhoneNumber {

    public static ArrayList checkCorrectNumber(String number) {
        String newNumbr = number;
        String errors = "";
        ArrayList output = new ArrayList();
        if (number.startsWith("+7")) {
            newNumbr = "8" + newNumbr.substring(2, number.length());
            errors = "Замена +7 на 8";
        }
        String correctNumber = newNumbr;
        correctNumber = correctNumber.replace(" ", "");
        correctNumber = correctNumber.replace("(", "");
        correctNumber = correctNumber.replace(")", "");
        if (!(correctNumber.equals(newNumbr))) {
            newNumbr = correctNumber;
            if (errors.isEmpty()) {
                errors = errors + "В номере есть пробелы и/или скобки";
            }
            else {
                errors = errors + "; В номере есть пробелы и/или скобки";
            }
        }
        if (newNumbr.length() != 11) {
            if (errors.isEmpty()) {
                output.add("Введен некорректный номер");
            }
            else {
                output.add(errors);
            }
            if (newNumbr.length() > 11){
                output.add("Сумма символов больше 11");
            }
            else {
                output.add("Сумма символов меньше 11");
            }
        }
        else {
            output.add(newNumbr);
            if (errors.isEmpty()) output.add("Не было изменений");
            else output.add(errors);
        }
        return output;
    }

    public static void main(String[] args) {
        String phone = "+79537376770";
        String phone1 = "895373767700";
        String phone2 = "895373767";
        String phone3 = "+7(920) 123 45 67";
        String phone4 = "89537376770";
        System.out.println(checkCorrectNumber(phone));
        System.out.println(checkCorrectNumber(phone1));
        System.out.println(checkCorrectNumber(phone2));
        System.out.println(checkCorrectNumber(phone3));
        System.out.println(checkCorrectNumber(phone4));
    }
}