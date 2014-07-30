package starDictRead;

import java.io.IOException;
import java.util.zip.DataFormatException;

public class StarDictReader {

	public static void main(String[] args) throws IOException, DataFormatException {
		// TODO Auto-generated method stub
		@SuppressWarnings("unused")
		IfoFileReader reader = new IfoFileReader("longman.ifo");
	}

}
