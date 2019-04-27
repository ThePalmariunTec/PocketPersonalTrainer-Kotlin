package palmariuntec.com.br.pocketpersonaltrainer.retrofit2.api

import palmariuntec.com.br.pocketpersonaltrainer.entidade.Academia
import retrofit2.Call
import retrofit2.http.GET

interface AcademiaAPI {

    @GET("pocketpersonalTrainer/AllExercicios")
    fun listAll(): Call<List<Academia>>
}