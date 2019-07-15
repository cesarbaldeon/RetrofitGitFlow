package pe.edu.cibertec.retrofirgitflow.network;

import java.util.List;

import pe.edu.cibertec.retrofirgitflow.data.entities.Comment;
import pe.edu.cibertec.retrofirgitflow.data.entities.Post;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface JsonPlaceHolderApi {

    @GET("posts")
    Call<List<Post>> getPosts();

    @GET("posts/{id}")
    Call<Post> getPost(@Path("id") int postId);

    @GET("/posts/{id}/comments")
    Call<List<Comment>> getCommets(@Path("id") int postId);

}
