package com.n1k0.smalldata.kafkaperiodicproducer.generator;

import com.n1k0.smalldata.kafkaperiodicproducer.models.Message;

import java.util.List;

public class MessageGenerator {
    public static Message generate(int telephoneRandomCount, int amountWordInMessage, List<String> dictionary){

        return new Message(Utils.generatePhone(telephoneRandomCount),
                Utils.generatePhone(telephoneRandomCount),
                Utils.generateRandomTextMessageFromDictionary(amountWordInMessage, dictionary),
                Utils.generateDate(),
                Utils.generateTime());

    }
}
