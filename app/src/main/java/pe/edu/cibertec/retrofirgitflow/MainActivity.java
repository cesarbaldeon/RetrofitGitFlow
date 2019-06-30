package pe.edu.cibertec.retrofirgitflow;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private TextView textViewResult;
    private List<Post> postList = new ArrayList<>();
    private RecyclerView recyclerView;
    private PostAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView =  findViewById(R.id.recycler_view);
        textViewResult = findViewById(R.id.textViewResult);

        mAdapter = new PostAdapter(postList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        prepareMovieData();

    }

    private void prepareMovieData() {
        callService();
        mAdapter.notifyDataSetChanged();
    }


    private void callService() {
        final Retrofit retrofit =  new Retrofit.Builder()
                             .baseUrl("http://jsonplaceholder.typicode.com")
                             .addConverterFactory(GsonConverterFactory.create())
                             .build();
        JsonPlaceHolderApi jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);
        Call<List<Post>>  call = jsonPlaceHolderApi.getPosts();

        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                if(!response.isSuccessful()){
                    textViewResult.setText("Code: " + response.code());
                }else {
                    textViewResult.setText("Funciono");
                    postList = response.body();
                }
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
              textViewResult.setText(t.getMessage());
              t.printStackTrace();
            }
        });
    }
}
