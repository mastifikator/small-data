import services.KafkaFlinkService;

public class KafkaFlinkSearcherApplication {

    public static void main(String[] args) throws Exception{
        System.out.println("start read message from kafka");
        KafkaFlinkService kafkaFlinkService = new KafkaFlinkService();
        kafkaFlinkService.startReadWriteKafka();
    }
}

