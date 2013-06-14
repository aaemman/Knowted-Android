package com.canal5.knowted;

import ServerConnector.createPostThread;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends Activity {

	static final String[] Notes = new String[] {};

	static final String[] NoteDates = new String[] {};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Button bPost = (Button) findViewById(R.id.bPost);
		bPost.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				EditText etNewNote = (EditText) findViewById(R.id.etNewNote);

				String NoteText = etNewNote.getText().toString();

				createPostThread cpt = new createPostThread(
						getApplicationContext(), NoteText,
						getString(R.string.auth_token),
						getString(R.string.notesURL));
				cpt.execute();

				etNewNote.setText("");

			}

		});
		getAllNotesThread gant = new getAllNotesThread(getApplicationContext(),
				getString(R.string.auth_token), getString(R.string.notesURL));
		gant.start();

		ListView lvNotes = (ListView) findViewById(R.id.lvNotes);
		lvNotes.setAdapter(new NoteArrayAdapter(this, Notes, NoteDates));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
