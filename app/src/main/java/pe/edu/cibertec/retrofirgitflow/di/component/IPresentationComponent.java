package pe.edu.cibertec.retrofirgitflow.di.component;

import dagger.Component;
import pe.edu.cibertec.retrofirgitflow.di.module.PostDetailModule;
import pe.edu.cibertec.retrofirgitflow.di.module.PresentatioModule;
import pe.edu.cibertec.retrofirgitflow.presentation.main.view.MainActivity;
import pe.edu.cibertec.retrofirgitflow.presentation.post_detail.view.PostDetailActivity;

@Component(modules = {PresentatioModule.class, PostDetailModule.class})
public interface IPresentationComponent {
    void inject(MainActivity mainActivity);
    void inject(PostDetailActivity postDetailActivity);
}
