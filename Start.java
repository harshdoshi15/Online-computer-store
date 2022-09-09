package Store;

import java.io.*;
import Store.Customer;
import Store.DB;

public class Start {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Welcome To Newark IT-Database \n");

		while(true) {
			//printing the menu options
			System.out.println("1. Register customer");
			System.out.println("2. Edit customer details");
			System.out.println("3. Delete customer details");
			System.out.println("4. Credit card details");
			System.out.println("5. Shipping address details");
			System.out.println("6. Place an order");
			System.out.println("7. Sale statistics");
			System.out.println("8. Exit\n\n");

			//entering the choice 
			System.out.println("Enter your choice: ");
			int c = Integer.parseInt(br.readLine());

			if(c == 1) {
				//Add customer details
				System.out.println("Enter First Name : ");
				String fname = br.readLine();
				System.out.println("Enter Last Name : ");
				String lname = br.readLine();
				System.out.println("Enter Email : ");
				String email = br.readLine();
				System.out.println("Enter Address : ");
				String address = br.readLine();                             
				System.out.println("Enter Phone number : ");
				String phone = br.readLine();
				System.out.println("Enter Status (Regular/silver/gold/platinum): ");
				String status = br.readLine();

				//insert into database
				Customer ct = new Customer(fname,lname,email,address,phone,status);
				boolean ans = DB.insert(ct);
				if(ans) {
					System.out.println("Customer record Inserted Successfully...");
				}else {
					System.out.println("Some error occured wWhile inserting...Please try again!");
				}

			}
			else if(c == 2) {
				//Update customer details
				System.out.println("a. Update email");
				System.out.println("b. Update address");
				System.out.println("c. Update phone");
				System.out.println("d. Update status \n \n");

				System.out.println("Enter your choice: ");
				String val = br.readLine();

				System.out.println("Enter First Name: ");
				String fname = br.readLine();

				System.out.println("Enter Last Name: ");
				String lname = br.readLine();


				if(val.equals("a")) {
					//Update Name
					System.out.println("Enter email to update:");
					String email = br.readLine();

					boolean f = DB.update(val,fname,lname,email);
					if(f) {
						System.out.println("Customer Email Updated Successfully...");
					}else {
					System.out.println("Some error occured wWhile inserting...Please try again!");
					}
				}
				else if(val.equals("b")) {
					//Update address
					System.out.println("Enter address to update:");
					String address = br.readLine();

					boolean f = DB.update(val,fname,lname,address);
					if(f) {
						System.out.println("Customer Address Updated Successfully...");
					}else {
					System.out.println("Some error occured wWhile inserting...Please try again!");
					}
				}
				else if(val.equals("c")) {
					//Update phone no
					System.out.println("Enter phone to update:");
					String phone = br.readLine();

					boolean f = DB.update(val,fname,lname,phone);
					if(f) {
						System.out.println("Customer Phone Updated Successfully...");
					}else {
					System.out.println("Some error occured wWhile inserting...Please try again!");
					}
				}
				else if(val.equals("d")) {
					//Update status
					System.out.println("Enter status to update:");
					String status = br.readLine();

					boolean f = DB.update(val,fname,lname,status);
					if(f) {
						System.out.println("Customer Status Updated Successfully...");
					}else {
					System.out.println("Some error occured wWhile inserting...Please try again!");
					}
				}
				else {
					System.out.println("Please choose option correctly!");
				}

			}
			else if(c == 3) {
				//Delete customer
				System.out.println("Enter First Name: ");
				String fname = br.readLine();

				System.out.println("Enter Last Name: ");
				String lname = br.readLine();

				boolean f = DB.delete(fname,lname);
				if(f) {
					System.out.println("Customer Record Deleted... ");
				}else {
					System.out.println("Some error occured wWhile inserting...Please try again!");
				}
			}
			else if(c == 4) {
				//credit card details
				System.out.println("a. Register credit card");
				System.out.println("b. Delete credit card");
				System.out.println("c. Update credit card \n \n");

				System.out.println("Enter your choice: ");
				String val = br.readLine();

				System.out.println("Enter First Name: ");
				String fname = br.readLine();

				System.out.println("Enter Last Name: ");
				String lname = br.readLine();

				if(val.equals("a")) {
					//Register credit card
					System.out.println("Enter CC Number : ");
					String ccno = br.readLine();
					System.out.println("Enter Sec Number : ");
					String secno = br.readLine();
					String owner = fname+lname;
					System.out.println("Enter CC type : ");
					String cct = br.readLine();
					System.out.println("Enter Bill Address : ");
					String address = br.readLine();                             
					System.out.println("Enter Expiration date (yyyy-mm-dd): ");
					String date = br.readLine();

					boolean ans = DB.insertCC(ccno,secno,owner,cct,address,date,fname,lname);
					if(ans) {
						System.out.println("Credit Card record Inserted Successfully...");
					}else {
					System.out.println("Some error occured wWhile inserting...Please try again!");
					}
				}
				else if(val.equals("b")) {
					//Delete credit card
					boolean f = DB.deleteCC(fname,lname);
					if(f) {
						System.out.println("Credit Card Deleted Successfully...");
					}else {
					System.out.println("Some error occured wWhile inserting...Please try again!");
					}
				}
				else if(val.equals("c")) {
					//Update credit card
					System.out.println("Enter CC Number : ");
					String ccno = br.readLine();
					System.out.println("Enter Sec Number : ");
					String secno = br.readLine();
					String owner = fname+lname;
					System.out.println("Enter CC type : ");
					String cct = br.readLine();
					System.out.println("Enter Bill Address : ");
					String address = br.readLine();                             
					System.out.println("Enter Expiration date (yyyy-mm-dd): ");
					String date = br.readLine();

					boolean ans = DB.updateCC(ccno,secno,owner,cct,address,date,fname,lname);
					if(ans) {
						System.out.println("Credit Card record Updated Successfully...");
					}else {
					System.out.println("Some error occured wWhile inserting...Please try again!");
					}
				}
				else {
					System.out.println("Please choose option correctly!");
				}
			}
			else if(c == 5) {
				//Shipping address
				System.out.println("a. Register Shipping address");
				System.out.println("b. Delete address ");
				System.out.println("c. Update address \n\n");

				System.out.println("Enter your choice:");
				String val = br.readLine();

				System.out.println("Enter First Name: ");
				String fname = br.readLine();

				System.out.println("Enter Last Name: ");
				String lname = br.readLine();

				if(val.equals("a")) {
					//Register Shipping address
					System.out.println("Enter SAName: ");
					String sname = br.readLine();
					System.out.println("Enter Recepient Name : ");
					String rname = br.readLine();
					System.out.println("Enter Street : ");
					String street = br.readLine();
					System.out.println("Enter SNumber : ");
					String sno = br.readLine();
					System.out.println("Enter City : ");
					String city = br.readLine();                             
					System.out.println("Enter ZIP : ");
					String zip = br.readLine();
					System.out.println("Enter State : ");
					String state = br.readLine();
					System.out.println("Enter Country : ");
					String country = br.readLine();

					boolean f = DB.insertSA(fname,lname,sname,rname,street,sno,city,zip,state,country);
					if(f) {
						System.out.println("Customer Shipping Address Inserted Successfully...");
					}else {
					System.out.println("Some error occured wWhile inserting...Please try again!");
					}
				}
				else if(val.equals("b")) {
					//Delete address
					System.out.println("Enter SAName: ");
					String sname = br.readLine();

					boolean f = DB.deleteSA(fname,lname,sname);
					if(f) {
						System.out.println("Customer Address Deleted Successfully...");
					}else {
					System.out.println("Some error occured wWhile inserting...Please try again!");
					}
				}
				else if(val.equals("c")) {
					//Update address
					System.out.println("Enter SAName: ");
					String sname = br.readLine();
					System.out.println("Enter Recepient Name : ");
					String rname = br.readLine();
					System.out.println("Enter Street : ");
					String street = br.readLine();
					System.out.println("Enter SNumber : ");
					String sno = br.readLine();
					System.out.println("Enter City : ");
					String city = br.readLine();                             
					System.out.println("Enter ZIP : ");
					String zip = br.readLine();
					System.out.println("Enter State : ");
					String state = br.readLine();
					System.out.println("Enter Country : ");
					String country = br.readLine();

					boolean f = DB.updateSA(fname,lname,sname,rname,street,sno,city,zip,state,country);
					if(f) {
						System.out.println("Customer Address Updated Successfully...");
					}else {
					System.out.println("Some error occured wWhile inserting...Please try again!");
					}
				}
				else {
					System.out.println("Please choose option correctly!");
				}
			}
			else if(c == 6) {
				//Place order
				System.out.println("Enter First Name: ");
				String fname = br.readLine();

				System.out.println("Enter Last Name: ");
				String lname = br.readLine();

				boolean f = DB.placeOrder(fname,lname);
				if(!f) {
					System.out.println("Some error occured wWhile inserting...Please try again!");
				}
			}
			else if(c == 7) {
				//dispay sales statistics
				System.out.println("a. The most frequently sold products");
				System.out.println("b. The products which are sold to the highest number of distinct customers");
				System.out.println("c. The best customers (in terms of money spent)");
				System.out.println("d. The maximum basket total amount per credit card");
				System.out.println("e. The average selling product price per product type for desktops, laptops and printers \n \n");

				System.out.println("Enter your choice: ");
				String val = br.readLine();

				System.out.println("Enter start date (yyyy-mm-dd): ");
				String sdate = br.readLine();

				System.out.println("Enter end date (yyyy-mm-dd): ");
				String edate = br.readLine();
				
				if(val.equals("a")||val.equals("b")||val.equals("c")||val.equals("d")||val.equals("e")){
					DB.showSalesRecord(val,sdate,edate);
				}else {
					System.out.println("Please choose option correctly!");
				}

			}
			else if(c == 8) {
				//Exit from the application
				System.out.println("Thank You For using the application!!");
				break;
			}
		}
	}
}

