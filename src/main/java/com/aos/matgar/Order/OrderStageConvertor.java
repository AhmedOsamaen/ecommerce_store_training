package com.aos.matgar.Order;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;

@Converter(autoApply = true)
public class OrderStageConvertor implements AttributeConverter<Stage, String> {
    @Override
    public String convertToDatabaseColumn(Stage category) {
        if (category == null) {
            return null;
        }
        return category.getCode();
    }

    @Override
    public Stage convertToEntityAttribute(String code) {
        if (code == null) {
            return null;
        }

        return Stream.of(Stage.values())
                .filter(c -> c.getCode().equals(code))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

}
