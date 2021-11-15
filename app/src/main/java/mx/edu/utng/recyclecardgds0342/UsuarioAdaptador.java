package mx.edu.utng.recyclecardgds0342;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class UsuarioAdaptador extends RecyclerView.Adapter<UsuarioAdaptador.ViewHolder>{
    //Clase interna para cada viewHolder vista por tarjeta (card)
    //Declara una lista necesaria como estructura de datos para el conjunto de items
    private List<Usuario> usuariolist;
    private Context context; //Declarar un contexto para los activitys necesarios

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //Inflar... o presentar el contenido en el  Recyclar
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.tarjeta_usuario, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //Detalle de la tarjeta (Holder)
        holder.tvNombre.setText(usuariolist.get(position).getNombre());
        holder.tvEmail.setText(usuariolist.get(position).getEmail());

        //Utilizar una libreria denominada Glide para cargar imagenes de INTERNET
        Glide.with(context)
                .load(usuariolist.get(position).getFoto())
                .circleCrop()
                .into(holder.imgFoto);
    }

    @Override
    public int getItemCount() {
        return usuariolist.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        //Declarar cada uno de los elementos visuales para enlazarlos
        private ImageView imgFoto;
        private TextView tvNombre;
        private TextView tvEmail;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            //Enlazar con la lista
            imgFoto = itemView.findViewById(R.id.img_foto);
            tvNombre = itemView.findViewById(R.id.tv_nombre);
            tvEmail = itemView.findViewById(R.id.tv_email);
        }
    }

    public UsuarioAdaptador(List<Usuario> usuariolist, Context context) {

        this.usuariolist = usuariolist;
        this.context = context;
    }
}
