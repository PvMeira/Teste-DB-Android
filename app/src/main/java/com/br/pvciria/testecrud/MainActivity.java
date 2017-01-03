package com.br.pvciria.testecrud;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private String tituloString;
    private String autorString;
    private String editoraString;
    private String resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button botao = (Button)findViewById(R.id.button);

        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BancoController crud = new BancoController(getBaseContext());
                EditText titulo = (EditText)findViewById(R.id.editText);
                EditText autor = (EditText)findViewById((R.id.editText2));
                EditText editora = (EditText)findViewById(R.id.editText3);
                atribuiValoresPersistencia(titulo.getText().toString(),
                        autor.getText().toString(),
                        editora.getText().toString());

                setResultado(crud.insereDado(getTituloString(), getAutorString(), getEditoraString()));

                Toast.makeText(getApplicationContext(), getResultado(), Toast.LENGTH_LONG).show();
            }
        });
    }

    public void mudaParaListagem(View view){
        Intent it = new Intent(MainActivity.this,Consulta.class);
        startActivity(it);
    }

    private void atribuiValoresPersistencia(String titulo,String autor,String Editora)
    {
        setTituloString(titulo);
        setAutorString(autor);
        setEditoraString(Editora);
    }

    public String getTituloString() {
        return tituloString;
    }

    public void setTituloString(String tituloString) {
        this.tituloString = tituloString;
    }

    public String getAutorString() {
        return autorString;
    }

    public void setAutorString(String autorString) {
        this.autorString = autorString;
    }

    public String getEditoraString() {
        return editoraString;
    }

    public void setEditoraString(String editoraString) {
        this.editoraString = editoraString;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }
}
