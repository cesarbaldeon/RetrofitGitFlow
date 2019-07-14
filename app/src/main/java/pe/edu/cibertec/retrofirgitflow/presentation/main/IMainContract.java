package pe.edu.cibertec.retrofirgitflow.presentation.main;

import java.util.List;

import pe.edu.cibertec.retrofirgitflow.data.entities.Post;

public interface IMainContract {

    interface IView{
        void showError(String errorMsg);
        void showProgressBar();
        void hideProgressBar();
        void getAllPostSuccess(List<Post> postList);
        void gotToDetailPost(int postId);
    }

    interface IPresenter{
        void attachView(IView view);
        void detahView();
        boolean isViewAttched();
        void getAllPost();
    }

}
