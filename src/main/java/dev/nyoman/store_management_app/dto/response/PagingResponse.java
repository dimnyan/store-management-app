package dev.nyoman.store_management_app.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class PagingResponse {
    private Integer page;
    private Integer size;
    private Integer totalPages;
    private Integer totalElements;
}
