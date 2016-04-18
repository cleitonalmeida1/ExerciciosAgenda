package adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import cleiton.adapter.R;
import model.Agenda;

/**
 * Created by Cleiton Gonçalves on 21/01/2016.
 */
public class CustomAdapter extends BaseAdapter {
    private LayoutInflater layoutInflater;
    private List<Agenda> itens;

    public CustomAdapter(List<Agenda> itens, Context context) {
        this.itens = itens;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return itens.size();
    }

    @Override
    public Object getItem(int position) {
        return itens.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        Agenda l = itens.get(position);

        if (convertView != null) {
            holder = (ViewHolder) convertView.getTag();
        } else {
            convertView =  layoutInflater.inflate(R.layout.item_layout, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }
        holder.nome.setText(l.getNome());
        holder.imagem.setImageResource(l.getImagem());
        holder.telefone.setText(l.getTelefone());

        return convertView;
    }

    static class ViewHolder {
        @Bind(R.id.tvNome)
        TextView nome;
        @Bind(R.id.tvTelefone) TextView telefone;
        @Bind(R.id.imageView)
        ImageView imagem;

        public ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
