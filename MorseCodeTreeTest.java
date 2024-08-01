import static org.junit.Assert.*;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MorseCodeTreeTest {
	
	private MorseCodeTree morseCodeTree;
	
	@Before
	public void setUp() throws Exception {
		morseCodeTree = new MorseCodeTree();
	}
	
	@Test
	public void testInsertAndFetch() {
		morseCodeTree.insert("...-", "v");
		assertEquals("v", morseCodeTree.fetch("...-"));
		
		morseCodeTree.insert(".--.", "p");
		assertEquals("p", morseCodeTree.fetch(".--."));
	}

	@Test
    public void testBuildTree() {
        morseCodeTree.buildTree();
        assertEquals("e", morseCodeTree.fetch("."));
        assertEquals("t", morseCodeTree.fetch("-"));
        assertEquals("i", morseCodeTree.fetch(".."));
        assertEquals("a", morseCodeTree.fetch(".-"));
    }

	@Test
    public void testToArrayList() {
        ArrayList<String> list = morseCodeTree.toArrayList();
        assertEquals("h", list.get(0));
        assertEquals("s", list.get(1));
        assertEquals("v", list.get(2));
    }
	
	@Test
    public void testLNRoutputTraversal() {
        ArrayList<String> list = new ArrayList<>();
        morseCodeTree.LNRoutputTraversal(morseCodeTree.getRoot(), list);
        assertEquals("h s v i f u e l r a p w j  b d x n c k y t z g q m o", String.join(" ", list));
    }

}
