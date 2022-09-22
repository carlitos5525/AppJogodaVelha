package com.br.jogo_da_velha;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

   private int quantidade_jogadas;
   private int jogador; //verifica de quem é a vez de jogar
   private int matriz_jogo[][] = new int[3][3];
   private Button b[] = new Button[9];
   private String ganhador;
   private String jogador1;
   private String jogador2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        quantidade_jogadas = 1;
        jogador = 1;
        b[0] = findViewById(R.id.bt_1);
        b[1] = findViewById(R.id.bt_2);
        b[2] = findViewById(R.id.bt_3);
        b[3] = findViewById(R.id.bt_4);
        b[4] = findViewById(R.id.bt_5);
        b[5] = findViewById(R.id.bt_6);
        b[6] = findViewById(R.id.bt_7);
        b[7] = findViewById(R.id.bt_8);
        b[8] = findViewById(R.id.bt_9);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_principal, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {

            case R.id.itemNovo:
                Toast.makeText(getApplicationContext(), "inicializa novo jogo", Toast.LENGTH_LONG).show();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    public void jogada(Button botao_clicado, int posicao_horizontal, int posicao_vertical){

        //os botões ficam desabilitados até que seja iniciado um novo jogo
        botao_clicado.setEnabled(true);


        if(jogador == 1){
            //localizando a posição marcada e preenchendo como jogada do jogador 1
            matriz_jogo[posicao_horizontal][posicao_vertical] = 1;
            //preenchendo o X no jogo
            botao_clicado.setText("X");
            //passando a vez para o jogador 2
            jogador = 2;
            ganhador = jogador1;
        }
        else{
            matriz_jogo[posicao_horizontal][posicao_vertical] = 2;
            botao_clicado.setText("O");
            jogador = 1;
            ganhador = jogador2;
        }
    }
}