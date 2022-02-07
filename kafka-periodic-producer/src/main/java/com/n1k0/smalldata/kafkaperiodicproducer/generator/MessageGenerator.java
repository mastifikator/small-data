package com.n1k0.smalldata.kafkaperiodicproducer.generator;

import com.n1k0.smalldata.kafkaperiodicproducer.models.Sms;

import java.util.List;

public class MessageGenerator {
    public static Sms generate(int telephoneRandomCount, int amountWordInMessage, List<String> dictionary){

        return new Sms(Utils.generatePhone(telephoneRandomCount),
                Utils.generatePhone(telephoneRandomCount),
                Utils.generateRandomTextMessageFromDictionary(amountWordInMessage, dictionary),
                Utils.generateDate(),
                Utils.generateTime());

    }
}
