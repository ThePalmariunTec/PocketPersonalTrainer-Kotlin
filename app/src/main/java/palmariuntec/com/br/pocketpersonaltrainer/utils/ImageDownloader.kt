package palmariuntec.com.br.pocketpersonaltrainer.utils

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import java.net.URL

object ImageDownloader {

    fun downloadBitmap(url: String): Bitmap{
        URL(url).openStream().use {
            val bitmap = BitmapFactory.decodeStream(it)
            return bitmap
        }
    }
}