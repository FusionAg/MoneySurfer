package pro.agfusion.plugin.dropbox

open class DropboxPluginExtension {
    var code: String? = null
    var token: String? = null
    val upload = mutableMapOf<CharSequence, CharSequence>()
}