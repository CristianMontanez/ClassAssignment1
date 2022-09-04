
public class Manufacturer {

	private String name ;
	
	private Address addr; // created object from Address class to use in Manufacturer class 
	
	
	
	public Manufacturer (String name , Address addr) 
	      
	   {
		
		this.name = name ; 
		
		this.addr = addr; 
		
	     }// used this. variable names as variable names in class are the same as variable names in constructor. 
	
	


    public String getName() 
       {
	
	    return name ; 
	    
      }
    
    
    public Address getAddress() 
    
    {
    	
    	return addr; 
    }
    




}
