package elec332.thaumiccrops;

/**
 * Created by Elec332 on 5-1-2015.
 */
public class helpers {

    public static String isTCShard(String string, String True, String False){
        if(string.equalsIgnoreCase("air") || string.equalsIgnoreCase("fire") || string.equalsIgnoreCase("water") || string.equalsIgnoreCase("earth") || string.equalsIgnoreCase("order") || string.equalsIgnoreCase("entropy"))
            return True;

        return False;
    }

    public static Boolean isTCShard(String string){
        return(string.equalsIgnoreCase("air") || string.equalsIgnoreCase("fire") || string.equalsIgnoreCase("water") || string.equalsIgnoreCase("earth") || string.equalsIgnoreCase("order") || string.equalsIgnoreCase("entropy"));
    }

}
