class Sorteo {
    var totalNumeros: IntArray = IntArray(100) { it + 1 }
    var diezPrimeros: IntArray = IntArray(10)
    var numeroGanador: Int = 0

    fun sortear() {
        for (i in 0 until diezPrimeros.size) {  // 0..9
            val ranIndex = (0 until totalNumeros.size).random()
            diezPrimeros[i] = totalNumeros[ranIndex]
            println(diezPrimeros[i])
        }
    }
}
