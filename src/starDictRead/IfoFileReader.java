package starDictRead;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.zip.DataFormatException;

/** @author Xiaohui, Zhou
 * This File will load and parse an .ifo file.
 * idxFileSize: size in byte of the original idx file
 * wordCount: the number of words in idx file
 */
public class IfoFileReader {
	
	//required fields
	private String version, bookName;
	
	//optional fields
	private String author, email, website,description, date, sameTypeSequence;
	
	private int wordCount, idxFileSize, idxOffsetBits, synWordCount;
	
	@SuppressWarnings("resource")
	public IfoFileReader(String path) throws IOException, DataFormatException{
		BufferedReader reader = new BufferedReader(new FileReader(path));
		
		String buffer= reader.readLine();
		
		if(!buffer.equals("StarDict's dict ifo file"))
			throw new  DataFormatException("Wrong format for the file provided");

		while((buffer=reader.readLine())!= null){
			String [] tokens = buffer.split("=");
			if (tokens.length != 2)
				continue;
				
			if(tokens[0].equals("version")){
				version = tokens[1];
			}else if(buffer.startsWith("bookname")){
				bookName = tokens[1];
			}else if(tokens[0].equals("wordcount")){
				wordCount = Integer.parseInt(tokens[1]);
			}else if(tokens[0].equals("synwordcount")){
				synWordCount = Integer.parseInt(tokens[1]);
			}else if(tokens[0].equals("idxfilesize")){
				idxFileSize = Integer.parseInt(tokens[1]);
			}else if(tokens[0].equals("idxoffsetbits")){
				idxOffsetBits = Integer.parseInt(tokens[1]);
			}else if(tokens[0].equals("author")){
				 author = tokens[1];
			}else if(tokens[0].equals("email")){
				 email = tokens[1];
			}else if(tokens[0].equals("website")){
				  website = tokens[1];
			}else if(tokens[0].equals("description")){
				  description = tokens[1];
			}else if(tokens[0].equals("date")){
				  date = tokens[1];
			}else if(tokens[0].equals("sameTypeSequence")){
				  sameTypeSequence = tokens[1];
			}
		}
		reader.close();
		if(bookName == null || wordCount== 0 || idxFileSize == 0)
			throw new  DataFormatException("not all mandantory fields provided in the file.");
	}
	
	public String getVersion() {
		return version;
	}
	public String getBookName() {
		return bookName;
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
	public int getIdxOffsetBits() {
		return idxOffsetBits;
	}
	public int getSynWordCount() {
		return synWordCount;
	}
}
