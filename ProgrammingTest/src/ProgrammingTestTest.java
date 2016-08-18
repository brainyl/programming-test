import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * 
 */

/**
 * @author AscellonNG13
 *
 */
public class ProgrammingTestTest {

	ProgrammingTest programmingTest;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		programmingTest = new ProgrammingTest();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link ProgrammingTest#RotateArrayByNPositions(int[], int)}.
	 */
	@Test
	public void testRotateArrayByNPositions() {
		int input1[] = { 1, 2, 3, 4, 5, 6 };
		assertArrayEquals(new int[] {5, 6, 1, 2, 3, 4}, this.programmingTest.RotateArrayByNPositions(input1, 2));
		assertArrayEquals(new int[] {3, 4, 5, 6, 1, 2}, this.programmingTest.RotateArrayByNPositions(input1, 4));
	}

	/**
	 * Test method for {@link ProgrammingTest#RemoveDuplicateFromSortedArray(int[])}.
	 */
	@Test
	public void testRemoveDuplicateFromSortedArray() {
		int sortedArray[] = new int[]{1, 1, 3, 7, 7, 8, 9, 9, 9, 10};
		assertArrayEquals(new int[] {1,3,7,8,9,10}, this.programmingTest.RemoveDuplicateFromSortedArray(sortedArray));
	}

	/**
	 * Test method for {@link ProgrammingTest#FindCharsOrderN2N(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testFindCharsOrderN2N() {
		String string1 = "Kelvin";
		String string2 = "nK";
		assertEquals("Kn", this.programmingTest.FindCharsOrderN2N(string1,string2));
	}

	/**
	 * Test method for {@link ProgrammingTest#FindCharsOrderN(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testFindCharsOrderN() {
		String string1 = "Kelvin";
		String string2 = "nKe";
		assertEquals("Ken", this.programmingTest.FindCharsOrderN(string1,string2));
		
	}

	/**
	 * Test method for {@link ProgrammingTest#GetLcmForArray(int[])}.
	 */
	@Test
	public void testGetLcmForArray() {
		int input1[] = {48};
		int input2[] = {21, 6};
		int input3[] = {14, 34, 51, 28};
		assertEquals(48, this.programmingTest.GetLcmForArray(input1));
		assertEquals(42, this.programmingTest.GetLcmForArray(input2));
		assertEquals(1428, this.programmingTest.GetLcmForArray(input3));
	}

}
