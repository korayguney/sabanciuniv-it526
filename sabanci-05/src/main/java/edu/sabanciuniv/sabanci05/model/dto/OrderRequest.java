package edu.sabanciuniv.sabanci05.model.dto;

import edu.sabanciuniv.sabanci05.model.Book;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderRequest {
    private List<Integer> bookIdList;
}
