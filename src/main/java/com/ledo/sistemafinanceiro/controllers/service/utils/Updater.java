package com.ledo.sistemafinanceiro.controllers.service.utils;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import static com.google.gson.internal.reflect.ReflectionHelper.isRecord;

public class Updater {

    //Método estatico para atualizar qualquer entidade a partir de uma classe record no requestBody
    public static <T> void update(T target, T source) {
        try {
            Method[] methods = source.getClass().getMethods();
            for (Method method : methods) {

                if (!Modifier.isFinal(method.getModifiers())) {
                    Object value = method.invoke(source);

                    if (value != null) {

                        String fieldName = getFieldName(method.getName());

                        //se tiver uma classe dentro do record, roda novamente o código atualizando a parte mais interior do código
                        if(isRecord(value.getClass())){

                            Method setter = target.getClass().getMethod("get" + fieldName);

                            var toUpdate = setter.invoke(target);

                            update(toUpdate, value);
                        }else {

                            //faz o set(MethoName) e atribui o valor do request para a variável
                            Method setter = target.getClass().getMethod("set" + fieldName, value.getClass());
                            setter.invoke(target, value);
                        }

                    }

                }
            }
        } catch (Exception e) {
            //e.printStackTrace();
        }
    }

    public static String getFieldName(String methodName) {
        return Character.toUpperCase(methodName.charAt(0)) + methodName.substring(1);
    }
}

