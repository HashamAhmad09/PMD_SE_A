package com.example.myapplication.RestAPI;

import java.util.List;
import java.util.Map;
import java.util.Stack;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public interface MyRetrofitInterface
{
    @GET("posts")
    Call<List<MyRestAPiModel>> getList();
    @GET("posts/1/comments")
    Call<List<MyComentsModel>> getComments();
    @GET("post/{id}/comments")
    Call<List<MyComentsModel>> getMyCommnets(@Path("id")int id);
    @GET("comments")
    Call<List<MyComentsModel>> getMyCommentsQuery(@Query("postId") int id,
                                                  @Query("_sort") String sort,
                                                  @Query("_order") String orderBy);
    @GET("comments")
    Call<List<MyComentsModel>> getMyCommmentsByArgument(@QueryMap Map<String, String> Argument);

    @POST("posts")
    Call<MyRestAPiModel> createPost(@Body MyRestAPiModel post);

}
