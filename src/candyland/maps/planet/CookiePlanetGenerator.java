package candyland.maps.planet;

import arc.graphics.Color;
import arc.math.geom.Vec3;
import arc.util.noise.Simplex;
import candyland.maps.utils.CookieBasicGenerator;
import mindustry.type.Sector;

public class CookiePlanetGenerator extends CookieBasicGenerator {
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