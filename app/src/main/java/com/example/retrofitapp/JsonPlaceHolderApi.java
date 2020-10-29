package com.example.retrofitapp;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

public interface JsonPlaceHolderApi {

    @GET("posts")// if you need call specifed user post or if you want you call all post-
    Call<List<Post>> getPosts(@Query("userId") Integer[] userID,
                              @Query("_sort") String sort,
                              @Query("_order") String order
                              );

    @GET("posts")//just call one user post
    Call<List<Post>> getPosts(@QueryMap Map<String ,String > parameters);


    @GET("/posts/{id}/comments")
    Call<List<Comment>> getComments(@Path("id") int postId);//dont same name like id and post id


    @GET//call comment by url
    Call<List<Comment>> getComments(@Url String url);

    //create post//
    //1st way to create data
    @POST("posts")
    Call<Post> createPost(@Body Post post);  //1st way to create data
    //1st way to create data

    //2nd way
    @FormUrlEncoded
    @POST("posts")

    Call<Post> createPost(
            @Field("userId") int userId,
            @Field("title") String title,
            @Field("body") String text
    );
    //2nd way

    //3rd way
    @FormUrlEncoded
    @POST("posts")
    Call<Post> createPost(@FieldMap Map<String, String> fields);
    //3rd way

    //create post//
}
