package palmariuntec.com.br.pocketpersonaltrainer.utils

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import java.io.File

object ImageUtils {

    fun resize(file: File, reqWidth: Int, reqHeigt: Int): Bitmap{
        val options = BitmapFactory.Options()
        options.inJustDecodeBounds = true
        BitmapFactory.decodeFile(file.absolutePath, options)
        options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeigt)
        options.inJustDecodeBounds = false
        return BitmapFactory.decodeFile(file.absolutePath, options)
    }

    private fun calculateInSampleSize(opt: BitmapFactory.Options, reqWidth: Int, reqHeigt: Int): Int {
        val height = opt.outHeight
        val width = opt.outWidth
        var inSampleSize = 1

        if(height > reqHeigt || width > reqWidth){
            val halfHeigt = height/2
            val halfwidth = width/2
            while(halfHeigt/inSampleSize >= reqHeigt && halfwidth/inSampleSize >= reqWidth){
                inSampleSize *= 2
            }
        }
        return inSampleSize
    }
}