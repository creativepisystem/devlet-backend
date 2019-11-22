package br.com.creative.devlet.util;

import br.com.creative.devlet.model.CheckListModel;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.persistence.AttributeConverter;
import java.io.IOException;
import java.util.Map;



public class HashMapConverter implements AttributeConverter<Object, String> {
    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public String convertToDatabaseColumn(Object attribute) {
        String checkList = null;
        try {
            checkList = objectMapper.writeValueAsString(attribute);
        }catch (final JsonProcessingException e){
            e.printStackTrace();
        }
        return checkList;
    }

    @Override
    public Object convertToEntityAttribute(String dbData) {
        CheckListModel checkListModel = null;
        try {
            checkListModel = (CheckListModel) objectMapper.readValue(dbData, Map.class);
        }catch (final IOException e){
            e.printStackTrace();
        }
        return null;
    }
}
