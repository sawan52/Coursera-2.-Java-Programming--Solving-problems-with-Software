import edu.duke.*;        
import org.apache.commons.csv.*;
/**
 * Write a description of Part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part1 {
    public void tester(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        //countryInfo(parser, "Nauru");
        //listExportersTwoProducts(parser, "cotton", "flowers");
        //int numberOfCountries  = numberOfExporters(parser, "cocoa");
        //System.out.println(numberOfCountries);
        bigExporters(parser, "$999,999,999,999"); 
    }

    public String countryInfo(CSVParser parser, String country){
        FileResource fr = new FileResource();
        parser = fr.getCSVParser();
        String completeInfo = "";
        for(CSVRecord record : parser){
            String countryName = record.get("Country");
            if(countryName.contains(country)){
                String exports = record.get("Exports");
                String value = record.get("Value (dollars)");
                System.out.println(country + ": " + exports + ": " + value);
            }
        } 
        return "NOT FOUND";
    }
    
    public void listExportersTwoProducts(CSVParser parser, String exportItem1, String exportItem2){
        FileResource fr = new FileResource();
        parser = fr.getCSVParser();
        for(CSVRecord record : parser){
            String export = record.get("Exports");
            if(export.contains(exportItem1) && export.contains(exportItem2)){
                String country = record.get("Country");
                System.out.println(country);
            }
        }
    }
    
    public int numberOfExporters(CSVParser parser, String exportItem){
        FileResource fr = new FileResource();
        parser = fr.getCSVParser();
        int count = 0;
        for(CSVRecord record : parser){
            String exports = record.get("Exports");
            if(exports.contains(exportItem)){
                count = count + 1;
            }
        }
        return count;
    }
    
    public void bigExporters(CSVParser parser, String amount){
        FileResource fr = new FileResource();
        parser = fr.getCSVParser();
        for(CSVRecord record : parser){
            String exportAmount = record.get("Value (dollars)");
            if(exportAmount.length() > amount.length()){
                String country = record.get("Country");
                String value = record.get("Value (dollars)");
                System.out.println(country + " " + value);
            }
        }
    }
} 
  