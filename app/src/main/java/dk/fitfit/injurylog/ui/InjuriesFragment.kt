package dk.fitfit.injurylog.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.observe
import dk.fitfit.injurylog.R
import org.koin.android.viewmodel.ext.android.viewModel

class InjuriesFragment : Fragment(R.layout.fragment_injuries) {
    private val injuriesViewModel: InjuriesViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        injuriesViewModel.update()

        injuriesViewModel.injuries.observe(viewLifecycleOwner) {
            it.forEach { injuryWithTags ->
                println(injuryWithTags.injury.description)
            }
        }
    }
}
