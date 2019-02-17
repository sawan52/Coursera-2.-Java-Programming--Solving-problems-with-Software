import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;
/**
 * Write a description of Part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part1 {
    
    public CSVRecord coldestHourInFile(CSVParser parser){
        CSVRecord coldestTemp = null;
        for(CSVRecord currentRow : parser){
            coldestTemp = getColdestOfTwo(currentRow, coldestTemp);
        }
        return coldestTemp;
    }
    
    public CSVRecord getColdestOfTwo(CSVRecord currentRow, CSVRecord coldestTemp){
        if(coldestTemp == null){ 
                coldestTemp = currentRow;
        }
        else{
             double currentTemp = Double.parseDouble(currentRow.get("TemperatureF"));
             double lowestTemp = Double.parseDouble(coldestTemp.get("TemperatureF"));      
             if(currentTemp < lowestTemp){
                coldestTemp = currentRow;
             }
        }
        return coldestTemp;
    }
    
    public String fileWithColdestTemperature(){
        File fileName = null;
        CSVRecord coldestTemp = null;
        DirectoryResource dr = new DirectoryResource();
        for(File f : dr.selectedFiles()){
            FileResource fr = new FileResource(f);
            CSVParser parser = fr.getCSVParser();
            CSVRecord currRow = coldestHourInFile(parser);
            
            if(coldestTemp == null){
                coldestTemp = currRow;
                fileName = f;
            }
            else{
                double currTemp = Double.parseDouble(currRow.get("TemperatureF"));
                double lowestTemp = Double.parseDouble(coldestTemp.get("TemperatureF"));
                if(currTemp < lowestTemp){
                    coldestTemp = currRow;
                    fileName = f;
                }
            }
            
        }
        return fileName.getAbsolutePath();
    }
    
    public CSVRecord lowestHumidityInFile(CSVParser parser){
        CSVRecord lowHumi = null;
        for(CSVRecord currRow : parser){ 
            if(lowHumi == null){
                lowHumi = currRow;
            }
            else{
                if(!currRow.get("Humidity").equals("N/A") && !lowHumi.get("Humidity").equals("N/A")){
                    int currHumi = Integer.parseInt(currRow.get("Humidity"));
                    int lowestHumi = Integer.parseInt(lowHumi.get("Humidity"));
                    if(currHumi < lowestHumi){
                        lowHumi = currRow;
                    } 
                }
            }
        }
        return lowHumi;
    }
    
    public CSVRecord lowestHumidityInManyFiles(){
        CSVRecord lowHumi = null;
        DirectoryResource dr = new DirectoryResource();
        for(File f : dr.selectedFiles()){
            FileResource fr = new FileResource(f);
            CSVRecord currRow = lowestHumidityInFile(fr.getCSVParser());
            if(lowHumi == null){
                lowHumi = currRow;
            }
            else{
                if(!currRow.get("Humidity").equals("N/A") && !lowHumi.get("Humidity").equals("N/A")){
                    int currHumi = Integer.parseInt(currRow.get("Humidity"));
                    int lowestHumi = Integer.parseInt(lowHumi.get("Humidity"));
                    if(currHumi < lowestHumi){
                        lowHumi = currRow;
                    }
                }
            }
            
        }
        return lowHumi;
    }
    
    public double averageTemperatureInFile(CSVParser parser){
        double total = 0.0;
        int count = 0;
        for(CSVRecord currRow : parser){
            total = total + Double.parseDouble(currRow.get("TemperatureF"));
            count++;
        }
        return total/count;
    }
    
    public double averageTemperatureWithHighHumidityInFile(CSVParser parser, int value){
        double Temp = 0.0;
        int count = 0;
        for(CSVRecord currRow : parser){
            double currTemp = Double.parseDouble(currRow.get("TemperatureF"));
            int currHumi = Integer.parseInt(currRow.get("Humidity"));
            if(currHumi >= value){
                Temp = Temp + currTemp;
                count++;
            }
        }
        return Temp/count;
    }
    
    public void testAverageTemperatureWithHighHumidityInFile(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        double averageTemp = averageTemperatureWithHighHumidityInFile(parser, 80);
        if(!Double.isNaN(averageTemp)){
            System.out.println("Average Temp when high Humidity is " + averageTemp);
        }
        else{
            System.out.println("No temperatures with that humidity");
        }
    }
    
    public void testAverageTemperatureInFile(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        double average = averageTemperatureInFile(parser);
        System.out.println("Average Temperature in file is " + average);
    }
    
    public void testLowestHumidityInManyFiles(){
        CSVRecord lowest = lowestHumidityInManyFiles();
        System.out.println("Lowest Humidity was " + lowest.get("Humidity") + " at " + lowest.get("DateUTC"));
    }
    
    public void testLowestHumidityInFile(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        CSVRecord lowestHumidity = lowestHumidityInFile(parser);
        System.out.println("Lowest Humidity was " + lowestHumidity.get("Humidity") + " at " + lowestHumidity.get("DateUTC"));
    }
    
    public void testFileWithColdestTemperature(){
        String fileWithColdestTemp = fileWithColdestTemperature();
        File f = new File(fileWithColdestTemp);
        String fileName = f.getName();
        System.out.println("Coldest day was in file " + fileName);
        
        FileResource fr = new FileResource(f);
        CSVParser parser = fr.getCSVParser();
        CSVRecord lowestTemp = coldestHourInFile(parser);
        System.out.println("Coldest Temperature on that day was " + lowestTemp.get("TemperatureF"));

        System.out.println("All the Temperatures on the coldest day were:");
        CSVParser parser2 = fr.getCSVParser();
        for(CSVRecord record : parser2) {
            String dateTime = record.get("DateUTC");
            double temp = Double.parseDouble(record.get("TemperatureF"));
            System.out.println(dateTime + " " + temp);
       	}
    } 
    
    public void testColdestHourInFile(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        CSVRecord lowest = coldestHourInFile(parser);
        System.out.println("Lowest temperature was " + lowest.get("TemperatureF"));
    }
    }
