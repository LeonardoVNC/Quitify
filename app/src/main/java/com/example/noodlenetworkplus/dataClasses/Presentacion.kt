package com.example.noodlenetworkplus.dataClasses

// La clase Presentacion almacena datos necesarios para cada pantalla de introducción
data class Presentacion (
    val fondo: Int,       // ID del recurso del fondo (imagen de fondo)
    val image: Int,       // ID del recurso de imagen principal
    val titulo: String,   // Título que se mostrará en la pantalla
    val descripcion: String // Descripción o texto secundario
)