package palmariuntec.com.br.pocketpersonaltrainer.entidade

import android.os.Parcel
import android.os.Parcelable
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "exercicio_usuario", foreignKeys = arrayOf(
                                        ForeignKey(entity = Usuario::class, parentColumns = arrayOf("id"), childColumns = arrayOf("usuario_id")),
                                        ForeignKey(entity = Exercicios::class, parentColumns = arrayOf("id"), childColumns = arrayOf("exercicio_id"))))
class ExercicioUsuario(): Parcelable {

    private var dtAgedado: Date? = null

    @PrimaryKey
    private var usuario_id: Long = 0

    private var exercicio_id: Long = 0

    private var pesoEscolhido = 00.00
    private var repeticoes = 0
    private var series = 0

    constructor(parcel: Parcel) : this() {
        usuario_id = parcel.readLong()
        exercicio_id = parcel.readLong()
        pesoEscolhido = parcel.readDouble()
        repeticoes = parcel.readInt()
        series = parcel.readInt()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeLong(usuario_id)
        parcel.writeLong(exercicio_id)
        parcel.writeDouble(pesoEscolhido)
        parcel.writeInt(repeticoes)
        parcel.writeInt(series)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ExercicioUsuario> {
        override fun createFromParcel(parcel: Parcel): ExercicioUsuario {
            return ExercicioUsuario(parcel)
        }

        override fun newArray(size: Int): Array<ExercicioUsuario?> {
            return arrayOfNulls(size)
        }
    }


}