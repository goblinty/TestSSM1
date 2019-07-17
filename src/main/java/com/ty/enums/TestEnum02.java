package com.ty.enums;

import java.util.EnumMap;

enum Sex{
    MALE("��"),
    FEMALE("Ů");

    //ö�����еĹ��췽��������˽�е�
    private String name;
    Sex(String name) {
        this.name = name;
    }

    public void doPrint(){
        System.out.println(name);
    }
}

//��Ա�Ѷ�
class Member{

    private Sex sex = Sex.FEMALE;

    public Sex getSex(){
        return sex;
    }
}

public class TestEnum02 {

    public static void main(String[] args) {

        //����ö�����еķ���
        Sex.MALE.doPrint();

        Member m1 = new Member();

        m1.getSex().doPrint();

        //����ö���� Ĭ�ϼ̳� Enum
        System.out.println(m1.getSex() instanceof Enum);

        EnumMap<Sex,String> enumMap = new EnumMap<Sex, String>(Sex.class);

        enumMap.put(Sex.MALE,"����");
        enumMap.put(Sex.FEMALE,"ŮŮ");

        System.out.println(enumMap);

    }
}
