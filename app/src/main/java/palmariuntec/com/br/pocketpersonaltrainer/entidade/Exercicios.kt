package palmariuntec.com.br.pocketpersonaltrainer.entidade

import android.graphics.Bitmap
import android.os.Parcel
import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

@Entity(tableName = "exercicios")
class Exercicios: Parcelable {

    @PrimaryKey
    var id: Long = 0
    @ColumnInfo(name = "exercicio_nome")
    var nome =""
    @ColumnInfo(name = "exercicio_desc")
    var desc = ""

    @Ignore
    var image: Bitmap? = null

    constructor(nome: String, desc: String){
       this.nome = nome
        this.desc = desc
    }

    constructor(parcel: Parcel) {
        id = parcel.readLong()
        nome = parcel.readString()
        desc = parcel.readString()
        image = parcel.readParcelable(Bitmap::class.java.classLoader)
    }



    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeLong(id)
        parcel.writeString(nome)
        parcel.writeString(desc)
        parcel.writeParcelable(image, flags)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Exercicios> {
        override fun createFromParcel(parcel: Parcel): Exercicios {
            return Exercicios(parcel)
        }

        override fun newArray(size: Int): Array<Exercicios?> {
            return arrayOfNulls(size)
        }
    }


}