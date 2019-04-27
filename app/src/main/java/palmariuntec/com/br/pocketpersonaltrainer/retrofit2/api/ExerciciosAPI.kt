package palmariuntec.com.br.pocketpersonaltrainer.retrofit2.api

import  retrofit2.Call
import retrofit2.http.*
import palmariuntec.com.br.pocketpersonaltrainer.entidade.Exercicios
import palmariuntec.com.br.pocketpersonaltrainer.retrofit2.Response

interface ExerciciosAPI {

    @GET("pocketpersonalTrainer/AllExercicios")
    fun listAll(): Call<List<Exercicios>>

    @GET("pocketpersonaltrainer/exercicios/{id}")
    fun findById(@Path ("id") id: Int): Call<Response>

}