package com.crpr.androidadapters.processor;

import com.crpr.androidadapters.AdapterTemplate;
import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.ParameterizedTypeName;
import com.squareup.javapoet.TypeName;
import com.squareup.javapoet.TypeSpec;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Messager;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.AnnotationMirror;
import javax.lang.model.element.AnnotationValue;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic;

@SupportedAnnotationTypes(value = "com.crpr.androidadapters.AdapterTemplate")
@SupportedSourceVersion(SourceVersion.RELEASE_7)
public class AdapterProcessor extends AbstractProcessor{

    private static final String ROOT_PATH = "com.crpr.androidadapters.generated";
    private static final String CLASS_NAME_SUFFIX = "Builder";

    private Messager messenger;

    @Override
    public synchronized void init(ProcessingEnvironment processingEnv) {
        super.init(processingEnv);
        messenger = processingEnv.getMessager();
    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {

        for(Element annotatedElement : roundEnv.getElementsAnnotatedWith(AdapterTemplate.class)){

            String className = annotatedElement.getSimpleName().toString() + CLASS_NAME_SUFFIX;

            if (annotatedElement.getKind() != ElementKind.CLASS) {
                error(annotatedElement, "Only classes can be annotated with @%s",
                        AdapterTemplate.class.getSimpleName());
                return true; // Exit processing
            }

            TemplateValueVisitor valueVisitor = new TemplateValueVisitor(messenger);

            TypeElement element = (TypeElement) annotatedElement;

            ClassName baseTemplateClass = ClassUtils.getClassNameByType(ClassUtils.BASE_TEMPLATE);
            ClassName baseViewHolderClass = ClassUtils.getClassNameByType(ClassUtils.BASE_VIEWHOLDER);
            ClassName templateModelClass = ClassUtils.getClassNameByType(ClassUtils.TEMPLATE_MODEL);

            MethodSpec getLayoutIdSpec = null, buildSpec = null;

            // Get the annotation element from the type element
            List<? extends AnnotationMirror> annotationMirrors = element.getAnnotationMirrors();
            messenger.printMessage(Diagnostic.Kind.NOTE, "START");
            for (AnnotationMirror annotationMirror : annotationMirrors) {

                Map<? extends ExecutableElement, ? extends AnnotationValue> elementValues
                        = annotationMirror.getElementValues();
                for (Map.Entry<? extends ExecutableElement, ? extends AnnotationValue> entry
                        : elementValues.entrySet()) {
                    messenger.printMessage(Diagnostic.Kind.NOTE, "ELEMENT");
                    entry.getValue().accept(valueVisitor, null);

                    if(entry.getKey().getSimpleName().toString().equals("layout")){
                        getLayoutIdSpec = generateGetLayoutId(entry);
                    }

                    if(entry.getKey().getSimpleName().toString().equals("view_holder_class")){
                        buildSpec = generateBuildViewHolder(entry, ParameterizedTypeName.get(baseViewHolderClass,
                                templateModelClass));
                    }
                }
            }

            try {
                TypeSpec classType = TypeSpec.classBuilder(className)
                        .addModifiers(Modifier.PUBLIC, Modifier.FINAL)
                        .addMethod(getLayoutIdSpec)
                        .addMethod(buildSpec)
                        .superclass(ParameterizedTypeName.get(baseTemplateClass, templateModelClass))
                        .build();

                JavaFile javaFile = JavaFile.builder(ROOT_PATH, classType)
                        .build();

                    javaFile.writeTo(processingEnv.getFiler());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return true;
    }

    private void error(Element e, String msg, Object... args) {
        messenger.printMessage(
                Diagnostic.Kind.ERROR,
                String.format(msg, args),
                e);
    }

    private static MethodSpec generateBuildViewHolder(Map.Entry<? extends ExecutableElement, ? extends AnnotationValue> entry,
                                                      ParameterizedTypeName returnType){
        return MethodSpec.methodBuilder("build")
                .addModifiers(Modifier.PUBLIC)
                .addAnnotation(Override.class)
                .returns(returnType)
                .addParameter(ClassName.get("android.view", "LayoutInflater"), "inflater")
                .addParameter(ClassName.get("android.view", "ViewGroup"), "parent")
                .addParameter(ClassName.get("com.crpr.androidadapters.common", "RecyclerItemTouchListener"), "listener")
                .addStatement("return new $T(inflate(inflater, parent), listener)", entry.getValue().getValue())
                .build();
    }

    private static MethodSpec generateGetLayoutId(Map.Entry<? extends ExecutableElement, ? extends AnnotationValue> entry){
        return MethodSpec.methodBuilder("getLayoutResId")
                .addModifiers(Modifier.PUBLIC)
                .addAnnotation(Override.class)
                .returns(TypeName.INT)
                .addStatement("return $L", entry.getValue())
                .build();
    }

}
