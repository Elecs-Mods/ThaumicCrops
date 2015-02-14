package elec332.thaumiccrops.init;

import elec332.core.helper.ArrayHelper;
import elec332.core.helper.StringHelper;
import elec332.thaumiccrops.thaumcraft.TChelper;
import thaumcraft.api.aspects.Aspect;

import java.util.ArrayList;

/**
 * Created by Elec332 on 14-2-2015.
 */
public class Data {

    public static Data INSTANCE = new Data();

    protected static String[] miscItemShardsString = {"air", "fire", "water", "earth", "order", "entropy", "diamond", "lapis", "amber", "iron", "gold", "coal", "redstone", "glowstone"};
    public static ArrayList<String> RecourceSeeds = new ArrayList<String>();
    public static ArrayList<String> T1Aspects = new ArrayList<String>();
    public static ArrayList<String> T2Aspects = new ArrayList<String>();
    public static ArrayList<String> T3Aspects = new ArrayList<String>();
    public static ArrayList<String> T4Aspects = new ArrayList<String>();
    public static ArrayList<String> T5Aspects = new ArrayList<String>();
    public static ArrayList<String> T6Aspects = new ArrayList<String>();
    public static ArrayList<String> T7Aspects = new ArrayList<String>();

    @SuppressWarnings("unchecked")
    public static ArrayList<String> primAspects = TChelper.getAspectTag(Aspect.getPrimalAspects());

    @SuppressWarnings("unchecked")
    public static ArrayList<String> compoundAspects = TChelper.getAspectTag(Aspect.getCompoundAspects());

    @SuppressWarnings("unchecked")
    public static ArrayList<String> cropList = ArrayHelper.mergeArrays(primAspects, compoundAspects);

    public void createTCArrayLists() {
        for (int i = 0; i < 10; i++) {
            this.T1Aspects.add(compoundAspects.get(i));
        }
        this.T2Aspects = StringHelper.convertStringArrayToArraylist(new String[]{"bestia", "fames", "herba", "iter", "limus", "metallum", "mortuus", "praecantatio", "sano", "tenebrae", "vinculum", "volatus"});
        this.T3Aspects = StringHelper.convertStringArrayToArraylist(new String[]{"alienis", "arbor", "auram", "corpus", "exanimis", "spiritus", "vitium"});
        this.T4Aspects = StringHelper.convertStringArrayToArraylist(new String[]{"cognitio", "sensus"});
        this.T5Aspects.add("humanus");
        this.T6Aspects = StringHelper.convertStringArrayToArraylist(new String[]{"instrumentum", "lucrum", "messis", "perfodio"});
        this.T7Aspects = StringHelper.convertStringArrayToArraylist(new String[]{"fabrico", "machina", "meto", "pannus", "telum", "tutamen"});
    }
}
