package com.example.kataloglaptop;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.kataloglaptop.model.Laptop;

import java.util.List;

public class DaftarLaptopAdapter extends ArrayAdapter<Laptop> {
    Context context;

    public DaftarLaptopAdapter(@NonNull Context context, @NonNull List<Laptop> objects) {
        super(context, R.layout.row_laptop, objects);
        this.context = context;
    }

    class ViewHolder {
        TextView txSpesifikasi;
        TextView txHarga;
        TextView txBrand;
        TextView txModel;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Laptop tr = getItem(position);
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.row_laptop, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.txSpesifikasi = convertView.findViewById(R.id.row_spec);
            viewHolder.txHarga = convertView.findViewById(R.id.row_hrg);
            viewHolder.txBrand = convertView.findViewById(R.id.row_brn);
            viewHolder.txModel = convertView.findViewById(R.id.row_md);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.txSpesifikasi.setText(tr.getSpesifikasi());
        viewHolder.txHarga.setText(tr.getHarga());
        viewHolder.txModel.setText(tr.getModel());
        if (tr.getBrand().equals(Laptop.APPLE)) {
            viewHolder.txBrand.setText("APPLE");
        } else if (tr.getBrand().equals(Laptop.ACCER)) {
            viewHolder.txBrand.setText("SAMSUNG");
        } else if (tr.getBrand().equals(Laptop.ASUS)) {
            viewHolder.txBrand.setText("VIVO");
        } else if (tr.getBrand().equals(Laptop.LENOVO)) {
            viewHolder.txBrand.setText("OPPO");
        } else if (tr.getBrand().equals(Laptop.ROG)) {
            viewHolder.txBrand.setText("XIOMI");
        } else {
            viewHolder.txBrand.setText("UMUM");
        }
        return convertView;
    }
}
