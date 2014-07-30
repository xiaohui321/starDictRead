package starDictRead;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.IllegalFormatException;
import java.util.zip.DataFormatException;

/** @author Xiaohui, Zhou
 * This File will load and parse an .ifo file.
 */
public class IfoFileReader {
	
	//required fields
	private String version, bookName;
	
	//optional fields
	private String idxOffsetBits, author, email, website,description, date, sameTypeSequence;
	
	private int wordCount, idxFileSize, synWordCount;
	
	public IfoFileReader(String path) throws IOException, DataFormatException{
		BufferedReader reader = new BufferedReader(new FileReader(path));
		
		String lineBuffer = reader.readLine();
		
		if(!lineBuffer.equals("StarDict's dict ifo file"))
			throw new  DataFormatException("Wrong format for the file provided");

		while((lineBuffer=reader.readLine())!= null){
			if(lineBuffer.startsWith("version=")){
				version = lineBuffer.substring(8);
			}else if(lineBuffer.startsWith("bookname=")){
				bookName = lineBuffer.substring(9);
			}else if(lineBuffer.startsWith("wordcount=")){
				wordCount = Integer.parseInt(lineBuffer.substring(10));
			}else if(lineBuffer.startsWith("synwordcount=")){
				synWordCount = Integer.parseInt(lineBuffer.substring(13));
			}else if(lineBuffer.startsWith("idxfilesize=")){
				idxFileSize = Integer.parseInt(lineBuffer.substring(12));
			}else if(lineBuffer.startsWith("idxoffsetbits=")){
				idxOffsetBits = lineBuffer.substring(13);
			}else if(lineBuffer.startsWith("author=")){
				 author = lineBuffer.substring(7);
			}else if(lineBuffer.startsWith("email=")){
				 email = lineBuffer.substring(6);
			}else if(lineBuffer.startsWith("website=")){
				  website = lineBuffer.substring(8);
			}else if(lineBuffer.startsWith("description=")){
				  description = lineBuffer.substring(12);
			}else if(lineBuffer.startsWith("date=")){
				  date = lineBuffer.substring(5);
			}else if(lineBuffer.startsWith("sameTypeSequence=")){
				  sameTypeSequence = lineBuffer.substring(17);
			}
		}
	}
	
	public String getVersion() {
		return version;
	}
	public String getBookName() {
		return bookName;
	}
	public String getIdxOffsetBits() {
		return idxOffsetBits;
	}
	public String getAuthor() {
		return author;
	}
	public String getEmail() {
		return email;
	}
	public String getWebsite() {
		return website;
	}
	public String getDescription() {
		return description;
	}
	public String getDate() {
		return date;
	}
	public String getSameTypeSequence() {
		return sameTypeSequence;
	}
	public int getWordCount() {
		return wordCount;
	}
	public int getIdxFileSize() {
		return idxFileSize;
	}
	public int getSynWordCount() {
		return synWordCount;
	}
}
