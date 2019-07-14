package pe.edu.cibertec.retrofirgitflow;


import android.widget.Toast;

import pe.edu.cibertec.retrofirgitflow.presentation.main.view.MainActivity;


public class TriggerClick {

    public final static void selectItem(int id, MainActivity mainActivity) {
        Toast.makeText(mainActivity,"Esta Funcionalidad es de Paga", Toast.LENGTH_SHORT).show();
    }
}
