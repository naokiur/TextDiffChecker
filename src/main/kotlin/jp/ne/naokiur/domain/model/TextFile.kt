package jp.ne.naokiur.domain.model

import org.apache.commons.csv.CSVFormat
import org.apache.commons.csv.CSVRecord
import java.io.FileReader

class TextFile(val fileKey: String, val filePath: String) {
    val records = CSVFormat.DEFAULT.parse(FileReader(filePath)).records

    fun notifyRecords(): MutableList<CSVRecord>? {
        return records
    }
}