package mx.edu.utng.recyclecardgds0342;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //Declara Recycler y el Adaptador
    RecyclerView recyclerUsuarios;
    UsuarioAdaptador usuarioAdaptador;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inicializarElementos();
    }

    private void inicializarElementos() {
        //Se enlaza con la vista
        recyclerUsuarios = findViewById(R.id.recycler);
        recyclerUsuarios.setLayoutManager(new LinearLayoutManager(this));
        List<Usuario> usuarioList = new ArrayList<>();

        //Cargar datos con un clicl For
        for(int i = 0;  i < 20; i++){
            usuarioList.add(new Usuario(i, ("Nombre..." + i), "Apellido",
                    "correo@gmail.com",
                    "https://play-lh.googleusercontent.com/aLaVWYoJjHElxFOpgm9U08bjNmxUpmH3t63Ft8HOUStBNkw6A5DymB9_B5LHy6lRxrnz=s180-rw"));
            Log.d("msg", "Se ha creado el objeto " + i);
        }
        usuarioAdaptador = new UsuarioAdaptador(usuarioList,this);
        //busuarioList = (List<Usuario>) new UsuarioAdaptador(usuarioList, this);
        recyclerUsuarios.setAdapter(usuarioAdaptador);
        Log.d("msg", "El tamaño de la lista es: " + usuarioList);
    }
}