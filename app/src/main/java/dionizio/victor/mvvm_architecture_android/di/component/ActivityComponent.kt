package dionizio.victor.mvvm_architecture_android.di.component

import dagger.Component
import dionizio.victor.mvvm_architecture_android.di.ActivityScope
import dionizio.victor.mvvm_architecture_android.di.module.ActivityModule
import dionizio.victor.mvvm_architecture_android.ui.topheadilne.TopHeadlineActivity

@ActivityScope
@Component(dependencies = [ApplicationComponent::class], modules = [ActivityModule::class])
interface ActivityComponent {

    fun inject(activity: TopHeadlineActivity)

}