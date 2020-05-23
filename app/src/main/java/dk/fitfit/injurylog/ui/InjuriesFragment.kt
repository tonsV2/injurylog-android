package dk.fitfit.injurylog.ui

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.observe
import dk.fitfit.injurylog.R
import kotlinx.android.synthetic.main.fragment_injuries.*
import org.koin.android.viewmodel.ext.android.viewModel

class InjuriesFragment : Fragment(R.layout.fragment_injuries) {
    private val injuriesViewModel: InjuriesViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        injuriesViewModel.update()

        val adapter = InjuriesAdapter {
            Toast.makeText(context, "$it", Toast.LENGTH_SHORT).show()
        }

        injuriesList.adapter = adapter

        injuriesViewModel.injuries.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }
    }
}
