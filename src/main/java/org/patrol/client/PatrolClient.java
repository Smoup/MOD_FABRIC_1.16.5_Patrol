package org.patrol.client;

import lombok.Getter;
import lombok.Setter;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.network.PlayerListEntry;
import net.minecraft.text.Text;

import java.util.*;

public class PatrolClient implements ClientModInitializer {

    @Getter @Setter
    private static ClientPlayerEntity player;
    /**
     * Runs the mod initializer on the client environment.
     */
    @Override
    public void onInitializeClient() {
        ClientTickEvents.END_CLIENT_TICK.register(new EndClientTick());
    }

    public static List<String> getOnlinePlayers() {
        final Collection<PlayerListEntry> online = Objects.requireNonNull(
                MinecraftClient.getInstance().getNetworkHandler()).getPlayerList();
        final List<String> players = new ArrayList<>();
        for (PlayerListEntry p : online) {
            players.add(p.getProfile().getName());
        }
        return players;
    }

    public static void sendClientMSG(String msg) {
        MinecraftClient.getInstance().inGameHud.getChatHud().addMessage(Text.of(msg));
    }

    public static void sendCMD(String cmd) {
        player.sendChatMessage("/" + cmd);
    }
}
