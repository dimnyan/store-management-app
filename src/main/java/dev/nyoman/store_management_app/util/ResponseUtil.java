package dev.nyoman.store_management_app.util;

import dev.nyoman.store_management_app.dto.response.CommonResponse;
import dev.nyoman.store_management_app.dto.response.PagingResponse;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class ResponseUtil {
    public static <T> ResponseEntity<CommonResponse<T>> responseBuilder(HttpStatus httpStatus, String message, T data) {
        CommonResponse<T> response = new CommonResponse<>(
                httpStatus.value(),
                message,
                data,
                null
        );
        return ResponseEntity.status(httpStatus).body(response);
    }

    public static <T> ResponseEntity<CommonResponse<?>> responseBuilderPage(HttpStatus httpStatus, String message, Page<T> page) {
        PagingResponse pagingResponse = PagingResponse.builder()
                .page(page.getPageable().getPageNumber() + 1)
                .size(page.getSize())
                .totalPages(page.getTotalPages())
                .totalElements(Math.toIntExact(page.getTotalElements()))
                .build();

        CommonResponse<List<T>> listCommonResponse = new CommonResponse<>(
                httpStatus.value(),
                message,
                page.getContent(),
                pagingResponse
        );

        return ResponseEntity.status(httpStatus).body(listCommonResponse);
    }
}

