package com.applaudstudios.android.popularmoviesp2;


import android.app.FragmentManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
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

    //checkbox for a favorite movie
    public void onCheckBoxClick(View view) {

        //is it checked?
        boolean checked = ((CheckBox) view).isChecked();

        // check which checkbox is checked
        switch (view.getId()) {
            case R.id.favorite_view:
                if (checked)
                    break;
        }

        Toast.makeText(this, R.string.show_favorite, Toast.LENGTH_SHORT).show();


    }

    public void onTrailerClick(View view) {

        // Toast.makeText(this, R.string.show_trailer, Toast.LENGTH_SHORT).show();

        Button trailerBtn = (Button) findViewById(R.id.movie_trailer);
        trailerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://api.themoviedb.org/3/movie/297762/videos"));
                startActivity(intent);
            }
        });

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
