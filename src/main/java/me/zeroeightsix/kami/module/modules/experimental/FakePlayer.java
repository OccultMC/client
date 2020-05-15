//love2004
package me.zeroeightsix.kami.module.modules.experimental;

import com.mojang.authlib.GameProfile;
import me.zeroeightsix.kami.module.Module;
import me.zeroeightsix.kami.setting.Setting;
import me.zeroeightsix.kami.setting.Settings;
import net.minecraft.client.entity.EntityOtherPlayerMP;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Module.Info(name = "FakePlayer", category = Module.Category.EXPERIMENTAL, description = "Spawns a fake Player")
public class FakePlayer extends Module {

    private final Setting<SpawnMode> spawnMode = register(Settings.e("Spawn Mode", SpawnMode.SINGLE));
    private List<Integer> fakePlayerIdList = null;
    private static final String[][] fakePlayerInfo;

    @Override
    protected void onEnable() {
        if (mc.player == null || mc.world == null) {
            disable();
            return;
        }
        fakePlayerIdList = new ArrayList<>();
        int entityId = -101;
        for (String[] data : fakePlayerInfo) {
            if (spawnMode.getValue().equals(SpawnMode.SINGLE)) {
                addFakePlayer(data[0], data[1], entityId, 0, 0);
                break;
            }
            addFakePlayer(data[0], data[1], entityId, Integer.parseInt(data[2]), Integer.parseInt(data[3]));
            --entityId;
        }
    }

    private void addFakePlayer(String uuid, String name, int entityId, int offsetX, int offsetZ) {
        EntityOtherPlayerMP fakePlayer = new EntityOtherPlayerMP(mc.world, new GameProfile(UUID.fromString(uuid), name));
        fakePlayer.copyLocationAndAnglesFrom(mc.player);
        fakePlayer.posX += offsetX;
        fakePlayer.posZ += offsetZ;
        mc.world.addEntityToWorld(entityId, fakePlayer);
        fakePlayerIdList.add(entityId);
    }

    @Override
    public void onUpdate() {
        if (fakePlayerIdList == null || fakePlayerIdList.isEmpty()) {
            disable();
        }
    }

    @Override
    protected void onDisable() {
        if (mc.player == null || mc.world == null) {
            return;
        }
        if (fakePlayerIdList != null) {
            for (int id : fakePlayerIdList) {
                mc.world.removeEntityFromWorld(id);
            }
        }
    }

    static {
        fakePlayerInfo = new String[][] { { "7703fa95-9a9d-4947-b2ae-ab7d30e2d995", "love2004", "-3", "0" }, { "7703fa95-9a9d-4947-b2ae-ab7d30e2d995", "love2004", "0", "-3" }, { "7703fa95-9a9d-4947-b2ae-ab7d30e2d995", "love2004", "3", "0" }, { "7703fa95-9a9d-4947-b2ae-ab7d30e2d995", "love2004", "0", "3" }, { "7703fa95-9a9d-4947-b2ae-ab7d30e2d995", "love2004", "-6", "0" }, { "7703fa95-9a9d-4947-b2ae-ab7d30e2d995", "love2004", "0", "-6" }, { "7703fa95-9a9d-4947-b2ae-ab7d30e2d995", "love2004", "6", "0" }, { "7703fa95-9a9d-4947-b2ae-ab7d30e2d995", "love2004", "0", "6" }, { "7703fa95-9a9d-4947-b2ae-ab7d30e2d995", "love2004", "-9", "0" }, { "7703fa95-9a9d-4947-b2ae-ab7d30e2d995", "love2004", "0", "-9" }, { "7703fa95-9a9d-4947-b2ae-ab7d30e2d995", "love2004", "9", "0" }, { "7703fa95-9a9d-4947-b2ae-ab7d30e2d995", "love2004", "0", "9" } };
    }

    private enum SpawnMode
    {
        SINGLE,
        MULTI
    }
}
