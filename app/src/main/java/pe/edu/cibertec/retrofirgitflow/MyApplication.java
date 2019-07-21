package pe.edu.cibertec.retrofirgitflow;

import android.app.Application;

import pe.edu.cibertec.retrofirgitflow.di.component.DaggerIPresentationComponent;
import pe.edu.cibertec.retrofirgitflow.di.component.IPresentationComponent;
import pe.edu.cibertec.retrofirgitflow.di.module.PostDetailModule;
import pe.edu.cibertec.retrofirgitflow.di.module.PresentatioModule;

public class MyApplication extends Application {

    private IPresentationComponent appComponent;

    @Override
    public void onCreate(){
        super.onCreate();
        InicializarComponent();
    }

    void InicializarComponent(){
        appComponent = DaggerIPresentationComponent.builder()
                .presentatioModule(new PresentatioModule()).postDetailModule(new PostDetailModule())
                .build();
    }

    public IPresentationComponent getAppComponent(){
        return appComponent;
    }

}
