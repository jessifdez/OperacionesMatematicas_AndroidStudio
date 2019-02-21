package com.example.maanas.myapplication;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView tv_numero1,tv_numero2,tv_signo, tv_operacion, tv_numoperaciones;
    EditText et_resultado, et_operaciones;
    Button boton_comprobar, boton_jugar;
    Spinner spinner1;
    Context contexto;
    Operacion o;
    int numero_operaciones;
    int numero_operaciones_hechas=0;
    int opcion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cargarVistas();
        //mostrarOperacion();
    }

    private void mostrarOperacion()
    {
       /* switch(opcion)
        {
            case 1:
                o=Operacion.obtenerSuma();
                break;
            case 2:
                o=Operacion.obtenerResta();
                break;
            case 3:
                o=Operacion.obtenerMultiplicacion();
                break;

        }

        int n1=o.getNumero1();
        int n2=o.getNumero2();
        et_resultado.setText("");
        tv_numero1.setText(String.valueOf(n1));
        tv_numero2.setText(String.valueOf(n2));
        tv_signo.setText(String.valueOf(o.getSigno()));*/
       String select=spinner1.getSelectedItem().toString();
        if(select.equals("Sumar")){
            o=Operacion.obtenerSuma();
            int n1=o.getNumero1();
            int n2=o.getNumero2();
            tv_numero1.setText(String.valueOf(n1));
            tv_numero2.setText(String.valueOf(n2));
            tv_signo.setText(String.valueOf(o.getSigno()));
        }
        else
            if(select.equals("Restar"))
            {
                o=Operacion.obtenerResta();
                int n1=o.getNumero1();
                int n2=o.getNumero2();
                tv_numero1.setText(String.valueOf(n1));
                tv_numero2.setText(String.valueOf(n2));
                tv_signo.setText(String.valueOf(o.getSigno()));
            }
            else
                if (select.equals("Multiplicar"))
                    {
                        o=Operacion.obtenerMultiplicacion();
                        int n1=o.getNumero1();
                        int n2=o.getNumero2();
                        tv_numero1.setText(String.valueOf(n1));
                        tv_numero2.setText(String.valueOf(n2));
                        tv_signo.setText(String.valueOf(o.getSigno()));
                    }
                    et_resultado.setText("");

    }

    private void cargarVistas()
    {
        tv_numero1=findViewById(R.id.tv_numero1);
        tv_numero2=findViewById(R.id.tv_numero2);
        tv_signo=findViewById(R.id.tv_signo);
        tv_operacion=findViewById(R.id.tv_operacion);
        tv_numoperaciones=findViewById(R.id.tv_numoperaciones);
        et_resultado=findViewById(R.id.et_resultado);
        et_operaciones=findViewById(R.id.et_operaciones);
        boton_comprobar=findViewById(R.id.btn_comprobar);
        boton_jugar=findViewById(R.id.btn_jugar);
        spinner1=findViewById(R.id.spinner);
        String [] opciones={"Seleccione opción","Sumar","Restar","Multiplicar"};
        ArrayAdapter<String> adapter=new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,opciones);
        spinner1.setAdapter(adapter);
        View.OnClickListener oyente_comprobar=new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                comprobar();
            }
        };
        boton_comprobar.setOnClickListener(oyente_comprobar);
        View.OnClickListener oyente_jugar=new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                jugar();
            }
        };
        boton_jugar.setOnClickListener(oyente_jugar);
    }

    private void jugar(){
        numero_operaciones_hechas=0;
        opcion=spinner1.getSelectedItemPosition();
        if(opcion!=0 && !et_operaciones.getText().toString().equals(""))
        {
            String operaciones=et_operaciones.getText().toString();
            numero_operaciones=Integer.parseInt(operaciones);
            mostrarOperacion();
        }
        else
            {
            //Quiza se podría poner un Toast
            }
    }

    private void comprobar()
    {
        numero_operaciones_hechas++;
        String resultado_usua=et_resultado.getText().toString();
        int resultado_usuario=Integer.parseInt(resultado_usua);
        int resultado_correcto=o.getResultado();
        String comentario="";
        if(resultado_usuario==resultado_correcto)
        {
            comentario="Enhorabuena, has acertado";
        }
        else
            {
            comentario="Error, la respuesta no es correcta. El resultado correcto es: "+resultado_correcto;
            }
        Toast notificacion=Toast.makeText(this,comentario,Toast.LENGTH_LONG);
        notificacion.show();
        if(numero_operaciones_hechas<numero_operaciones)
        {
            mostrarOperacion();
        }
        else
            {
            Toast notificacion1=Toast.makeText(this,"Has terminado",Toast.LENGTH_LONG);
            notificacion1.show();
        }
    }

}
