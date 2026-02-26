package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SpellCheckerTest {

	@Test
	void test() {
		SpellChecker checker = new SpellChecker();
		int words = checker.getNumberofWords();
		assertEquals(0, words);
	}

	@Test
	void addWord() {
		SpellChecker checker = new SpellChecker();
		int words = checker.getNumberofWords();
		checker.addWord("test");
		assertEquals(words+1, checker.getNumberofWords);
	}

	@Test
	void checkExists(){
		SpellChecker checker = new SpellChecker();
		checker.addWord("test");
		checker.addWord("test");
		assertEquals(1, checker.size());
	}

	@Test
	void spelledCorrectly(){
		SpellChecker checker = new SpellChecker();
		checker.addWord("cat");
		checker.addWord("test");
		checker.addWord("man");
		checker.addWord("lap");
		assertTrue(checker.isCorrect("cat"));
    	assertTrue(checker.isCorrect("test"));
		assertTrue(checker.isCorrect("man"));
    	assertTrue(checker.isCorrect("lap"));
	}

	@Test
	void spelledIncorrectly(){
		SpellChecker checker = new SpellChecker();
		checker.addWord("cta");
		checker.addWord("telkdt");
		assertFalse(checker.isCorrect("cat"));
    	assertFalse(checker.isCorrect("test"));
	}

	@Test
	void spelledCorrectly(){
		SpellChecker checker = new SpellChecker();
		checker.addWord("caT");
		checker.addWord("teSt");
		checker.addWord("cAr");
		assertTrue(checker.isCorrect("caT"));
    	assertTrue(checker.isCorrect("teSt"));
		assertTrue(checker.isCorrect("cAr"));
	}

	@Test
	void suggestionGiven(){
		SpellChecker checker = new SpellChecker();
		checker.addWord("bamk");
		checker.addWord("phoen");
		assertEquals("bank", checker.reccomendWord("bamk"));
		assertEquals("phone", checker.reccomendWord("phoen"));
	}
	
	@Test
	void correctWord(){
		SpellChecker checker = new SpellChecker();
		checker.addWord("bank");
		checker.addWord("phone");
		assertEquals("bank", checker.reccomendWord("bank"));
		assertEquals("phone", checker.reccomendWord("phone"));
	}

	@Test
	void ignorePunct(){
		SpellChecker checker = new SpellChecker();
		checker.addWord("bank!");
		checker.addWord("phone?");
		assertTrue(checker.isCorrect("bank!"));
		assertTrue(checker.isCorrect("phone?"));
	}

	@Test
	void ignoreWhiteSpace(){
		SpellChecker checker = new SpellChecker();
		checker.addWord("bank   ");
		checker.addWord("   phone  ");
		checker.addWord("   p  hon e  ");
		assertTrue(checker.isCorrect("bank   "));
		assertTrue(checker.isCorrect("   phone  "));
		assertFalse(checker.isCorrect("   p  hon e  "));
	}

}
