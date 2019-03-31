package jp.ne.naokiur.domain.application

import jp.ne.naokiur.domain.model.TextFile
import java.util.*

class TextDiffChecker(val beforeFile: TextFile, val afterFile: TextFile) {
    val resultList = mutableListOf<String>()

    fun execute() {
        check()
        output()
    }

    private fun check() {
        val sizeBefore = beforeFile.records.count()
        val sizeAfter = afterFile.records.count()

        val baseSize = if (sizeBefore > sizeAfter) sizeAfter else sizeBefore

        var i = 0
        while (i < baseSize) {
            val beforeRecord = beforeFile.records[i]
            val afterRecord = afterFile.records[i]
            val sizeBeforeColumn = beforeRecord.size()
            val sizeAfterColumn = afterRecord.size()


            val baseColumnSize = if (sizeBeforeColumn > sizeAfterColumn) sizeAfterColumn else sizeBeforeColumn

            var columnIndex = 0
            while (columnIndex < baseColumnSize) {
                val valueBefore = beforeRecord[columnIndex]
                val valueAfter = afterRecord[columnIndex]

                if(valueBefore != valueAfter) {
                    resultList.add("${i + 1}行目 before: $valueBefore, after: $valueAfter")
                }

                columnIndex++
            }

            i++
        }

//        beforeFile.records.forEachIndexed(fun(index: Int, value: CSVRecord) {
//            val isExistsDiff = value.forEachIndexed(fun(columnIndex: Int, columnValue: String) {
//                return (columnValue.equals(afterFile.records[index][columnIndex]))
////                    println("before: $columnValue, after: ${afterFile.records[index][columnIndex]}")
//            })
//        })

//        afterFile.records.forEach(fun(value: CSVRecord) {
//            val index = value.recordNumber.toInt() - 1
//            if (value == beforeFile.records[index]) {
//                print("Exists diff")
//            }
//        })
    }

    private fun output() {
        println(resultList)
    }
}
