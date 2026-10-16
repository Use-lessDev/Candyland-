package candyland.content;

import arc.graphics.*;
import mindustry.type.*;

public class CandylandItems {
    public static Item cookie, dough, chocolateChip, whitePowder;

    public static void load() {
        cookie = new Item("cookie", Color.valueOf("e8a05a")) {{
            hardness = 1; cost = 0.8f; alwaysUnlocked = true;
        }};
        dough = new Item("dough", Color.valueOf("f5deb3")) {{
            hardness = 1; cost = 0.5f; alwaysUnlocked = true;
        }};
        chocolateChip = new Item("chocolate-chip", Color.valueOf("3d1f0e")) {{
            hardness = 1; cost = 0.6f; alwaysUnlocked = true;
        }};
        whitePowder = new Item("white-powder", Color.valueOf("f5f5f5")) {{
            hardness = 1; cost = 0.4f; alwaysUnlocked = true;
        }};
    }
}
