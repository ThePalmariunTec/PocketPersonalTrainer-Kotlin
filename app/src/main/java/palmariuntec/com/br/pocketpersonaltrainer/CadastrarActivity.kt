package palmariuntec.com.br.pocketpersonaltrainer

import android.app.Activity
import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.os.Environment
import android.os.PersistableBundle
import android.provider.MediaStore
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.FileProvider
import palmariuntec.com.br.pocketpersonaltrainer.entidade.Usuario
import kotlinx.android.synthetic.main.activity_cadastrar.*
import palmariuntec.com.br.pocketpersonaltrainer.database.DatabaseManager
import palmariuntec.com.br.pocketpersonaltrainer.utils.ImageUtils
import java.io.File
import java.util.*


class CadastrarActivity : AppCompatActivity() {

    var file: File? = null
    var user = Usuario()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastrar)

        btnCadastrar.setOnClickListener {
            if (salvarDados()) {
                val intent = Intent(this, MenuPrincipalActivity::class.java)
                intent.putExtra("email", user.email)
                intent.putExtra("senha", user.senha)
                intent.putExtra("fotoPerfil", file)
                startActivity(intent)
            }
        }

        fabtnTirarFoto.setOnClickListener {
            val file = getSdCardFile("foto.jpg")
            val it = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            val uri = FileProvider.getUriForFile(this,
                this.applicationContext.packageName + ".provider", file)
            it.putExtra(MediaStore.EXTRA_OUTPUT, uri)
            startActivity(it)
        }

        if(savedInstanceState != null){
            file = savedInstanceState.getSerializable("file") as File
            showImage(file)
        }
    }

    private fun showImage(file: File?) {
        if(file != null && file.exists()){
            val w = fotoPerfil.width
            val h = fotoPerfil.height
            val bitmap = ImageUtils.resize(file, w, h)
            fotoPerfil.setImageBitmap(bitmap)
        }
    }

    private fun getSdCardFile(fileName: String): File {
        val sdCardDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES)
        if(!sdCardDir.exists()){
            sdCardDir.mkdir()
        }
        val foto = File(sdCardDir, fileName)
        return foto
    }

    private fun salvarDados(): Boolean {
        var isSaved = false
        if (edtNome.text.isBlank() || edtSenhaC.text.isBlank() ||
                edtEmailCadastro.text.isBlank() || edtPeso.text.isBlank() ||
                edtAltura.text.isBlank()) {
            edtNome.setFocusable(true)
        } else {
            validarSenha()
            user.nome = edtNome.text.toString()
            user.email = edtEmailCadastro.text.toString()
            user.senha = edtSenhaC.text.toString()
            user.peso =  edtPeso.text.toString().toDouble()
            user.altura = edtAltura.text.toString().toDouble()
            user.telefone = edtTelefone.text.toString()
            user.status = 0
            user.valorMensalidade = 50.00
            user.dtVencimentoMensalidade = Date()
            if(file!!.exists() && file != null) {
                user.URIfotoPerfil = file!!.absolutePath

            }
            val dao = DatabaseManager.getUsuarioDAO()
            dao.insert(user)
            isSaved = true
        }
        return isSaved
    }

    private fun validarSenha(): Boolean {
        var isValidSenha = false
        if(edtConfSenha.text.isNullOrEmpty() || edtSenhaC.text.isNullOrEmpty()){
            if(edtConfSenha.text.equals(edtSenhaC.text))
                isValidSenha = true;
        }

        return isValidSenha
    }

    override fun onSaveInstanceState(outState: Bundle?, outPersistentState: PersistableBundle?) {
        super.onSaveInstanceState(outState, outPersistentState)
        outState?.putSerializable("file", file)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(resultCode == Activity.RESULT_OK)
            showImage(file)
    }
}

