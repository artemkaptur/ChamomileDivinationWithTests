package by.htp.divination.logic;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ValidNumberOfChamomiles_Test {

	private FortuneTeller fortuneTeller;

	@Before
	public void	initializeData() {
		fortuneTeller = new FortuneTeller();
	}

	@Test
	public void positiveValidNumberOfChamomiles_Test() {
		assertTrue(fortuneTeller.getChamomilesCount() > 0);
	}

}
