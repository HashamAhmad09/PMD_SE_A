package com.example.myapplication.RestAPI;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MyRetrofit
{
    public static Retrofit retrofit;
    public static String URL="https://jsonplaceholder.typicode.com/";
    public static Retrofit getRetrofit()
    {
        if (retrofit==null)
        {
            retrofit= new Retrofit.Builder()
                    .baseUrl(URL)
                    .addConverterFactory(GsonConverterFactory.create())//udhr sb json pra issliye convert kr rahe
                    .build();
        }
        return retrofit;
    }
}
