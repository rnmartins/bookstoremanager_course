package com.renanmartins.bookstoremanager.publishers.builder;

import com.renanmartins.bookstoremanager.publishers.dto.PublisherDTO;
import lombok.Builder;

import java.time.LocalDate;

@Builder
public class PublisherDTOBuilder {

    @Builder.Default
    private final Long id = 1L;

    private final String name = "Martins Editora";

    private final String code = "MAR1234";

    private final LocalDate foundationDate = LocalDate.of(2021,06,12);

    public PublisherDTO buildPublisherDTO() {
        return new PublisherDTO(id, name, code, foundationDate);
    }
}
