//love2004
package me.zeroeightsix.kami.module.modules.experimental;

import me.zeroeightsix.kami.module.Module;
import me.zeroeightsix.kami.setting.Setting;
import me.zeroeightsix.kami.setting.Settings;

@Module.Info(name = "FOVBrightness",category = Module.Category.EXPERIMENTAL,description = "Changes your fov and Brightness")
public class CustomFOV extends Module
{
        private final Setting<Float> fov = register(Settings.floatBuilder("Value").withMinimum(30f).withValue(110f).withMaximum(360f).withRange(30f,360f));
        private final Setting<Integer> brightness = register(Settings.integerBuilder("Brightness").withMinimum(0).withValue(90).withMaximum(180));

        @Override
        public void onUpdate() {
                mc.gameSettings.fovSetting = fov.getValue();
                mc.gameSettings.gammaSetting = brightness.getValue();
        }
}