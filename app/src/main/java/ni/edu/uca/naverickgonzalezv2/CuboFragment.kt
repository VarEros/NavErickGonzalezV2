package ni.edu.uca.naverickgonzalezv2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import ni.edu.uca.naverickgonzalezv2.databinding.FragmentCuboBinding
import java.lang.NumberFormatException
import kotlin.math.pow

class CuboFragment : Fragment() {
    private lateinit var binding: FragmentCuboBinding
    private var numero = 0.0F
    private var resultado = 0.0F

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentCuboBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnCalcular.setOnClickListener {
            try {
                numero = binding.etNumero.text.toString().toFloat()
                resultado = calcularCubo(numero)
                binding.etNumero.setText("")
                binding.tvMaterial.text = "El cubo de ${String.format("%.2f", numero)} es ${String.format("%.2f", resultado)}"
            }catch (e: NumberFormatException) {
                Toast.makeText(context, "El dato digitado no es valido", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun calcularCubo(num: Float): Float {
        return num.pow(3)
    }
}