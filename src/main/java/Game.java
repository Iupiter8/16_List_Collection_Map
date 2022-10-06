import java.util.ArrayList;



public class Game {

    // Зарегистрированные игроки
    ArrayList<Player> players = new ArrayList<>();

    public void register(Player player) {

        players.add(player);

    }


    // Проверка регистрации, вывод ошибки, сравнение силы
    public int round(String playerName1, String playerName2) {
        Player player1 = null;
        Player player2 = null;

        for (Player player : players) {
            if (player.getName().equals(playerName1)) {
                player1 = player;
            }
            if (player.getName().equals(playerName2)) {
                player2 = player;
            }
        }

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
