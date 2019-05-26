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
        val toast = Toast.makeText(PocketPersonalTrainer.getInstance().applicationContext, "Erro: Usuario não encontrado", Toast.LENGTH_SHORT)
        btnLogin.setOnClickListener {
            loading.visibility = ProgressBar.VISIBLE
            //val userRetrofit = AndroidThreads.taskGetUsuarioRetrofit(email.text.toString(), senha.text.toString())
            val userSQLite = UsuarioService.getUserByEmailSenha(email.text.toString(), senha.text.toString())
            if(userSQLite != null){
                loading.visibility = ProgressBar.GONE
                val inte = Intent(this, MenuPrincipalActivity::class.java)
                inte.putExtra("email", email.text.toString())
                inte.putExtra("senha", senha.text.toString())
                startActivity(inte)
            }else{
                toast.show()
            }
        }
        signup.setOnClickListener {
            val inte = Intent(this, CadastrarActivity::class.java)
            startActivity(inte)
        }
    }
}
