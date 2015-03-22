package elec332.thaumiccrops.init;

import elec332.core.helper.ArrayHelper;
import elec332.thaumiccrops.main.ThaumicCrops;
import elec332.thaumiccrops.thaumcraft.TChelper;
import thaumcraft.api.aspects.Aspect;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Elec332 on 14-2-2015.
 */
public class Data {

    public static Data INSTANCE = new Data();

    protected static String[] miscItemShardsString = {"air", "fire", "water", "earth", "order", "entropy", "diamond", "lapis", "amber", "iron", "gold", "coal", "redstone", "glowstone"};
    public static ArrayList<String> RecourceSeeds;
    public static ArrayList<String> primAspects;
    public static ArrayList<String> compoundAspects;
    public static ArrayList<String> T1Aspects;
    public static ArrayList<String> T2Aspects;
    public static ArrayList<String> T3Aspects;
    public static ArrayList<String> T4Aspects;
    public static ArrayList<String> T5Aspects;
    public static ArrayList<String> T6Aspects;
    public static ArrayList<String> T7Aspects;
    public static ArrayList<String> T8Aspects; //unused
    public static ArrayList<String> cropList;

    @SuppressWarnings("unchecked")
    public void createTCArrayLists() {
        ArrayList<Aspect> done = new ArrayList<Aspect>(); //Aspect.getPrimalAspects();
        ArrayList<Aspect> todo = new ArrayList<Aspect>(); //Aspect.getCompoundAspects();
        HashMap<Integer, ArrayList<Aspect>> registry = new HashMap<Integer, ArrayList<Aspect>>();
        ArrayList<Aspect> primal_Aspects = Aspect.getPrimalAspects();
        ArrayList<Aspect> compound_Aspects = Aspect.getCompoundAspects();

        //Yes, I indeed want to do this myself ;)
        for (Aspect aspect : Aspect.aspects.values()) {
            if (aspect.isPrimal())
                done.add(aspect);
            else
                todo.add(aspect);
        }

        for (int i = 1; i < 11; i++) {
            ThaumicCrops.instance.info("Making TC arrays for tier: "+i);
            ArrayList<Aspect> regist = new ArrayList<Aspect>();
            ArrayList<Aspect> thisdone = new ArrayList<Aspect>();
            for (Aspect aspect : todo){
                if (done.contains(aspect.getComponents()[0]) && done.contains(aspect.getComponents()[1])) {
                    if (!regist.contains(aspect)) {
                        regist.add(aspect);
                        thisdone.add(aspect);
                        ThaumicCrops.instance.info("Added " + aspect.getTag() + " to tier " + i);
                    }
                }
            }
            registry.put(i, regist);
            done.addAll(thisdone);
            todo.removeAll(thisdone);
            ThaumicCrops.instance.info("Finished making TC arrays for tier: "+i);
        }
        RecourceSeeds = new ArrayList<String>();
        primAspects = TChelper.getAspectTag(primal_Aspects);
        compoundAspects = TChelper.getAspectTag(compound_Aspects);
        T1Aspects = TChelper.getAspectTag(registry.get(1));
        T2Aspects = TChelper.getAspectTag(registry.get(2));
        T3Aspects = TChelper.getAspectTag(registry.get(3));
        T4Aspects = TChelper.getAspectTag(registry.get(4));
        T5Aspects = TChelper.getAspectTag(registry.get(5));
        T6Aspects = TChelper.getAspectTag(registry.get(6));
        T7Aspects = TChelper.getAspectTag(registry.get(7));
        T8Aspects = TChelper.getAspectTag(registry.get(8));
        cropList = TChelper.getAspectTag(ArrayHelper.mergeArrays(primal_Aspects, compound_Aspects));
        /*
        for (int i = 0; i < 10; i++) {
            this.T1Aspects.add(compoundAspects.get(i));
        }
        this.T2Aspects = StringHelper.convertStringArrayToArraylist(new String[]{"bestia", "fames", "herba", "iter", "limus", "metallum", "mortuus", "praecantatio", "sano", "tenebrae", "vinculum", "volatus"});
        this.T3Aspects = StringHelper.convertStringArrayToArraylist(new String[]{"alienis", "arbor", "auram", "corpus", "exanimis", "spiritus", "vitium"});
        this.T4Aspects = StringHelper.convertStringArrayToArraylist(new String[]{"cognitio", "sensus"});
        this.T5Aspects.add("humanus");
        this.T6Aspects = StringHelper.convertStringArrayToArraylist(new String[]{"instrumentum", "lucrum", "messis", "perfodio"});
        this.T7Aspects = StringHelper.convertStringArrayToArraylist(new String[]{"fabrico", "machina", "meto", "pannus", "telum", "tutamen"});
        */

    }
}
