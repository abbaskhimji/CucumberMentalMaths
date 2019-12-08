package CucumberMentalMaths;

public class MentalMathsTool {

    public static int addingTool (String theSum){
        System.out.println(theSum);
        String numbers[] = theSum.split("\\+", 2);
        numbers[0] = numbers[0].replaceAll("\\s+","");
        numbers[1] = numbers[1].replaceAll("\\s+","");
        int answer = Integer.valueOf(numbers[0]) + Integer.valueOf(numbers[1]);
        return answer;
    }


    public static boolean loadingFile (String dataSet){
        Boolean fileloaded = false;



        return fileloaded;
    }

}
