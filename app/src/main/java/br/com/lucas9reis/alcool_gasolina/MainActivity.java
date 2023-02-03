package br.com.lucas9reis.alcool_gasolina;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText editPrecoAlcool, editPrecoGasolina;
    private TextView textResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editPrecoAlcool     = findViewById(R.id.editPrecoAlcool);
        editPrecoGasolina   = findViewById(R.id.editPrecoGasolina);
        textResultado       = findViewById(R.id.textResultado);
    }

    public void calcularPreco( View view ){

        //Recupera os valores digitados
        String precoAlcool = editPrecoAlcool.getText().toString();
        String precoGasolina = editPrecoGasolina.getText().toString();

        //Validação dos campos
        Boolean camposValidados = validarCampos(precoAlcool, precoGasolina);

        if(camposValidados){

            //Convertendo de String para numero
            Double valorAlcool = Double.parseDouble(precoAlcool);
            Double valorGasolina = Double.parseDouble(precoGasolina);

            // Fazer calculo de menor preço
            // Se ( valorAlcool / valorGasolina) >= 0.7 é melhor utilizar gasolina
            // Se não é melhor utilizar alcool
            Double resultado = valorAlcool / valorGasolina;
            if( resultado >= 0.7){
                textResultado.setText("É melhor utilizar Gasolina!");
            }else {
                textResultado.setText("É melhor utilizar Álcool!");
            }

        }else{
            textResultado.setText("Preencha os preços primeiro!");
        }

    }

    public Boolean validarCampos(String pcAlcool, String pcGasolina){
        Boolean camposValidados = true;

        if(pcAlcool == null || pcAlcool.equals("")){
            camposValidados = false;
        }else if( pcGasolina == null || pcGasolina.equals("")){
            camposValidados = false;
        }

        return camposValidados;
    }

}