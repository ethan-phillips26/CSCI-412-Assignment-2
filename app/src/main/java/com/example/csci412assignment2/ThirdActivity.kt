package com.example.csci412assignment2

import android.Manifest
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.activity.ComponentActivity
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import androidx.core.content.FileProvider
import com.bumptech.glide.Glide
import java.io.File
import java.io.IOException

class ThirdActivity : ComponentActivity() {

    private lateinit var openCamera: Button
    private lateinit var clickedImage: ImageView

    private var photoFile: File? = null
    private var photoUri: Uri? = null

    private val takePicture = registerForActivityResult(ActivityResultContracts.TakePicture()) { success ->
        if (success) {
            photoUri?.let { uri ->
                Glide.with(this)
                    .load(uri)
                    .into(clickedImage)
            }
        }
    }

    // Must request camera permission or app will crash
    private val requestPermissionLauncher =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted: Boolean ->
            if (isGranted) {
                launchCamera()
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)

        openCamera = findViewById(R.id.camera_open)
        clickedImage = findViewById(R.id.click_image)

        openCamera.setOnClickListener {
            checkCameraPermissionAndLaunch()
        }
    }

    private fun checkCameraPermissionAndLaunch() {
        when {
            ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.CAMERA
            ) == PackageManager.PERMISSION_GRANTED -> {
                launchCamera()
            }
            else -> {
                requestPermissionLauncher.launch(Manifest.permission.CAMERA)
            }
        }
    }

    private fun launchCamera() {
        try {
            val file = createImageFile()
            photoFile = file

            val uri = FileProvider.getUriForFile(
                this,
                "${packageName}.fileprovider",
                file
            )
            photoUri = uri

            takePicture.launch(uri)

        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    @Throws(IOException::class)
    private fun createImageFile(): File {
        val imageDir = File(cacheDir, "images")
        if (!imageDir.exists()) {
            imageDir.mkdirs()
        }
        return File.createTempFile("captured_", ".jpg", imageDir)
    }
}
