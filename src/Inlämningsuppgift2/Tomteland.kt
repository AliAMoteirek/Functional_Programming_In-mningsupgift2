package Inlämningsuppgift2

import java.io.File
import java.io.FileNotFoundException
import java.lang.Exception

class Tomteland {
    private val mapList = mutableMapOf<String, List<String>>()

    private fun constructMapOfTomtar() {
        try {
            File("file.txt").useLines { lines ->
                lines.groupBy {
                    val list = it.split(", ")
                    mapList.put(list[0], list.subList(1, list.size))
                }
                //mapList.forEach { println(it) }
            }
        } catch (e: FileNotFoundException) {
            println("The text file is not found")
            e.printStackTrace()
        } catch (e: Exception) {
            println("Something went wrong")
            e.printStackTrace()
        }
    }

    fun getUnderlings(currentName: String, res: MutableList<String>): List<String> {
        constructMapOfTomtar()
        mapList.forEach { (key, value) ->
            value.filter { key == currentName }.forEach {
                res += it
                getUnderlings(it, res)
            }
        }
        return res
    }
}

fun main() {
    val test = Tomteland()
    val list: MutableList<String> = mutableListOf()
    println(test.getUnderlings("Glader", list))
}