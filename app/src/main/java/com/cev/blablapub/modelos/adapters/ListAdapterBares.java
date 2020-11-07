package com.cev.blablapub.modelos.adapters;

/*
public class ListAdapterBares extends ArrayAdapter {


    Context context;
    int itemLayout;
    ArrayList<Bares> datos;

    public ListAdapterBares(@NonNull Context context, int resource, @NonNull ArrayList<Bares> objects) {
        super(context, resource, objects);

        this.context = context;
        this.itemLayout = resource;
        this.datos = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(itemLayout, parent, false);

        TextView textCorto = view.findViewById(R.id.titulo);
        textCorto.setText(datos.get(position).getNombreBar());

        TextView textLargo = view.findViewById(R.id.detalleInformacion);
        textLargo.setText(datos.get(position).getNombreBar());

        ImageView imageView = view.findViewById(R.id.imagenBar);

        return view;
    }


}

*/
// todo valorar eliminar este adapter que esta ligado a la clase listActivityBares y creo que no tiene funcionalidad