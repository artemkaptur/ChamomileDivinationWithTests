package by.htp.divination.logic;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import by.htp.divination.bean.Chamomile;

public class ValidChamomileTest {

	private FortuneTeller fortuneTeller;

	@Before
	public void initializeData() {
		fortuneTeller = new FortuneTeller();
	}

	@Test
	public void positiveValidChamomileTest() {
		for (Chamomile chamomile : fortuneTeller.getChamomiles()) {
			assertTrue(chamomile.getPetals().size() > 0 && chamomile.getPetals().size() < 13);
		}

	}
}
