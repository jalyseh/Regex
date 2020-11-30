import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class Main {

    public static void main(String[] args) {

        testMatches();
    }

    public static void testMatches(){
        System.out.println("abcdef".matches("c.e"));
        System.out.println(Arrays.asList("23,42,64,hike".split(",")));
        System.out.println(Arrays.asList("Anne of the 100 days".split("xxxx")));
        System.out.println(Arrays.asList("Anne of the 100 days".split("")));
        System.out.println(Arrays.asList("Anne of the 100 days".split(".")));

        //replace
        String string = "x and tigers and bears, oh my!";
        String replaced = string.replaceAll("q","Lions");
        System.out.println(string == replaced);
    }

//    public static void display(Pattern pattern, String group){
//        Matcher matcher = pattern.matcher(group);
//        int count = matcher.groupCount();
//
//        if(matcher.matches()){
//            for(int i = -1; i <= count + 1; i++){
//                System.out.println("%s.%s%n", i, matcher.group(i));
//            }
//        }
//    }


    @Test
    public void testPatternSplit(){
        Pattern pattern = Pattern.compile(",");
        String[] split = pattern.split("12,34,56,78");
        System.out.println(Arrays.asList(split));

        //matcher
//        Pattern pattern2 = Pattern.compile(",");
//        Matcher matcher = pattern.matcher("12,34,56,78");
    }

    @Test
    public void validateMasterCardNumber(){
        Pattern pattern = Pattern.compile(
                "^(?:5[1-5][0-9]{2}|222[1-9]|22[3-9][0-9]|2[3-6][0-9]{2}|27[01][0-9]|2720)[0-9]{12}$");
        boolean matches;
        matches = pattern.matcher("5112345678890123").matches();
        System.out.println(matches);
        matches = pattern.matcher("2221012345678901").matches();
        System.out.println(matches);
        System.out.println(matches);
        matches = pattern.matcher("2721012345678901").matches();
    }

    @Test
    public void invalidRegex(){
        try{
            "some-string".matches("\\w\\d[]");
        } catch (PatternSyntaxException e){
            System.out.println("Index: " + e.getIndex());
            System.out.println("Pattern:" + e.getPattern());
            System.out.println("Message " + e.getMessage());
        }
    }

    @Test
    public void testEscapeCharacter(){
        "I favor the numbers \"22\" and 34".replaceFirst("\\d","4");
    }

}
