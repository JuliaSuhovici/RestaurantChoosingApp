

public class RestaurantChoosingApp {
	public static void main(String[] args) {		
		VeganRestaurant.Info.printMenu();
		SushiRestaurant.Info.printMenu();
	}
}

//###################### RESTAURANT CLASSES ##########################
class SuperRestaurant {	
	static class InfoRestaurant {
		static void print(double menuPrice, double specialMenuPrice) {
	    	
	    	System.out.printf("MENU \t\tx 1\tportions  \t%.2f MDL\n", Menu.getPriceMenu(1, Menu.getDiscount(1), menuPrice));
	    	System.out.printf("MENU \t\tx 5\tportions(- %d%%)\t%.2f MDL\n", Menu.getDiscount(5), Menu.getPriceMenu(5, Menu.getDiscount(5),menuPrice));
	    	System.out.printf("SPECIAL MENU \tx 1\tportion \t%.2f MDL\n", Menu.getPriceMenu(1, Menu.getDiscount(1), specialMenuPrice));
	    	System.out.printf("SPECIAL MENU \tx 10\tportions(-%d%%)\t%.2f MDL\n" , Menu.getDiscount(10), Menu.getPriceMenu(10, Menu.getDiscount(10),specialMenuPrice));
	    }
	}
}

class Menu {	
	static int getDiscount(int portions) {
    	int discount = 0;
    	if(portions%5 == 0) 
    		discount = 10 * portions/5;      //ñêèäêà 10% íà êàæäóþ ïÿòóþ ïîðöèþ
    	return discount;
    }
	
    static double getPriceMenu(int portions,int discount, double price) { 	
    	double toPay =portions * price - portions * price*discount/100;
    	return toPay;
    }
}

class VeganRestaurant extends SuperRestaurant {	
	static class Info extends InfoRestaurant {
		static void printName() {
	    	System.out.printf("############## Vegan Pure Restaurant #############\n"); 
	    }
		static void printAddress() {
	    	System.out.printf("--UpTown Str 77/B, Maxicity\t\t\t--\n");
	    }
		
		static void printMenu() {
			printName();
			printAddress();
			print(Menu.getPrice(), SpecialMenu.getPrice());
		}
	}
	
	static class Menu {
		static double getPrice() {
		       return 50.00;
		    }
	}
	
	static class SpecialMenu {
		static double getPrice() {
		       return 100.00;
		    }
	}
}
class SushiRestaurant extends SuperRestaurant {	
	static class Info extends InfoRestaurant {
		static void printName() {
	    	System.out.printf("############## Sushi Mini Restaurant ##############\n"); 
	    }
		static void printAddress() {
	    	System.out.printf("--DownTown Str 88/A, Minicity\t\t\t--\n");
	    }
		static void printMenu() {
			printName();
			printAddress();
			print(Menu.getPrice(), SpecialMenu.getPrice());
		}
	}
	
	static class Menu {
		static double getPrice() {
		       return 100.00;
		    }
	}
	
	static class SpecialMenu {
		static double getPrice() {
		       return 200.00;
		    }
	}
}

