//package Product;

public class Product {

	private int productNumber;
	private String productName;
	private int productStock;
	private double productPrice;
	private boolean productStatus = true;
	
	public Product() {
		
	}
	
	//default constructor
	public Product(int tempProductNumber, String tempProductName, int prodcutStock, double tempProductPrice, boolean tempProductStatus) {
		setProductNumber(0);
		setProductName("");
		setProductStock(0);
		setProductPrice(0);
	}

	//getter and setter
	
	public int getProductNumber() {
		return productNumber;
	}

	public void setProductNumber(int productNumber) {
		this.productNumber = productNumber;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getProductStock() {
		return productStock;
	}

	public void setProductStock(int productStock) {
		this.productStock = productStock;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public boolean isProductStatus() {
		return productStatus;
	}

	public void setProductStatus(boolean productStatus) {
		this.productStatus = productStatus;
	}
	
	//Gets data about Product in string form
	public String toString() {
		String temporary;
		if(productStatus == false) {
			temporary = "Discontinued";}
		else {temporary ="Active";
			
		}
		return ("\nProduct Number: " + productNumber +
				"\nProduct Name: " + productName +
				"\nProduct Stock: " + productStock +
				"\nProduct Price: " + productPrice +
				"\nProduct Stock Value: " + getStockValue() +
				"\nProduct Status: " + temporary +
				"\n");
		}
	
	//Calculate the value of the stock
	public double getStockValue() {
		return productPrice * (double)productStock;
	}

	
	//function to add stock
	public void addToInventory(int updateValue) {
		if(this.productStatus==false) {
			System.out.println("This product is discontinued");
		}else {
			this.productStock = productStock + updateValue;
		}
		
	}

	//function to deduct stock
	public void deductFromInventory(int updateValue) {
		if(this.productStatus==false) {
			System.out.println("This product is discontinued");
		}else {
			this.productStock = productStock - updateValue;
		
	}
	}
	
}
