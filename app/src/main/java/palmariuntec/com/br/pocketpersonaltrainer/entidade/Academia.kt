package palmariuntec.com.br.pocketpersonaltrainer.entidade

import android.os.Parcel
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "academia")
class Academia() : Parcelable {
    @PrimaryKey
    var id: Long = 0

    var nome = ""
    var endereco = ""
    var telefone = ""
    var cidade = ""

    override fun toString(): String {
        return "Academia {nome = '$nome'}"
    }

    constructor(parcel: Parcel) : this() {
        id = parcel.readLong()
        nome = parcel.readString()
        endereco = parcel.readString()
        telefone = parcel.readString()
        cidade = parcel.readString()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeLong(id)
        parcel.writeString(nome)
        parcel.writeString(endereco)
        parcel.writeString(telefone)
        parcel.writeString(cidade)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Academia> {
        override fun createFromParcel(parcel: Parcel): Academia {
            return Academia(parcel)
        }

        override fun newArray(size: Int): Array<Academia?> {
            return arrayOfNulls(size)
        }
    }
}