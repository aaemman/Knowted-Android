package com.canal5.knowted;

import java.io.IOException;

import ServerConnector.sendReceiveJSON;
import android.content.Context;

public class getAllNotesThread extends Thread {

	private final Context context;
	private final String auth_token;
	private final String requestURL;
	private String returnString;

	public getAllNotesThread(Context context, String auth_token,
			String requestURL) {
		// TODO Auto-generated constructor stub
		this.context = context;
		this.auth_token = auth_token;
		this.requestURL = requestURL;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

		

		System.out.println("Getting all notes from: " + requestURL);

		try {
			returnString = sendReceiveJSON.getAllEvents(requestURL, auth_token);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Message from " + requestURL + ": " + returnString
				+ "\n");

	}

	
}
