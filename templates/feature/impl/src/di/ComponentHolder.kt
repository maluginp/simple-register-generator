package ${packageName}.${featureName}.impl.di

import ${rootPackageName}.core.module_injector.ComponentHolder
import ${packageName}.${featureName}.api.${featureNameCamelCase}FeatureApi

object ${featureNameCamelCase}ComponentHolder : ComponentHolder<${featureNameCamelCase}FeatureApi, ${featureNameCamelCase}FeatureDependencies> {
    private var ${featureName}ComponentHolder: ${featureNameCamelCase}FeatureComponent? = null

    override fun init(dependencies: ${featureNameCamelCase}FeatureDependencies) {
        if (${featureName}ComponentHolder == null) {
            synchronized(${featureNameCamelCase}ComponentHolder::class.java) {
                if (${featureName}ComponentHolder == null) {
                    ${featureName}ComponentHolder = ${featureNameCamelCase}FeatureComponent.initAndGet(dependencies)
                }
            }
        }
    }

    override fun get(): ${featureNameCamelCase}FeatureApi {
        checkNotNull(${featureName}ComponentHolder) { "${featureNameCamelCase}Component was not initialized!" }
        return ${featureName}ComponentHolder!!
    }

    override fun reset() {
        ${featureName}ComponentHolder = null
    }

}
