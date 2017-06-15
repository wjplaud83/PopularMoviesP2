package com.applaudstudios.android.popularmoviesp2;




import java.util.List;

/**
 * Created by wjplaud83 on 5/18/17.
 */
// custom interface for a call back to return results for async task
public interface AsyncResponse {

     void onTaskCompleted(List<com.applaudstudios.android.popularmoviesp2.Movie> results);


}
