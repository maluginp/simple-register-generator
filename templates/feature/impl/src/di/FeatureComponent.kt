package ${packageName}.${featureName}.impl.di

import ${rootPackageName}.core.di.PerFeature
import ${packageName}.${featureName}.api.${featureNameCamelCase}FeatureApi

@dagger.Component(dependencies = [${featureNameCamelCase}FeatureDependencies::class], modules = [${featureNameCamelCase}FeatureModule::class])
@PerFeature
internal abstract class ${featureNameCamelCase}FeatureComponent : ${featureNameCamelCase}FeatureApi {

    companion object {
        fun initAndGet(${featureName}FeatureDependencies: ${featureNameCamelCase}FeatureDependencies): ${featureNameCamelCase}FeatureComponent {
            return Dagger${featureNameCamelCase}FeatureComponent.builder()
                .${featureName}FeatureDependencies(${featureName}FeatureDependencies)
                .build()
        }
    }
}