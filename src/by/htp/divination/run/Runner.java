package by.htp.divination.run;

import by.htp.divination.logic.Client;
import by.htp.divination.logic.FortuneTeller;

public class Runner {

	public static void main(String[] args) {
		
		FortuneTeller dumbledore = new FortuneTeller("Albus");
		Client client1 = new Client("Harry", "Potter");
		Client client2 = new Client("Hermione", "Granger");
		Client client3 = new Client("Ron", "Weasley");
		Client client4 = new Client("Bob", "Smith");
		Client client5 = new Client("Ann", "Turner");
		Client client6 = new Client("Jade", "Anderson");

		client1.askFortuneTeller(dumbledore);
		client1.askFortuneTeller(dumbledore);
		client2.askFortuneTeller(dumbledore);
		client3.askFortuneTeller(dumbledore);
		client4.askFortuneTeller(dumbledore);
		client5.askFortuneTeller(dumbledore);
		client6.askFortuneTeller(dumbledore);	
				
	}

}
