
package Store;

//methods to get and set the parameters of customer
public class Customer {

	private int CustomerID;
	private String fName;
	private String lname;
	private String email;
	private String address;
	private String Phone;
	private String status;

	public int getCustomerID() {
		return CustomerID;
	}

	public void setCustomerID(int CustomerID) {
		this.CustomerID = CustomerID;
	}

	public String getfName() {
		return fName;
	}

	public String getlname() {
		return lname;
	}

	public void setName(String fName,String lname) {
		this.fName = fName;
		this.lname = lname;
	}

	public String getPhone() {
		return Phone;
	}

	public void setPhone(String Phone) {
		this.Phone = Phone;
	}

	public String getemail() {
		return email;
	}

	public void setemail(String email) {
		this.email = email;
	}
	public String getstatus() {
		return status;
	}

	public void setstatus(String status) {
		this.status = status;
	}

	public String getaddress() {
		return address;
	}

	public void setaddress(String address) {
		this.address = address;
	}

	public Customer(String fName, String lname, String email, String address, String phone, String status) {
		this.fName = fName;
		this.lname = lname;
		this.email=email;
		this.address=address;
		this.Phone = phone;
		this.status = status;
	}
}
