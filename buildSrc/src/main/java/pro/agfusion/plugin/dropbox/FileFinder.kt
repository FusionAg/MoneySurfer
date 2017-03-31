package pro.agfusion.plugin.dropbox

import org.apache.tools.ant.DirectoryScanner

class FileFinder(private val absolutePath: String) {
    val scanner = DirectoryScanner()
        .apply {
            setBasedir(absolutePath)
            isCaseSensitive = false
        }

    fun find(patterns: List<PatternPair>): List<DropboxEntry> =
        patterns.flatMap { (from, to) ->
            scanner.setIncludes(arrayOf(from))
            scanner.scan()
            scanner.includedFiles.toList()
                .map {
                    val cleanPattern = from.replace("**", "")
                        .let {
                            it.slice(0..it.lastIndexOf('/'))
                        }
                    val toWithoutPatternPath = "$to${it.replace(cleanPattern, "")}"
                    DropboxEntry("$absolutePath/$it", toWithoutPatternPath)
                }
        }
}