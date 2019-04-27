package palmariuntec.com.br.pocketpersonaltrainer.DAO

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import palmariuntec.com.br.pocketpersonaltrainer.entidade.Academia

@Dao
interface AcademiaDAO {

    @Query("SELECT * FROM academia")
    fun findAll(): List<Academia>

    @Insert
    fun insert(gym: Academia)

}