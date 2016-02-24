package zad3;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class SortowanieTest {
	
	private Sortowanie sort;
	
	@Before
	public void setup(){
		sort = new Sortowanie();
	}
	
	@Test
	public void sortArrayTest() {
		Integer[] tablica = {1,2,5,8,3,9};
		sort.SortArray(tablica);
		assertThat(Arrays.asList(tablica), contains(1,2,3,5,8,9));
	}
	
	@Test
	public void sortArrayWithNumbersLessThanZeroTest() {
		Integer[] tablica = {1,-2,5,0,3,-9};
		sort.SortArray(tablica);
		assertThat(Arrays.asList(tablica), contains(-9,-2,0,1,3,5));
	}
	
	@Test
	public void sortDecreasingArrayTest() {
		Integer[] tablica = {9,8,7,6,5,4};
		sort.SortArray(tablica);
		assertThat(Arrays.asList(tablica), contains(4,5,6,7,8,9));
	}
	
	@Test
	public void sortEmptyArrayTest() {
		Integer[] tablica = {};
		sort.SortArray(tablica);
		assertThat(tablica, emptyArray());
	}

	@After
	public void teardown(){
		sort = null;
	}

}
