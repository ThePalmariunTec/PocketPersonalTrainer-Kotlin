package palmariuntec.com.br.pocketpersonaltrainer.DAO

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import palmariuntec.com.br.pocketpersonaltrainer.entidade.Exercicios


@Dao
interface ExercicioDAO {

    @Query("SELECT * FROM exercicios")
    fun findAll(): List<Exercicios>

    @Insert
    fun insert(exercise: Exercicios)
}