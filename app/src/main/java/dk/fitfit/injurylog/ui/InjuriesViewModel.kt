package dk.fitfit.injurylog.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import dk.fitfit.injurylog.db.model.InjuryWithTags
import dk.fitfit.injurylog.repository.InjuryRepository
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class InjuriesViewModel(private val repository: InjuryRepository) : ViewModel() {
    val injuries: LiveData<List<InjuryWithTags>> = liveData {
        emitSource(repository.findAll())
    }

    fun update() {
        viewModelScope.launch(IO) {
            repository.update()
        }
    }
}
