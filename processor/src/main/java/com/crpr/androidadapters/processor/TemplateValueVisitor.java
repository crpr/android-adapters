package com.crpr.androidadapters.processor;

import java.util.List;

import javax.annotation.processing.Messager;
import javax.lang.model.element.AnnotationMirror;
import javax.lang.model.element.AnnotationValue;
import javax.lang.model.element.VariableElement;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.util.SimpleAnnotationValueVisitor7;
import javax.tools.Diagnostic;

/**
 * Created by claudioribeiro on 20/09/16.
 */

public class TemplateValueVisitor extends SimpleAnnotationValueVisitor7<Void, Void> {

    private Messager messenger;

    public TemplateValueVisitor(Messager messager){
        this.messenger = messager;
    }

    @Override
    public Void visitInt(int i, Void p) {
        messenger.printMessage(Diagnostic.Kind.NOTE, ">> intValue:" + i);
        return p;
    }

    @Override
    public Void visitString(String s, Void p) {
        messenger.printMessage(Diagnostic.Kind.NOTE, ">> stringValue:" + s);
        return p;
    }

    @Override
    public Void visitEnumConstant(VariableElement c, Void p) {
        messenger.printMessage(Diagnostic.Kind.NOTE, ">> enumValue:" + c.getSimpleName());
        return p;
    }

    @Override
    public Void visitAnnotation(AnnotationMirror a, Void p) {
        messenger.printMessage(Diagnostic.Kind.NOTE, ">> annotationTypeValue:" + a.toString());
        return p;
    }

    @Override
    public Void visitType(TypeMirror t, Void p) {
        messenger.printMessage(Diagnostic.Kind.NOTE, ">> classValue:" + t.toString());
        return p;
    }

    @Override
    public Void visitArray(List<? extends AnnotationValue> vals, Void p) {
        for (AnnotationValue val : vals) {
            val.accept(this, p);
        }
        return p;
    }
}