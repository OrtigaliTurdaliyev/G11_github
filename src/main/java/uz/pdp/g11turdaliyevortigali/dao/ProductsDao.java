package uz.pdp.g11turdaliyevortigali.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import uz.pdp.g11turdaliyevortigali.model.Products;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ProductsDao {

    private final JdbcTemplate jdbcTemplate;

    public List<Products> getAllProductsFromDb() {
        String sql = "select * from public.products";

        return jdbcTemplate.query(sql, (resultSet, row) ->
                Products.builder()
                        .id(resultSet.getInt(1))
                        .name(resultSet.getString(2))
                        .price(resultSet.getDouble(3))
                        .build()
        );
    }

    public Object addNewProducts(Products product)  {
        try {
            String sql = "INSERT INTO public.products ( name, price)\n" +
                    "VALUES ( '" + product.getName() + "', '" + product.getPrice()+ "');";

            jdbcTemplate.update(sql);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public void editProducts(Products product)  {
        try {
            String sql = "UPDATE public.product\n" +
                    "SET full_name = '" + product.getName() + "'\n," +
                    " password = '" + product.getPrice() + "'\n" +
                    "WHERE id = " + product.getId();

            jdbcTemplate.update(sql);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteProducts(Integer id) throws IllegalAccessException {
        try {
            String sql = "DELETE\n" +
                    "FROM public.products\n" +
                    "WHERE id = " + id;
            jdbcTemplate.update(sql);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Products getProductsById(Integer id) {
        String sql = "select * from products where id=" + id;

        Products query = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Products.class));
        return query;

    }
}
