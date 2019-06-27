package io.github.boostersamples.transformer.javassist

import com.didiglobal.booster.kotlinx.ifNotEmpty
import com.didiglobal.booster.transform.TransformContext
import com.didiglobal.booster.transform.javassist.ClassTransformer
import com.google.auto.service.AutoService
import javassist.CtClass
import javassist.bytecode.Descriptor

/**
 * @author johnsonlee
 */
@AutoService(ClassTransformer::class)
class SampleJavassistTransformer : ClassTransformer {

    override fun transform(context: TransformContext, klass: CtClass) = klass.also {
        println("Transforming ${klass.name}: ")
        klass.fields.asList().ifNotEmpty {
            println(klass.fields.joinToString("\n") {
                "  - $it"
            })
        }
        klass.methods.asList().ifNotEmpty {
            println(klass.methods.joinToString("\n") {
                "  - ${it.name}${Descriptor.toString(it.signature)}"
            })
        }
    }

}
