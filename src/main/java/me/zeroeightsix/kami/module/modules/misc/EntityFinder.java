//LittleDraily#3718
package me.zeroeightsix.kami.module.modules.misc;

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

@Module.Info(name = "EntityFinder", category = Module.Category.MISC, description = "Finds you a entity!")
public class EntityFinder extends Module {
    private Setting<Boolean> Llama = register(Settings.b("Llama", false));
    private Setting<Boolean> Donkey = register(Settings.b("Donkey", false));



    @Override
    public void onUpdate() {
        if (mc.player == null) return;

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




        }
    }


            @Override
            public void onEnable () {

            }

        }
