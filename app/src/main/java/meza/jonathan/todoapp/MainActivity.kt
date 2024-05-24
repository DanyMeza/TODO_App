package meza.jonathan.todoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.SeekBar
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    lateinit var etCant:EditText
    //9lateinit var btnGuardar:Button
    lateinit var sbMes:SeekBar
    lateinit var tvMes2:TextView
    lateinit var listaTareas:RecyclerView
    lateinit var adapter:TareasAdapter

    private val tareasViewModel:TareasViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etCant = findViewById(R.id.etCant)
        //btnGuardar = findViewById(R.id.btnGuardar)
        sbMes = findViewById(R.id.sbMes)
        tvMes2 = findViewById(R.id.tvMes2)
        listaTareas = findViewById(R.id.rvCetes)

        tvMes2.setText("Meses: " + sbMes.progress)

        /*tareasViewModel.elementos.add(
            Tarea("Jonathan Daniel", "Meza Casas", false)
        )*/

        adapter = TareasAdapter(tareasViewModel.elementos)

        listaTareas.adapter = adapter
        listaTareas.layoutManager = GridLayoutManager(this, 1)

        /*btnGuardar.setOnClickListener {
            var tasa = 4.28
            var ISR = 0.97
            var monto = etCant.text.toString().toFloat()
            var plazo = sbMes.progress.toString().toFloat() * 30 // En dias
            tasa = tasa/100
            ISR = ISR/100

            val cant = "Cantidad: " + etCant.text.toString()
            val mes = "Meses: " + sbMes.progress.toString()

            var int_bruto = (monto * plazo * tasa) / 360
            ISR = (monto * ISR * plazo) / 365

            val interes = "Interes NETO: ${int_bruto - ISR}"
            val ganancias = "Ganancias: ${monto + (int_bruto - ISR)}"
            tareasViewModel.elementos.add(Tarea(cant, mes, ganancias, interes))

            adapter.notifyDataSetChanged()
            Toast.makeText(this,"${tareasViewModel.elementos.size}",Toast.LENGTH_SHORT).show()
        }*/

        sbMes.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                tvMes2.setText("Meses: " + sbMes.progress)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                var tasa = 11.69
                var ISR = 0.97
                var monto = etCant.text.toString().toFloat()
                var plazo = sbMes.progress.toString().toFloat() * 30 // En dias
                tasa = tasa/100
                ISR = ISR/100

                val cant = "Cantidad: " + etCant.text.toString()
                val mes = "Meses: " + sbMes.progress.toString()

                var int_bruto = (monto * plazo * tasa) / 360
                ISR = (monto * ISR * plazo) / 365

                val interes = "Interes NETO: ${int_bruto - ISR}"
                val ganancias = "Ganancias: ${monto + (int_bruto - ISR)}"
                tareasViewModel.elementos.add(Tarea(cant, mes, ganancias, interes))

                adapter.notifyDataSetChanged()
            }
        })
    }
}