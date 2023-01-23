import java.io.*
import java.util.Date

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

class Estudiante(
    codigo: String,
    nombre: String,
    semestre: Int,
    fecha_registro: Date,
    beca: Boolean
) {
    var codigo: String
    var nombre: String
    var semestre: Int
    var fecha_registro: Date
    var beca: Boolean

    init{
        this.codigo = codigo
        this.nombre = nombre
        this.semestre = semestre
        this.fecha_registro = fecha_registro
        this.beca = beca
    }
}

fun crear_string(materia: Materia, estudiantes: ArrayList<Estudiante>): String{

    val datos: String

    val materia_string = "${materia.codigo},${materia.nombre},${materia.num_estudiantes}," +
            "${materia.profesor},${materia.horas_semestre}/"

    val estudiantes_string = estudiantes.joinToString(";") {
        "${it.codigo},${it.nombre},${it.semestre},${it.fecha_registro},${it.beca}"
    }

    datos = materia_string + estudiantes_string + "\n"
    return datos
}

fun escribir_archivo(datos: String, archivo: File){

    val escritor = FileWriter(archivo, true)
    escritor.append(datos)
    escritor.close()
}

fun leer_archivo(materia: Materia, archivo: File){

    val inputStream = FileInputStream(archivo)
    val lector = BufferedReader(InputStreamReader(inputStream))
    var linea: String? = lector.readLine()
    var cont = 1
    while (linea != null) {
        if(linea.contains(materia.codigo)){
            val separadores = "[/;]"
            val info = linea.split(separadores.toRegex())
            println("----------Materia----------")
            for(linea in info){
                val info_estudiante = linea.split(";")
                if(cont == 0){
                    println("----------Estudiantes----------")
                }
                for(linea in info_estudiante){
                    println(linea)
                }
                cont--
            }
        }
        linea = lector.readLine()
    }
    lector.close()
}

fun actualizar_archivo(archivo: File, antiguo_valor: String, nuevo_valor: String, tipo: String) {
    val inputStream = FileInputStream(archivo)
    val lector = BufferedReader(InputStreamReader(inputStream))
    var linea: String? = lector.readLine()
    while (linea != null) {
        if(linea.contains(antiguo_valor)){
            val linea_borrar = linea
            val lineas = archivo.readLines().filterNot { it == linea_borrar }
            archivo.writeText(lineas.joinToString("\n"))

            if(tipo == "materia"){
                escribir_archivo(linea.replace(antiguo_valor, nuevo_valor), archivo)
            }
            else if(tipo == "estudiante"){
                escribir_archivo(linea.replace(antiguo_valor, nuevo_valor), archivo)
            }
        }
        linea = lector.readLine()
    }
    lector.close()
}

fun borrar_info(archivo: File, codigo: String, tipo: String){
    val inputStream = FileInputStream(archivo)
    val lector = BufferedReader(InputStreamReader(inputStream))
    var linea: String? = lector.readLine()
    while (linea != null) {
        if(tipo == "materia" && linea.contains(codigo)){
            val linea_borrar = linea
            val lineas = archivo.readLines().filterNot { it == linea_borrar }
            archivo.writeText(lineas.joinToString("\n"))
        }
        if(tipo == "estudiante" && linea.contains(codigo)){
            val separadores = "[/;]"
            val info = linea.split(separadores.toRegex())
            for(linea in info) {
                val info_estudiante = linea.split(";")
                for (linea in info_estudiante) {
                    if (linea.contains(codigo)) {
                        val linea_borrar = linea
                        val nueva_linea = info.filterNot { it == linea_borrar }
                        archivo.writeText(nueva_linea.joinToString(";"))
                    }
                }
            }
        }
        linea = lector.readLine()
    }
    lector.close()
}

fun main(){

    // CREAR ARCHIVO
    val archivo = File("C:\\Users\\escritorio.virtual9\\Documents\\AppMov\\" +
            "garces-proano-andrea-fernanda-ms\\00-Kotlin\\Proyecto\\src\\main\\kotlin" +
            "\\Datos.txt")

    val fecha: Date = Date()

    // CREAR DATOS
    val materia1 = Materia("ISW123", "Programacion", 3,
        "Maria Rosero", 50.5)

    val est1 = Estudiante("202120131", "Oscar Navarrete", 2,
        fecha, true)
    val est2 = Estudiante("202120132", "Ian Moposita", 2,
        fecha, false)
    val est3 = Estudiante("202120133", "Jessica Perez", 2,
        fecha, false)

    val estudiantes: ArrayList<Estudiante> = arrayListOf<Estudiante>(est1, est2, est3)

    // LLENAR DATOS
        //escribir_archivo(crear_string(materia1, estudiantes), archivo)

    // ACTUALIZAR DATOS
        // DATOS MATERIA
            //actualizar_archivo(archivo, materia1.nombre, "POO", "materia")
        // DATOS ESTUDIANTE
            //actualizar_archivo(archivo, est1.beca.toString(), "false", "estudiante")

    // BORRAR DATOS
        // BORRAR ESTUDIANTE
            //borrar_info(archivo, est1.codigo, "estudiante")
        // BORRAR MATERIA
            //borrar_info(archivo, materia1.codigo, "materia")

    // LEER DATOS
        //leer_archivo(materia1, archivo)

}