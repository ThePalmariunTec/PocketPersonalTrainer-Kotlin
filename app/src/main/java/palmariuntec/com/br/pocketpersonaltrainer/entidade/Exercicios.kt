package palmariuntec.com.br.pocketpersonaltrainer.entidade

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "exercicios")
data class Exercicios(
    @PrimaryKey val id: Long?,
    @ColumnInfo(name = "name") val nome: String?,
    @ColumnInfo(name = "description")val desc:String?
){}