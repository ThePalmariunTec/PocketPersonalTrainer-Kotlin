package palmariuntec.com.br.pocketpersonaltrainer.entidade

import androidx.room.Entity
import androidx.room.PrimaryKey
import android.os.Parcel
import android.os.Parcelable
import java.util.*

// entidade usuario: referente a tabela cliente no banco de dados
@Entity(tableName = "usuario")
class Usuario() : Parcelable {

    @PrimaryKey
    var id: Long = 0

    var nome = ""
    var email = ""
    var peso = 00.00
    var altura = 00.00
    var senha = ""
    var telefone = ""
    var status = 0
    var valorMensalidade = 00.00
    var dtVencimentoMensalidade: Date? = null
    var URIfotoPerfil = ""

    constructor(parcel: Parcel) : this() {
        id = parcel.readLong()
        nome = parcel.readString()
        email = parcel.readString()
        peso = parcel.readDouble()
        altura = parcel.readDouble()
        senha = parcel.readString()
        telefone = parcel.readString()
        status = parcel.readInt()
        valorMensalidade = parcel.readDouble()
        dtVencimentoMensalidade = parcel.readString() as Date
        URIfotoPerfil = parcel.readString()
    }

    override fun toString(): String {
        return "Usuario{nome = '$nome'}"
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeLong(id)
        parcel.writeString(nome)
        parcel.writeString(email)
        parcel.writeDouble(peso)
        parcel.writeDouble(altura)
        parcel.writeString(senha)
        parcel.writeString(telefone)
        parcel.writeInt(status)
        parcel.writeDouble(valorMensalidade)
        parcel.writeString(dtVencimentoMensalidade.toString())
        parcel.writeString(URIfotoPerfil)
    }

    override fun describeContents(): Int {
        return 0
    }

    fun readFromParcel(parcel: Parcel){

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