package com.blyy.game.tigermachinegame.util;

import com.blyy.game.tigermachinegame.R;

import java.util.Map;


/**
 * Created by WuJingCheng on 2018/3/15.
 */

public class ChooseBrandUtils {
    public static int getBg(final String type) {
        int bg = -1;
        switch (type) {
            case "A1"://红桃
                bg = R.mipmap.a2;
                break;
            case "A2"://黑桃
                bg = R.mipmap.a4;
                break;
            case "A3"://梅花
                bg = R.mipmap.a3;
                break;
            case "A4"://方块
                bg = R.mipmap.a1;
                break;
            case "21"://红桃
                bg = R.mipmap.b2;
                break;
            case "22"://黑桃
                bg = R.mipmap.b4;
                break;
            case "23"://梅花
                bg = R.mipmap.b3;
                break;
            case "24"://方块
                bg = R.mipmap.b1;
                break;
            case "31"://红桃
                bg = R.mipmap.c2;
                break;
            case "32"://黑桃
                bg = R.mipmap.c4;
                break;
            case "33"://梅花
                bg = R.mipmap.c3;
                break;
            case "34"://方块
                bg = R.mipmap.c1;
                break;
            case "41"://红桃
                bg = R.mipmap.d2;
                break;
            case "42"://黑桃
                bg = R.mipmap.d4;
                break;
            case "43"://梅花
                bg = R.mipmap.d3;
                break;
            case "44"://方块
                bg = R.mipmap.d1;
                break;
            case "51"://红桃
                bg = R.mipmap.e2;
                break;
            case "52"://黑桃
                bg = R.mipmap.e4;
                break;
            case "53"://梅花
                bg = R.mipmap.e3;
                break;
            case "54"://方块
                bg = R.mipmap.e1;
                break;
            case "61"://红桃
                bg = R.mipmap.f2;
                break;
            case "62"://黑桃
                bg = R.mipmap.f4;
                break;
            case "63"://梅花\
                bg = R.mipmap.f3;
                break;
            case "64"://方块
                bg = R.mipmap.f1;
                break;
            case "71"://红桃
                bg = R.mipmap.g2;
                break;
            case "72"://黑桃
                bg = R.mipmap.g4;
                break;
            case "73"://梅花
                bg = R.mipmap.g3;
                break;
            case "74"://方块
                bg = R.mipmap.g1;
                break;
            case "81"://红桃
                bg = R.mipmap.h2;
                break;
            case "82"://黑桃
                bg = R.mipmap.h4;
                break;
            case "83"://梅花
                bg = R.mipmap.h3;
                break;
            case "84"://方块
                bg = R.mipmap.h1;
                break;
            case "91"://红桃
                bg = R.mipmap.i2;
                break;
            case "92"://黑桃
                bg = R.mipmap.i4;
                break;
            case "93"://梅花
                bg = R.mipmap.i3;
                break;
            case "94"://方块
                bg = R.mipmap.i1;
                break;
            case "101"://红桃
                bg = R.mipmap.j2;
                break;
            case "102"://黑桃
                bg = R.mipmap.j4;
                break;
            case "103"://梅花
                bg = R.mipmap.j3;
                break;
            case "104"://方块
                bg = R.mipmap.j1;
                break;
            case "J1"://红桃
                bg = R.mipmap.k2;
                break;
            case "J2"://黑桃
                bg = R.mipmap.k4;
                break;
            case "J3"://梅花
                bg = R.mipmap.k3;
                break;
            case "J4"://方块
                bg = R.mipmap.k1;
                break;
            case "Q1"://红桃
                bg = R.mipmap.l2;
                break;
            case "Q2"://黑桃
                bg = R.mipmap.l4;
                break;
            case "Q3"://梅花
                bg = R.mipmap.l3;
                break;
            case "Q4"://方块
                bg = R.mipmap.l1;
                break;
            case "K1"://红桃
                bg = R.mipmap.m2;
                break;
            case "K2"://黑桃
                bg = R.mipmap.m4;
                break;
            case "K3"://梅花
                bg = R.mipmap.m3;
                break;
            case "K4"://方块
                bg = R.mipmap.m1;
                break;
            case "小王5":
                bg = R.mipmap.n2;
                break;
            case "大王5":
                bg = R.mipmap.n1;
                break;
        }
       return bg;
    }
    public static Map<String,Integer> putBrand(Map<String,Integer> map){
        map.put("11",R.mipmap.a2);map.put("12",R.mipmap.a4);
        map.put("13",R.mipmap.a3);map.put("14",R.mipmap.a1);

        map.put("21",R.mipmap.b2);map.put("22",R.mipmap.b4);
        map.put("23",R.mipmap.b3);map.put("24",R.mipmap.b1);

        map.put("31",R.mipmap.c2);map.put("32",R.mipmap.c4);
        map.put("33",R.mipmap.c3);map.put("34",R.mipmap.c1);

        map.put("41",R.mipmap.d2);map.put("42",R.mipmap.d4);
        map.put("43",R.mipmap.d3);map.put("44",R.mipmap.d1);

        map.put("51",R.mipmap.e2);map.put("52",R.mipmap.e4);
        map.put("53",R.mipmap.e3);map.put("54",R.mipmap.e1);

        map.put("61",R.mipmap.f2);map.put("62",R.mipmap.f4);
        map.put("63",R.mipmap.f3);map.put("64",R.mipmap.f1);

        map.put("71",R.mipmap.g2);map.put("72",R.mipmap.g4);
        map.put("73",R.mipmap.g3);map.put("74",R.mipmap.g1);

        map.put("81",R.mipmap.h2);map.put("82",R.mipmap.h4);
        map.put("83",R.mipmap.h3);map.put("84",R.mipmap.h1);

        map.put("91",R.mipmap.i2);map.put("92",R.mipmap.i4);
        map.put("93",R.mipmap.i3);map.put("94",R.mipmap.i1);

        map.put("101",R.mipmap.j2);map.put("102",R.mipmap.j4);
        map.put("103",R.mipmap.j3);map.put("104",R.mipmap.j1);

        map.put("111",R.mipmap.k2);map.put("112",R.mipmap.k4);
        map.put("113",R.mipmap.k3);map.put("114",R.mipmap.k1);

        map.put("121",R.mipmap.l2);map.put("122",R.mipmap.l4);
        map.put("123",R.mipmap.l3);map.put("124",R.mipmap.l1);

        map.put("131",R.mipmap.m2);map.put("132",R.mipmap.m4);
        map.put("133",R.mipmap.m3);map.put("134",R.mipmap.m1);

        map.put("145",R.mipmap.n2);map.put("155",R.mipmap.n1);
        return map;
    }
}
