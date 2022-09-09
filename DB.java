package Store;

import java.sql.*;
import java.io.*;

//methods defining the queries to be executed
public class DB {

	//insert customer details
	public static boolean insert(Customer st) {
		
		boolean f = false;

		try {
			Connection con = DBcon.createc();
			Statement smt = con.createStatement();
			ResultSet set = smt.executeQuery("SELECT CID FROM CUSTOMER ORDER BY CID DESC LIMIT 1");
			int id=0;
			while(set.next()) {
				id = (set.getInt(1));
			}

			String query = "INSERT INTO CUSTOMER(CID,FName,LName,EMail,Address,Phone,stat)VALUES (?,?,?,?,?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(query);
			
			//set the value of parameters
			pstmt.setInt(1, id+1);
			pstmt.setString(2, st.getfName());
			pstmt.setString(3, st.getlname());
			pstmt.setString(4, st.getemail());
			pstmt.setString(5, st.getaddress());
			pstmt.setString(6, st.getPhone());
			pstmt.setString(7, st.getstatus());

			pstmt.executeUpdate();

			f = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	//insert credit card details
	public static boolean insertCC(String ccno,String secno,String owner,String cct,String address,String date,String fname, String lname) {
		
		boolean f = false;
		
		try {
			Connection con = DBcon.createc();
			Statement smt = con.createStatement();
			ResultSet set = smt.executeQuery("SELECT CID FROM CUSTOMER where fname='"+fname+"' and lname='"+lname+"';");

			int id=0;
			while(set.next()) {
				id = (set.getInt(1));
			}

			String query = "INSERT INTO CREDIT_CARD(CCNumber,SecNumber,OwnerName,CCType,BillAddress,ExpDate,StoredCardCID) values (?,?,?,?,?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(query);

			//set the value of parameters
			pstmt.setString(1, ccno);
			pstmt.setString(2, secno);
			pstmt.setString(3, owner);
			pstmt.setString(4, cct);
			pstmt.setString(5, address);
			pstmt.setString(6, date);
			pstmt.setInt(7, id);

			pstmt.executeUpdate();

			f = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	//update credit card details
	public static boolean updateCC(String ccno,String secno,String owner,String cct,String address,String date,String fname, String lname) {
		boolean f = false;
		
		try {
			Connection con = DBcon.createc();
			Statement smt = con.createStatement();
			ResultSet set = smt.executeQuery("SELECT CID FROM CUSTOMER where fname='"+fname+"' and lname='"+lname+"';");

			int id=0;
			while(set.next()) {
				id = (set.getInt(1));
			}
			
			String query = "UPDATE CREDIT_CARD SET CCNumber=?,SecNumber=?,OwnerName=?,CCType=?,BillAddress=?,ExpDate=? where StoredCardCID=?";
			PreparedStatement pstmt = con.prepareStatement(query);
		
			//set the value of parameters
			pstmt.setString(1, ccno);
			pstmt.setString(2, secno);
			pstmt.setString(3, owner);
			pstmt.setString(4, cct);
			pstmt.setString(5, address);
			pstmt.setString(6, date);
			pstmt.setInt(7, id);

			pstmt.executeUpdate();

			f = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	//delete customer details
	public static boolean delete(String fname, String lname) {
		boolean f = false;
		
		try {
			Connection con = DBcon.createc();
			String query = "delete from CUSTOMER where FName=? and Lname=?;";
			PreparedStatement pstmt = con.prepareStatement(query);
		
			//set the value of parameters
			pstmt.setString(1, fname);
			pstmt.setString(2, lname);

			pstmt.executeUpdate();

			f = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	//delete credit card details
	public static boolean deleteCC(String fname, String lname) {
		boolean f = false;

		try {
			Connection con = DBcon.createc();
			String query = "delete from CREDIT_CARD where OwnerName='"+fname+lname+"';";
			PreparedStatement pstmt = con.prepareStatement(query);

			pstmt.executeUpdate();

			f = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	//insert parameters of shipping address
	public static boolean insertSA(String fname,String lname,String sname,String rname,String street,String sno,String city,String zip,String state,String country) {
		boolean f = false;
		
		try {
			Connection con = DBcon.createc();
			Statement smt = con.createStatement();
			ResultSet set = smt.executeQuery("SELECT CID FROM CUSTOMER where fname='"+fname+"' and lname='"+lname+"';");

			int id=0;
			while(set.next()) {
				id = (set.getInt(1));
			}

			String query = "INSERT INTO SHIPPING_ADDRESS(CID,SAName,RecepientName,Street,SNumber,City,ZIP,State,Country) values (?,?,?,?,?,?,?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(query);
			
			//set the value of parameters
			pstmt.setInt(1, id);
			pstmt.setString(2, sname);
			pstmt.setString(3, rname);
			pstmt.setString(4, street);
			pstmt.setString(5, sno);
			pstmt.setString(6, city);
			pstmt.setString(7, zip);
			pstmt.setString(8, state);
			pstmt.setString(9, country);

			pstmt.executeUpdate();

			f = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	//update shipping address details
	public static boolean updateSA(String fname,String lname,String sname,String rname,String street,String sno,String city,String zip,String state,String country) {
		boolean f = false;
		
		try {
			Connection con = DBcon.createc();
			Statement smt = con.createStatement();
			ResultSet set = smt.executeQuery("SELECT CID FROM CUSTOMER where fname='"+fname+"' and lname='"+lname+"';");
			
			int id=0;
			while(set.next()) {
				id = (set.getInt(1));
			}

			String query = "UPDATE SHIPPING_ADDRESS SET SAName=?,RecepientName=?,Street=?,SNumber=?,City=?,ZIP=?,State=?,Country=? where CID=?";
			PreparedStatement pstmt = con.prepareStatement(query);
			
			//set the value of parameters
			pstmt.setString(1, sname);
			pstmt.setString(2, rname);
			pstmt.setString(3, street);
			pstmt.setString(4, sno);
			pstmt.setString(5, city);
			pstmt.setString(6, zip);
			pstmt.setString(7, state);
			pstmt.setString(8, country);
			pstmt.setInt(9, id);

			pstmt.executeUpdate();

			f = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

//delete shipping address details
	public static boolean deleteSA(String fname, String lname, String sname) {
		boolean f = false;

		try {
			Connection con = DBcon.createc();
			String query = "delete from SHIPPING_ADDRESS where SAName='"+sname+"';";
			PreparedStatement pstmt = con.prepareStatement(query);

			pstmt.executeUpdate();

			f = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	//place product orders for a customer
	public static boolean placeOrder(String fname, String lname) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		boolean f = false;
		try {
		Connection con = DBcon.createc();
		Statement smt = con.createStatement();
		ResultSet set = smt.executeQuery("SELECT CID FROM CUSTOMER where fname='"+fname+"' and lname='"+lname+"';");

		int id=0;
		while(set.next()) {
		id = (set.getInt(1));
		}

		//if the customer exists then place an order
		if(id!=0){

		//printing all the products
		String query = "select * from product";
		ResultSet s1 = smt.executeQuery(query);

		while(s1.next()) {
		int pid = s1.getInt(1);
		String ptype = s1.getString(2);
		String pname = s1.getString(3);
		String pprice = s1.getString(4);
		String pdesc = s1.getString(5);

		System.out.println("Product ID: " + pid + " \n Product Type: " + ptype + " \n Product Name: " + pname + " \n Product Price: " + pprice + " \n Product description: " + pdesc);
		System.out.println("----------------------------------------------");
		}

		//setting the parameters
		System.out.println("Enter the Product ID to buy the Product: ");
		int pid1 = Integer.parseInt(br.readLine());

		System.out.println("Enter the Quantity: ");
		int qt1 = Integer.parseInt(br.readLine());

		//getting the latest id of the basket owned by the customer 
		ResultSet s2 = smt.executeQuery("SELECT BID FROM APPEARS_IN ORDER BY BID DESC LIMIT 1;");
		int bid=0;
		while(s2.next()) {
		bid = (s2.getInt(1));
		}

		//get the priice of product
		ResultSet rs = smt.executeQuery("SELECT pprice from product where pid="+pid1+";");
		int p=0;
		while(rs.next()) {
		p = (rs.getInt(1));
		}
		int psold=p*qt1;

		//setting the total items to be sold corresponding to the basket owned by the customer 
		String query1 = "INSERT INTO APPEARS_IN(BID,PID,Quantity,PriceSold) VALUES (?,?,?,?)";
		PreparedStatement pstmt = con.prepareStatement(query1);
		pstmt.setInt(1, bid+1);
		pstmt.setInt(2, pid1);
		pstmt.setInt(3, qt1);
		pstmt.setInt(4, psold);
		pstmt.executeUpdate();

		//setting the values for the basket
		String query2 = "INSERT INTO BASKET(CID,BID) VALUES (?,?)";
		PreparedStatement pstmt1 = con.prepareStatement(query2);
		pstmt1.setInt(1, id);
		pstmt1.setInt(2, bid+1);
		pstmt1.executeUpdate();

		//get the corresponding credit card id
		ResultSet rs1 = smt.executeQuery("SELECT CCNumber FROM CREDIT_CARD WHERE STOREDCARDCID="+id+";");
		String cc="";
		while(rs1.next()) {
		cc = (rs1.getString(1));
		}

		//get the corresponding shipping address id
		ResultSet rs2 = smt.executeQuery("SELECT SAName FROM SHIPPING_ADDRESS WHERE CID="+id+";");
		String sa="";
		while(rs2.next()) {
		sa = (rs2.getString(1));
		}

		//set the current date and time
		java.util.Date date=new java.util.Date();
		java.sql.Date sqlDate=new java.sql.Date(date.getTime());

		//set all the values received in the transaction table
		String query3 = "INSERT INTO TRANSACTION(BID,CCNUMBER,CID,SANAME,TDATE,TTAG) VALUES (?,?,?,?,?,?)";
		PreparedStatement pstmt2 = con.prepareStatement(query3);
		pstmt2.setInt(1, bid+1);
		pstmt2.setString(2, cc);
		pstmt2.setInt(3, id);
		pstmt2.setString(4, sa);
		pstmt2.setDate(5, sqlDate);
		pstmt2.setString(6, "IN PROCESS");

		pstmt2.executeUpdate();

		System.out.println("Order has been placed succesfully!!");
		}
		else {
		System.out.println("Please register yourself to be able to place an order!");
		}
		f = true;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return f;
		}

	//displaying the sales statistics
	public static void showSalesRecord(String val, String sdate, String edate) {
		try {
			Connection con = DBcon.createc();
			
			//get the most frequently sold products
			if(val.equals("a")){
				String query = "SELECT PName, SUM(Quantity) AS QTY FROM PRODUCT p, TRANSACTION t, APPEARS_IN a, BASKET b WHERE a.PID=p.PID AND a.BID=b.BID AND b.BID=t.BID AND TDate between '"+sdate+"' and '"+edate+"' GROUP BY p.PID ORDER BY QTY DESC LIMIT 1;";
				Statement st = con.createStatement();
				ResultSet set = st.executeQuery(query);

				while(set.next()) {
					String pname = set.getString(1);
					int sum = set.getInt(2);

					System.out.println("Product name: " + pname +"\nQuantity: "+ sum +"\n");
					System.out.println("----------------------------------------------\n");						
				}
			}	//get the products which are sold to the highest number of distinct customers
			else if(val.equals("b")){
				String query = "SELECT PNAME,COUNT(b.CID) AS SOLD_TO FROM PRODUCT p, TRANSACTION t, BASKET b, APPEARS_IN a WHERE t.BID=b.BID AND b.BID=a.BID AND a.PID=p.PID and TDate>='"+sdate+"' and TDate<='"+edate+"' and TTag='Delivered' GROUP BY PNAME ORDER BY SOLD_TO DESC LIMIT 3;";
				Statement st = con.createStatement();
				ResultSet set = st.executeQuery(query);

				while(set.next()) {
					String pname = set.getString(1);
					int c = set.getInt(2);

					System.out.println("Product name: " + pname + " \nCount: " + c + " \n");
					System.out.println("----------------------------------------------\n");						
				}
			}	//get the best customers (in terms of money spent)
			else if(val.equals("c")){
				String query = "SELECT c.CID,FName,LName FROM CUSTOMER c, BASKET b, APPEARS_IN a, TRANSACTION t WHERE c.CID=b.CID AND t.BID=b.BID AND b.BID=a.BID AND TTag='Delivered' AND TDate BETWEEN '"+sdate+"' AND '"+edate+"' GROUP BY CID ORDER BY SUM(PriceSold)  DESC LIMIT 3;";
				Statement st = con.createStatement();
				ResultSet set = st.executeQuery(query);

				while(set.next()) {
					int id = set.getInt(1);
					String fname = set.getString(2);
					String lname = set.getString(3);

					System.out.println("Customer id: "+ id +" \n First name: " + fname + " \n Last name: " + lname + "\n");
					System.out.println("----------------------------------------------\n");						
				}
			}	//get the maximum basket total amount per credit card
			else if(val.equals("d")){
				String query = "Select max(c.total) from (Select sum(a.PriceSold) as total from transaction t, appears_in a Where t.bid = a.bid And t.TDate between '"+sdate+"' and '"+edate+"' Group by t.CCNumber) c";
				Statement st = con.createStatement();
				ResultSet set = st.executeQuery(query);

				while(set.next()) {
					int sum = set.getInt(1);

					System.out.println("Maximum: " + sum + " \n ");
					System.out.println("----------------------------------------------");						
				}

			}	//get the average selling product price per product type for desktops, laptops and printers
			else if(val.equals("e")){
				String query = "select c.type,c.price from (select avg(a.pricesold) as price ,p.ptype as type from product p, appears_in a, transaction t where a.pid = p.pid and t.TDate between '"+sdate+"' and '"+edate+"' group by p.ptype) c where  c.type = 'Laptop' or c.type = 'Printer' or c.type = 'Desktop';";
				Statement st = con.createStatement();
				ResultSet set = st.executeQuery(query);

				while(set.next()) {
					String type = set.getString(1);
					int price = set.getInt(2);

					System.out.println("Type: " + type + " \n Price: "+ price +"\n");
					System.out.println("----------------------------------------------\n");						
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//update the customer details
	public static boolean update(String val,String fname, String lname, String toUpdate) {
		boolean f = false;

		try {
			Connection con = DBcon.createc();
			
			if(val.equals("a")) {				
				//Update Name
				String query = "update CUSTOMER set email=? where fname=? and lname=?";
				PreparedStatement pstmt = con.prepareStatement(query);
				pstmt.setString(1, toUpdate);
				pstmt.setString(2, fname);
				pstmt.setString(3, lname);

				pstmt.executeUpdate();
				f = true;
			}
			else if(val.equals("b")) {
				//Update Phone
				String query = "update CUSTOMER set address=? where fname=? and lname=?";
				PreparedStatement pstmt = con.prepareStatement(query);
				pstmt.setString(1, toUpdate);
				pstmt.setString(2, fname);
				pstmt.setString(3, lname);

				pstmt.executeUpdate();
				f = true;
			}
			else if(val.equals("c")) {
				//Update City
				String query = "update CUSTOMER set phone=? where fname=? and lname=?";
				PreparedStatement pstmt = con.prepareStatement(query);
				pstmt.setString(1, toUpdate);
				pstmt.setString(2, fname);
				pstmt.setString(3, lname);

				pstmt.executeUpdate();
				f = true;
			}
			else if(val.equals("d")) {
				//Update Status
				String query = "update CUSTOMER set stat=? where fname=? and lname=?";
				PreparedStatement pstmt = con.prepareStatement(query);
				pstmt.setString(1, toUpdate);
				pstmt.setString(2, fname);
				pstmt.setString(3, lname);

				pstmt.executeUpdate();
				f = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return f;
	}
}