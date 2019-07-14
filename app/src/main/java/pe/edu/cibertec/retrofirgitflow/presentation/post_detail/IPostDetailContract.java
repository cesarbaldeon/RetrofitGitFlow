package pe.edu.cibertec.retrofirgitflow.presentation.post_detail;

import java.util.List;

import pe.edu.cibertec.retrofirgitflow.data.entities.Post;
import pe.edu.cibertec.retrofirgitflow.presentation.main.IMainContract;

public interface IPostDetailContract {

    interface IView{
        void showError(String errorMsg);
        void getPostSuccess(Post post);
    }

    interface IPresenter{
        void attachView(IPostDetailContract.IView view);
        void detahView();
        boolean isViewAttched();
        void getPost(int postId);
    }
}
