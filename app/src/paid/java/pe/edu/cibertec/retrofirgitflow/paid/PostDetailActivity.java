package pe.edu.cibertec.retrofirgitflow.paid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import pe.edu.cibertec.retrofirgitflow.JsonPlaceHolderApi;
import pe.edu.cibertec.retrofirgitflow.Post;
import pe.edu.cibertec.retrofirgitflow.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PostDetailActivity extends AppCompatActivity {

    private TextView textViewResult;
    private Post post = new Post();
    private int postid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_detail);
        textViewResult = findViewById(R.id.textViewResult);
        postid = getIntent().getIntExtra("post_id",-1);

        if(postid == -1){
            Toast.makeText(this,"No has mandado un post id",Toast.LENGTH_SHORT);
            finish();
        }

        callService();
    }

    private void callService() {
        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://jsonplaceholder.typicode.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        JsonPlaceHolderApi jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);
        Call<Post> call = jsonPlaceHolderApi.getPost(postid);

        call.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                if (!response.isSuccessful()) {
                    //textViewResult.setText("Code: " + response.code());
                    Log.e("Response; ", "response.code: " + response.code());
                } else {
                    // Log.e("Response; ", "response.body: " + response.body().size());
                    post = response.body();
                    textViewResult.setText("Id" + String.valueOf(post.getId()) + "\n"
                            +"UserId" + String.valueOf(post.getUserId()) + "\n"
                            + "Title" + post.getTitle() + "\n"
                            + "Text" + post.getText() + "\n");
                }
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                //textViewResult.setText(t.getMessage());
                Log.e("Response; ", "t.getMessage(): " + t.getMessage());
                t.printStackTrace();
            }
        });
    }
}
