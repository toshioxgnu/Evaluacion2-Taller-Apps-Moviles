package com.example.appeva2josegonzalez

import java.lang.Math.round

fun valida(rut: String): Boolean {
    var rutvalida = ""
    val constantesValidacion = arrayOf(3,2,7,6,5,4,3,2)
    var suma = 0;

    rutvalida = when(rut.length){
        9 -> "0" + rut
        8 -> "00" + rut
        7 -> "000" + rut
        6 -> "0000" + rut
        else -> rut
    }
    for (i in 0.. constantesValidacion.size -1 ){
        suma += Character.getNumericValue(rutvalida[i]) * constantesValidacion[i]
    }
    var division : Float = suma.toFloat()/11
    var divisionentero = division.toInt()
    var resto = division - divisionentero
    var digito = round(11- (11*resto))

    var digitovalida = Character.toString(rutvalida[9])

    if(digitovalida == "k"){
        digitovalida = "9"
    }
    if(digitovalida == "0"){
        digitovalida = "11"
    }
    return if (digito == digitovalida.toInt()) {
        return true
    } else {
        if (digito.toInt() == 9) {
            return false
        } else if (digito.toInt() == 11) {
            return false
        } else {
            false
        }
    }
}