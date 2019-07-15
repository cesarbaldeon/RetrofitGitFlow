package pe.edu.cibertec.retrofirgitflow.domain.commet_interactor;



import java.util.List;

import pe.edu.cibertec.retrofirgitflow.data.entities.Comment;

public interface ICommentInterator {

    interface IPostCommentCallBack{
        void onSuccess(List<Comment> listComments);
        void onError(String errorMsg);
    }

    void getCommentsOfPost(int postId,IPostCommentCallBack callBack);


}
