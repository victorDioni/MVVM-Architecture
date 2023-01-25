package dionizio.victor.mvvm_architecture_android.di.component

import android.content.Context
import dagger.Component
import dionizio.victor.mvvm_architecture_android.MVVMApplication
import dionizio.victor.mvvm_architecture_android.data.api.NetworkService
import dionizio.victor.mvvm_architecture_android.data.repository.TopHeadlineRepository
import dionizio.victor.mvvm_architecture_android.di.ApplicationContext
import dionizio.victor.mvvm_architecture_android.di.module.ApplicationModule
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {

    fun inject(application: MVVMApplication)

    @ApplicationContext
    fun getContext(): Context

    fun getNetworkService(): NetworkService

    fun getTopHeadlineRepository(): TopHeadlineRepository
}