package starDictRead;

/** 
 * Currently assume no type sequence is used.
 */
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;


public class DictFileReader {
	RandomAccessFile dictFile;
	
	
	
	public DictFileReader(IfoFileReader ifoFileReader, String path) throws FileNotFoundException{
		this.dictFile = new RandomAccessFile(path, "r");
	}
	
	public void updateWord(Word word) throws IOException{
		byte [] buffers = new byte[word.size];
		dictFile.read(buffers,0,word.size);
		word.setData(new String(buffers,0,word.size));
	}
}
