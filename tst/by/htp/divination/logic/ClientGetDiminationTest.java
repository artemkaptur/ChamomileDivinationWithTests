package by.htp.divination.logic;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ClientGetDiminationTest {

	private Client client;
	private FortuneTeller fortuneTeller;

	@Before
	public void initializeData() {
		client = new Client();
		fortuneTeller = new FortuneTeller();
	}

	@Test
	public void positiveClientGetDiminationTest() {
		String clientFuture = client.askFortuneTeller(fortuneTeller);

		assertTrue(fortuneTeller.getDivinations().containsValue((Object) clientFuture));
	}

}
