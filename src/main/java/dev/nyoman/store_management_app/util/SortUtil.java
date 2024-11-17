package dev.nyoman.store_management_app.util;

import lombok.Setter;
import org.springframework.data.domain.Sort;

@Setter
public class SortUtil {
    public static Sort parseSort(String sort) {
        Sort sortBy = Sort.unsorted();
        if (sort != null) {
            sortBy = sort.startsWith("-") ?
                    Sort.by(Sort.Direction.DESC, sort.substring(1))
                    : Sort.by(Sort.Direction.ASC, sort);
        }
        return sortBy;
    }
}
