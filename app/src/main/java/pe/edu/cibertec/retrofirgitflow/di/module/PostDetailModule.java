package pe.edu.cibertec.retrofirgitflow.di.module;

import dagger.Module;
import dagger.Provides;
import pe.edu.cibertec.retrofirgitflow.domain.commet_interactor.CommentInteractorImpl;
import pe.edu.cibertec.retrofirgitflow.domain.commet_interactor.ICommentInterator;
import pe.edu.cibertec.retrofirgitflow.domain.post_detail_interactor.IPostInteractor;
import pe.edu.cibertec.retrofirgitflow.domain.post_detail_interactor.PostInteractorImpl;
import pe.edu.cibertec.retrofirgitflow.presentation.post_detail.presenter.PostPresenter;

@Module
public class PostDetailModule {
    @Provides
    PostPresenter providePostPresenter(IPostInteractor interactor, ICommentInterator interatorComent){
        return new PostPresenter(interactor,interatorComent);
    }

    @Provides
    IPostInteractor providePostInteractor(){
        return new PostInteractorImpl();
    }

    @Provides
    ICommentInterator provideCommentInteractor(){
        return new CommentInteractorImpl();
    }

}
