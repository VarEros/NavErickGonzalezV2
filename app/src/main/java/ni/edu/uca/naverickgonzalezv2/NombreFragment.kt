package ni.edu.uca.naverickgonzalezv2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import ni.edu.uca.naverickgonzalezv2.databinding.FragmentCuboBinding
import ni.edu.uca.naverickgonzalezv2.databinding.FragmentNombreBinding
import java.lang.NumberFormatException

class NombreFragment : Fragment() {
    private lateinit var binding: FragmentNombreBinding
    private lateinit var nombre: String
    private var largo = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentNombreBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnCalcular.setOnClickListener {
            try {
                nombre = binding.etNombre.text.toString()
                largo = calcularLargo(nombre)

                binding.tvMaterial.text = "Su nombre tiene $largo letras y ${VerificarSiEsPar(largo)}"
                binding.etNombre.setText("")
            } catch (e: NumberFormatException) {
                Toast.makeText(context, "El dato digitado no es valido", Toast.LENGTH_SHORT).show()
            }
        }
    }

        private fun VerificarSiEsPar(largo: Int): String {
            return if(largo%2 == 0)
                "es par"
            else
                "no es par"
    }

    private fun calcularLargo(nombre: String): Int {
        return nombre.length
    }
}