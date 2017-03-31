package pro.agfusion.plugin.dropbox

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction
import java.awt.Desktop
import java.net.URI

open class DropboxOauthTask : DefaultTask() {
    lateinit var code: CharSequence

    private val url by lazy { URI.create("https://www.dropbox.com/1/oauth2/authorize?client_id=$code&response_type=token&redirect_uri=http://localhost") }

    @Suppress("unused")
    @TaskAction
    fun openBrowser() {
        Desktop.getDesktop().browse(url)
    }
}