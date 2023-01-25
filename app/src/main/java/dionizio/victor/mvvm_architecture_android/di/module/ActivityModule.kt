package dionizio.victor.mvvm_architecture_android.di.module

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import dagger.Module
import dagger.Provides
import dionizio.victor.mvvm_architecture_android.data.repository.TopHeadlineRepository
import dionizio.victor.mvvm_architecture_android.di.ActivityContext
import dionizio.victor.mvvm_architecture_android.ui.base.ViewModelProviderFactory
import dionizio.victor.mvvm_architecture_android.ui.topheadilne.TopHeadlineAdapter
import dionizio.victor.mvvm_architecture_android.ui.topheadilne.TopHeadlineViewModel

@Module
class ActivityModule(private val activity: AppCompatActivity) {

    @ActivityContext
    @Provides
    fun provideContext(): Context {
        return activity
    }

    @Provides
    fun provideTopHeadlineViewModel(topHeadlineRepository: TopHeadlineRepository): TopHeadlineViewModel {
        return ViewModelProvider(activity,
            ViewModelProviderFactory(TopHeadlineViewModel::class) {
                TopHeadlineViewModel(topHeadlineRepository)
            })[TopHeadlineViewModel::class.java]
    }

    @Provides
    fun provideTopHeadlineAdapter() = TopHeadlineAdapter(ArrayList())

}