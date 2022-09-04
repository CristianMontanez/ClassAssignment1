import java.text.DateFormat;
import java.util.Date;
import java.text.NumberFormat;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.util.ArrayList;
import javax.swing.JTable;


public class testerClass {

	public static void main(String[] args) {
		
		ProductDatabase pb = new ProductDatabase();// Database for active products 
		ProductDatabase deleted = new ProductDatabase();// database for deleted products 
		Date now = new Date();
		Boolean done = false ; 
		
		
		
		while (!done)
		{
			String menu = getData.getString("\t Welcome to the ABC Enterprise product database \n"+ " \t \nPlease choose one of the following options\n"+"\n"+ "(1)- Add product to database\n" + "(2)- Search for product in database\n" +"(3)- Enter a sale or reorder of a product\n"+ "(4)- Update cost of a product\n"+ "(5)- Delete product from active database");
			
			
			
			
			switch(menu) 
			{
			
			case "1": // creating a product & storing in a product database
				
				String state = getData.getString("Enter company state location"); // creating variable to store in Address object
				
				String manu = getData.getString("Enter company name"); // creating variable to store in MANUFACTURER object 
				
				Address addr = new Address(state); // Created ADDRESS object & stored STATE variable in it. 
				
				Manufacturer m = new Manufacturer(manu , addr); // Created MANUFACTURER object & stored MANUFACTURER variable in it & ADDRESS object in it 
				
				String itemname = getData.getString("Enter name of the product");
				int itemquantity= getData.getInt("Enter product quantity amount");
				double itemcost= getData.getDouble("Enter product unit price");
				String purchaseDate = getData.getString("Enter the date of purchase");
			    Product p = new Product (itemname, itemquantity, itemcost, purchaseDate,m); // Stored ADDRESS (OBJECT) , MANUFACTURER (OBJECT) & PRODUCT variables in PRODUCT object 
				// Created variables for PRODUCT class object 
				pb.addProduct(p); // added product object to PRODUCT DATABASE object ;
				
				break;
			
			case "2" : // product search option 
				
				String menuChoice = getData.getString("(1)- Locate a single product item \n" + "(2)- Print active database inventory reprot \n" + "(3)- Print deleted products inventory report");
				
				
				
				
				switch(menuChoice)
					
				 {
				
					case "1" : 
						
					 // create Product object to call methods from product. 
						
						itemname = getData.getString("Please enter the product name you wish to view");
						pb.search(itemname);
					
					if (! pb.inList() )
							
							JOptionPane.showMessageDialog(null, "no product or no database for product found ");
					else {
						
					Product po = pb.getProduct();
					
					String  str = "\tProduct Information\n" + "\n"+ "\n" + "(Product Name): "+ po.getProduct()+"\n" + "(Product Cost): "+  "$" + po.getPrice() +"\n"+ " "  +"(Quantity):" + po.getQuantity();
					
					display(str , "Product Database" , JOptionPane.INFORMATION_MESSAGE);
					
					
					}
					
					break; // Leave breaks before Case , outside of current case brackets , 
					case "2" :
						
						// Create Inventory report for active products 
						
						ArrayList list = pb.getList();
						
						if (list.isEmpty())
							JOptionPane.showMessageDialog(null, "Product inventory list is empty");
						
						else {
					 
						
						int i = 0 , length = pb.getSize();
						
						String s = "";
						
						while(i < length) 
						{
							Product pr =  (Product)list.get(i);
							
							s = s + pr.getProduct() + "\t" +pr.getPurchaseDate()+ "\t" + pr.getQuantity() +"\t" + "$" + pr.getPrice() +"\t"+ pr.getCompany().getName() +"\t" +pr.getCompany().getAddress().getState() + "\n";
							
							i++;
						}
						display (s ," Product  Purchase Date   Quantity   Price  Manufacturer  State" , JOptionPane.INFORMATION_MESSAGE);
						 
						}
						break;
						
						
					case "3":  // List for deleted products 
						
						ArrayList delete = pb.getList();
						
						if (delete.isEmpty())
							
							JOptionPane.showMessageDialog(null, "Deleted product inventory list is empty");
						
						else 
						{
							int i =0 , length = pb.getSize();
							
							String s ="";
							
							while (i < length) 
							{
								Product pdelete = (Product)delete.get(i);
								
								s = s + pdelete.getProduct() +"\t"+pdelete.getPurchaseDate()+ "\t" + pdelete.getCompany().getName();
								
								i++;
								
							}
							
							display(s, "\t Product \t Date \t Manufacturer", JOptionPane.INFORMATION_MESSAGE);
			
						}
						break; 
						
						default :
							
							JOptionPane.showMessageDialog(null, "User selction not valid");
						break;
					}
					break;
					
				
				
			case "3" : // Product sale & product re order option screen 
				
				itemname = getData.getString("Enter name of the product");
				pb.search(itemname);
				
				if(!pb.inList())
					JOptionPane.showMessageDialog(null, "Account not found :(");
				
				else 
				{
					int submenu =getData.getInt("(1)- Re-order Product" + "(2)- Product sale");
					
					switch(submenu) 
					{
					case 1: 
						
						int amt = getData.getInt("Enter the unit amount of the re-order of the product");
						
						Product po = pb.getProduct();
						
						po.addQuantity(amt);
						
						break;
						
					case 2: 
						
						
						
						int amtLess = getData.getInt("Enter how many units are being sold ");
						
					Product poTwo = pb.getProduct();
					
					if (poTwo.isSufficent(amtLess)== false)
						
						JOptionPane.showMessageDialog(null, "You do not have enough product units for the sale");
					else {
					
					poTwo.subtractQuanity(amtLess);
					
					// Break might need to be added here  this may cause error 
					
					}
					
						
						
						
						
					}
				
				}
				
				break;
			case "4" : // price change of product menu
				
				itemname = getData.getString("Enter product name for price cost change ");
				
				pb.search(itemname);
				if(!pb.inList())
					
					JOptionPane.showMessageDialog(null, "Product not found :(");
				
				else 
				{
				   double priceChange = getData.getDouble("Enter the new price of the Product");
				   
				   Product po = pb.getProduct();
				   
				   po.changePrice(priceChange);
				   
				   
						   
				}
				break;
				
			case "5":  // deletes product from database option
				
				itemname = getData.getString("Enter the product you wish to delete from the database");
				
				pb.search(itemname);
				
				if(!pb.inList())
					JOptionPane.showMessageDialog(null, "Product selection not found");
				
				else 
				{
					Product pr = pb.getProduct();
					
					int index = pb.getIndex();
					
					deleted.addProduct(pb.deleteItem(index));
					
					JOptionPane.showMessageDialog(null, "The product" + " "+itemname + " " +"has been deleted from the ABC Enterprise product database");
				}
				
				break;
				
					
			default : 
				JOptionPane.showMessageDialog(null, "The entry you submitted is not valid.\n"+ "\t Please try again .");
			break;
			}
			
			
		}
		
		
	
	}
	
	static void display(String s, String heading, int MESSAGE_TYPE)// pop up menu syntax 
    {
        JTextArea text = new JTextArea(s, 20, 30);
        JScrollPane pane = new  JScrollPane(text);
        JOptionPane.showMessageDialog(null, pane, heading, MESSAGE_TYPE);
    }
	}



