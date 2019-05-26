package palmariuntec.com.br.pocketpersonaltrainer

import android.app.Application
import android.util.Log
import palmariuntec.com.br.pocketpersonaltrainer.database.DatabaseManager
import palmariuntec.com.br.pocketpersonaltrainer.entidade.Usuario
import palmariuntec.com.br.pocketpersonaltrainer.utils.AndroidThreads
import java.lang.IllegalStateException

class PocketPersonalTrainer: Application() {

    private  val TAG = "PocketPersonalTrainerApplication"

    override fun onCreate() {
        super.onCreate()
        appInstance = this
    }
    companion object{
        private var appInstance: PocketPersonalTrainer? = null

        fun getInstance(): PocketPersonalTrainer{
            if(appInstance == null){
                throw IllegalStateException("Configure a classe de Application no AndroidManifest.xml")
            }
            return appInstance!!
        }
    }

    override fun onTerminate() {
        super.onTerminate()
        Log.d(TAG, "PocketPersonalTrainer.onTerminate()")
    }
}