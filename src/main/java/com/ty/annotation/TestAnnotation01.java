package com.ty.annotation;

import java.lang.annotation.*;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/*
    �Զ���ע��
 */
@Retention(RetentionPolicy.RUNTIME)//����ע���ʱ��Ч
@Target(ElementType.TYPE)//����ע�����������Щ����(�࣬���� ��)
@interface Entrty{
    //Ԫ����(�������ݵ�����)
    String value() default ""; //ע���е����Զ���

}

//@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD,ElementType.METHOD})
@interface ID{

    String value() default "";
}

@Entrty("cnm")
class Goods{

    @ID("gis")
    private Integer id;
}

public class TestAnnotation01 {

    public static void main(String[] args) throws Exception {

        //Bean Pool   ,��һ�δ����ڳ��д������ڶ����ڳ���Ѱ�ң��еĻ����ó�����  ������һ��˼·
        Map<String,Object> singletonMap = new HashMap();

        //ͨ�������ȡgoods����� ע��
        Class<?> aClass = Class.forName("com.ty.annotation.Goods");

        /*Annotation[] annotations = aClass.getAnnotations();

        for (Annotation a:annotations
             ) {
            System.out.println(a);
        }*/

        Entrty entrty = aClass.getAnnotation(Entrty.class);


        String value = entrty != null ? entrty.value() : null;
        System.out.println(value);

        if (entrty!=null) {
            System.out.println("��������󽻸�spring" + entrty);
            singletonMap.put("Entry",entrty);

        }

        //Entrty daE = aClass.getDeclaredAnnotation(Entrty.class);

        //��ȡ goods�����ϵ�ע��

        Field id = aClass.getDeclaredField("id");

        ID idAnnotation = id.getAnnotation(ID.class);

        if (idAnnotation!=null){

            String s = idAnnotation.value();
            System.out.println(s);

            singletonMap.put("ID",idAnnotation);
        }


        System.out.println(singletonMap);


    }
}
