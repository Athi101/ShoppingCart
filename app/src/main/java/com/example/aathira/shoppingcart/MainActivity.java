package com.example.aathira.shoppingcart;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.aathira.shoppingcart.retrofit.ApiClient;
import com.example.aathira.shoppingcart.retrofit.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.rv_recycle);

        collectPhones();
    }

    public void collectPhones() {
        ApiInterface service = ApiClient.getRetrofitInstance().create(ApiInterface.class);
        Call<List<Phone>> call = service.getPhone();

        call.enqueue(new Callback<List<Phone>>() {
            @Override
            public void onResponse(Call<List<Phone>> call, Response<List<Phone>> response) {
                Log.v(MainActivity.class.toString(), response.body().toString());
                recyclerStuff(response.body());

            }

            @Override
            public void onFailure(Call<List<Phone>> call, Throwable t) {
                Log.e(MainActivity.class.toString(), t.toString());
            }
        });

    }

    public void recyclerStuff(List<Phone> phones) {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(), 2, GridLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(gridLayoutManager);
        PhoneAdapter adapter = new PhoneAdapter(phones, this);
        recyclerView.setAdapter(adapter);
    }

}
