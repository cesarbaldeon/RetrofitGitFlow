package pe.edu.cibertec.retrofirgitflow.domain.post_detail_interactor;

import java.util.List;

import pe.edu.cibertec.retrofirgitflow.data.entities.Post;

public interface IPostInteractor {

    interface IPostCallBack{
        void onSuccess(Post post);
        void onError(String errorMsg);
    }

    void getPost(int postid,IPostCallBack callBack);

}
