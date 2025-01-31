import java.util.Scanner;

public class ToolStore extends normalLoc{
	Scanner scan = new Scanner(System.in);
	ToolStore(Player player) {
		super(player, "Mağaza");

	}
	public boolean getLocation() {
		System.out.println("Para: " + player.getMoney());
		System.out.println("1.Silahlar: ");
		System.out.println("2.Zırhlar: ");
		System.out.println("3.Çıkış: ");
		System.out.print("Seçiminiz: ");
		int selTool = scan.nextInt();
		int selItemID;
		switch(selTool) {
		case 1: 
			selItemID = weaponMenu();
			buyWeapon(selItemID);
			break;
		case 2: 
			selItemID = armorMenu();
			buyArmor(selItemID);
			
			break;
		default:
			
			break;
		}
		return true;
	}
	public int armorMenu() {
		System.out.println("1.Hafif Zırh\t <Koruma: 1 - Fiyat: 15>");
		System.out.println("2.Orta Zırh\t <Koruma: 3 - Fiyat: 25>");
		System.out.println("3.Ağır Zırh\t <Koruma: 5 - Fiyat: 40>");
		System.out.println("4.Çıkış");
		System.out.println("Zırh Seçiniz: ");
		int selArmorID = scan.nextInt();
		return selArmorID;
	}
	public void buyArmor(int itemID) {
		int avoid = 0, price = 0;
		String aName = null;
		switch(itemID) {
		case 1:
			avoid = 1;
			price = 15;
			aName = "Hafif Zırh";
			break;
		case 2:
			avoid = 3;
			price = 25;
			aName = "Orta Zırh";
			break;
		case 3:
			avoid = 5;
			price = 40;
			aName = "Ağır Zırh";
			break;
		case 4:
			System.out.println("Çıkış Yapılıyor..");
			break;
			default:
				System.out.println("Geçersiz İşlem. !");
				break;
		}
		if(price > 0) {
			if(player.getMoney() >= price) {
				player.getInv().setArmor(avoid);
				player.getInv().setaName(aName);
				player.setMoney(player.getMoney() - price);
				System.out.println(aName + " Zırhını satın aldınız, engellenen hasar: " + player.getInv().getArmor());
				System.out.println("Kalan Para: " + player.getMoney());
				}
		}
	}
	public int weaponMenu() {
		System.out.println("1.Tabanca\t <Fiyat: 25 - Hasar: 2>");
		System.out.println("2.Kılıç \t <Fiyat: 35 - Hasar: 3>");
		System.out.println("3.Tüfek \t <Fiyat: 45 - Hasar: 7>");
		System.out.println("4. Çıkış yap");
		System.out.print("Silah seçiniz: ");
		int selWeaponID = scan.nextInt();
		return selWeaponID;
	}
	public void buyWeapon(int itemID) {
		int damage = 0, price = 0;
		String wName = null;
		switch(itemID) {
		case 1: 
			damage = 2;
			wName = "Tabanca";
			price =  25;				
			break;
		case 2:
			damage = 3;
			wName = "Kılıç";
			price = 35;
		case 3 :
			damage = 7;
			wName = "Tüfek";
			price = 45;
			break;
		case 4:
			System.out.println("Çıkış yapılıyor.");
			break; 	
			default:
			System.out.println("Geçersiz İşlem! ");
			break;
		}
		if(price > 0) {
			if(player.getMoney() >= price) {
				player.getInv().setDamage(damage);
				player.getInv().setwName(wName);
				player.setMoney(player.getMoney() - price);
				System.out.println(wName + " satın aldınız, önceki hasar: " + player.getDamage() + "Yeni hasar: "
						+ player.getTotalDamage());
				System.out.println("Kalan para: " + player.getMoney());
			}else {
				System.out.println("Yetersiz Bakiye! ");
			}

			
		}
	}
	
}
