package org.perso.litby2.models.dto;

public interface IDtoConverter<T> {
    void fromEntity(T t);
}
