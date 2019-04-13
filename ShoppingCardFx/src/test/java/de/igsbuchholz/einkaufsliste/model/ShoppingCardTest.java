package de.igsbuchholz.einkaufsliste.model;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ShoppingCardTest extends ShoppingCard {

	private ShoppingCard card;

	@Before
	public void before() {
		card = new ShoppingCard();
	}

	@After
	public void after() {
		card = null;
	}

	@Test
	public void addItem_addOneItem_ShouldReturnTrueForContainItem() {

		// given
		final String description = "test";

		// when
		card.addItem(description);

		// then
		boolean contains = card.containsItem(description);
		assertThat(contains, is(true));
	}

	@Test
	public void containsItem_withoutCorrespondingItem_shouldReturnFalse() {
		// given
		final String description = "test";

		// when
		boolean contains = card.containsItem(description);

		// then
		assertThat(contains, is(false));
	}

	@Test
	public void removeItem_withCorrespondingItem_shouldReturnTrue() {

		// given
		final String description = "test";
		card.addItem(description);

		// when
		boolean removed = card.removeItem(description);

		// then
		assertThat(removed, is(true));

	}

	@Test
	public void removeItem_withoutCorrespondingItem_shouldReturnFalse() {
		// given
		final String description = "test";

		// when
		boolean removed = card.removeItem(description);

		// then
		assertThat(removed, is(false));

	}

}
