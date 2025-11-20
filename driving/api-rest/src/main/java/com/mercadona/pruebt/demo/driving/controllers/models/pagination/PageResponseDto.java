package com.mercadona.pruebt.demo.driving.controllers.models.pagination;

import com.mercadona.framework.cna.commons.rest.api.model.Pagination;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class PageResponseDto<T> {
    private Pagination pagination;
    private List<T> data;
}
