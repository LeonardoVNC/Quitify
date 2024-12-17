package com.example.noodlenetworkplus.dataClasses

data class Publicacion(
    val autor: String,                  //Autor de la publicación
    val fechaDePublicacion: String,     //Fecha relacionada a la publicación
    val horaDePublicacion: String,      //Hora relacionada a la publicación
    val contenido: String,              //Contenido de la publicación
    val imagen: Int                     //ID de la imágen que acompañará a la publicación
)
