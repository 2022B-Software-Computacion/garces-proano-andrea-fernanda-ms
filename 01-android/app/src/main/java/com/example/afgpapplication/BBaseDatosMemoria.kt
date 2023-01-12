package com.example.afgpapplication

class BBaseDatosMemoria {
    companion object{
        val arregloBEntrenador = arrayListOf<BEntrenador>()
        init{
            arregloBEntrenador
                .add(
                    BEntrenador(1, "Andrea", "a@a.com")
                )
            arregloBEntrenador
                .add(
                    BEntrenador(2, "Garces", "b@b.com")
                )
            arregloBEntrenador
                .add(
                    BEntrenador(3, "Carolina", "c@c.com")
                )
        }
    }
}