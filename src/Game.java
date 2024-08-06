import java.util.Scanner;

public class Game {
	Scanner scan = new Scanner(System.in);
	Player player;
	Location location;
	public void login() {
		System.out.println("Macera Oyununa Hoşgeldiniz");
		System.out.print("Oyuna Başlamadan Önce İsminizi Giriniz: ");
		String playerName = scan.nextLine();
		player = new Player(playerName);
		player.selectChar();
	}
}
