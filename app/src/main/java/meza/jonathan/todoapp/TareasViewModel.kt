package meza.jonathan.todoapp

import androidx.lifecycle.ViewModel

class TareasViewModel:ViewModel() {
    var elementos = mutableListOf<Tarea>()
}