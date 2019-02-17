
/**
 * Write a description of Part here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part { 
    
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
            return dnaStr.length();
        }
    
    public String findGene(String dna, int where){
        int startIndex = dna.indexOf("ATG", where);
        if(startIndex == -1){
            return "";
        }
        int taaIndex = findStopCodon(dna, startIndex, "TAA");
        int tagIndex = findStopCodon(dna, startIndex, "TGA");
        int tgaIndex = findStopCodon(dna, startIndex, "TAG");
        
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
    
    public void printAllGene(String dna){
        int startIndex = 0;
        while(true){
            String currGene = findGene(dna, startIndex);
            if(currGene.isEmpty()){ 
                break;
            }
            System.out.println(currGene);
            startIndex = dna.indexOf(currGene, startIndex) + currGene.length();
        }
    }
    
    public int countGenes(String dna){
        int startIndex = 0, count = 0;
        while(true){
            String currGene = findGene(dna, startIndex);
            if(currGene.isEmpty()){ 
                break;
            }
            //System.out.println(currGene); 
            count = count + 1;
            startIndex = dna.indexOf(currGene, startIndex) + currGene.length();
        }
        return count;
    }
    
    public void testCountGenes(){
        String dna = "ATGTAAGATGCCCTAGT";
        System.out.println("Number of times = " + countGenes(dna));
        dna = "ATGTAAAGTATGTGTTAGATGGGGTGA";
        System.out.println("Number of times = " + countGenes(dna));
    }

}
