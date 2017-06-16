package com.applaudstudios.android.popularmoviesp2;


import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;


/**
 * Created by wjplaud83 on 5/19/17.
 */

public class MovieDetailActivity extends ActionBarActivity {

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

    public void onTrailerClick(View view) {

        Toast.makeText(this, R.string.show_trailer, Toast.LENGTH_LONG).show();

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
