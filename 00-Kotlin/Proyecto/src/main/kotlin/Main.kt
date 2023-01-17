class Materia(
    codigo: String,
    nombre: String,
    num_estudiantes: Int,
    profesor: String,
    horas_semestre: Double
) {
    var codigo: String
    var nombre: String
    var num_estudiantes: Int
    var profesor: String
    var horas_semestre: Double

    init{
        this.codigo = codigo
        this.nombre = nombre
        this.num_estudiantes = num_estudiantes
        this.profesor = profesor
        this.horas_semestre = horas_semestre
    }
}

fun main(){
    println("hola")
    val materia1 = Materia("ABC", "APP", 1, "AAA", 2.2)
    println(materia1.nombre)
}