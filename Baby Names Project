import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;
import java.text.*;
/**
 * Write a description of Part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part1 {
    
    public void printNames(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser(false);
        for(CSVRecord record : parser){
            int numBorn = Integer.parseInt(record.get(2));
            if(numBorn <= 5){
            System.out.println("Name: " + record.get(0) + ",Gender: " + record.get(1)
                                +  ",Number Of Borns: " + record.get(2));
            }
        }
    }
    
    public void totalBirths(){
        int totalBirth = 0;
        int totalBoys = 0, totalGirls = 0;
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser(false);
        for(CSVRecord rec : parser){
            int numBorn = Integer.parseInt(rec.get(2));
            totalBirth = totalBirth + numBorn;
            if(rec.get(1).equals("M")){
                totalBoys = totalBoys + numBorn;
            }
            else{
                totalGirls = totalGirls + numBorn;
            }
        }
        System.out.println("Total Births: " + totalBirth);
        System.out.println("Total Boys: " + totalBoys);
        System.out.println("Total Girls: " + totalGirls);
    }
    
    public int getRank(int year, String name, String gender){
        int rank = 0;
        FileResource fr = new FileResource("us_babynames/us_babynames_by_year/yob" + year + ".csv");
        CSVParser parser = fr.getCSVParser(false);
        for(CSVRecord rec : parser){
            String childName = rec.get(0);
            String childGender = rec.get(1);
           
            if(childGender.equals(gender)){
                rank++;
                if(childName.equals(name)){
                    return rank;
                }
            }
        }
        return -1;
    }
    
    public void testGetRank(){
        int rank = getRank(1971, "Frank", "M");
        System.out.println("Rank is: " + rank);
    }
    
    public String getName(int year, int rank, String gender){
        String name = "";
        int childRank = 0;
        FileResource fr = new FileResource("us_babynames/us_babynames_by_year/yob" + year + ".csv");
        CSVParser parser = fr.getCSVParser(false);
        for(CSVRecord rec : parser){
            String childName = rec.get(0);
            String childGender = rec.get(1);
            if(childGender.equals(gender)){
                childRank++;
                if(childRank == rank){
                    return childName;
                }
            }
        }
        return "NO NAME";
    }
    
    public void testGetName(){
        String name = getName(1982, 450, "M");
        System.out.println(name);
    }  
    
    public void whatIsNameInYear(String name, int year, int newYear, String gender){
        String childGender = "";
        int childRank = getRank(year, name, gender);
        String childName = getName(newYear, childRank, gender);
        if(gender.equals("M")){
            childGender = "he";
        }
        else{
            childGender = "she";
        }
        System.out.println(name + " born in " + year + " would be " + childName + " if " + childGender + " was born in " + newYear + ".");
    }
    
    public void testWhatIsNameInYear(){
        whatIsNameInYear("Owen", 1974, 2014, "M");
        //  Isabella born in 2012 would be Sophia if she was born in 2014.
    }
    
    public int yearOfHighestRank(String name, String gender){
        int initialYear = -1;
        int initialRank = 999999999;
        DirectoryResource dr = new DirectoryResource();
        for(File f : dr.selectedFiles()){
            FileResource fr = new FileResource(f);
            CSVParser parser = fr.getCSVParser(false);
            String yearName = f.getName();
            int yearNm = getYearOfFile(yearName);
            int currRank = getRank(yearNm, name, gender);
            if(currRank < initialRank){
                initialYear = yearNm;
                initialRank = currRank;
            }
        }
        return initialYear;
    }
    
    public int getYearOfFile(String yr){
        int x = yr.indexOf("yob");
        int length = x + 3;
        yr = yr.substring(length, length + 4);
        int year = Integer.parseInt(yr);
        return year;   
    }
    
    public void testYearOfHighestRank(){
        int year = yearOfHighestRank("Mich", "M");
        System.out.println("Year: " + year);
    }
    
    public double getAverageRank(String name, String gender){
        double total = 0, count = 0;
        DirectoryResource dr = new DirectoryResource();
        for(File f : dr.selectedFiles()){
            FileResource fr = new FileResource(f);
            CSVParser parser = fr.getCSVParser(false);
            String yearName = f.getName();
            int yearNm = getYearOfFile(yearName);
            int currRank = getRank(yearNm, name, gender);
            total = total + currRank;
            count++;
        }
        return (total / count);
    }
    
    public void testGetAverageRank(){
        DecimalFormat df = new DecimalFormat("#.####");
        double average = getAverageRank("Robert", "M");
        System.out.println("Average Rank: " + df.format(average));
    }
    
    public int getTotalBirthsRankedHigher(int year, String name, String gender){
        int totalNumBorn = 0;
        FileResource fr = new FileResource("us_babynames/us_babynames_by_year/yob" + year + ".csv");
        CSVParser parser = fr.getCSVParser();
        for(CSVRecord record : parser){
            String childGender = record.get(1);
            String childName = record.get(0);
            if(childGender.equals(gender)){
                if(childName.equals(name)){
                    return totalNumBorn;
                }
                else{
                    int numBorn = Integer.parseInt(record.get(2));
                    totalNumBorn += numBorn;
                }
            }
        }
        return -1;
    }
    
    public void testGetTotalBirthsRankedHigher(){
        int higherRank = getTotalBirthsRankedHigher(1990, "Emily", "F");
        System.out.println("Higher Rank: " + higherRank);
    }
    
    public void numberOfNames(){
        int male = 0, female = 0;
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser(false);
        for(CSVRecord rec : parser){
            String gender = rec.get(1);
            if(gender.equals("M")){
                male++;
            }
            else{
                female++;
            }
        }
        System.out.println("Number of males: " + male + "\n" + "Number of females: " + female);
    }
    
}

// You can change name according to your question needs...
