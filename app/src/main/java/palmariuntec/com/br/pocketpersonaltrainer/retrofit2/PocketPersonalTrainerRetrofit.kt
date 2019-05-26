package palmariuntec.com.br.pocketpersonaltrainer.retrofit2

import palmariuntec.com.br.pocketpersonaltrainer.entidade.Academia
import palmariuntec.com.br.pocketpersonaltrainer.entidade.Exercicios
import palmariuntec.com.br.pocketpersonaltrainer.entidade.Usuario
import palmariuntec.com.br.pocketpersonaltrainer.retrofit2.api.AcademiaAPI
import palmariuntec.com.br.pocketpersonaltrainer.retrofit2.api.ExerciciosAPI
import palmariuntec.com.br.pocketpersonaltrainer.retrofit2.api.UserAPI
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PocketPersonalTrainerRetrofit {

    private var userService: UserAPI
    private var exerciseService: ExerciciosAPI
    private var gymService: AcademiaAPI

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("http://github.com")
            .addConverterFactory(GsonConverterFactory.create())

            .build()
        userService = retrofit.create(UserAPI::class.java)
        exerciseService = retrofit.create(ExerciciosAPI::class.java)
        gymService = retrofit.create(AcademiaAPI::class.java)
    }

    fun getTodasAcademias(): List<Academia>{
        val call = gymService.listAll()
        val academia = call.execute().body()
        return academia?: listOf()
    }

    fun getTodosExercicios(): List<Exercicios>{
        val call = exerciseService.listAll()
        val exercise = call.execute().body()
        return exercise?: listOf()
    }

    fun insertUserToDataBase(user: Usuario): Response{
        val call = userService.save(user)
        val response = call.execute().body()
        return response?:Response.error()
    }

    fun getUsuarioByEmailSenha(email: String, senha:String): Usuario?{
        val call = userService.loginApp(email,senha)
        val user = call.execute().body()
        return user
    }
}
