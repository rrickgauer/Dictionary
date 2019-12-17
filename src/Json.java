
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class Json {
	
	private static String streamToString(InputStream inputStream) {
		String text = new Scanner(inputStream, "UTF-8").useDelimiter("\\Z").next();
		return text;
	}
	
	private static String createUrl(String word, String category, int max) {
		String result = "https://api.datamuse.com/words?&rel_" + category + "=" + word + "&max=" + Integer.toString(max);
		return result;
	}

	public static String jsonGetRequest(String word, String category, int max) {
		String json = null;
		String requestUrl = createUrl(word, category, max);
		
		try {
			URL url = new URL(requestUrl);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setDoOutput(true);
			connection.setInstanceFollowRedirects(false);
			connection.setRequestMethod("GET");
			connection.setRequestProperty("Content-Type", "application/json");
			connection.setRequestProperty("charset", "utf-8");
			connection.connect();
			InputStream inStream = connection.getInputStream();
			json = streamToString(inStream); // input stream to string
		}
		catch (IOException ex) {
			ex.printStackTrace();
		}
		return json;
	}
}
