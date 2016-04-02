package com.example.pekohome.calculadoragdg;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //Declarar variables de views de forma global
    private Button sumar;
    private Button restar;
    private Button dividir;
    private Button multiplicar;
    private Button borrar;
    private TextView ingresado1;
    private TextView ingresado2;
    private  TextView resultOper;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Declarar los views
        ingresado1 = (TextView) findViewById(R.id.num1);
        ingresado2 = (TextView) findViewById(R.id.num2);
        resultOper = (TextView) findViewById(R.id.resultado);
        sumar = (Button) findViewById(R.id.sumar);
        restar = (Button) findViewById(R.id.restar);
        multiplicar = (Button) findViewById(R.id.multiplicar);
        dividir = (Button) findViewById(R.id.dividir);
        borrar  =  (Button) findViewById(R.id.borrar);

        /**
         * Al hacer click en un Boton realizar una operación
         */
        sumar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //declaración variable local
                int  num1 = Integer.parseInt(ingresado1.getText().toString());
                int  num2 = Integer.parseInt(ingresado2.getText().toString());
                resultOper.setText(String.valueOf(suma(num1,num2)));
            }
        });
        restar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int  num1 = Integer.parseInt(ingresado1.getText().toString());
                int  num2 = Integer.parseInt(ingresado2.getText().toString());
                resultOper.setText(String.valueOf(resta(num1,num2)));
            }
        });
        multiplicar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int  num1 = Integer.parseInt(ingresado1.getText().toString());
                int  num2 = Integer.parseInt(ingresado2.getText().toString());
                resultOper.setText(String.valueOf(multiplicacion(num1,num2)));
            }
        });
        dividir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int  num1 = Integer.parseInt(ingresado1.getText().toString());
                int  num2 = Integer.parseInt(ingresado2.getText().toString());
                if(num2 == 0){
                    resultOper.setText(" E R R O R ");
                }else{
                    resultOper.setText(String.valueOf(division(num1,num2)));
                }
            }
        });
        borrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ingresado1.setText("");
                ingresado2.setText("");
            }
        });

        /**
         * Limpiar al hacer click en el textView
         */
        ingresado1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ingresado1.setText("");
            }
        });
        ingresado2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ingresado2.setText("");
            }
        });
    }

    /**
     * Realiza la operación de sumar
     * @param num1
     * @param num2
     * @return Resultado Entero
     */
    public int suma (int num1, int num2){
        int resultado = 0;
        resultado= num1 + num2;
        // Ocultamos el digitador de numero del dispositivo
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }

        return resultado;
    }

    /**
     * Realiza la operación de restar
     * @param num1
     * @param num2
     * @return Resultado Entero
     */
    public int resta (int num1, int num2){
        int resultado = 0;
        if(num1>=num2){
           resultado=num1-num2;
        }else{
            resultado= num2 - num1;
        }
        // Ocultamos el digitador de numero del dispositivo
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }

        return resultado;
    }

    /**
     * Realiza la operación de multiplicar
     * @param num1
     * @param num2
     * @return Resultado Entero
     */
    public int multiplicacion (int num1, int num2){
        int resultado = 0;
        resultado= num1 * num2;
        // Ocultamos el digitador de numero del dispositivo
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }

        return resultado;
    }

    /**
     * Realiza la operación de dividir
     * @param num1
     * @param num2
     * @return Resultado decimal
     */
    public double division (int num1, int num2){
        int resultado = 0;
        //Validamos division por cero
        if(num2!=0){
            resultado= num1 / num2;
        }
        // Ocultamos el digitador de numero del dispositivo.
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }

        return resultado;
    }

}
