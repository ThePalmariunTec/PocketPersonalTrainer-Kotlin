package palmariuntec.com.br.pocketpersonaltrainer.entidade

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "gym")
class Academia(
    @PrimaryKey val id: Long?,
    @ColumnInfo(name = "name") val nome: String?,
    @ColumnInfo(name = "endereco") val endereco: String?,
    @ColumnInfo(name = "phone")val telefone:String?,
    @ColumnInfo(name = "city") val cidade: String?
) {
    override fun toString(): String {
        return "Academia {nome = '$nome'}"
    }
}