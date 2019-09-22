import java.util.ArrayList;
import java.util.concurrent.RecursiveTask;

    public class WeatherParallel extends Methods {
        static int[] ind = new int[3];
        double ansX = 0;
        double ansY = 0;

        /**
         * Subclass that contains methods for Java's fork-join framework
         */
        public static class Thread extends RecursiveTask<Vector> {
            int lo; // arguments
            int hi;
            Vector[][][] arr;
            static final int SEQUENTIAL_CUTOFF = 100000;

            /**
             * creates a thread
             * @param a Vector[][][] for wind
             * @param l start value for recursive task
             * @param h size of Vector[][][] and also end value for recursive task
             */
            Thread(Vector[][][] a, int l, int h) {
                lo = l;
                hi = h;
                arr = a;
            }

            /**
             *recursive task to compute classifications and total x and y
             * @return the vector with total x and total y
             */
            @Override
            protected Vector compute() {// return answer - instead of run
                if ((hi - lo) < SEQUENTIAL_CUTOFF) {
                    double ansX = 0;
                    double ansY = 0;
                    for (int i = lo; i < hi; i++) {
                        Methods.locate(i, ind);
                        ansX += arr[ind[0]][ind[1]][ind[2]].x;
                        ansY += arr[ind[0]][ind[1]][ind[2]].y;
                        setClassification(ind[0], ind[1], ind[2]);
                    }
                    return new Vector(ansX, ansY);
                } else {
                    Thread left = new Thread(arr, lo, (hi + lo) / 2);
                    Thread right = new Thread(arr, (hi + lo) / 2, hi);
                    left.fork();
                    Vector rightAns = right.compute();
                    Vector leftAns = left.join();
                    return new Vector(rightAns.x + leftAns.x, rightAns.y + leftAns.y);
                }
            }
        }

        /**
         *initiates fork-join pool methods
         * @param wind wind vector to processed
         * @return the wind vector with total x and total y
         */
        static Vector thread(Vector[][][] wind) {
            return fjPool.invoke(new Thread(wind, 0, dimt * dimx * dimy));
        }

        /**
         * main method to execute Parallel Weather program
         * @param args contains parameters
         */
        public static void main(String[] args) {
         if(args.length==1 && args!=null){          //takes input from terminal
             fileIn=args[0].split(" ")[0];    //sets first file name to input file
             fileOut=args[0].split(" ")[1];   //sets second file name to input file
         }
            read(); //reads input file in
            avg =new Vector();
            float time;
            ArrayList<Float> times = new ArrayList<>();
            for(int i =0; i<11; i++){
                System.gc();
                avg = thread(wind);
            }
            for(int i =0; i<100; i++){
                System.gc();
                tick();
                avg = thread(wind);
                time=tock();
                times.add(time);
            }
            System.out.println("Run took " + Methods.mean(times) + " seconds");
            avg.x/=(dimt*dimx*dimy);avg.y/=(dimt*dimx*dimy);
            write();
        }
    }








