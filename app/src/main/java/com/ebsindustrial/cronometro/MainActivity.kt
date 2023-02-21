package com.ebsindustrial.cronometro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import com.ebsindustrial.cronometro.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    var running = false
    var pause: Long = 0
    var mensagem = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        var ativo = binding.atividade.text.toString()
        var parado = binding.descanso.text.toString()

        binding.btIniciar.setOnClickListener{
            IniciarCronometro()
        }

        binding.btPausar.setOnClickListener{
            PausarCronometro()
        }

        binding.btZerar.setOnClickListener{
            ZerarCronometro()
        }

    }

    private fun IniciarCronometro(){
        if (!running){ // se a variavel estiver falsa
            binding.cronometro1.base = SystemClock.elapsedRealtime() - pause // busque o valor real do cronometro
            binding.cronometro1.start() // inicialize o cronometro
            running = true
        }
    }

    private fun PausarCronometro(){
        if (running){
            binding.cronometro1.stop()
            pause = SystemClock.elapsedRealtime() - binding.cronometro1.base
            running = false
        }
    }

    private fun ZerarCronometro(){
            binding.cronometro1.base = SystemClock.elapsedRealtime()
            pause = 0
            //running = false
    }
}