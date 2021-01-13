package com.example.kataloglaptop;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.kataloglaptop.model.Laptop;
import com.google.android.material.textfield.TextInputLayout;

public class FormLaptopActivity extends AppCompatActivity {

    Button btnSimpan;
    TextInputLayout tilSpec, tilHrg, tilMd;
    Spinner spnbrand;
    final String[] tipeLis = {Laptop.APPLE, Laptop.ACCER, Laptop.ASUS, Laptop.LENOVO, Laptop.ROG};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_laptop);
        inisialisasiView();
    }

    private void inisialisasiView() {
        btnSimpan = findViewById(R.id.btn_simpan);
        btnSimpan.setOnClickListener(view -> simpan());
        tilSpec = findViewById(R.id.til_speks);
        tilHrg = findViewById(R.id.til_harga);
        tilMd = findViewById(R.id.til_md);
        spnbrand = findViewById(R.id.spn_jenis);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this,
                R.layout.support_simple_spinner_dropdown_item,
                tipeLis
        );
        spnbrand.setAdapter(adapter);
        spnbrand.setSelection(0);
    }

    private void simpan() {
        if (isDataValid()) {
            Laptop tr = new Laptop();
            tr.setSpesifikasi(tilSpec.getEditText().getText().toString());
            tr.setHarga(tilHrg.getEditText().getText().toString());
            tr.setModel(tilMd.getEditText().getText().toString());
            tr.setBrand(spnbrand.getSelectedItem().toString());
            SharedPerefernceUtility.addLaptop(this, tr);
            Toast.makeText(this, "Data berhasil disimpan", Toast.LENGTH_SHORT).show();

            // Kembali ke layar sebelumnya setelah 500 ms (0.5 detik)
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    finish();
                }
            }, 500);


        }
    }

    private boolean isDataValid() {
        if (tilSpec.getEditText().getText().toString().isEmpty()
                || tilHrg.getEditText().getText().toString().isEmpty()
                || tilMd.getEditText().getText().toString().isEmpty()
                || spnbrand.getSelectedItem().toString().isEmpty()
        ) {
            Toast.makeText(this, "Data tidak bileh ada yang kosong", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
}