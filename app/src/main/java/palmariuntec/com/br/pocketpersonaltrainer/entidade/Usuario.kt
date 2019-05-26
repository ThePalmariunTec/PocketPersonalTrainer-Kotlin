package palmariuntec.com.br.pocketpersonaltrainer.entidade

import androidx.room.Entity
import androidx.room.PrimaryKey
import android.os.Parcel
import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Ignore
import java.io.File
import java.io.Serializable
import java.util.*

// entidade usuario: referente a tabela cliente no banco de dados
@Entity(tableName = "usuario")
class Usuario: Parcelable {
    @PrimaryKey
    var id: Long = 0
    @ColumnInfo(name = "name")
    var nome = ""
    @ColumnInfo(name = "email")
    var email = ""
    @ColumnInfo(name = "weidth")
    var peso = 00.00
    @ColumnInfo(name = "heigth")
    var altura = 00.00
    @ColumnInfo(name = "password")
    var senha = ""
    @ColumnInfo(name = "phone")
    var telefone = ""
    @ColumnInfo(name = "month_value")
    var valorMensalidade = 00.00
    @ColumnInfo(name = "date_payoff")
    var dtVencimentoMensalidade = Date()

    constructor(parcel: Parcel): this() {
        id = parcel.readLong()
        nome = parcel.readString()
        email = parcel.readString()
        peso = parcel.readDouble()
        altura = parcel.readDouble()
        senha = parcel.readString()
        telefone = parcel.readString()
        valorMensalidade = parcel.readDouble()
    }

    constructor()

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeLong(id)
        parcel.writeString(nome)
        parcel.writeString(email)
        parcel.writeDouble(peso)
        parcel.writeDouble(altura)
        parcel.writeString(senha)
        parcel.writeString(telefone)
        parcel.writeDouble(valorMensalidade)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Usuario> {
        override fun createFromParcel(parcel: Parcel): Usuario {
            return Usuario(parcel)
        }

        override fun newArray(size: Int): Array<Usuario?> {
            return arrayOfNulls(size)
        }
    }
}