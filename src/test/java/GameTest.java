import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class GameTest {


    Game game = new Game();
    Player player1 = new Player(1, "Lika", 100);
    Player player2 = new Player(2, "Kira", 100);
    Player player3 = new Player(3, "Dimok", 91);

    @BeforeEach
    public void setup() {
        game.register(player1);
        game.register(player2);
        game.register(player3);
    }


    @Test
    public void shouldRoundOneStrongerTwo() {

        int expected = 1;
        int actual = game.round("Lika", "Dimok");

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void shouldRoundTwoStrongerOne() {

        int expected = 2;
        int actual = game.round("Dimok", "Lika");

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void shouldRoundIdentical() {

        int expected = 0;
        int actual = game.round("Lika", "Kira");

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void shouldRoundOneInvalidRegistered() {

        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Sparta", "Kira"));
    }

    @Test
    public void shouldRoundSecondInvalidRegistered() {

        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Lika", "Tulip"));
    }

    @Test
    public void shouldRoundBothInvalidRegistered() {

        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Sparta", "Tulip"));
    }


}