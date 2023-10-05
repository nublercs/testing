package es.damiguet.daw2.secondactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button

class MainActivity2 : AppCompatActivity() {


    private lateinit var boton2a:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val usuario=intent.getStringExtra("usuario")
        Log.d("SegundaActividad", "$usuario")
        boton2a=findViewById(R.id.button2act)
        boton2a.setOnClickListener{
            val data = Intent()
            data.putExtra("stringdevuelta", "he devuelto un valor")
            setResult(RESULT_OK, data)
            finish()
        }

    }
}