 import edu.duke.*;
/**
 * Write a description of Part1 here.
 * 
 * @author (your name)         
 * @version (a version number or a date)
 */
public class Part1 {
    
    public int findStopCodon(String dnaStr, int startIndex, String stopCodon){
        int currIndex = dnaStr.indexOf(stopCodon, startIndex + 3);
        while(currIndex != -1){
            int diff = currIndex - startIndex;
            if(diff % 3 == 0){
                return currIndex;
            }
            else{
                currIndex = dnaStr.indexOf(stopCodon, currIndex +1);
            }
        }
        return -1;
    }
    
    public String findGene(String dna, int where){
        int startIndex = dna.indexOf("ATG", where);
        if(startIndex == -1){
            return "";
        }
        int taaIndex = findStopCodon(dna, startIndex, "TAA");
        int tagIndex = findStopCodon(dna, startIndex, "TAG");
        int tgaIndex = findStopCodon(dna, startIndex, "TGA"); 
        
        int minIndex = 0;
        if(taaIndex == -1 || (tgaIndex != -1 && tgaIndex < taaIndex)){
            minIndex = tgaIndex;
        }
        else{
            minIndex = taaIndex;
        }
        if(minIndex == -1 || (tagIndex != -1 && tagIndex < minIndex)){
            minIndex = tagIndex;
        }
        if(minIndex == -1){
            return "";
        }
        return dna.substring(startIndex, minIndex + 3);
    }
    
    public StorageResource getAllGenes(String dna){
        
        StorageResource geneList = new StorageResource();
        int startIndex = 0;
        while(true){
            String currGene = findGene(dna, startIndex);
            if(currGene.isEmpty()){
                break;
            }
            geneList.add(currGene);
            startIndex = dna.indexOf(currGene, startIndex) + currGene.length();
        }
        return geneList;
    }
    
    public float cgRatio(char firstCh,char secondCh, String dna){
        int denominator = dna.length();
        int cIndex = 0, cCount = 0, gIndex = 0, gCount = 0;
        while(cIndex != -1 && gIndex != -1){
             cIndex = dna.indexOf(firstCh, cIndex);
             gIndex = dna.indexOf(secondCh, gIndex);
             if(cIndex != -1){
                 cCount = cCount +1;
                 cIndex = cIndex + 1;
             }
             if(gIndex != -1){
                 gCount = gCount + 1;
                 gIndex = gIndex + 1;
             }
        }
        int totalCount = cCount + gCount;
        float numerator = (float) totalCount;
        float ratio = numerator/denominator;
        return ratio;
    }
    
    public int countCTG(String dna){
        int index = 0, count = 0;
        index = dna.indexOf("CTG", index);
        while(index != -1){
            count++;
            index = dna.indexOf("CTG", index + 3);
        }
        return count;
    }
    
    public void processGenes(StorageResource geneList){
       int charCount = 0, cgCount = 0, longestGene = 0;
       System.out.println("Strings longer than 60 characters: ");
         for(String dna : geneList.data()){
           if(dna.length() > 60){
               System.out.println(dna);
               charCount++;
           }
    }
    System.out.println("Number of Strings longer than 60 characters: " + charCount);
    System.out.println();
    System.out.println("Strings whose CGRatio higher than 0.35: ");
    for(String dna : geneList.data()){
        if(cgRatio('C','G',dna) > 0.35){
            System.out.println(dna);
            cgCount++;
        }
    }
    System.out.println("Number of Strings whose CGRatio higher than 0.35: " + cgCount);
    System.out.println();
    System.out.println("Length of Longest gene is: ");
    longestGene(geneList);
    }

    public void longestGene(StorageResource genes){
        int longestGene = 0;
        for(String dna : genes.data()){
            if(dna.length() > longestGene){
                longestGene = dna.length();
            }
        }
        System.out.print(longestGene);
    } 
    
    public void testProcessGenes(){
        int count = 0;
        FileResource fr = new FileResource("GRch38dnapart.fa");
        String dna = fr.asString();
        StorageResource genes = getAllGenes(dna);
        int ctg = countCTG(dna);
        System.out.println("Number of times CTG appears DNA strand: " + ctg);
        System.out.println("Executing getAllGenes() method on DNA: " + dna);
        for(String g : genes.data()){
            System.out.println(g);
            count++;
        }
        System.out.println("Total number of genes= " + count);
        System.out.println();
        
        System.out.println("Executing processGenes() method on DNA: " + dna);
        processGenes(genes);
    }
 
    
} 
