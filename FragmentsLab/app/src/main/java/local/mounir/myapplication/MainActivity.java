package local.mounir.myapplication;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {

    private Button btn1, btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 1. Liaison des éléments visuels avec le code Java
        btn1 = findViewById(R.id.btnFragment1);
        btn2 = findViewById(R.id.btnFragment2);

        // 2. Afficher le premier fragment au démarrage
        // (Uniquement si c'est la création initiale, pas une rotation d'écran)
        if (savedInstanceState == null) {
            replaceFragment(new FragmentOne(), false);
        }

        // 3. Écouteurs de clics sur les boutons
        btn1.setOnClickListener(v -> replaceFragment(new FragmentOne(), true));
        btn2.setOnClickListener(v -> replaceFragment(new FragmentTwo(), true));
    }

    /**
     * Méthode générique pour remplacer dynamiquement le contenu du conteneur.
     * * @param fragment       Le nouveau fragment à injecter
     * @param addToBackStack Si true, ajoute l'action à l'historique pour autoriser le bouton "Retour"
     */
    private void replaceFragment(Fragment fragment, boolean addToBackStack) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction()
                .setReorderingAllowed(true)
                .replace(R.id.fragment_container, fragment);

        // Permet à l'utilisateur d'utiliser le bouton retour de son téléphone
        if (addToBackStack) {
            ft.addToBackStack(null);
        }

        // Exécution finale de la transaction
        ft.commit();
    }
}