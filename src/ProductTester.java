//package Product;
import java.util.Scanner;
import java.util.InputMismatchException;
public class ProductTester {

	//Static Method to show details of product.
	public static void displayInventory(Product[] products) {
		int i = 0;
		for (Product temp : products) {
			System.out.println(products[i].toString());
			i++;
		}
	}
	
	//Main
	public static void main(String[]args) {
		Scanner in = new Scanner(System.in);
		int maxSize = getNumberOfProducts(in);
		int menuOption;
		
		if(maxSize ==0) {
			System.out.println("No product required");
			System.exit(0);
		}
		else {
			Product[] products = new Product[maxSize];
			ProductTester.addNewProduct(in, products);
			do {
				menuOption = ProductTester.getMenuOption(in);
				ProductTester.executeMenuOption(menuOption, in, products);
			}while(menuOption != 5);
		}
		in.close();
	}

	//Static Method to ask user for number of products
	public static int getNumberOfProducts(Scanner in) {
				int maxSize = -1;
				System.out.println("Enter the number of products you would like to add\n" + 
									"Enter 0 if you do not wish to add products");
				
				do {
					try {
						maxSize = in.nextInt();
						if(maxSize < 0 ) {
							System.out.println("Incorrect value entered");}
						}
					catch(InputMismatchException e) {
						System.out.println("Incorrect data type entered");
						in.nextLine();
				}
			}while(maxSize < 0);
				return maxSize;
			}


	//Static Method to ask user for the details of each product to be added
	public static void addNewProduct(Scanner in, Product[] products) {
		int tempProductNumber = 0;
		String tempProductName = "";
		int tempProductQuantity = 0;
		double tempProductPrice = 0;
		
		for(int i = 0 ; i < products.length; i++) {
			products[i] = new Product();
			System.out.println("FOR PRODUCT "+(i));
			
			System.out.println("Enter item Number: ");
			tempProductNumber = in.nextInt();
			products[i].setProductNumber(tempProductNumber);
			
			System.out.println("Enter item Name: ");
			in.nextLine();
			tempProductName = in.nextLine();
			products[i].setProductName(tempProductName);
			
			System.out.println("Enter item quantity: ");
			tempProductQuantity = in.nextInt();
			products[i].setProductStock(tempProductQuantity);
			
			
			System.out.println("Enter item price: ");
			tempProductPrice = in.nextInt();
			products[i].setProductPrice(tempProductPrice);;
			
		}
	}

	//Static Method to display menu and return values of the option selected
	public static int getMenuOption(Scanner in) {
		int temp = -1;
		System.out.println("---------Menu---------" );
		System.out.println("1. View Inventory\n" +
							"2. Add stock\n" +
							"3. Detuct Stock\n" +
							"4. Discontinue Product\n" +
							"5. Exit\n" );
		
		do {
			try {
				temp = in.nextInt();
				if((temp <6) && (temp>0)) {
					break;}
				else {
					System.out.println("Incorrect value entered");
				}}
				catch(InputMismatchException e) {
					System.out.println("Incorrect data type entered");
					in.nextLine();
				}
			}
		while(true);
		return temp;
	}
	
	
	//Static Method for execute the menu option selected
	public static void executeMenuOption(int menuOption, Scanner in, Product[] products) {
		
		switch(menuOption){
			
		case 1:
			ProductTester.displayInventory(products);
			break;
		case 2:
			ProductTester.addInventory(in, products);
			break;
		case 3:
			ProductTester.deductInventory(in, products);
			break;
		case 4:
			ProductTester.discontinueProduct(in, products);
			break;
		case 5:
			System.out.println("Thank you for using this system.");
		}
	}
	
	//Static Method to ask user for which product for editing its stock
	public static int getProductNumberForEditStock(Scanner in, Product[] products) {
		int productChoice = -1;
		System.out.println("Choose a product for editing its stocks");
		for (int i = 0 ; i < products.length ; i++) {
			System.out.println("Product "+ i + ":" + products[i].getProductName());
		}
		do {
			try {productChoice = in.nextInt();
					if((productChoice < products.length) && (-1 < productChoice)) {
						break;}
		
			else {
				System.out.println("Incorrect value entered");
			}
			}
			catch(InputMismatchException e) {
				System.out.println("Incorrect data type entered");
				in.nextLine();
			}
	}while(true);
		return productChoice;
	}
	
	//Static Method to ask user for which product for adding its stock
	public static void addInventory(Scanner in, Product[] products) {
		int productChoice = ProductTester.getProductNumberForEditStock(in, products);
		int updateValue = -1;
		System.out.println("Enter the amount of stock to be added");
		do {
			try {
				updateValue = in.nextInt();
				if(updateValue >= 0) {
					break;
				}
				else {
					System.out.println("Invalid value entered");}
				}
			catch(InputMismatchException e) {
				System.out.println("Please enter a valid data type");
				in.nextLine();
			}
		}while(true);
			
	products[productChoice].addToInventory(updateValue);
		
		
	}

	//Static Method to ask user for which product for deducting its stock
	public static void deductInventory(Scanner in, Product[] products) {
		int productChoice = ProductTester.getProductNumberForEditStock(in, products);
		int updateValue = -1;
		System.out.println("Entered the amount of stock to be detucted");
		do {
			try {
				updateValue = in.nextInt();
				if((0 <= updateValue) && (updateValue <=products[productChoice].getProductStock())){
					break;}
				else {
					System.out.println("Incorrect value entered");}
				}
			catch(InputMismatchException e) {
				System.out.println("Incorrect data type entered");
				in.nextLine();
			}
		}while(true);
		products[productChoice].deductFromInventory(updateValue);
		
	}

	//Static Method for user to choose which product to be discontinued
	public static void discontinueProduct(Scanner in, Product[] products) {
		int productChoice;
		productChoice = getProductNumberForEditStock(in, products);
		products[productChoice].setProductStatus(false);
		
	}
}
