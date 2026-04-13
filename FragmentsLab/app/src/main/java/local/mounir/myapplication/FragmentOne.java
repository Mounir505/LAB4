package local.mounir.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentOne extends Fragment {

    private TextView tv;
    private Button btnHello;

    // 1. Le constructeur moderne
    public FragmentOne() {
        super(R.layout.fragment_one);
    }

    // 2. L'initialisation des composants visuels
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Attention : on doit utiliser "view.findViewById" dans un Fragment
        tv = view.findViewById(R.id.textOne);
        btnHello = view.findViewById(R.id.btnHello);

        // 3. Action du bouton locale au fragment
        btnHello.setOnClickListener(v -> tv.setText("Bonjour depuis Fragment 1 !"));
    }

}