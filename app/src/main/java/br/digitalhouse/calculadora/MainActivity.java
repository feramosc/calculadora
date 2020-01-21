package br.digitalhouse.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText inputNumeroUm;
    private EditText inputNumeroDois;
    private Button botaoCalcular;
    private TextView textViewResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        botaoCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logicaBotaoCalcular();
            }
        });
    }

    private void logicaBotaoCalcular() {
        if (!inputNumeroUm.getText().toString().isEmpty() &&
                !inputNumeroDois.getText().toString().isEmpty()) {

            int numero1 = Integer.parseInt(inputNumeroUm.getText().toString());
            int numero2 = Integer.parseInt(inputNumeroDois.getText().toString());

            String resultado = String.valueOf(calcular(numero1, numero2));
            textViewResultado.setText(resultado);

            inputNumeroUm.getText().clear();
            inputNumeroDois.getText().clear();

        } else {
            inputNumeroUm.setError("Campo inválido");
            inputNumeroDois.setError("Campo inválido");
        }
    }

    private void initViews(){
        inputNumeroUm = findViewById(R.id.edit_text_numero_um);
        inputNumeroDois = findViewById(R.id.edit_text_numero_dois);
        botaoCalcular = findViewById(R.id.botao_calcular);
        textViewResultado = findViewById(R.id.texto_resultado);
    }

    private int calcular(int numero1, int numero2){
        return numero1+numero2;
    }
}
