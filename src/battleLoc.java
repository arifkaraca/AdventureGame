
public abstract class battleLoc extends Location{
	protected obstacle obstacle;
	protected String award;
	battleLoc(Player player, String name, obstacle obstacle, String award) {
		super(player);
		this.obstacle = obstacle;
		this.name = name ;
		this.award = award;
	}
	
	public boolean getLocation() {
		int obsCount = obstacle.count();
		System.out.println("Şuan buradasınız: " + this.getName() );
		System.out.println("Dikkatli ol! Burada " + obsCount + " tane " + obstacle.getName() + " yaşıyor !");
		System.out.print("<S>avaş veya <K>aç");
		String selCase = scan.nextLine();
		selCase = selCase.toUpperCase();
		if(selCase.equals("S")) {
			if(combat(obsCount)) {
				System.out.println(this.getName() + " bölgesindeki tüm düşmanları temizlediniz.");
				if(this.award.equals("Food") && player.getInv().isFood() == false) {
					System.out.println(this.award + " kazandınız.");
					player.getInv().setFood(true);
				}else if(this.award.equals("Water") && player.getInv().isWater() == false) {
					System.out.println(this.award + " kazandınız.");
					player.getInv().setWater(true);
				}else if(this.award.equals("Firewood") && player.getInv().isFirefood() == false) {
					System.out.println(this.award + " kazandınız.");
					player.getInv().setFirefood(true);
				}
				return true;
			}else {
				
			}
			if(player.getHealthy() <= 0) {
				System.out.println("Öldünüz..!");
				return false;
			}
		}
		
		return true;
	}
	
	public boolean combat(int obsCount) {
		
		for(int i = 0; i < obsCount; i++) {
			int defObsHealth = obstacle.getHealth();
			playerStats();
			enemyStats();
			while(player.getHealthy() > 0 && obstacle.getHealth() > 0) {
				System.out.print("<V>ur veya <K>aç");
				String selCase = scan.nextLine();
				selCase = selCase.toUpperCase();
				if(selCase.equals("V")) {
					System.out.println("Siz Vurdunuz");
					obstacle.setHealth(obstacle.getHealth() - player.getTotalDamage());
					afterHit();
					if(obstacle.getHealth() >  0) {
						System.out.println();
						System.out.println("Canavar Size Vurdu.");
						player.setHealthy(player.getHealthy() - (obstacle.getDamage() - player.getInv().getArmor()));
						afterHit();

					}
				}else {
					return false;
				}
			}
			if(obstacle.getHealth() < player.getHealthy()) {
				System.out.println("Düşmanı Yendiniz. !");
				player.setMoney(player.getMoney() + obstacle.getAward());
				System.out.println("Güncel Paranız: " + player.getMoney());
				obstacle.setHealth(defObsHealth);
				
			}else {
				return false;
				
			}
			System.out.println("---------------------------------------");
		}
		return true;
		
	}
	public void playerStats() {
		System.out.println("Oyuncu Değerleri \n--------------------");
		System.out.println("Can: " + player.getHealthy());
		System.out.println("Hasar: " + player.getTotalDamage());
		System.out.println("Para: " + player.getMoney());
		if(player.getInv().getDamage() > 0 ) {
			System.out.println("Silah: " + player.getInv().getwName());
		}
		if(player.getInv().getArmor() > 0 ) {
			System.out.println("Zırh: " + player.getInv().getaName());
		}
	}
	public void enemyStats() {
			System.out.println(obstacle.getName() + " Değerleri \n -------------------------");
			System.out.println("Can: " + obstacle.getHealth());
			System.out.println("Hasar: " + obstacle.getDamage());
			System.out.println("Ödül: " + obstacle.getAward());
	}
	
	public void afterHit() {
		System.out.println("Oyuncu canı: " + player.getHealthy());
		System.out.println(obstacle.getName() + " Canı: " + obstacle.getHealth());
		System.out.println();
	}
}
