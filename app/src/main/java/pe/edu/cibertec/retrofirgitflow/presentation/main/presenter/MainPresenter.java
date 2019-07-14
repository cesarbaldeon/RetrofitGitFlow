package pe.edu.cibertec.retrofirgitflow.presentation.main.presenter;

import java.util.List;

import pe.edu.cibertec.retrofirgitflow.data.entities.Post;
import pe.edu.cibertec.retrofirgitflow.domain.main_interactor.IMainInteractor;
import pe.edu.cibertec.retrofirgitflow.presentation.main.IMainContract;

public class MainPresenter implements IMainContract.IPresenter {
    IMainContract.IView view;
    IMainInteractor interactor;

    public MainPresenter(IMainInteractor interactor){
        this.interactor = interactor;
    }

    @Override
    public void attachView(IMainContract.IView view) {
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
    public void getAllPost() {
       //aca usaremos un interceptor de la capa domain
        view.showProgressBar();
        interactor.getAllPost(new IMainInteractor.IMainCallBack() {
            @Override
            public void onSuccess(List<Post> postList) {
                if(isViewAttched()){
                    view.getAllPostSuccess(postList);
                    view.hideProgressBar();
                }
            }

            @Override
            public void onError(String errorMsg) {
                if(isViewAttched()) {
                    view.showError(errorMsg);
                    view.hideProgressBar();
                }
            }
        });
    }
}
