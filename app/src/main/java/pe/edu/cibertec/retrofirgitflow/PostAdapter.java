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
    private ClickListener clickListener;

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView title, id_pos;

        public MyViewHolder(View view) {
            super(view);
            view.setOnClickListener(this);
            id_pos = (TextView) view.findViewById(R.id.id_pos);
            title = (TextView) view.findViewById(R.id.title);
        }

        @Override
        public void onClick(View v) {
         clickListener.onItemClick(getAdapterPosition());
        }
    }

    public final void setOnItemClickListener(ClickListener clickListener){
        this.clickListener = clickListener;
    }

  public interface ClickListener{
        void onItemClick(int position);
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

        holder.id_pos.setText( String.valueOf(post.getId()));
        holder.title.setText(post.getTitle());
    }

    @Override
    public int getItemCount() {
        return postList.size();
    }
}
