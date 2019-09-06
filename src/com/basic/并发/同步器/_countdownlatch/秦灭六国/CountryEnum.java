package com.basic.����.ͬ����._countdownlatch.��������;

import lombok.Getter;

/**
 * Description
 * ö�ٵ�ʹ��
 *
 * @author veliger@163.com
 * @version 1.0
 * @date 2019-04-13 10:14
 **/
public enum CountryEnum {
    /**
     *
     */
    ONE(1, "��"),
    /**
     *
     */
    TWO(2, "��"),
    /**
     *
     */
    THREE(3, "��"),
    /**
     *
     */
    FOUR(4, "��"),
    /**
     *
     */
    FIVE(5, "κ"),
    /**
     *
     */
    SIX(6, "��");

    CountryEnum(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    @Getter
    private Integer code;
    @Getter
    private String name;

    public static CountryEnum forEach(int index) {
        CountryEnum[] countryEnums = CountryEnum.values();
        for (CountryEnum countryEnum : countryEnums) {
            if (index == countryEnum.getCode()) {
                return countryEnum;
            }
        }
        return null;
    }
}
