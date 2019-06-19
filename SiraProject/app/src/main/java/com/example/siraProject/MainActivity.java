package com.example.siraProject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.sira.R;

public class MainActivity extends AppCompatActivity {
    private Button carteira;
    private Button add_receita;
    private Button add_despesa;
    private Button listaMovimentos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        carteira = findViewById(R.id.BotaoCarteiraId);
        add_receita = findViewById(R.id.BotaoAdicionarReceitaId);
        add_despesa = findViewById(R.id.BotaoAdicionarDespesaId);
        listaMovimentos = findViewById(R.id.BotaoListaDeMovimentosId);

        carteira.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,CarteiraActivity.class);
                startActivity(intent);

            }
        });

        add_receita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,AdicionarReceitaActivity.class);
                startActivity(intent);

            }
        });

        add_despesa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AdicionarDespesaActivity.class);
                startActivity(intent);

            }
        });

        listaMovimentos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ListaMovimentosActivity.class);
                startActivity(intent);

            }
        });

    }
}
