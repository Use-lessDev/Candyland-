package candyland.content;

import candyland.world.blocks.production.DrillButButtonItemSprite;
import mindustry.type.*;
import mindustry.world.blocks.defense.*;
import mindustry.world.blocks.environment.*;
import mindustry.world.meta.*;
import static mindustry.type.ItemStack.*;

/**
 * Environment setup matches Project RayField style:
 * plain Floor / StaticWall / Prop with variants matching numbered sprites.
 * large wall uses auto -large split (sprites must be exact 64x64).
 */
public class CandylandBlocks {
    public static Floor cookieFloor;
    public static StaticWall cookieWall, chocolateCookieWall, depletedCookieWall;
    public static Prop cookieBoulder, chocolateCookieBoulder, depletedCookieBoulder;
    public static Wall cookieDefenseWall, cookieDefenseWallLarge;
    public static DrillButButtonItemSprite cookieDrill;

    public static void load() {
        cookieFloor = new Floor("cookie-floor") {{
            variants = 2;
            alwaysUnlocked = true;
        }};

        cookieWall = new StaticWall("cookie-wall") {{
            variants = 3;
            alwaysUnlocked = true;
            cookieFloor.asFloor().wall = this;
        }};

        chocolateCookieWall = new StaticWall("chocolate-cookie-wall") {{
            variants = 2;
            alwaysUnlocked = true;
        }};

        depletedCookieWall = new StaticWall("depleted-cookie-wall") {{
            variants = 2;
            alwaysUnlocked = true;
        }};

        cookieBoulder = new Prop("cookie-boulder") {{
            variants = 1;
            alwaysUnlocked = true;
            cookieFloor.asFloor().decoration = this;
        }};
        chocolateCookieBoulder = new Prop("chocolate-cookie-boulder") {{
            variants = 1;
            alwaysUnlocked = true;
        }};
        depletedCookieBoulder = new Prop("depleted-cookie-boulder") {{
            variants = 1;
            alwaysUnlocked = true;
        }};

        cookieDefenseWall = new Wall("cookie-defense-wall") {{
            requirements(Category.defense, with(CandylandItems.cookie, 6));
            health = 390; armor = 15f; size = 1; alwaysUnlocked = true;
        }};
        cookieDefenseWallLarge = new Wall("cookie-defense-wall-large") {{
            requirements(Category.defense, with(CandylandItems.cookie, 24));
            health = 1560; armor = 15f; size = 2; alwaysUnlocked = true;
        }};

        cookieDrill = new DrillButButtonItemSprite("cookie-drill") {{
            requirements(Category.production, with(CandylandItems.cookie, 20, CandylandItems.dough, 15));
            size = 2;
            tier = 3;
            drillTime = 300f;
            alwaysUnlocked = true;
        }};
    }
}
