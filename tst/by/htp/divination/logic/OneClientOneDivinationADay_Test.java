package by.htp.divination.logic;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class OneClientOneDivinationADay_Test {
	
	private Client client;
	private FortuneTeller fortuneTeller;

	@Before
	public void initializeData() {
		client = new Client();
		fortuneTeller = new FortuneTeller();
	}

	@Test
	public void positiveOneClientOneDivinationADay_Test() {
		client.askFortuneTeller(fortuneTeller);
		String result = client.askFortuneTeller(fortuneTeller);
		assertEquals(result, "Sorry buddy, I have already told your future, come back tommorow!\n");
	}

}
