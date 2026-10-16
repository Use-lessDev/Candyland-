package candyland.content;

import arc.graphics.*;
import arc.math.geom.*;
import arc.util.noise.*;
import candyland.maps.planet.CookiePlanetGenerator;
import mindustry.content.*;
import mindustry.graphics.g3d.*;
import mindustry.maps.generators.*;
import mindustry.type.*;
import mindustry.world.meta.*;

public class CandylandPlanets {
    public static Planet cookie;

    public static void load() {
        cookie = new Planet("cookie", Planets.sun, 0.55f, 1) {{
            generator = new CookiePlanetGenerator();
            meshLoader = () -> new HexMesh(this, 4);
            cloudMeshLoader = () -> new MultiMesh(
                new HexSkyMesh(this, 1, 0.15f, 0.28f, 5, Color.valueOf("87ceeb").a(0.9f), 2, 0.45f, 1.0f, 0.4f),
                new HexSkyMesh(this, 2, 0.30f, 0.32f, 5, Color.valueOf("ffd700").a(0.85f), 2, 0.42f, 1.1f, 0.42f),
                new HexSkyMesh(this, 3, 0.45f, 0.36f, 5, Color.valueOf("ff4500").a(0.8f), 2, 0.40f, 1.2f, 0.44f)
            );

            atmosphereColor = Color.valueOf("d2691e");
            iconColor = Color.valueOf("cd853f");
            landCloudColor = Color.valueOf("daa520").a(0.5f);
            atmosphereRadIn = 0.02f;
            atmosphereRadOut = 0.22f;

            startSector = 0;
            alwaysUnlocked = true;
            accessible = true;
            visible = true;

            allowLaunchToNumbered = false;
            allowWaves = false;
            allowSectorInvasion = false;
            allowSelfSectorLaunch = false;
            allowLaunchLoadout = false;
            allowLaunchSchematics = false;

            defaultEnv = Env.terrestrial | Env.oxygen;
            tidalLock = false;
            orbitSpacing = 6f;
            orbitRadius = 35f;

            ruleSetter = r -> {
                r.waveTeam = mindustry.game.Team.crux;
                r.placeRangeCheck = false;
            };

            unlockedOnLand.addAll(
                CandylandItems.cookie, CandylandItems.dough,
                CandylandItems.chocolateChip, CandylandItems.whitePowder,
                CandylandBlocks.cookieDefenseWall, CandylandBlocks.cookieDefenseWallLarge,
                CandylandBlocks.cookieDrill
            );
        }};
    }
}