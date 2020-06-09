package dk.fitfit.injurylog.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import dk.fitfit.injurylog.db.model.Tag
import dk.fitfit.injurylog.repository.TagRepository
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class TagsViewModel(private val repository: TagRepository) : ViewModel() {
    val tags: LiveData<List<Tag>> = liveData {
        emitSource(repository.findAll())
    }

    fun update() {
        viewModelScope.launch(IO) {
            repository.update()
        }
    }
}
