import edu.duke.*;
import java.io.*;
/**
 * Write a description of BatchInversions here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BatchInversions {
    
    public ImageResource makeInversion(ImageResource image){
        
        ImageResource newImage = new ImageResource(image.getWidth(), image.getHeight());
        
        for(Pixel pixel : newImage.pixels()){
            Pixel imagePixel = image.getPixel(pixel.getX(), pixel.getY());
            
            int red = imagePixel.getRed();
            int blue = imagePixel.getBlue();
            int green = imagePixel.getGreen();
            
            pixel.setRed(255 - red);
            pixel.setBlue(255 - blue);
            pixel.setGreen(255 - green); 
            // R B G 
        }
        return newImage;
    }
    
    public void testInverted(){
        ImageResource image = new ImageResource();
        ImageResource img = makeInversion(image);
        img.draw();
    }
    
    public void selectInvertSave(){
        DirectoryResource dr = new DirectoryResource();
        for(File f : dr.selectedFiles()){
            ImageResource img = new ImageResource(f);
            ImageResource inverImg = makeInversion(img);
            inverImg.setFileName("inverted-" + img.getFileName());
            inverImg.draw();
            inverImg.save();
        }
    }

}
