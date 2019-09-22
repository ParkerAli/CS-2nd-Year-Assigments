public class WeatherSequential extends Methods {
    /**
     * main method to execute Sequential Weather program
     * @param args stores arguments
     */
    public static void main (String [] args) {
         if(args.length==1 && args!=null){      //takes input from terminal
             fileIn=args[0].split(" ")[0]; //sets first file name to input file
             fileOut=args[0].split(" ")[1]; //sets second file name to input file
         }
        read(); //reads input file in
        tick(); //starts timer
        for (int t = 0; t < dimt; t++) { //iteratively computes total x and y and classification
            for (int x = 0; x < dimx; x++) {
                for (int y = 0; y < dimy; y++) {
                    totalX += wind[t][x][y].x;
                    totalY += wind[t][x][y].y;
                    setClassification(t, x, y);
                }
            }
        }
        avg= new Vector(totalX/(dimt*dimx*dimy),totalY/(dimt*dimx*dimy)); //average x and y
        float time = tock();

        System.out.println("Run took " + time + " seconds");
        write(); //writes to output file
    }
}
