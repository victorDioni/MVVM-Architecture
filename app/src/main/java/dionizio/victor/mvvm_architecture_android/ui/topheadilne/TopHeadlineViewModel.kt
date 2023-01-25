package dionizio.victor.mvvm_architecture_android.ui.topheadilne

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dionizio.victor.mvvm_architecture_android.data.model.Article
import dionizio.victor.mvvm_architecture_android.data.repository.TopHeadlineRepository
import dionizio.victor.mvvm_architecture_android.utils.AppConstant.COUNTRY
import dionizio.victor.mvvm_architecture_android.utils.Resource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class TopHeadlineViewModel (private val topHeadlineRepository: TopHeadlineRepository) : ViewModel(){
    private val _articleList = MutableStateFlow<Resource<List<Article>>>(Resource.loading())

    val articleList: StateFlow<Resource<List<Article>>> = _articleList

    init {
        fetchTopHeadlines()
    }

    private fun fetchTopHeadlines() {
        viewModelScope.launch {
            topHeadlineRepository.getTopHeadlines(COUNTRY)
                .catch { e ->
                    _articleList.value = Resource.error(e.toString())
                }
                .collect {
                    _articleList.value = Resource.success(it)
                }
        }
    }
}