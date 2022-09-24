package uz.pdp.g11turdaliyevortigali.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Products {
    private Integer id;
    private String name;
    private Double price;
}
