package Test3;

public class PhoneBook {
	String Name;
	String Phone;
	String Address;
	
	public PhoneBook(String Name, String Phone, String Address) {
		this.Name = Name;
		this.Phone = Phone;
		this.Address = Address;
	}
	
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getPhone() {
		return Phone;
	}
	public void setPhone(String phone) {
		Phone = phone;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	
}
