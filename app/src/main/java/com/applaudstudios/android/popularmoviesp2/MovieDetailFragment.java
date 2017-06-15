package com.applaudstudios.android.popularmoviesp2;


import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * Created by wjplaud83 on 5/21/17.
 */

public class MovieDetailFragment extends Fragment {

    public final String LOG_TAG = MovieDetailFragment.class.getSimpleName();
    Movie movie;

    public MovieDetailFragment() {
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_movie_detail, container, false);

        Intent intent = getActivity().getIntent();
        if (intent != null && intent.hasExtra("movies_details")) {

            movie = (Movie) intent.getParcelableExtra("movies_details");
            DisplayInfo(rootView);
        }
        return rootView;
    }

    private void DisplayInfo(View v) {
        TextView title = (TextView) v.findViewById(R.id.movie_title_view);
        ImageView poster = (ImageView) v.findViewById(R.id.poster_image_view);
        TextView releaseDate = (TextView) v.findViewById(R.id.release_date);
        TextView ratings = (TextView) v.findViewById(R.id.ratings_view);
        Button trailer =  (Button) v.findViewById(R.id.movie_trailer);
        TextView overview = (TextView) v.findViewById(R.id.synopsis_view);

        title.setText(movie.getTitle());
        Picasso.with(getActivity()).load(movie.getPoster()).into(poster);
        releaseDate.setText(movie.getReleaseDate());
        trailer.setText(movie.getTrailer());
        ratings.setText(movie.getVoteAverage() + "/10");
        overview.setText(movie.getOverview());

    }
}
