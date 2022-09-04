import java.util.ArrayList;


public class ProductDatabase {
	
	ArrayList <Product> list ;
	Product p ;
	int index ; 
	Boolean found ; 
	
	ProductDatabase ()
	{
		list = new ArrayList<Product>();
	}
	
	
	
	

	
	
	void search (String Productname) 
	{
		found = false ;
		int i = 0 ; 
		
		while(!found && i< list.size()) 
		{
			Product pr = list.get(i);
			
			if (pr.getProduct().equalsIgnoreCase(Productname))
			{
				p = pr ; 
				found = true ;
				index = i;
			}
			
			else i++ ;
		}
		
		
				
				
	}
	
	void addProduct(Product item ) 
	{
		list.add(item);
	}
	
	
	Product deleteItem (int i ) 
	{
		return list.remove(i);
	}
		
	
	
	
	
	int getIndex() 
	{
		return index; 
	}
	
	
	
	int getSize() 
	{
		return list.size();
	}
	
	Boolean inList () 
	{
		return found ;
	}
	
	ArrayList getList() 
	{
		return list; // Returns entire array list for entire inventory report. 
	}
	
	Product getProduct() 
	{
		return p;
	}
	
}
