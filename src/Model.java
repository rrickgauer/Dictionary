
import com.google.gson.Gson;


public class Model {
	
	private String word;		// word to be searched for
	private String category;	// synonym, antonym, rhyme, or approx rhyme
	private int max;			// max number of search results to get
	
	public Model() {
		word = "none";
		category = "syn";
		max = 20;
	}
	
	public Model(String word, String category, int max) {
		this.word = word;
		setCategory(category);
		setMax(max);
	}
	
	public void setCategory(String category) {
		
		switch(category) {
			case "syn":
				this.category = category;
				break;
			case "ant":
				this.category = category;
				break;
			case "rhy":
				this.category = category;
				break;
			case "nry":
				this.category = category;
				break;
			default:
				this.category = "syn";
				break;
		}
	}
	
	public void setMax(int max) {
		if (max > 20)
			this.max = 20;
		else if (max < 1) 
			this.max = 1;
		else
			this.max = max;
	}
	
	public String getWord() {
		return word;
	}
	
	public String getCategory() {
		return category;
	}
	
	public int getMax() {
		return max;
	}
	
	public Response[] getResponses() {
		String json = Json.jsonGetRequest(word, category, max);
		Gson gson = new Gson();
		return gson.fromJson(json, Response[].class);
	}
}
