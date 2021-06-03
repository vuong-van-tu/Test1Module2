package Class;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexStudent {
    private static final String MA_SINH_VIEN = "^[C]\\d{4}[G|H|I|K]\\d{2}$";
    private static final String EMAIL = "^[[a-z]{1,}].{2,}@codegym.vn$";
    private static final String DATE_OF_BIRTH = "^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[13-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$";
    public RegexStudent() {
    }
    public static boolean validateID(String id){
        Pattern pattern ;
        pattern=Pattern.compile(MA_SINH_VIEN);
        Matcher matcher = pattern.matcher(id);
        return  matcher.matches();
    }
    public static boolean validateEmail(String email){
        Pattern pattern;
        pattern=Pattern.compile(EMAIL);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
    public static boolean validateDate(String date){
        Pattern pattern;
        pattern=Pattern.compile(DATE_OF_BIRTH);
        Matcher matcher = pattern.matcher(date);
        return matcher.matches();
    }

}
