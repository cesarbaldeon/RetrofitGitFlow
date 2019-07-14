package pe.edu.cibertec.retrofirgitflow.presentation.post_detail.presenter;

import pe.edu.cibertec.retrofirgitflow.data.entities.Post;
import pe.edu.cibertec.retrofirgitflow.domain.post_detail_interactor.IPostInteractor;
import pe.edu.cibertec.retrofirgitflow.presentation.post_detail.IPostDetailContract;

public class PostPresenter implements IPostDetailContract.IPresenter {
    IPostDetailContract.IView view;
    IPostInteractor interactor;

    public PostPresenter(IPostInteractor postInteractor) {
        this.interactor = postInteractor;
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
}
