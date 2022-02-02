package com.n1k0.smalldata.kafkaperiodicproducer.generator;

import com.n1k0.smalldata.kafkaperiodicproducer.models.Call;

public class CallGenerator {

    public static Call generate(int telephoneRandomCount){

        return new Call(Utils.generatePhone(telephoneRandomCount),
                Utils.generatePhone(telephoneRandomCount),
                Utils.generateDate(),
                Utils.generateTime());
    }
}
