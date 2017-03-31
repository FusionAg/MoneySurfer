package pro.agfusion.plugin.dropbox

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

open class DropboxUploadTask : DefaultTask() {
    lateinit var upload: List<PatternPair>
    lateinit var dropboxFileUploads: List<DropboxEntry>.() -> Unit
    lateinit var findFiles: List<PatternPair>.() -> List<DropboxEntry>

    @Suppress("unused")
    @TaskAction
    fun uploadFiles() {
        upload.findFiles().dropboxFileUploads()
    }
}