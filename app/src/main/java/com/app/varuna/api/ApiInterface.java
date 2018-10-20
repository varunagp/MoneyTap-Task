package com.app.varuna.api;

import com.app.varuna.model.Wiki;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Varun on 8/18/2017.
 */

public interface ApiInterface {

    @GET("/w/api.php")
    Call<Wiki> getWikiData(@Query("action") String action,
                           @Query("format") String format,
                           @Query("prop") String prop,
                           @Query("iwurl") String iwurl,
                           @Query("generator") String generator,
                           @Query("redirects") String redirects,
                           @Query("formatversion") String formatversion,
                           @Query("piprop") String piprop,
                           @Query("pithumbsize") String pithumbsize,
                           @Query("pilimit") String pilimit,
                           @Query("wbptterms") String wbptterms,
                           @Query("inprop") String inprop,
                           @Query("gpssearch") String gpssearch,
                           @Query("gpslimit") String gpslimit);
}
