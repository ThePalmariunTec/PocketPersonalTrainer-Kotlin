package palmariuntec.com.br.pocketpersonaltrainer.database.services

import palmariuntec.com.br.pocketpersonaltrainer.database.DatabaseManager
import palmariuntec.com.br.pocketpersonaltrainer.entidade.Exercicios

object ExercicioService {

    fun insert(exerc: Exercicios){
        val dao = DatabaseManager.getExercicioDAO()
        dao.insert(exerc)
    }

    fun getAllExercises(): List<Exercicios>{
        val dao = DatabaseManager.getExercicioDAO()
        val exercicios = dao.findAll()
        return exercicios
    }
}