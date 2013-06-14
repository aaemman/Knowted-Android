package ServerConnector;

import java.io.IOException;

import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

public class createPostThread extends AsyncTask<String, Integer, String> {
	private final String message;
	private final Context context;
	private final String auth_token;
	private final String requestURL;

	public createPostThread(Context context, String message, String auth_token,
			String requestURL) {
		// TODO Auto-generated constructor stub
		this.message = message;
		this.context = context;
		this.auth_token = auth_token;
		this.requestURL = requestURL;
	}

	
	private boolean checkNoteLength() {
		// TODO Auto-generated method stub
		if (message == null) {
			return false;
		}
		return true;
	}

	@Override
	protected String doInBackground(String... params) {
		// TODO Auto-generated method stub
		if (checkNoteLength()) {

			JSONObject obj = new JSONObject();
			JSONObject note = new JSONObject();
			String returnString = new String();

			try {
				note.put("text", message);
				obj.put("note", note);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			System.out.println("Sending: " + obj.toString() + "to "
					+ requestURL);
			returnString = sendReceiveJSON.createEvent(requestURL, obj,
					auth_token);
			
			System.out.println("Message from " + requestURL + ": "
					+ returnString + "\n");
			return returnString;

		}else{			
			System.out.println("ERROR: note content cannot be blank");
		}
		return null;
	}

}
