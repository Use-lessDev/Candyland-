package candyland;

import arc.util.*;
import mindustry.mod.*;
import candyland.content.*;

public class CandylandMod extends Mod {
    public CandylandMod() {
        Log.info("Loaded Candyland mod.");
    }

    @Override
    public void loadContent() {
        CandylandItems.load();
        CandylandBlocks.load();
        CandylandPlanets.load();
    }
}
