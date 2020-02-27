package com.ssm.po;

public class Card_Person {
    private  Integer id;
    private  Integer age;
    private  String name;
    private  String sex;
    private  Card card;

    @Override
    public String toString() {
        return "Card_Person{" +
                "id='"+id+'\''+
                "age='" + age + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", card_num=" + card +
                '}';
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Card getCard_num() {
        return card;
    }

    public void setCard_num(Card card_num) {
        this.card= card;
    }
}
