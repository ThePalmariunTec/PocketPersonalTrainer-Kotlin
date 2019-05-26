package palmariuntec.com.br.pocketpersonaltrainer.entidade

import androidx.room.*
import java.util.*

@Entity(tableName = "train_user",
    foreignKeys = arrayOf(
        ForeignKey(entity = Usuario::class, parentColumns = arrayOf("id"), childColumns = arrayOf("user_id")),
        ForeignKey(entity = Exercicios::class, parentColumns = arrayOf("id"), childColumns = arrayOf("exercise_id"))
    ))

data class ExercicioUsuario(

    @PrimaryKey val id: Long?,
    @ColumnInfo(name = "data") val dtAgedado: Date?,
    @ColumnInfo(name = "user_id") var user_id: Long?,

    @ColumnInfo(name = "user_id") val exercise_id: Long?,

    @ColumnInfo(name = "choised_weidth") val pesoEscolhido: Double?,
    @ColumnInfo(name = "repete_time") val repeticoes: Long?,
    @ColumnInfo(name = "many-time") val series: Long?

){


}