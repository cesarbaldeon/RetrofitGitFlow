package pe.edu.cibertec.retrofirgitflow.domain.post_detail_interactor;

import java.util.List;

import pe.edu.cibertec.retrofirgitflow.data.entities.Post;
import pe.edu.cibertec.retrofirgitflow.network.ApiClient;
import pe.edu.cibertec.retrofirgitflow.network.JsonPlaceHolderApi;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostInteractorImpl implements IPostInteractor {
    @Override
    public void getPost(int postid,IPostCallBack callBack) {
        JsonPlaceHolderApi jsonPlaceHolderApi = ApiClient.getClient().create(JsonPlaceHolderApi.class);

        Call<Post> call = jsonPlaceHolderApi.getPost(postid);

        call.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                if(!response.isSuccessful()){
                    callBack.onError("Code:" + response.code());
                }else{
                    callBack.onSuccess(response.body());
                }
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                callBack.onError(t.getMessage());
            }
        });
    }
}
