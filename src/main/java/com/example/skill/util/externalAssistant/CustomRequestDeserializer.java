//package com.example.skill.util.external;
//
//import com.example.voiceAssistants.alice.model.request.*;
//import com.fasterxml.jackson.core.JacksonException;
//import com.fasterxml.jackson.core.JsonParser;
//import com.fasterxml.jackson.databind.DeserializationContext;
//import com.fasterxml.jackson.databind.JsonDeserializer;
//import com.fasterxml.jackson.databind.JsonNode;
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//import java.io.IOException;
//
//public class CustomRequestDeserializer extends JsonDeserializer<CustomRequest> {
//    private final ObjectMapper objectMapper = new ObjectMapper();
//
//    @Override
//    public CustomRequest deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JacksonException {
//        JsonNode node = jsonParser.getCodec().readTree(jsonParser);
//
//        if (node.has("meta")) {
//            JsonNode meta = node.get("meta");
//
//            if (meta.has("client_id") && meta.get("client_id").asText().contains("yandex")) {
//                YandexAliceRequest yandexAliceRequest = new YandexAliceRequest();
//
//                yandexAliceRequest.setMeta(objectMapper.treeToValue(meta, YAMetadata.class));
//                yandexAliceRequest.setRequest(objectMapper.treeToValue(node.get("request"), YASkillRequest.class));
//                yandexAliceRequest.setSession(objectMapper.treeToValue(node.get("session"), YASession.class));
//                yandexAliceRequest.setSessionState(objectMapper.treeToValue(node.get("state"), YAState.class));
//                yandexAliceRequest.setVersion(objectMapper.treeToValue(node.get("version"), String.class));
//
//                return yandexAliceRequest;
//            }
//        }
//
//        throw new IOException("Unknown request type");
//    }
//}
