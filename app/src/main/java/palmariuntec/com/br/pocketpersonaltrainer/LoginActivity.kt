package palmariuntec.com.br.pocketpersonaltrainer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import palmariuntec.com.br.pocketpersonaltrainer.database.services.UsuarioService

import palmariuntec.com.br.pocketpersonaltrainer.utils.AndroidThreads

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val btnLogin = findViewById<Button>(R.id.btnEntrar)
        val signup = findViewById<TextView>(R.id.txtViewCadastrar)
        val email = findViewById<EditText>(R.id.edtEmail)
        val senha = findViewById<EditText>(R.id.edtPassWd)
        val loading = findViewById<ProgressBar>(R.id.entrando)
        btnLogin.setOnClickListener {
            loading.visibility = ProgressBar.VISIBLE
            //val userRetrofit = AndroidThreads.taskGetUsuarioRetrofit(email.text.toString(), senha.text.toString())
            val userSQLite = UsuarioService.getUserByEmailSenha(email.text.toString(), senha.text.toString())
            val toast = Toast.makeText(this, "Erro: Usuario não encontrado", Toast.LENGTH_SHORT)
            if(userSQLite != null){
                loading.visibility = ProgressBar.GONE
                val it = Intent(this, MenuPrincipalActivity::class.java)
                it.putExtra("user", userSQLite)
                startActivity(it)
            }else{
                toast.show()
            }
        }
        signup.setOnClickListener {
            val it = Intent(this, CadastrarActivity::class.java)
            startActivity(it)
        }
    }
}
