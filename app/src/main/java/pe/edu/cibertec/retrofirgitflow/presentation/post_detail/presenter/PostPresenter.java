package pe.edu.cibertec.retrofirgitflow.presentation.post_detail.presenter;

import java.util.List;

import pe.edu.cibertec.retrofirgitflow.data.entities.Comment;
import pe.edu.cibertec.retrofirgitflow.data.entities.Post;
import pe.edu.cibertec.retrofirgitflow.domain.commet_interactor.ICommentInterator;
import pe.edu.cibertec.retrofirgitflow.domain.post_detail_interactor.IPostInteractor;
import pe.edu.cibertec.retrofirgitflow.presentation.post_detail.IPostDetailContract;

public class PostPresenter implements IPostDetailContract.IPresenter {
    IPostDetailContract.IView view;
    IPostInteractor interactor;
    ICommentInterator interatorComment;

    public PostPresenter(IPostInteractor postInteractor,ICommentInterator commentInterator) {
        this.interactor = postInteractor;
        this.interatorComment = commentInterator;
    }

    @Override
    public void attachView(IPostDetailContract.IView view) {
        this.view = view;
    }

    @Override
    public void detahView() {
        view = null;
    }

    @Override
    public boolean isViewAttched() {
        return view !=null;
    }


    @Override
    public void getPost(int postId) {
//aca usaremos un interceptor de la capa domain
        interactor.getPost(postId, new IPostInteractor.IPostCallBack() {
            @Override
            public void onSuccess(Post post) {
                if(isViewAttched()){
                    view.getPostSuccess(post);
                }
            }

            @Override
            public void onError(String errorMsg) {
                if(isViewAttched()) {
                    view.showError(errorMsg);
                }
            }
        });

    }

    @Override
    public void getCommets(int postId) {
        interatorComment.getCommentsOfPost(postId, new ICommentInterator.IPostCommentCallBack() {
            @Override
            public void onSuccess(List<Comment> listComments) {
                if(isViewAttched()){
                    view.getCommentSuccess(listComments);
                }
            }

            @Override
            public void onError(String errorMsg) {
                if(isViewAttched()) {
                    view.showError(errorMsg);
                }
            }
        });
    }
}
