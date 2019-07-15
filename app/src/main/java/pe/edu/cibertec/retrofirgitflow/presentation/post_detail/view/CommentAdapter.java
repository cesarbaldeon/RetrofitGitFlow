package pe.edu.cibertec.retrofirgitflow.presentation.post_detail.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import pe.edu.cibertec.retrofirgitflow.R;
import pe.edu.cibertec.retrofirgitflow.data.entities.Comment;

public class CommentAdapter extends RecyclerView.Adapter<CommentAdapter.MyViewHolder> {

    private List<Comment> commentList;


    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView txtemail, txtcommet;

        public MyViewHolder(View view) {
            super(view);

            txtemail = (TextView) view.findViewById(R.id.txtemail);
            txtcommet = (TextView) view.findViewById(R.id.txtcommet);
        }
    }

    public CommentAdapter(List<Comment> commentList) {
        this.commentList = commentList;
    }

    @Override
    public CommentAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.comment_row, parent, false);
        return new CommentAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Comment comment = commentList.get(position);

        holder.txtemail.setText(String.valueOf(comment.getEmail()));
        holder.txtcommet.setText(String.valueOf(comment.getComentario()));
    }

    @Override
    public int getItemCount() {
        return commentList.size();
    }

}
