package pro.agfusion.plugin.dropbox

import org.gradle.api.Plugin
import org.gradle.api.Project

open class DropboxPlugin : Plugin<Project> {
    lateinit var dropboxInteractor: DropboxInteractor
    lateinit var fileFinder: FileFinder
    lateinit var config: DropboxPluginExtension

    override fun apply(project: Project) {
        config = project.extensions.create("dropbox", DropboxPluginExtension::class.java)

        project.afterEvaluate {
            if (!config.code.isNullOrBlank()) {
                val oauthTask = project.tasks.create("dropboxOauth", DropboxOauthTask::class.java)
                oauthTask.code = config.code!!
                oauthTask.group = "publishing"
            }

            if (config.upload.isNotEmpty() && !config.token.isNullOrBlank()) {
                dropboxInteractor = DropboxInteractor(config.token!!)
                fileFinder = FileFinder(project.projectDir.absolutePath)
                val uploadTask = project.tasks.create("dropboxUpload", DropboxUploadTask::class.java)
                uploadTask.dropboxFileUploads = { dropboxInteractor.uploadFiles(this) }
                uploadTask.findFiles = { fileFinder.find(this) }
                uploadTask.upload = config.upload.map { PatternPair(it.key.toString(), it.value.toString()) }
                uploadTask.group = "publishing"
            }
        }
    }
}