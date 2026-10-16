package candyland.world.blocks.production;

import arc.*;
import arc.graphics.g2d.*;
import mindustry.graphics.*;
import mindustry.world.blocks.production.*;

public class DrillButButtonItemSprite extends Drill {

    public DrillButButtonItemSprite(String name) {
        super(name);
        drawMineItem = true;
    }

    @Override
    public void loadIcon() {
        fullIcon = uiIcon = Core.atlas.find(name + "-full", Core.atlas.find(name));
    }

    public class DrillButButtonItemSpriteBuild extends DrillBuild {
        @Override
        public void draw() {
            if (dominantItem != null && drawMineItem) {
                Draw.color(dominantItem.color);
                Draw.rect(itemRegion, x, y);
                Draw.color();
            }

            Draw.rect(region, x, y);
            Draw.z(Layer.blockCracks);
            drawDefaultCracks();
            Draw.z(Layer.blockAfterCracks);

            if (drawRim) {
                Draw.color(heatColor);
                Draw.alpha(warmup * 0.6f * (1f - 0.3f + arc.math.Mathf.absin(arc.util.Time.time, 3f, 0.3f)));
                Draw.blend(arc.graphics.Blending.additive);
                Draw.rect(rimRegion, x, y);
                Draw.blend();
                Draw.color();
            }

            if (drawSpinSprite) {
                Drawf.spinSprite(rotatorRegion, x, y, timeDrilled * rotateSpeed);
            } else {
                Draw.rect(rotatorRegion, x, y, timeDrilled * rotateSpeed);
            }

            Draw.rect(topRegion, x, y);
        }
    }
}
