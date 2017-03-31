package pro.agfusion.plugin.dropbox

import com.dropbox.core.DbxRequestConfig
import com.dropbox.core.v2.DbxClientV2
import java.io.File

class DropboxInteractor(token: String) {
    val client by lazy {
        val config = DbxRequestConfig.newBuilder("dropbox/gradlePlugin")
            .build()
        DbxClientV2(config, token)
    }

    fun uploadFiles(files: List<DropboxEntry>) {
        files.forEach {
            println("Dropbox uploading ${it.from} to ${it.to}")
            client.files().upload(it.to).uploadAndFinish(File(it.from).inputStream())
        }
    }
}