import java.util.ArrayList;
import java.util.HashMap;


public class Game {

    // Зарегистрированные игроки

    HashMap<String, Player> players = new HashMap<>();


    public void register(Player player) {

        players.put(player.name, player);

    }


    // Проверка регистрации, вывод ошибки, сравнение силы
    public int round(String playerName1, String playerName2) {

        Player player1 = players.get(playerName1);
        Player player2 = players.get(playerName2);

        if (player1 == null) {
            throw new NotRegisteredException(playerName1);
        } else if (player2 == null) {
            throw new NotRegisteredException(playerName2);

        } else if (player1.getStrength() == player2.getStrength()) {
            return 0;
        } else if (player1.getStrength() > player2.getStrength()) {
            return 1;
        }
        return 2;

    }

}
