package palmariuntec.com.br.pocketpersonaltrainer.database.services

import palmariuntec.com.br.pocketpersonaltrainer.database.DatabaseManager
import palmariuntec.com.br.pocketpersonaltrainer.entidade.ExercicioUsuario
import palmariuntec.com.br.pocketpersonaltrainer.entidade.Usuario

object ExercicioUsuarioService {

    fun insert(exercicioUsuario: ExercicioUsuario){
        val dao = DatabaseManager.getExercicioUsuarioDAO()
        dao.insert(exercicioUsuario)
    }

    fun getAllByUser(usuario: Usuario){

    }
}