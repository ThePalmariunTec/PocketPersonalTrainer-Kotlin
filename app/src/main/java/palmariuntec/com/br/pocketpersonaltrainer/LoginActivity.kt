package palmariuntec.com.br.pocketpersonaltrainer

import android.content.DialogInterface
import android.content.Intent
import  android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import palmariuntec.com.br.pocketpersonaltrainer.database.services.UsuarioService

import palmariuntec.com.br.pocketpersonaltrainer.utils.AndroidThreads

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val btnLogin = findViewById<Button>(R.id.btnEntrar)
        val email = findViewById<EditText>(R.id.edtEmail)
        val senha = findViewById<EditText>(R.id.edtPassWd)
        val loading = findViewById<ProgressBar>(R.id.entrando)
        btnLogin.setOnClickListener {
            loading.visibility = ProgressBar.VISIBLE
            val userRetrofit = AndroidThreads.taskGetUsuarioRetrofit(email.text.toString(), senha.text.toString())
            val userSQLite = UsuarioService.getUserByEmailSenha(email.text.toString(), senha.text.toString())
            val toast = Toast.makeText(PocketPersonalTrainer.getInstance(), "Erro: Usuario não encontrado", Toast.LENGTH_SHORT)
            if(userRetrofit != null || userSQLite != null){
                loading.visibility = ProgressBar.GONE
                val it = Intent(this, MenuPrincipalActivity::class.java)
                it.putExtra("user", userRetrofit)
                startActivity(it)
            }else{
                toast.show()
            }
        }
    }
}
