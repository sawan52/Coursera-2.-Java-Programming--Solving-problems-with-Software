import edu.duke.*;
import java.io.File;

public class PerimeterAssignmentRunner {
    public double getPerimeter (Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0.0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        return totalPerim;
    }

    public int getNumPoints (Shape s) {
        // Put code here
        int count = 0;
        for(Point p : s.getPoints()){
            count++;
        }
        return count;
    }
       
    public double getAverageLength(Shape s) {
        // Put code here
        double count = getNumPoints(s);
        double perimeter = getPerimeter(s);
        return (perimeter / count );
    }

    public double getLargestSide(Shape s) {
        // Put code here
        double largest = 0.0;
        Point prevPt = s.getLastPoint();
        for(Point currPt : s.getPoints()){
            double currDist = prevPt.distance(currPt);
            if(currDist > largest){
                largest = currDist;
               // prevPt = currPt;
            } 
            prevPt = currPt;
        }
        return largest;
    }

    public double getLargestX(Shape s) {
        // Put code here
        Point prevPt = s.getLastPoint();
        double largestX = prevPt.getX();
        for(Point currPt : s.getPoints()){
            double x = currPt.getX();
            if(x > largestX){
                largestX = x;
            }
        }
        return largestX;
    }

    public double getLargestPerimeterMultipleFiles() {
        // Put code here
        double largestPerim = 0.0;
        DirectoryResource dr = new DirectoryResource();
        for(File f : dr.selectedFiles()){
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            double newPerim = getPerimeter(s);
            if(newPerim > largestPerim){
                largestPerim = newPerim;
            }
        }
        return largestPerim;
    }

    public String getFileWithLargestPerimeter() {
        // Put code here
        File temp = null;// replace this code
        double largestPerim = 0.0;
        DirectoryResource dr = new DirectoryResource();
        for(File f : dr.selectedFiles()){
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            double currPerim = getPerimeter(s);
            if(currPerim > largestPerim){
                largestPerim = currPerim;
                temp = f;
            }
        }
        return temp.getName();
    }

    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double longestSide = getLargestSide(s);
        double largestX = getLargestX(s);
        double averageLength = getAverageLength(s);
        double numberOfPoints = getNumPoints(s);
        double length = getPerimeter(s);
        System.out.println("\n");
        System.out.println("perimeter = " + length);
        System.out.println("number of points = " + numberOfPoints);
        System.out.println("average length = " + averageLength);
        System.out.println("largest x = " + largestX);
        System.out.println("longest side = " + longestSide);
        testPerimeterMultipleFiles();
        testFileWithLargestPerimeter();
    }
    
    public void testPerimeterMultipleFiles() {
        // Put code here
        /*
        DirectoryResource dr = new DirectoryResource();
        for(File f : dr.selectedFiles()){
        FileResource fr = new FileResource(f);
        Shape s = new Shape(fr);
        */
        double largePerim = getLargestPerimeterMultipleFiles();
        System.out.println("Largest Perim Multi Files length = " + largePerim);
      //  }
    }

    public void testFileWithLargestPerimeter() {
        // Put code here
        /*
        DirectoryResource dr = new DirectoryResource();
        for(File f : dr.selectedFiles()){
        FileResource fr = new FileResource(f);
        Shape s = new Shape(fr);
        */
        String largeFile = getFileWithLargestPerimeter();
        System.out.println("Largest Perim Multi Files name = " + largeFile);
       // }
    }

    // This method creates a triangle that you can use to test your other methods
    public void triangle(){
        Shape triangle = new Shape();
        triangle.addPoint(new Point(0,0));
        triangle.addPoint(new Point(6,0));
        triangle.addPoint(new Point(3,6));
        for (Point p : triangle.getPoints()){
            System.out.println(p);
        }
        double peri = getPerimeter(triangle);
        System.out.println("perimeter = "+peri);
    }

    // This method prints names of all files in a chosen folder that you can use to test your other methods
    public void printFileNames() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            System.out.println(f);
        }
    }

    public static void main (String[] args) {
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        pr.testPerimeter();
    }
}
