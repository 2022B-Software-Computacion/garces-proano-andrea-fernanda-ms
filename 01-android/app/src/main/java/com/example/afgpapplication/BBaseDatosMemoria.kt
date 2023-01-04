package com.example.afgpapplication

class BBaseDatosMemoria {
    companion object{
        val arregloBEntrenador = arrayListOf<BEntrenador>()
        init{
            arregloBEntrenador
                .add(
                    BEntrenador("Andrea", "a@a.com")
                )
            arregloBEntrenador
                .add(
                    BEntrenador("Garces", "b@b.com")
                )
            arregloBEntrenador
                .add(
                    BEntrenador("Carolina", "c@c.com")
                )
        }
    }
}