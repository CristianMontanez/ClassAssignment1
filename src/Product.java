
public class Product {
	
	private String productName ;
	
	private int productQuantity; 
	
	private double productPrice; 
	
	private String purchaseDate;
	
	private Manufacturer company ; 
	
	
	
	
	public Product (String pname , int quantity , double price ,String purchDate, Manufacturer cname ) 
	{
		productName = pname; 
		productQuantity = quantity; 
		productPrice = price; 
		company = cname; 
		purchaseDate = purchDate;
	}
	
	
	public String getProduct() 
	{
		return productName; 
	}
	
	public void addQuantity(int a) 
	{
		productQuantity += a; 
	}// Increase product quantity  mutator method 
	
	public void subtractQuanity(int s) 
	{
		productQuantity -= s;
	}// Decrease product quantity  mutator method 
	
	public int getQuantity() 
	{
		return productQuantity; 
	}
	
	public void changePrice(double d) 
	{
		productPrice = d; 
	}
	
	public double getPrice() 
	{
		return productPrice; 
	}
	
	public String getPurchaseDate() 
	{
		return purchaseDate;
	}
	
	public Boolean isSufficent(int a) 
	{
		
		return productQuantity >= a;
	}
	
	public Manufacturer getCompany()
	{
		return company; 
	}
	
	
	
	
	
	

}
