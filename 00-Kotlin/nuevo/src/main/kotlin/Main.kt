import java.util.*
import kotlin.collections.ArrayList

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

    // ARREGLOS

    // Tipos de Arreglos

    // Arreglo estatico
    val arregloEstatico: Array<Int> = arrayOf<Int>(1, 2, 3)
    println(arregloEstatico)

    // ArregloDinamico
    val arregloDinamico: ArrayList<Int> = arrayListOf<Int>(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    println(arregloDinamico)
    arregloDinamico.add(11)
    arregloDinamico.add(12)
    println(arregloDinamico)

    // OPERADORES -> Sirven para los arreglos estaticos y dinamicos

    // FOR EACH -> Unit
    // Iterar un arreglo
    val respuestaForEach: Unit = arregloDinamico.forEach{
        valorActual: Int -> println("Valor actual: ${valorActual}")
    }
    arregloEstatico.forEachIndexed { indice: Int, valorActual: Int ->
        println("Valor ${valorActual} Indice: ${indice}")
    }
    println(respuestaForEach)

    // MAP -> Muta el arreglo (cambia el arreglo)
    // 1) Enviemos el nuevo valor de la iteracion
    // 2) Nos devuelve un NUEVO ARREGLO con los valores modificados

    val respuestaMap: List<Double> = arregloDinamico.map {
        valorActual: Int -> return@map valorActual.toDouble() + 100.00
    }

    println(respuestaMap)

    val respuestaMapDos = arregloDinamico.map { it + 15 }

    println(respuestaMapDos)

    // Filter -> FILTRAR EL ARREGLO
    // 1) Devolver una expresion (TRUE o FALSE)
    // 2) Nuevo arreglo filtrado

    val respuestaFilter: List<Int> = arregloDinamico.filter { valorActual: Int ->
        val mayoresACinco: Boolean = valorActual > 5 // Expresion Condicion
        return@filter mayoresACinco
    }
    val respuestaFilterDos = arregloDinamico.filter { it <= 5 }
    println(respuestaFilter)
    println(respuestaFilterDos)

    // OR AND
    // OR -> ANY (Alguno cumple?)
    // AND -> ALL (Todos cumplen?)

    val respuestaAny: Boolean = arregloDinamico.any{ valorActual: Int ->
        return@any (valorActual > 5)
    }
    println(respuestaAny) // true

    val respuestaAll: Boolean = arregloDinamico.all { valorActual: Int ->
        return@all(valorActual > 5)
    }
    println(respuestaAll) // false

    // REDUCE -> Valor acumulado
    // Valor acumulado = 0 (Siempre 0 en lenguaje Kotlin)
    // [1, 2, 3, 4, 5] -> Sume todos los valores del arreglo
    // valorIteracion1 = valorEmpieza + 1 = 0 + 1 = 1
    // valorIteracion2 = valorIteracion1 + 2 = 1 + 2 = 3 -> Iteracion2
    // valorIteracion3 = valorIteracion2 + 3 = 3 + 3 = 6 -> Iteracion3
    // valorIteracion4 = valorIteracion3 + 4 = 6 + 4 = 10 -> Iteracion4
    // valorIteracion5 = valorIteracion4 + 5 = 10 + 5 = 15 -> Iteracion5

    val respuestaReduce: Int = arregloDinamico.reduce{ // acumulado = 0 -> SIEMPRE EMPIEZA EN 0
        acumulado: Int, valorActual: Int ->
        return@reduce (acumulado + valorActual) // -> Logica negocio
    }
    println(respuestaReduce) // 78
}

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

// Clase con constructor
abstract class NumerosJava {
    protected val numeroUno: Int
    private val numeroDos:Int

    constructor(
        uno: Int,
        dos: Int
    ) { // Bloque de codigo constructor
        this.numeroUno = uno
        this.numeroDos = dos
        println("Inicializado")
    }
}

// Constructor primario
abstract class Numeros( // Constructor Primario
    // public var uno: Int, // La palabra public es opcional
    var uno: Int,
    protected val numeroUno: Int,
    protected val numeroDos: Int
) {
    init { // Bloque de codigo constructor Primario
        // this.uno = uno // La palabra this es opcional
        numeroUno
        numeroDos
        println("Inicializado")
    }
}

class Suma( // Constructor Primario Suma
    uno: Int, // Parametro
    dos: Int // Parametro
): Numeros(uno, dos){
    init { // Bloque constructor Primario
        this.numeroUno
        this.numeroDos
    }

    constructor( // Segundo constructor
        uno: Int,
        dos: Int?
    ):this( // Llamada constructor Primario
        uno,
        if (dos == null) 0 else dos
    ){
    }
    constructor( // Tercer constructor
        uno: Int?,
        dos: Int?
    ):this(
        if (uno == null) 0 else uno,
        if (dos == null) 0 else dos
    )

    public fun sumar(): Int {
        val total = numeroUno + numeroDos
        agregarHistorial(total)
        return(total)
    }
    companion object { //Atributos y metodos "compartidos"
        // entre las instancias
        val pi = 3.14
        fun elevarAlCuadrado(num: Int): Int {
            return num * num
        }
        val historialSumas = arrayListOf<Int>()
        fun agregarHistorial(valorNuevaSuma: Int){
            historialSumas.add(valorNuevaSuma)
        }
    }
}






