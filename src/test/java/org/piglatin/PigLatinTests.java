package org.memoryextension.piglatin;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PigLatinTests {

	@Test
	void isVowelTest() {
		assertTrue(PigLatin.isVowel('i'));
		assertFalse(PigLatin.isVowel('y'));
	}

	void convertTest() {
		assertEquals("",PigLatin.convert(null));
		assertEquals("ellohay",PigLatin.convert("hello"));
		assertEquals("isthay isway easyway",PigLatin.convert("this is easy"));
	}
}
