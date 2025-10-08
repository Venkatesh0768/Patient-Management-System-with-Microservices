package org.pm.analyticsservice.kafka;

import com.google.protobuf.InvalidProtocolBufferException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import patient.events.PatientEvent;

@Service
public class KafkaConsumer {
    private static final Logger log = LoggerFactory.getLogger(KafkaConsumer.class);

    @KafkaListener(topics = "patient", groupId = "analytics-service")
    public void consumeEvent(byte[] event) {
        try {
            PatientEvent patientEvent = PatientEvent.parseFrom(event);
            log.info("Received the patient : [patientId= {} , patientName={} , patientEmail={}]",
                    patientEvent.getPatientId(), patientEvent.getName(), patientEvent.getEmail());
        } catch (InvalidProtocolBufferException e) {
            log.error("Error deserizing the event {}", e.getMessage());
        }
    }
}
