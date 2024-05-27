package com.example.myapplication.RestAPI;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RestAPIMainActivity extends AppCompatActivity {

    MyRetrofitInterface myRetrofitInterface;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_rest_apimain);
        myRetrofitInterface = MyRetrofit.getRetrofit()
                .create(MyRetrofitInterface.class);
        recyclerView= findViewById(R.id.myretrofitrecyclerview);
       // GetMyRetrofit();
        GetMyComments();
       // GetMyCommentsBy();
        CreatePost();

    }

    private void CreatePost() {
        MyRestAPiModel model = new MyRestAPiModel(10,2,"Title","Body");
        myRetrofitInterface.createPost(model);
        Call<MyRestAPiModel> myPost = myRetrofitInterface.createPost(model);
        myPost.enqueue(new Callback<MyRestAPiModel>() {
            @Override
            public void onResponse(Call<MyRestAPiModel> call, Response<MyRestAPiModel> response) {
                if(response.isSuccessful())
                {
                    Log.d("TAG"," "+response.body().getUserId()+" \n "+response.body().getTitle()+ "\n"+" "+response.body().getBody());
                }
            }

            @Override
            public void onFailure(Call<MyRestAPiModel> call, Throwable t) {

            }
        });
    }

    private void GetMyComments()
    {/*
        Call<List<MyComentsModel>> list = myRetrofitInterface.getMyCommentsQuery(4);//getMyCommnets(2);//getComments();
        list.enqueue(new Callback<List<MyComentsModel>>() {
            @Override
            public void onResponse(Call<List<MyComentsModel>> call, Response<List<MyComentsModel>> response) {
                if(response.isSuccessful())
                {
                    for (MyComentsModel comentsModel: response.body())
                    {
                        Log.d("TAG","ID"+comentsModel.getId()
                                +"Post ID"+comentsModel.getPostId()
                                +"User"+comentsModel.getName()
                                +"Email"+comentsModel.getEmail());
                    }
                }
            }

            @Override
            public void onFailure(Call<List<MyComentsModel>> call, Throwable t) {

            }
        });*/
    }

    private void GetMyCommentsBy()
    {
        Map<String,String> argument= new HashMap<>();
        argument.put("postID", "5");
        argument.put("_sort","id");
        argument.put("_order","desc");
        Call<List<MyComentsModel>> list = myRetrofitInterface.getMyCommmentsByArgument(argument);//getMyCommentsQuery(5,"id","desc");
        list.enqueue(new Callback<List<MyComentsModel>>() {
            @Override
            public void onResponse(Call<List<MyComentsModel>> call, Response<List<MyComentsModel>> response) {
                if(response.isSuccessful())
                {
                    for (MyComentsModel comentsModel: response.body())
                    {
                        Log.d("TAG","ID"+comentsModel.getId()
                                +"Post ID"+comentsModel.getPostId()
                                +"User"+comentsModel.getName()
                                +"Email"+comentsModel.getEmail());
                    }
                }
            }

            @Override
            public void onFailure(Call<List<MyComentsModel>> call, Throwable t) {

            }
        });

    }

    private void GetMyRetrofit() {
        myRetrofitInterface.getList().enqueue(new Callback<List<MyRestAPiModel>>() {
            @Override
            public void onResponse(Call<List<MyRestAPiModel>> call, Response<List<MyRestAPiModel>> response) {
               if (response.body().size()>0)
               {
                   List<MyRestAPiModel> list = response.body();
                   MyRestAdapter adapter= new MyRestAdapter(list,RestAPIMainActivity.this);
                   LinearLayoutManager linearLayoutManager = new LinearLayoutManager(RestAPIMainActivity.this);
                   recyclerView.setLayoutManager(linearLayoutManager);
                   recyclerView.setAdapter(adapter);
                   Toast.makeText(RestAPIMainActivity.this, "Data Retrieved", Toast.LENGTH_SHORT).show();
               }
               else {
                   Toast.makeText(RestAPIMainActivity.this, "List is Empty", Toast.LENGTH_SHORT).show();
               }
            }

            @Override
            public void onFailure(Call<List<MyRestAPiModel>> call, Throwable t) {
                Toast.makeText(RestAPIMainActivity.this,"Failure",Toast.LENGTH_SHORT)
                        .show();
            }
        });
    }
}