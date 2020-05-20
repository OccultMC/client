//love2004
package me.zeroeightsix.kami.module.modules.experimental;

import me.zeroeightsix.kami.module.Module;
import me.zeroeightsix.kami.setting.Setting;
import me.zeroeightsix.kami.setting.Settings;

@Module.Info(name = "Spider",category = Module.Category.EXPERIMENTAL,description = "Spidery Things")
public class Spider extends Module {

    private final Setting<Float> speed = register(Settings.floatBuilder("Speed").withMinimum(0f).withValue(0.2f).withMaximum(1f));

    public void onUpdate() {
        if (mc.player.collidedHorizontally) {
            mc.player.motionY = speed.getValue();
        }
    }
}