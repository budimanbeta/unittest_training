package example.testing.mock;

import java.util.ArrayList;
import java.util.List;

public class Client {

	private final List<Address> addresses = new ArrayList<Address>();
	
	public void addAddress(Address address) {
		addresses.add(address);
	}

	public List<Address> getAddresses() {
		return addresses;
	}

	public Object getEmail() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}
