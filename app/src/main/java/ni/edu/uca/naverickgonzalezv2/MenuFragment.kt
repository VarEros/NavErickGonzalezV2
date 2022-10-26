package ni.edu.uca.naverickgonzalezv2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import ni.edu.uca.naverickgonzalezv2.databinding.FragmentMenuBinding

class MenuFragment : Fragment() {
    lateinit var binding: FragmentMenuBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMenuBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding){
            btnModa.setOnClickListener {
                findNavController().navigate(R.id.modaFragment)
            }
            btnCubo.setOnClickListener {
                findNavController().navigate(R.id.cuboFragment)
            }
            btnNombre.setOnClickListener {
                findNavController().navigate(R.id.nombreFragment)
            }
        }
    }
}