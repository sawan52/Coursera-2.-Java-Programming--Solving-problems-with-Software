

/**
 * Write a description of Part3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part3 {              //    by       A story by Abby Long
    public String twoOccurrences(String stringA, String stringB){
        System.out.println(stringA + "\t" + stringB);
        int lengthA = stringA.length();
        int index = 0, count =0;
        while(index != -1){
            index = stringB.indexOf(stringA, index);
            if(index != -1){
                index = index + lengthA;
                count++;
            }
        }
        if(count >= 2){
            return "true";
        }
        else{
            return "false";
        }         
    }
    
    public void testing(){
        String answer = twoOccurrences("hello","khelloslkhellodjladfjhello");
        System.out.println(answer);
        String lastString = lastPart("an","banana");
        System.out.println("Remaining String = " + lastString);
        answer = twoOccurrences("khe","khlloslkhllodjladfjkhhello");
        System.out.println(answer);
        lastString = lastPart("zoo","forest");
        System.out.println("Remaining String = " + lastString);
        answer = twoOccurrences("llo","khelloslkhellodjlloadfjhello");
        System.out.println(answer);
        lastString = lastPart("an","banana");
        System.out.println("Remaining String = " + lastString);
        
    }
    
    public String lastPart(String stringA, String stringB){
        System.out.println(stringA + "\t" + stringB);
        int length = stringA.length();
        int index = stringB.indexOf(stringA);
        if(index == -1){
            return stringB;
        }
        else {
            String remainString = stringB.substring(index + length);
            return remainString;
        }
    }

}
