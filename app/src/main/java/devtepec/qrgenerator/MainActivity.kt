package devtepec.qrgenerator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidmads.library.qrgenearator.QRGContents
import androidmads.library.qrgenearator.QRGEncoder
import com.google.zxing.WriterException
import devtepec.qrgenerator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    /** */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        generateQrImage()
    }

    /**
     *
     */
    private fun generateQrImage() {
        val qrEncoder = QRGEncoder("https://codestats.net/users/JesusTepec", null, QRGContents.Type.TEXT, 300)
        try {
            val bitmap = qrEncoder.encodeAsBitmap()
            binding.imageViewQr.apply {
                setImageBitmap(bitmap)
            }
        } catch (e: WriterException) {
            e.printStackTrace()
        }
    }
}