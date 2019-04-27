package palmariuntec.com.br.pocketpersonaltrainer.database

import palmariuntec.com.br.pocketpersonaltrainer.PocketPersonalTrainer
import androidx.room.Room
import palmariuntec.com.br.pocketpersonaltrainer.DAO.AcademiaDAO
import palmariuntec.com.br.pocketpersonaltrainer.DAO.ExercicioDAO
import palmariuntec.com.br.pocketpersonaltrainer.DAO.ExercicioUsuarioDAO
import palmariuntec.com.br.pocketpersonaltrainer.DAO.UsuarioDAO

object DatabaseManager {
    private var dbInstance: AcademiaDatabase
    init {
        val appContext = PocketPersonalTrainer.getInstance().applicationContext
        dbInstance = Room.databaseBuilder(
            appContext,
            AcademiaDatabase::class.java,
            "academia.sqlite")
            .build()
    }
    fun getUsuarioDAO(): UsuarioDAO{
        return dbInstance.usuarioDAO()
    }
    fun getAcademiaDAO(): AcademiaDAO{
        return dbInstance.academiaDAO()
    }
    fun getExercicioDAO(): ExercicioDAO{
        return dbInstance.exercicioDAO()
    }
    fun getExercicioUsuarioDAO(): ExercicioUsuarioDAO{
        return  dbInstance.exercicioUsuarioDAO()
    }
}