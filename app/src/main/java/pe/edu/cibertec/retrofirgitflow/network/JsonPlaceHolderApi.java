package pe.edu.cibertec.retrofirgitflow.network;

import java.util.List;

import pe.edu.cibertec.retrofirgitflow.data.entities.Comment;
import pe.edu.cibertec.retrofirgitflow.data.entities.Post;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface JsonPlaceHolderApi {

    @GET("posts")
    Call<List<Post>> getPosts();

    @GET("posts/{id}")
    Call<Post> getPost(@Path("id") int postId);

    @GET("/comments")
    Call<List<Comment>> getCommets(@Query("postId") int postId);

}
