
/**
 * Write a description of Part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part1 {
    
    public String findSimpleGene(String dna){
        String result = "";
        int startIndex = dna.indexOf("ATG");
        if(startIndex == -1){
            return result;
        }
        int stopIndex = dna.indexOf("TAA",startIndex+3);
        if(stopIndex == -1){
            return result;
        }
        if((stopIndex - startIndex) % 3 == 0){
            result = dna.substring(startIndex, stopIndex+3);
        }
        return result;
    }
    public void testSimpleGene(){
        // CASE 1 - NO ATG
        String dna = "AGTGATTATATGATAA";// NO ATG
        String gene = findSimpleGene(dna);
        System.out.println("GENE IS = " + gene);
        
        // CASE 2 - NO TAA
        dna = "AATAATGATAGATAGATGGAT";// NO TAA
        gene = findSimpleGene(dna);
        System.out.println("GENE IS = " + gene);
        
        // CASE 3 - NO ATG OR TAA
        dna = "ATATTATAGTAGTGGTAGTAGAT";//NO ATG OR TAA
        gene = findSimpleGene(dna);
        System.out.println("GENE IS = " + gene);
        
        // CASE 4 - ATG,TAA,MULTIPLE OF 3
        dna = "TAGATGTAGTAGGATAGATAA";//ATG,TAA,MULTIPLE OF 3
        gene = findSimpleGene(dna); 
        System.out.println("GENE IS = " + gene);
        
        // CASE 5 - ATG,TAA,NOT MULTIPLE OF 3
        dna = "TAGATGTAGTAGGATAGTAA";//ATG,TAA,NOT MULTIPLE OF 3
        gene = findSimpleGene(dna);
        System.out.println("GENE IS = " + gene);
        
    }

}
