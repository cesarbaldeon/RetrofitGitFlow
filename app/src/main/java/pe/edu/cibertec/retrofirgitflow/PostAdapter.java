package pe.edu.cibertec.retrofirgitflow;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.MyViewHolder>{

    private List<Post> postList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, id;

        public MyViewHolder(View view) {
            super(view);

            id = (TextView) view.findViewById(R.id.id);
            title = (TextView) view.findViewById(R.id.title);
        }
    }


    public PostAdapter(List<Post> postList) {
        this.postList = postList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.datos_row, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull PostAdapter.MyViewHolder holder, int position) {
        Post post = postList.get(position);

        holder.id.setText(post.getId());
        holder.title.setText(post.getTitle());

    }

    @Override
    public int getItemCount() {
        return postList.size();
    }
}
