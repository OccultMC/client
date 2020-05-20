//LittleDraily#3718
package me.zeroeightsix.kami.module.modules.experimental;

import me.zeroeightsix.kami.module.Module;
import me.zeroeightsix.kami.setting.Setting;
import me.zeroeightsix.kami.setting.Settings;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.EntityDonkey;
import net.minecraft.entity.passive.EntityLlama;
import net.minecraft.util.math.BlockPos;
import scala.Int;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import static me.zeroeightsix.kami.util.MessageSendHelper.sendChatMessage;

<<<<<<< HEAD:src/main/java/me/zeroeightsix/kami/module/modules/experimental/EntityFinder.java
@Module.Info(name = "EntityFinder", category = Module.Category.EXPERIMENTAL, description = "Finds you a Llama or Donkey!")
=======
@Module.Info(name = "EntityFinder", category = Module.Category.MISC, description = "Finds you a Donkey!")
>>>>>>> 500348eee3ce45508723dffcee3ce91c7e58c3f8:src/main/java/me/zeroeightsix/kami/module/modules/misc/EntityFinder.java
public class EntityFinder extends Module {
    private Setting<Boolean> Llama = register(Settings.b("Llama", false));
    private Setting<Boolean> Donkey = register(Settings.b("Donkey", false));

    private List<String> knownPlayers;
    boolean test = false;

    @Override
    public void onUpdate() {
        if (mc.player == null) return;

        List<Integer> tickPlayerList = new ArrayList<>();

        for (Entity entity : mc.world.getLoadedEntityList()) {
            if(Donkey.getValue().equals(true)){
                if (entity instanceof EntityDonkey) {
                    sendChatMessage("I found a donkey at: " + Math.round(entity.lastTickPosX) + " " + Math.round(entity.lastTickPosY) + " " + Math.round(entity.lastTickPosZ));
                }
            }
            if(Llama.getValue().equals(true)){
                if (entity instanceof EntityLlama) {
                    sendChatMessage("I found a llama at: " + Math.round(entity.lastTickPosX) + " " + Math.round(entity.lastTickPosY) + " " + Math.round(entity.lastTickPosZ));
                }
            }



            if (tickPlayerList.size() > 0) {


            }
        }
    }


            @Override
            public void onEnable () {
                this.knownPlayers = new ArrayList<>();

            }

        }
