package com.ssm.po;

public class Card {
    private  Integer  card_id;
    private  Integer card_num;

    @Override
    public String toString() {
        return "Card{" +
                "id=" + card_id +
                ", card_num=" + card_num +
                '}';
    }

    public Integer getId() {
        return card_id;
    }

    public void setId(Integer id) {
        this.card_id= card_id;
    }

    public Integer getCard_num() {
        return card_num;
    }

    public void setCard_num(Integer card_num) {
        this.card_num = card_num;
    }
}
