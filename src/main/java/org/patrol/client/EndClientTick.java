package org.patrol.client;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

public class EndClientTick implements ClientTickEvents.EndTick {

    @Override
    public void onEndTick(MinecraftClient client) {
        if (PatrolClient.getPlayer() == null) {
            PatrolClient.setPlayer(client.player);
        }

        if (NEXT_PLAYER.wasPressed()) {
            PatrolServer.tpNext();
        } else if (PREV_PLAYER.wasPressed()) {
            PatrolServer.tpPrev();
        } else if (THIS_PLAYER.wasPressed()) {
            PatrolServer.tpThis();
        } else if (UPDATE_PLAYERS_LIST.wasPressed()) {
            PatrolServer.updatePlayerList();
        } else if (CMD_CHECKACCOUNT.wasPressed()) {
            PatrolClient.sendCMD("checkaccount " + PatrolServer.getThisName());
        } else if (CMD_DUPEIP.wasPressed()) {
            PatrolClient.sendCMD("dupeip " + PatrolServer.getThisName());
        } else if (CMD_MFREEZE.wasPressed()) {
            PatrolClient.sendCMD("mfreeze " + PatrolServer.getThisName());
        } else if (CMD_SEEN.wasPressed()) {
            PatrolClient.sendCMD("seen " + PatrolServer.getThisName());
        } else if (CMD_RFIND.wasPressed()) {
            PatrolClient.sendCMD("rfind " + PatrolServer.getThisName());
        } else if (CMD_BAN_30.wasPressed()) {
            PatrolClient.sendCMD("ipban " + PatrolServer.getThisName() + " 30d читы(видео)");
        } else if (CMD_BAN_15.wasPressed()) {
            PatrolClient.sendCMD("ipban " + PatrolServer.getThisName() + " 15d признание в читах");
        }
    }

    private static final KeyBinding NEXT_PLAYER = KeyBindingHelper.registerKeyBinding(new KeyBinding(
            "Телепортация к следуйщему игроку",
            InputUtil.Type.KEYSYM,
            GLFW.GLFW_KEY_RIGHT,
            "SMOD"
    ));

    private static final KeyBinding PREV_PLAYER = KeyBindingHelper.registerKeyBinding(new KeyBinding(
            "Телепортация к предыдущему игроку",
            InputUtil.Type.KEYSYM,
            GLFW.GLFW_KEY_LEFT,
            "SMOD"
    ));

    private static final KeyBinding THIS_PLAYER = KeyBindingHelper.registerKeyBinding(new KeyBinding(
            "Повторная телепортация к игроку",
            InputUtil.Type.KEYSYM,
            GLFW.GLFW_KEY_UP,
            "SMOD"
    ));

    private static final KeyBinding UPDATE_PLAYERS_LIST = KeyBindingHelper.registerKeyBinding(new KeyBinding(
            "Обновить список игроков",
            InputUtil.Type.KEYSYM,
            GLFW.GLFW_KEY_DOWN,
            "SMOD"
    ));

    private static final KeyBinding CMD_CHECKACCOUNT = KeyBindingHelper.registerKeyBinding(new KeyBinding(
            "/checkaccount",
            InputUtil.Type.KEYSYM,
            GLFW.GLFW_KEY_KP_0,
            "SMOD"
    ));

    private static final KeyBinding CMD_DUPEIP = KeyBindingHelper.registerKeyBinding(new KeyBinding(
            "/dupeip",
            InputUtil.Type.KEYSYM,
            GLFW.GLFW_KEY_KP_0,
            "SMOD"
    ));

    private static final KeyBinding CMD_MFREEZE = KeyBindingHelper.registerKeyBinding(new KeyBinding(
            "/mfreeze",
            InputUtil.Type.KEYSYM,
            GLFW.GLFW_KEY_KP_0,
            "SMOD"
    ));

    private static final KeyBinding CMD_SEEN = KeyBindingHelper.registerKeyBinding(new KeyBinding(
            "/seen",
            InputUtil.Type.KEYSYM,
            GLFW.GLFW_KEY_KP_0,
            "SMOD"
    ));

    private static final KeyBinding CMD_RFIND = KeyBindingHelper.registerKeyBinding(new KeyBinding(
            "/rfind",
            InputUtil.Type.KEYSYM,
            GLFW.GLFW_KEY_KP_0,
            "SMOD"
    ));

    private static final KeyBinding CMD_BAN_30 = KeyBindingHelper.registerKeyBinding(new KeyBinding(
            "/ipban player 30d читы(видео)",
            InputUtil.Type.KEYSYM,
            GLFW.GLFW_KEY_KP_0,
            "SMOD"
    ));

    private static final KeyBinding CMD_BAN_15 = KeyBindingHelper.registerKeyBinding(new KeyBinding(
            "/ipban player 15d признание в читах",
            InputUtil.Type.KEYSYM,
            GLFW.GLFW_KEY_KP_0,
            "SMOD"
    ));
}
