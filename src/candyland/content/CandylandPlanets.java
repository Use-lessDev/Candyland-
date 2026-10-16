package candyland.content;

import arc.graphics.*;
import arc.math.geom.*;
import arc.util.noise.*;
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
public static class CookiePlanetGenerator extends BlankPlanetGenerator {
        private static final Color doughLight = Color.valueOf("e8a05a");
        private static final Color doughDark  = Color.valueOf("c17a3a");
        private static final Color chocolate  = Color.valueOf("2a1508");
        private static final Color crack      = Color.valueOf("6b2e0a");

        @Override
        public float getHeight(Vec3 position) {
            float n  = Simplex.noise3d(seed, 6, 0.55, 1.4, position.x, position.y, position.z);
            float n2 = Simplex.noise3d(seed + 10, 4, 0.6, 2.8, position.x * 2.2f, position.y * 2.2f, position.z * 2.2f);
            return Math.max(n * 0.2f + n2 * 0.08f, -0.05f);
        }

        @Override
        public void getColor(Vec3 position, Color out) {
            float chipNoise = Simplex.noise3d(seed + 50, 2, 0.65, 2.8, position.x * 3.2f, position.y * 3.2f, position.z * 3.2f);
            if (chipNoise > 0.52f) { out.set(chocolate); return; }
            float crackNoise = Simplex.noise3d(seed + 80, 3, 0.45, 2.5, position.x * 3.8f, position.y * 3.8f, position.z * 3.8f);
            if (Math.abs(crackNoise) > 0.55f) { out.set(crack); return; }
            float noise = Simplex.noise3d(seed + 20, 4, 0.55, 1.8, position.x * 3.0f, position.y * 3.0f, position.z * 3.0f);
            out.set(noise > 0.12f ? doughDark : doughLight);
        }

        @Override public void generateSector(Sector sector) { sector.generateEnemyBase = false; }
        @Override public boolean allowLanding(Sector sector) { return false; }
        @Override public void getLockedText(Sector hovered, StringBuilder out) { out.append("[orange]Cookie locked[]"); }
    }
