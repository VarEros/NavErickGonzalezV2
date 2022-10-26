package ni.edu.uca.naverickgonzalezv2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import ni.edu.uca.naverickgonzalezv2.databinding.FragmentModaBinding
import java.lang.NumberFormatException

class ModaFragment : Fragment() {
    private lateinit var binding: FragmentModaBinding
    private var lista = mutableListOf<Int>()
    private var repeticiones = 0
    private var maxRep = 0
    private var moda = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentModaBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnAgregar.setOnClickListener {
            try {
                agregarALista(binding.etNum.text.toString().toInt())
                binding.etNum.setText("")
            } catch (e: NumberFormatException) {
                Toast.makeText(context, "El dato digitado no es valido", Toast.LENGTH_SHORT).show()
            }
        }

        binding.btnCalcular.setOnClickListener {
            if(lista.isEmpty()) {
                Toast.makeText(context, "Necesita agregar elementos a la lista", Toast.LENGTH_SHORT).show()
            }
            ordenarLista()
            calcularModa()
            binding.tvMaterial.text = "La moda de esta lista es $moda"
        }
    }

    private fun agregarALista(numero: Int) {
        lista.add(numero)
    }

    private fun ordenarLista() {
        lista.sort()
    }

    private fun calcularModa() {
        for(num in lista) {
            repeticiones = 0
            for(count in lista){
                if(num==count)
                    repeticiones++
            }
            if(maxRep < repeticiones) {
                moda = num
                maxRep = repeticiones
            }
        }
    }
}