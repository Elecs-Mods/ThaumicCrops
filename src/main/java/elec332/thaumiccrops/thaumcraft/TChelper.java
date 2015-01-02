package elec332.thaumiccrops.thaumcraft;

import thaumcraft.api.aspects.Aspect;

import java.util.ArrayList;

/**
 * Created by Elec332 on 2-1-2015.
 */
public class TChelper {
    public static ArrayList getAspectTag(ArrayList<Aspect> aspects){
        ArrayList<String> arrayList= new ArrayList<String>();
        for (int i = 0; i < aspects.size(); i++) {
            arrayList .add(aspects.get(i).getTag());
        }
        return arrayList;
    }
}
