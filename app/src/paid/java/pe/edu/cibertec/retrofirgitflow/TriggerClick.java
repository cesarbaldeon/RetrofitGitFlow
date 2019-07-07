package pe.edu.cibertec.retrofirgitflow;


import android.content.Intent;

import pe.edu.cibertec.retrofirgitflow.paid.PostDetailActivity;

public class TriggerClick {

    public final static void selectItem(int id, MainActivity mainActivity) {
        Intent intent = new Intent(mainActivity, PostDetailActivity.class);
        intent.putExtra("post_id",id);
        mainActivity.startActivity(intent);
    }
}
