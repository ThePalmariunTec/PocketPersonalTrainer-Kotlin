package palmariuntec.com.br.pocketpersonaltrainer.utils

import android.graphics.Bitmap
import palmariuntec.com.br.pocketpersonaltrainer.database.services.AcademiaService
import palmariuntec.com.br.pocketpersonaltrainer.database.services.ExercicioService
import palmariuntec.com.br.pocketpersonaltrainer.entidade.*
import palmariuntec.com.br.pocketpersonaltrainer.retrofit2.PocketPersonalTrainerRetrofit
import palmariuntec.com.br.pocketpersonaltrainer.retrofit2.Response


//Classe de processos que serão chamados no app
object AndroidThreads
{
    //Função que realiza o Thread para buscar no banco de dados no servidor listas(Exercícios e Academias)
    // e insere no SQLite
    fun taskUpdateSqlite(){
        object : Thread(){
            override fun run() {
                val service = PocketPersonalTrainerRetrofit()
                val listaExercicios = service.getTodosExercicios()
                for(exercicio in listaExercicios){
                    ExercicioService.insert(exercicio)
                }
                val listaAcademias = service.getTodasAcademias()
                for(gym in listaAcademias){
                    AcademiaService.inserir(gym)
                }
            }
        }.start()
    }

    //Função que realiza o Thread para inserir o Usuario cadastrado no app ao banco de dados no servidor
    fun taskInsertUserToServerDb(user:Usuario?){
        object :Thread(){
            override fun run() {
                if(user != null){
                    val service = PocketPersonalTrainerRetrofit()
                    service.insertUserToDataBase(user).isOk()
                }

            }
        }.start()
    }

    fun taskGetUsuarioRetrofit(email: String, senha: String): Usuario?{
        var user: Usuario? = null
        object : Thread(){
            override fun run() {
                val service = PocketPersonalTrainerRetrofit()
                user = service.getUsuarioByEmailSenha(email, senha)
            }
        }.start()
        return user
    }

}