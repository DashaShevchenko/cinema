package com.geniusee.cinema.converter;

import java.util.ArrayList;
import java.util.List;

public abstract class DtoConverter<ENTITY, DTO> {

    public abstract ENTITY fromDto(DTO dto);

    public abstract DTO toDto(ENTITY entity);

    public List<ENTITY> fromDto(List<DTO> dtoList) {
        if (dtoList == null) {
            return null;
        }
        List<ENTITY> list = new ArrayList<>(dtoList.size());
        for (DTO dto : dtoList) {
            list.add(fromDto(dto));
        }
        return list;
    }

    public List<DTO> toDto(List<ENTITY> entityList) {
        if (entityList == null) {
            return null;
        }
        List<DTO> list = new ArrayList<>(entityList.size());
        for (ENTITY entity : entityList) {
            list.add(toDto(entity));
        }
        return list;
    }
}
