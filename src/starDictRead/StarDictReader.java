package starDictRead;

import java.io.IOException;
import java.util.zip.DataFormatException;

public class StarDictReader {

	public static void main(String[] args) throws IOException, DataFormatException {
		// TODO Auto-generated method stub
		IfoFileReader ifo_reader = new IfoFileReader("longman.ifo");
		IdxFileReader idx_reader = new IdxFileReader(ifo_reader, "longman.idx");
		DictFileReader dict_reader = new DictFileReader(ifo_reader, "longman.dict");
		
		Word word = idx_reader.getNextWordIndex();
		while(word.word != ""){
			dict_reader.updateWord(word);
			System.out.println("  Word: " + word.word);
			System.out.println("Offset: " + word.offset);
			System.out.println("Length: " + word.size);
			System.out.println("data: " + word.getData() + '\n');
			word = idx_reader.getNextWordIndex();
		}
	}

}
