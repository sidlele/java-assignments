import java.io.*;
class Vehicle{ 
	 String company;
	 double price;

	public void accept() throws IOException{
		System.out.println("Enter the Company Name: ");
	 	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			 		company=br.readLine();
		while(true){
		System.out.println("Enter price of the Vehicle: ");
		price=Double.parseDouble(br.readLine());
		if(price <=0) System.out.println("Enter valid price");		
		else
			break;		
		}	
	 }

	 public void display(){
	  System.out.println("Company: "+company+" Price: "+price);
	 }
	  
 }

class LightMotorVehicle extends Vehicle{
	 double mileage;
	
	public void accept() throws IOException{
	 	super.accept();
	while(true){
	  	System.out.println("Enter the mileage of the vehicle: ");
	  	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	  	mileage=Double.parseDouble(br.readLine());
		if(mileage <= 0)		  System.out.println("Enter valid Mileage value");
		else
			break;
		}
	 }

	 public void display(){
		  super.display();
		  System.out.println("Mileage: "+mileage);
	 }
}
	
class HeavyMotorVehicle extends Vehicle{
	 double captons;
	 
	public void accept() throws IOException{
		  super.accept();
		  System.out.println("Enter the capacity of vehicle in tons: ");
		  BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		while(true){			  
			captons=Double.parseDouble(br.readLine());
		if(captons<=0) System.out.println("Enter valid capacity");
		else break;	 
		}
	}

	 public void display(){
		  super.display();
		  System.out.println("Capacity in tons: "+captons);
	 }
}
	 
public class VehicleMain {

	 public static void main(String [] args) throws IOException{
		  int i;
		  boolean flag=true;
		  System.out.println("Enter the type of vehicle: ");
		  BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	
			while(flag)
			{  
			  System.out.println("1.Light Vehicle");
			  System.out.println("2.Heavy Vehicle");
			  System.out.println("3.Exit Program");
	
			  int ch=Integer.parseInt(br.readLine());

				  switch(ch){
					  case 1: int n;
						   System.out.println("Enter the number of Light vehicles: ");
						while(true){						   
								n=Integer.parseInt(br.readLine());
								if(n<=0) 	  System.out.println("Enter valid number of vehicles");
								else break;
							}
						   LightMotorVehicle [] l=new LightMotorVehicle[n];
					   for(i=0;i<n;i++){
							l[i]=new LightMotorVehicle();
							l[i].accept();
					   }
					   for(i=0;i<n;i++){
							l[i].display();
					   }
					   break;
					  case 2:
						   System.out.println("Enter the number of Heavy vehicles: ");
						   int m=Integer.parseInt(br.readLine());
						   HeavyMotorVehicle [] h=new HeavyMotorVehicle[m];
						   for(i=0;i<m;i++){
								 h[i]=new HeavyMotorVehicle();
							 h[i].accept(); 
							}

						   for(i=0;i<m;i++){
							h[i].display();
						   }
					   break; 
					   
						case 3:	  System.out.println("Program exiting...");
							flag=false;
							break;
						default:System.out.println("Invalid Input!"); break;
				  }//switch
			}//while
		}//main
}//class
