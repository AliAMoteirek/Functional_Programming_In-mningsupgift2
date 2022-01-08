package Inlämningsuppgift2

class Tomteland {
    private val mapOfTomte = mapOf(
        "Tomten" to listOf("Glader", "Butter"),
        "Glader" to listOf("Tröger", "Trötter", "Blyger"),
        "Butter" to listOf("Rådjuret", "Nyckelpigan", "Haren", "Räven"),
        "Trötter" to listOf("Skumtomten"), "Skumtomten" to listOf("Dammråttan"),
        "Räven" to listOf("Gråsuggan", "Myran"), "Myran" to listOf("Bladlusen")
    )

    fun getUnderlings(currentName: String, res: MutableList<String>): List<String> {
        mapOfTomte.forEach { (key, value) ->
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