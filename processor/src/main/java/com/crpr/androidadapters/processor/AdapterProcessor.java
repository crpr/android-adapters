package com.crpr.androidadapters.processor;

import java.io.IOException;
import java.io.Writer;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.tools.JavaFileObject;

@SupportedAnnotationTypes("com.crpr.androidadapters.processor.AdapterTemplate")
@SupportedSourceVersion(SourceVersion.RELEASE_7)
public class AdapterProcessor extends AbstractProcessor{

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {

        StringBuilder builder = new StringBuilder()
                .append("package com.crpr.androidadapters.generated;\n\n")
                .append("import android.view.LayoutInflater;\n" +
                        "import android.view.ViewGroup;\n" +
                        "import com.crpr.androidadapters.R;\n" +
                        "import com.crpr.androidadapters.common.BaseTemplate;\n" +
                        "import com.crpr.androidadapters.common.BaseViewHolder;\n" +
                        "import com.crpr.androidadapters.common.RecyclerItemTouchListener;\n" +
                        "import com.crpr.androidadapters.common.templates.TemplateModel;\n\n")
                .append("public class ContactTemplateBuilder extends BaseTemplate<TemplateModel> {\n\n")
                .append("\tprivate android.widget.TextView field;\n\n")
                .append("\tpublic android.widget.TextView getField() { \n")
                .append("\t\treturn this.field;\n")
                .append("\t}\n\n")
                .append("\tpublic String getMessage() { \n")
                .append("\t\treturn \"");

        for(Element element : roundEnv.getElementsAnnotatedWith(AdapterTemplate.class)){
            String objectType = element.getSimpleName().toString();
            builder.append(objectType).append(" says hello");
        }

        builder.append("\";\n")
                .append("\t}\n\n")
                .append("\t@Override\n" +
                        "    protected int getLayoutResId() {\n" +
                        "        return R.layout.layout_contact_item;\n" +
                        "    }\n" +
                        "\n" +
                        "    @Override\n" +
                        "    public BaseViewHolder<TemplateModel> build(LayoutInflater inflater, ViewGroup parent,\n" +
                        "                                               RecyclerItemTouchListener listener) {\n" +
                        "        return new ContactTemplateViewHolder(inflate(inflater, parent), listener);\n" +
                        "    }\n")
                .append("}\n");

        try {
            JavaFileObject source = processingEnv.getFiler().createSourceFile("com.crpr.androidadapters.generated.ContactTemplateBuilder");

            Writer writer = source.openWriter();
            writer.write(builder.toString());
            writer.flush();
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return true;
    }
}
