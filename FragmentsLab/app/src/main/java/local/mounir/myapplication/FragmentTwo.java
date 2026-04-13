package local.mounir.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentTwo extends Fragment {

    private TextView tvValue;
    private SeekBar seek;
    private int progress = 0;

    // Clé constante utilisée pour sauvegarder et récupérer la donnée
    private static final String KEY_PROGRESS = "progress";

    public FragmentTwo() {
        super(R.layout.fragment_two);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        tvValue = view.findViewById(R.id.tvValue);
        seek = view.findViewById(R.id.seekBar);

        // 1. RESTAURATION : Si le fragment a été recréé (ex: rotation de l'écran)
        if (savedInstanceState != null) {
            // On récupère la valeur sauvegardée (0 par défaut si rien n'est trouvé)
            progress = savedInstanceState.getInt(KEY_PROGRESS, 0);
            seek.setProgress(progress);
            tvValue.setText("Valeur : " + progress);
        }

        // 2. ÉCOUTEUR : Suivre les changements de la barre glissante (SeekBar)
        seek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int p, boolean fromUser) {
                progress = p; // On met à jour notre variable
                tvValue.setText("Valeur : " + p); // On met à jour l'affichage
            }

            // Méthodes obligatoires de l'interface, même si on ne les utilise pas ici
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });
    }

    /**
     * 3. SAUVEGARDE : Cette méthode est appelée juste avant que le fragment ne soit détruit
     * (par exemple, quand on bascule le téléphone en mode paysage).
     */
    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        // On glisse notre progression dans le "sac" de sauvegarde (outState)
        outState.putInt(KEY_PROGRESS, progress);
    }
}
