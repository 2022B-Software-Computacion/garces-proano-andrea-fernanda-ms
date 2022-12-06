import java.util.*

fun main(){
    println("Hola")

    // Tipos de Variables

    // INMUTABLES (No se pueden reasignar)
    val inmutable: String = "Andrea";
    // inmutable = "Nuevo"; (No se permite)

    // MUTABLES
    var mutable: String = "Fernanda"
    mutable = "Andrea"

    // ; es opcional en Kotlin

    // Sintaxis Duck typing
    val ejemploVariable = "Ejemplo"
    val edadEjemplo: Int = 12
    ejemploVariable.trim()

    // Variables primitivas
    val nombreProfesor: String = "Adrian Eguez"
    val sueldo: Double = 1.2
    val estadoCivil: Char = 'S'
    val mayorEdad: Boolean = true

    // Clases JAVA
    val fechaNacimiento: Date = Date()

    if (true) {
    } else {
    }

    // Switch no existe
    val estadoCivilWhen = "S"
    when (estadoCivilWhen) {
        ("S") -> {
            println("acercarse")
        }
        "C" -> {
            println("alejarse")
        }
        "UN" -> print("hablar")
        else -> println("no reconocido")
    }

    // En una linea
    val coqueteo = if (estadoCivilWhen == "S") "SI" else "NO"

    // Unit == void
    fun imprimirNombre(nombre: String): Unit {
        println("Nombre : ${nombre}")
    }

    fun calcularSueldo(
        sueldo: Double, // Requerido
        tasa: Double = 12.00,   // Opcional (Defecto)
        bonoEspecial: Double? = null,   //Opcional (Null) -> nullable
    ): Double {
        // String -> String? (Puede ser Null)
        // Int -> Int?
        // Date -> Date?
        if (bonoEspecial == null){
            return sueldo * (100 / tasa)
        } else {
            return sueldo * (100 / tasa) + bonoEspecial
        }
    }
}