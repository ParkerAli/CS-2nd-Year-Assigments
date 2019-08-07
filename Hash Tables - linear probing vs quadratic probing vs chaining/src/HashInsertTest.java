import java.io.File;

/**
 * Implements an insert test
 */
public class HashInsertTest {
    static File data = new File("cleaned_data.csv");
    public static void main(String[]args){
        if (args.length==1){
            String[] argss=args[0].split(" ");
            int size= Integer.parseInt(argss[0]);
            String scheme = argss[1];
            if (scheme.equals("linear")){InsertImp.linear(size,data);}
            else if(scheme.equals("quadratic")){InsertImp.quadratic(size,data);}
            else{InsertImp.chaining(size,data);}
        }
        else return;
    }
}

