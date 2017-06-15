package com.applaudstudios.android.popularmoviesp2;


import android.app.FragmentManager;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


/**
 * Created by wjplaud83 on 5/19/17.
 */

public class MovieDetailActivity extends ActionBarActivity {

    // COMPLETED (3) Create an instance variable storing a Cursor called mData
    // The data from the DroidTermsExample content provider
    private Cursor mData;

    // The current state of the app
    private int mCurrentState;

    private Button mButton;

    // This state is when the word definition is hidden and clicking the button will therefore
    // show the definition
    private final int STATE_HIDDEN = 0;

    // This state is when the word definition is shown and clicking the button will therefore
    // advance the app to the next word
    private final int STATE_SHOWN = 1;


    private final String LOG_TAG = MovieDetailActivity.class.getSimpleName();
    private FragmentManager fragmentManager = getFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);

        if (savedInstanceState == null) {
            fragmentManager.beginTransaction()
                    .add(R.id.container, new com.applaudstudios.android.popularmoviesp2.MovieDetailFragment())
                    .commit();
        }
        getSupportActionBar().setElevation(0f);
    }

    public void onButtonClick(View view) {

        Toast.makeText(this, R.string.show_favorite, Toast.LENGTH_LONG).show();

        }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == 0) {
            startActivity(new Intent(this, com.applaudstudios.android.popularmoviesp2.SettingsActivity.class));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
