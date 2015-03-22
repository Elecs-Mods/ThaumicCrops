package elec332.thaumiccrops.thaumcraft;

import thaumcraft.api.aspects.Aspect;

import java.util.ArrayList;

/**
 * Created by Elec332 on 2-1-2015.
 */
public class TChelper {

    public static ArrayList<String> getAspectTag(ArrayList<Aspect> aspects){
        ArrayList<String> arrayList= new ArrayList<String>();
        for (Aspect aspect : aspects) {
            arrayList.add(aspect.getTag());
        }
        return arrayList;
    }
}
