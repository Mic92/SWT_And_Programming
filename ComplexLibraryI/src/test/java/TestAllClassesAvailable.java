

import static org.junit.Assert.fail;

import org.junit.Test;


public class TestAllClassesAvailable {
	
	private void testAvailability(InstanceConstructor constructor) throws Exception{
		try {
			constructor.createInstance();
		} catch (Exception e) {
			if(e instanceof ClassNotFoundException) {
				fail("The class " + constructor.getName() + " was not found!");
			} else {
				throw e;
			}
		}
	}
	
	@Test
	public void testLibraryAvailable() throws Exception {
		testAvailability(new LibraryInstanceConstructor());
	}

}

interface InstanceConstructor {
	public Object createInstance();
	public String getName();
}

class LibraryInstanceConstructor implements InstanceConstructor {

	public Object createInstance() {
		return Library.getTheLibrary();
	}

	public String getName() {
		return "Library";
	}
	
}