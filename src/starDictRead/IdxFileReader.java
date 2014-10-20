package starDictRead;
/**
 * Currently assuming only use 32 bit offset
 */
import java.io.EOFException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class IdxFileReader {
	/*
	private int offsetLength;
	*/
	
	RandomAccessFile idxFile;
	

	public IdxFileReader(IfoFileReader ifoFileReader, String path) throws IOException{
		/*
		if(ifoFileReader.getVersion().equals("3.0.0") && 
				ifoFileReader.getIdxOffsetBits() == 64)
			offsetLength = 64;
		else
			offsetLength = 32;
		*/
		this.idxFile = new RandomAccessFile(path, "r");
	}
	
	public Word getNextWordIndex() throws IOException{
		byte [] buffers = new byte[1024];
		try {
			byte buffer = this.idxFile.readByte();
			int i = 0;
			for(; i<1024; i++){
				if(buffer == 0)
					break;
				
				buffers[i] = buffer;
				buffer = this.idxFile.readByte();
			}
			String word = new String(buffers, 0, i, "UTF8");
			int offset = 0;
			int size = 0;
			
			for(int j = 0; j<4; j++){
				offset<<=8;
				offset|= this.idxFile.readByte()&0xff;
			}
			
			for(int j = 0; j<4; j++){
				size<<=8;
				size|= this.idxFile.readByte()&0xff;
			}
			
			return new Word(word,offset, size);
		}catch (EOFException e) {
			return new Word("",0,0);	
		}
	}
}
