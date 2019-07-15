package pe.edu.cibertec.retrofirgitflow.presentation.post_detail.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import pe.edu.cibertec.retrofirgitflow.R;
import pe.edu.cibertec.retrofirgitflow.data.entities.Comment;
import pe.edu.cibertec.retrofirgitflow.data.entities.Post;
import pe.edu.cibertec.retrofirgitflow.domain.commet_interactor.CommentInteractorImpl;
import pe.edu.cibertec.retrofirgitflow.domain.post_detail_interactor.PostInteractorImpl;
import pe.edu.cibertec.retrofirgitflow.presentation.post_detail.IPostDetailContract;
import pe.edu.cibertec.retrofirgitflow.presentation.post_detail.presenter.PostPresenter;


public class PostDetailActivity extends AppCompatActivity implements IPostDetailContract.IView {
    private Post post = new Post();
    private int postid;
     PostPresenter presenter;
    private TextView txtId,txtUserId,txtTitle,txtTexto;
    private List<Comment> commentList = new ArrayList<>();
    private RecyclerView recyclerViewComment;
    private CommentAdapter commentAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_detail);
        txtId = findViewById(R.id.txtid);
        txtUserId = findViewById(R.id.txtUserId);
        txtTitle = findViewById(R.id.txtTitle);
        txtTexto = findViewById(R.id.txtTexto);

        recyclerViewComment = findViewById(R.id.recyclerViewComment);

        presenter = new PostPresenter(new PostInteractorImpl(), new CommentInteractorImpl());
        presenter.attachView(this);

        commentAdapter = new CommentAdapter(commentList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerViewComment.setLayoutManager(mLayoutManager);
        recyclerViewComment.setAdapter(commentAdapter);

        postid = getIntent().getIntExtra("post_id",-1);

        if(postid == -1){
            Toast.makeText(this,"No has mandado un post id",Toast.LENGTH_SHORT);
            finish();
        }
      presenter.getPost(postid);
      presenter.getCommets(postid);

    }

    @Override
    public void showError(String errorMsg) {
        Toast.makeText(this,errorMsg,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void getPostSuccess(Post post) {

        txtId.setText("Id: " + String.valueOf(post.getId()));
        txtUserId.setText("UserId: " + String.valueOf(post.getUserId()));
        txtTitle.setText("Title: " + post.getTitle());
        txtTexto.setText("Body: " + post.getText() );
    }

    @Override
    public void getCommentSuccess(List<Comment> commentList) {
        this.commentList.addAll(commentList);
        commentAdapter.notifyDataSetChanged();
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
