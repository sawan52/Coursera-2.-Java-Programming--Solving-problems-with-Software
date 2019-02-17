
/**
 * Write a description of Part2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part2 {
    public String findSimpleGene(String dna, String startCodon, String stopCodon){
        String result = "";
        if(startCodon == "ATG" && stopCodon == "TAA"){
            dna = dna.toUpperCase();
        }
        else if(startCodon == "atg" && stopCodon == "taa"){
            dna = dna.toLowerCase();
        }      
        int startIndex = dna.indexOf(startCodon);
        if(startIndex == -1){
            return result;
        }
        int stopIndex = dna.indexOf(stopCodon, startIndex + 3);
        if(stopIndex == -1){
            return result;      
        }
        if((stopIndex - startIndex) % 3 == 0){
            result = dna.substring(startIndex, stopIndex + 3);
        }
        return result;
    }
    public void testSimpleGene(){
        // CASE 1 - NO ATG
        String dna = "AGTGATTATATGATAA";// NO ATG
        String gene = findSimpleGene(dna,"ATG","TAA");
        System.out.println("GENE IS = " + gene);
        
        // CASE 2 - NO TAA
        dna = "AATAATGATAGATAGATGGAT";// NO TAA
        gene = findSimpleGene(dna,"ATG","TAA");
        System.out.println("GENE IS = " + gene);
        
        // CASE 3 - NO ATG OR TAA
        dna = "ATATTATAGTAGTGGTAGTAGAT";//NO ATG OR TAA
        gene = findSimpleGene(dna,"ATG","TAA");
        System.out.println("GENE IS = " + gene);
        
        // CASE 4 - ATG,TAA,MULTIPLE OF 3
        dna = "TAGATGTAGTAGGATAGATAA";//ATG,TAA,MULTIPLE OF 3
        gene = findSimpleGene(dna,"ATG","TAA");
        System.out.println("GENE IS = " + gene);
        
        // CASE 5 - ATG,TAA,NOT MULTIPLE OF 3
        dna = "TAGATGTAGTAGGATAGTAA";//ATG,TAA,NOT MULTIPLE OF 3
        gene = findSimpleGene(dna,"ATG","TAA");
        System.out.println("GENE IS = " + gene);
        
        // CASE 6 - DNA WITH ALL CAPITAL LETTERS
        dna = "ATGGGTTAAGTC";
        gene = findSimpleGene(dna,"atg","taa");
        System.out.println("GENE IS = " + gene);
        
        // CASE 7 - DNA WITH ALL SMALL LETTERS
        dna = "gatgctataat";
        gene = findSimpleGene(dna,"ATG","TAA");
        System.out.println("GENE IS = " + gene);
        /*
        // CASE 8 - DNA WITH  
        dna = "TAGATGTAGTAGGATAGTAA";//ATG,TAA,NOT MULTIPLE OF 3
        gene = findSimpleGene(dna,"ATG","TAA");
        System.out.println("GENE IS = " + gene);
        */
        System.out.println("\n");
        
    }


}
 