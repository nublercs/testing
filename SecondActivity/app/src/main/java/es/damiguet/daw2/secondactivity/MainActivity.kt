package es.damiguet.daw2.secondactivity

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.PermissionChecker

class MainActivity : AppCompatActivity() {
    private lateinit var btnLanzarSegundaActividad:Button
    private val CALL_PERMISSION_CODE = 100



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnLanzarSegundaActividad=findViewById(R.id.boton)

        var startForResult: ActivityResultLauncher<Intent> = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                val data = result.data
                if (data != null) {
                    val returnString = data.extras!!.getString("stringdevuelta")
                    Log.d("Primera", "$returnString")                }
            }
        }
        //checkPermission(Manifest.permission.CALL_PHONE, CALL_PERMISSION_CODE)
        
        btnLanzarSegundaActividad.setOnClickListener {
            compruebaPermisoLlamada()
            /*val intent = Intent(this@MainActivity, MainActivity2::class.java)
            intent.putExtra("usuario", "damiguet")*/
            //startActivity(intent)
           // startForResult.launch(intent)
            /*val callIntent = Intent(Intent.ACTION_CALL)
            callIntent.data = Uri.parse("tel:3777789888")

            if(!permisos)
               checkPermission(Manifest.permission.CALL_PHONE, CALL_PERMISSION_CODE)
            else
                startActivity(callIntent)*/
            /*val browserIntent =Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.es"))
            if(browserIntent.resolveActivity(packageManager)!=null){
                startActivity(browserIntent)
            }
            val camaraIntent =Intent(MediaStore.INTENT_ACTION_STILL_IMAGE_CAMERA)
            if(camaraIntent.resolveActivity(packageManager)!=null){
                startActivity(camaraIntent)
            }*/

          /*  val callIntent = Intent(Intent.ACTION_CALL)
            callIntent.data = Uri.parse("tel:3777789888")
            if(callIntent.resolveActivity(packageManager)!=null) {
                if(tenemosPermiso(Manifest.permission.CALL_PHONE)) {
                    startActivity(callIntent)
                }else{
                    pidePermiso(Manifest.permission.CALL_PHONE, CALL_PERMISSION_CODE)
                }
            }else{
                Log.d("MainACtivity", "NO hay callintent")
            }*/
           /* val uriText = "mailto:youremail@gmail.com" +
                    "?subject=" + Uri.encode("some subject text here") +
                    "&body=" + Uri.encode("some text here")

            val uri = Uri.parse(uriText)

            val sendIntent = Intent(Intent.ACTION_SENDTO)
            sendIntent.data = uri
            if (sendIntent.resolveActivity(packageManager) != null) {
                startActivity(Intent.createChooser(sendIntent, "Send email"))
            }*/
        }

        // Function to check and request permission.

    }
    /*private fun checkPermission(permission: String, requestCode: Int) :Boolean{
        if (PermissionChecker.checkSelfPermission(this@MainActivity, permission) == PermissionChecker.PERMISSION_DENIED) {

            // Requesting the permission
            requestPermissions(arrayOf(permission), requestCode)
        } else {
            //Toast.makeText(this@MainActivity, "Permission already granted", Toast.LENGTH_SHORT).show()
            return true
        }
    }*/

    /*override fun onRequestPermissionsResult(requestCode: Int,
                                            permissions: Array<String>,
                                            grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == CALL_PERMISSION_CODE) {
            permisos = grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED

        }
    }*/

    private fun tenemosPermiso(permiso:String): Boolean
            = PermissionChecker.checkSelfPermission(this, permiso) ==
            PermissionChecker.PERMISSION_GRANTED

    private fun compruebaPermisoLlamada() {
        if( ! tenemosPermiso(Manifest.permission.CALL_PHONE)) {
            requestPermissions(arrayOf(Manifest.permission.CALL_PHONE), CALL_PERMISSION_CODE)
        }else{
            val callIntent = Intent(Intent.ACTION_CALL)
            callIntent.data = Uri.parse("tel:3777789888")
            if(callIntent.resolveActivity(packageManager)!=null) {
                startActivity(callIntent)
            }
        }
    }
    override fun onRequestPermissionsResult(requestCode: Int,
                                            permissions: Array<String>,
                                            grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if(requestCode == CALL_PERMISSION_CODE
            && permissions[0] == Manifest.permission.CALL_PHONE
            && grantResults[0] == PermissionChecker.PERMISSION_GRANTED) {
            Toast.makeText(this, "lanzando llamada", Toast.LENGTH_SHORT).show()
            compruebaPermisoLlamada()

        }else{
            Toast.makeText(this, "permiso no dado", Toast.LENGTH_SHORT).show()
        }
    }


}
