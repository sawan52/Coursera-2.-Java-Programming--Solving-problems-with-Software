
/**
 * Write a description of Part2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part2 {
    
    public int howMany(String stringA, String stringB){
        int lengthA = stringA.length();
        int currIndex = 0, count = 0;
        while(currIndex != -1){
             currIndex = stringB.indexOf(stringA, currIndex);
             if(currIndex != -1){
                 count = count +1;
                 currIndex = currIndex + lengthA;
             }
        }
        return count;
    }
    
    public void testHowMany(){
        int numberOfTimes = howMany("GAA","ATGAACGAATTGAATC");
        System.out.println(numberOfTimes + " Number of times GAA appears in ATGAACGAATTGAATC");
        numberOfTimes = howMany("AA","ATAAAAAAAAAAAA");
        System.out.println(numberOfTimes);
    }

}
