package pe.edu.cibertec.retrofirgitflow.presentation.main.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import pe.edu.cibertec.retrofirgitflow.R;
import pe.edu.cibertec.retrofirgitflow.TriggerClick;
import pe.edu.cibertec.retrofirgitflow.data.entities.Post;
import pe.edu.cibertec.retrofirgitflow.domain.main_interactor.MainInteractorImpl;
import pe.edu.cibertec.retrofirgitflow.network.JsonPlaceHolderApi;
import pe.edu.cibertec.retrofirgitflow.presentation.main.IMainContract;
import pe.edu.cibertec.retrofirgitflow.presentation.main.presenter.MainPresenter;
import pe.edu.cibertec.retrofirgitflow.presentation.post_detail.view.PostDetailActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity
        implements IMainContract.IView {

    //private TextView textViewResult;
    private ProgressBar progressBarMain;
    private List<Post> postList = new ArrayList<>();
    private RecyclerView recyclerView;
    private PostAdapter mAdapter;
    private MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter = new MainPresenter(new MainInteractorImpl());
        presenter.attachView(this);

        recyclerView =  findViewById(R.id.recycler_view);
       // textViewResult = findViewById(R.id.textViewResult);
        progressBarMain = findViewById(R.id.progressBar);


        mAdapter = new PostAdapter(postList);
        mAdapter.setOnItemClickListener(new IPostClickListener() {
            @Override
            public void onClick(int position) {
                gotToDetailPost(postList.get(position).getId());
            }
        });
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(mAdapter);
        presenter.getAllPost();
        //mAdapter.notifyDatadetahViewSetChanged();
    }



    @Override
    public void showError(String errorMsg) {
        Toast.makeText(this,errorMsg,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showProgressBar() {
        progressBarMain.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBar() {
        progressBarMain.setVisibility(View.GONE);
    }

    @Override
    public void getAllPostSuccess(List<Post> postList) {
          this.postList.addAll(postList);
          mAdapter.notifyDataSetChanged();
    }

    @Override
    public void gotToDetailPost(int postId) {
        Intent intent = new Intent(this, PostDetailActivity.class);
        intent.putExtra("post_id",postId);
        startActivity(intent);
    }

    @Override
    protected void onDestroy() {
        presenter.detahView();
        super.onDestroy();
    }

    @Override
    public void onDetachedFromWindow() {
        presenter.detahView();
        super.onDetachedFromWindow();

    }
}
