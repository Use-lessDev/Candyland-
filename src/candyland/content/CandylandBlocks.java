package candyland.content;

import candyland.world.blocks.production.DrillButButtonItemSprite;
import mindustry.content.*;
import mindustry.type.*;
import mindustry.world.blocks.defense.*;
import mindustry.world.blocks.environment.*;
import mindustry.world.blocks.production.*;
import mindustry.world.draw.*;
import mindustry.world.meta.*;
import static mindustry.type.ItemStack.*;

public class CandylandBlocks {
    public static Floor cookieFloor;
    public static StaticWall cookieWall, chocolateCookieWall, depletedCookieWall;
    public static Prop cookieBoulder, chocolateCookieBoulder, depletedCookieBoulder;
    public static Wall cookieDefenseWall, cookieDefenseWallLarge;
    public static DrillButButtonItemSprite cookieDrill;
    public static GenericCrafter cookieOven;

    public static void load() {
        cookieFloor = new Floor("cookie-floor") {{ variants = 2; alwaysUnlocked = true; }};

        cookieWall = new StaticWall("cookie-wall") {{
            variants = 3; alwaysUnlocked = true;
            cookieFloor.asFloor().wall = this;
        }};
        chocolateCookieWall = new StaticWall("chocolate-cookie-wall") {{ variants = 2; alwaysUnlocked = true; }};
        depletedCookieWall = new StaticWall("depleted-cookie-wall") {{ variants = 2; alwaysUnlocked = true; }};

        cookieBoulder = new Prop("cookie-boulder") {{
            variants = 1; alwaysUnlocked = true;
            cookieFloor.asFloor().decoration = this;
        }};
        chocolateCookieBoulder = new Prop("chocolate-cookie-boulder") {{ variants = 1; alwaysUnlocked = true; }};
        depletedCookieBoulder = new Prop("depleted-cookie-boulder") {{ variants = 1; alwaysUnlocked = true; }};

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
            size = 2; tier = 3; drillTime = 300f; alwaysUnlocked = true;
        }};

        cookieOven = new GenericCrafter("cookie-oven") {{
            requirements(Category.crafting, with(CandylandItems.pilonciyo, 35));
            size = 3;
            health = 500;
            craftTime = 72f;
            hasPower = true;
            hasItems = true;
            itemCapacity = 20;
            craftEffect = Fx.smeltsmoke;
            consumePower(0.50f);
            consumeItems(with(
                CandylandItems.dough, 1,
                CandylandItems.whitePowder, 2,
                CandylandItems.chocolateChip, 3
            ));
            outputItem = new ItemStack(CandylandItems.cookie, 3);
            drawer = new DrawMulti(
                new DrawDefault(),
                new DrawFlame(arc.graphics.Color.valueOf("ffc66e"))
            );
            alwaysUnlocked = true;
        }};
    }
}
