package org.patrol.client;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class PatrolServer {

    @Getter
    private static List<String> players = new ArrayList<>();

    private static int playerNum = 0;
    public static void tpNext() {
        if (players.isEmpty()) {
            PatrolClient.sendClientMSG("Для начала обновите список игроков.");
            return;
        }

        if (playerNum + 1 < players.size()) {
            playerNum++;
        } else {
            playerNum = 0;
        }

        tp(playerNum);
    }

    public static void tpPrev() {
        if (players.isEmpty()) {
            PatrolClient.sendClientMSG("Для начала обновите список игроков.");
            return;
        }

        if (playerNum == 0) {
            playerNum = players.size() - 1;
        } else {
            playerNum--;
        }

        tp(playerNum);
    }

    public static void tpThis() {
        if (players.isEmpty()) {
            PatrolClient.sendClientMSG("Для начала обновите список игроков.");
            return;
        }

        PatrolClient.sendClientMSG("Вы были телепортированы к "
                + players.get(playerNum) + "(" + playerNum +" из " + players.size() + ")");

        tp(playerNum);
    }

    public static void updatePlayerList() {
        PatrolClient.sendClientMSG("Вы обновили список игроков.");

        players = PatrolClient.getOnlinePlayers();
    }

    public static String getThisName() {
        if (players.isEmpty()) {
            PatrolClient.sendClientMSG("Для начала обновите список игроков.");
            return "Ja Eblan";
        }

        return players.get(playerNum);
    }

    private static void tp(int num) {
        final String playerName = players.get(num);

        PatrolClient.sendCMD("tp " + playerName);
    }
}
