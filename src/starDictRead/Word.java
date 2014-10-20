package starDictRead;

public class Word {
	public final String word;
	public final int offset, size;
	
	private String data, meaning;
	public Word(String word, int offset, int size){
		this.word = word;
		this.offset = offset;
		this.size = size;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getMeaning() {
		return meaning;
	}
	public void setMeaning(String meaning) {
		this.meaning = meaning;
	}
}
