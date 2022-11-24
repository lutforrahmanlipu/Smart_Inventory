


public class food extends Product  {
	
	private int productNumber;
	private String productName;
	private int productStock;
	private double productPrice;
	private boolean productStatus;
	
	
	public food( int productNumber, String productName ,int productstock, double productprise,boolean productstatus ) {
	}  
	{	
	
	this.setProductNumber(productNumber);
	this.setProductName(productName);
	this.setProductStock(productStock);
	this.setProductPrice(productPrice);
}

//Return the current value of the product number

public int getProductNumber() {
	return productNumber;
}
//change the current value of the product number

public void setProductNumber(int productNumber) {
	this.productNumber = productNumber;
}

//Return the current value of productName

public String getProductName() {
return productName;
}
//change the current value of ProductName
public void setProductName(String productName) {
this.productName = productName;
}
//Return the current value of productStock
public int getProductStock() {
return productStock;
}
//change the current value of productStock
public void setProductStock(int productStock) {
this.productStock = productStock;
}
//Return the current value of productprice
public double getProductPrice() {
return productPrice;
}
//Change the current value of productprice
public void setProductPrice(double productPrice) {
this.productPrice = productPrice;
}

public boolean isProductStatus() {
return productStatus;
}

public void setProductStatus(boolean productStatus) {
this.productStatus = productStatus;
}

public double inventoryvalue(int Productstock, double productprice)
{
	return  Productstock *  productprice *1.05;
	
}
//Gets data about Product in string form
public String toString() {
String temporary;
if(productStatus == false) {
	temporary = "Discontinued";}
else {temporary ="Active";
	
}
return ("\nProduct Number: " + productNumber +"\nProduct Name: " + productName +"\nProduct Stock: " + productStock +"\nProduct Price: " + productPrice +"\nProduct Stock Value: " + getStockValue() +"\nProduct Status: " + temporary +"\n");
}
}

