package pe.edu.cibertec.retrofirgitflow.presentation.post_detail;

import java.util.List;

import pe.edu.cibertec.retrofirgitflow.data.entities.Comment;
import pe.edu.cibertec.retrofirgitflow.data.entities.Post;

public interface IPostDetailContract {

    interface IView{
        void showError(String errorMsg);
        void getPostSuccess(Post post);
        void getCommentSuccess(List<Comment> commentList);
    }

    interface IPresenter{
        void attachView(IPostDetailContract.IView view);
        void detahView();
        boolean isViewAttched();
        void getPost(int postId);
        void getCommets(int postId);
    }
}
