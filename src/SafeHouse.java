
public class SafeHouse extends normalLoc{

	SafeHouse(Player player) {
		super(player, "Güvenli ev");
	}
	public boolean getLocation() {
		player.setHealthy(player.getrHealthy());
		System.out.println("Şuan Güvenli Evdesiniz");
		System.out.println("Canınız Doldu.");
		return true;
	}
}
