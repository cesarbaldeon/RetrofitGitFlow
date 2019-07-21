package pe.edu.cibertec.retrofirgitflow.di.module;

import dagger.Module;
import dagger.Provides;
import pe.edu.cibertec.retrofirgitflow.domain.main_interactor.IMainInteractor;
import pe.edu.cibertec.retrofirgitflow.domain.main_interactor.MainInteractorImpl;
import pe.edu.cibertec.retrofirgitflow.presentation.main.presenter.MainPresenter;

@Module
public class PresentatioModule {
    @Provides
    MainPresenter provideMainPresenter(IMainInteractor mainInteractor){
        return new MainPresenter(mainInteractor);
    }

    @Provides
    IMainInteractor provideMainInteractor(){
        return new MainInteractorImpl();
    }
}
