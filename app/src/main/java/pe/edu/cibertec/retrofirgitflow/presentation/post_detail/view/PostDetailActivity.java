package pe.edu.cibertec.retrofirgitflow.presentation.post_detail.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import pe.edu.cibertec.retrofirgitflow.R;
import pe.edu.cibertec.retrofirgitflow.data.entities.Post;
import pe.edu.cibertec.retrofirgitflow.domain.post_detail_interactor.PostInteractorImpl;
import pe.edu.cibertec.retrofirgitflow.presentation.post_detail.IPostDetailContract;
import pe.edu.cibertec.retrofirgitflow.presentation.post_detail.presenter.PostPresenter;


public class PostDetailActivity extends AppCompatActivity implements IPostDetailContract.IView {
    private Post post = new Post();
    private int postid;
     PostPresenter presenter;
    private TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_detail);
        textViewResult = findViewById(R.id.textViewResult);
        presenter = new PostPresenter(new PostInteractorImpl());
        presenter.attachView(this);

        postid = getIntent().getIntExtra("post_id",-1);

        if(postid == -1){
            Toast.makeText(this,"No has mandado un post id",Toast.LENGTH_SHORT);
            finish();
        }
      presenter.getPost(postid);

    }

    @Override
    public void showError(String errorMsg) {
        Toast.makeText(this,errorMsg,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void getPostSuccess(Post post) {
        textViewResult.setText("Id" + String.valueOf(post.getId()) + "\n"
                +"UserId" + String.valueOf(post.getUserId()) + "\n"
                + "Title" + post.getTitle() + "\n"
                + "Text" + post.getText() + "\n");
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
