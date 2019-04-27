package palmariuntec.com.br.pocketpersonaltrainer.retrofit2.api
import android.database.Observable
import palmariuntec.com.br.pocketpersonaltrainer.entidade.Usuario
import palmariuntec.com.br.pocketpersonaltrainer.retrofit2.Response
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface UserAPI {
    @GET("pocketPersonalTrainer/clientes")
    fun list(): Call<List<Usuario>>

    @GET("pocketPersonelTrainer/cliente/{id}")
    fun userById(@Path("id") id: Int): Call<Usuario>

    @GET("pocketPersonalTrainer/loginUser/{email,senha}")
    fun loginApp(@Path("email") email: String, @Path("senha") senha: String): Call<Usuario>

    @GET("pocketpersonaltrainerdb/blob/master/usuario.json")
    fun getUser(): Observable<Usuario>

    @POST("pocketPersonalTrainer/user")
    fun save(@Body user: Usuario?): Call<Response>

}