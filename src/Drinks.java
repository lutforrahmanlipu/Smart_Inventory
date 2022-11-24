//package Product;

public class Drinks extends Product{
	private int drinkBatchDate;
	private String drinkManufacturer;
	private String drinkFromCountry;
	
	public Drinks(int productNumber, String productName, int productStock, double productPrice, boolean productStatus, 
			int drinkBatchDate, String drinkManufacturer, String drinkFromCountry) {
		super(productNumber, productName, productStock, productPrice, productStatus);
		this.drinkBatchDate = drinkBatchDate;
		this.drinkManufacturer = drinkManufacturer;
		this.drinkFromCountry = drinkFromCountry;
	}
	
	//getter and setters
	public int getDrinkBatchDate() {
		return drinkBatchDate;
	}
	
	public String getDrinkManufacturer() {
		return drinkManufacturer;
	}
	
	public String getDrinkFromCountry() {
		return drinkFromCountry;
	}
	
	public void setDrinkBatchDate(int x) {
		drinkBatchDate = x;
	}
	
	public void setDrinkManufacturer(String x) {
		drinkManufacturer = x;
	}
	
	public void setDrinkFromCountry(String x) {
		drinkFromCountry = x;
	}
	
	
	//Convert it to toString method
	public String toString() {
		String temporary = "Active";
		if(super.isProductStatus() == false) {
			temporary = "Discontinued";
		}
		return ("\nProduct Number : " + super.getProductNumber() +
				"\nProduct Name : " + super.getProductName() +
				"\nDate : " + drinkBatchDate +
				"\nManufacturer : " + drinkManufacturer +
				"\nOrigin Country : " + drinkFromCountry +
				"\nInstock Quantity : " + super.getProductStock() +
				"\nProduct Price : " + super.getProductPrice() +
				"\nStock Value : " + getStockValue() +
				"\nProduct Status : " + temporary) + "\n";
				
	}
	
}
