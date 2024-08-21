import java.util.Scanner;

public class Game {
	Scanner scan = new Scanner(System.in);
	Player player;
	Location location;
	public void login() {
		System.out.println("Macera Oyununa Hoşgeldiniz");
		System.out.print("Oyuna Başlamadan Önce İsminizi Giriniz: ");
		String playerName = scan.nextLine();
		System.out.println("Merhaba! " + playerName);
		player = new Player(playerName);
		player.selectChar();
		start();
	}
	
	public void start() {
		while(true) {
			System.out.println();
			System.out.println("==============================================");
			System.out.println();
			System.out.println("Eylem gerçekleştirmek için lütfen bir yer seçiniz.");
			System.out.println("1- Güvenli Ev --> Size ait güvenli bir mekandır düşman bulunmaz.");
			System.out.println("2- Mağara --> Karşınıza zombi çıkabilir.");
			System.out.println("3- Orman --> Karşınıza vampir çıkabilir.");
			System.out.println("4- Nehir --> Karşınıza ayı çıkabilir.");
			System.out.println("5- Mağaza --> Silah veya zırh alabilirsiniz.");
			System.out.print("Gitmek istediğiniz yeri seçiniz: ");
			int selLoc = scan.nextInt();
			while(selLoc <1 || selLoc >5) {
				System.out.println("Lütfen geçerli bir alan seç.");
				selLoc = scan.nextInt();
				break;
			}
			 switch(selLoc) {
			 case 1:
				 location = new SafeHouse(player);
				 break;
			 case 2: 
				 location = new Cave(player);
				 break;
			 case 3:
				 location = new Forest(player);
				 break;
			 case 4:
				 location = new River(player);
				 break;
			 case 5:
				 location = new ToolStore(player);
				 break;
				 default :
					 location = new SafeHouse(player);
			 }
			 if(location.getClass().getName().equals("SafeHouse")) {
				 if(player.getInv().isFirefood() && player.getInv().isFood() && player.getInv().isWater()) {
					 System.out.println("Tebrikler Oyunu Kazandınız. !!");
					 break;
				 }
				 
			 }
			 if(!location.getLocation()) {
				 System.out.println("Oyun Bitti !");
				 break;
			 }

			 
		}
	}
	
}
