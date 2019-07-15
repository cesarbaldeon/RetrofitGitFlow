package pe.edu.cibertec.retrofirgitflow.presentation.main.view;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import java.util.List;

import pe.edu.cibertec.retrofirgitflow.R;
import pe.edu.cibertec.retrofirgitflow.data.entities.Post;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.MyViewHolder>{

    private IPostClickListener clickListener;
    private List<Post> postList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, texto;

        public MyViewHolder(View view) {
            super(view);
            view.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            if (clickListener != null) {
                                                clickListener.onClick(getAdapterPosition());
                                            }
                                        }
                                    });
            texto = (TextView) view.findViewById(R.id.texto);
            title = (TextView) view.findViewById(R.id.title);
        }
    }

    public final void setOnItemClickListener(IPostClickListener clickListener){
        this.clickListener = clickListener;
    }

    public PostAdapter(List<Post> postList) {
        this.postList = postList;
    }

    @Override
    public PostAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.datos_row, parent, false);
        return new PostAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull PostAdapter.MyViewHolder holder, int position) {
        Post post = postList.get(position);

        holder.texto.setText(post.getText());
        holder.title.setText(post.getTitle());
    }

    @Override
    public int getItemCount() {
        return postList.size();
    }
}
