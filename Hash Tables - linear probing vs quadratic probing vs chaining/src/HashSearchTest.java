import java.io.File;

/**
 * implements a search test
 */
public class HashSearchTest {
    static File data = new File("cleaned_data.csv");
    public static void main(String[]args){
        if (args.length==1){
            String[] argss=args[0].split(" ");
            int size= Integer.parseInt(argss[0]);
            String scheme = argss[1];
            if (scheme.equals("linear")){SearchImp.linear(size,data);}
            else if(scheme.equals("quadratic")){SearchImp.quadratic(size,data);}
            else{SearchImp.chaining(size,data);}
        }
        else return;
    }

}
