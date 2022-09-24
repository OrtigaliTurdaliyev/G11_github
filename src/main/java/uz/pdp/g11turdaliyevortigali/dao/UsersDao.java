package uz.pdp.g11turdaliyevortigali.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import uz.pdp.g11turdaliyevortigali.model.Users;

import java.util.List;


@Component
@RequiredArgsConstructor
public class UsersDao {

    private final JdbcTemplate jdbcTemplate;

    public List<Users> getAllUsersFromDb() {
        String sql = "select * from public.users";

        return jdbcTemplate.query(sql, (resultSet, row) ->
                Users.builder()
                        .id(resultSet.getInt(1))
                        .fullName(resultSet.getString(2))
                        .password(resultSet.getString(3))
                        .build()
        );
    }

    public void addNewUsers(Users users) throws IllegalAccessException {
        try {
            String sql = "INSERT INTO public.users (id, full_name, password)\n" +
                    "VALUES (DEFAULT, '" + users.getFullName() + "', '" + users.getPassword() + "');";

            jdbcTemplate.update(sql);

        } catch (Exception e) {
            throw new IllegalAccessException("Xatolik yuz berdi....");
        }

    }

    public void editUsers(Users users)  {
        try {
            String sql = "UPDATE public.users\n" +
                    "SET full_name = '" + users.getFullName() + "'\n," +
                    " password = '" + users.getPassword() + "'\n" +
                    "WHERE id = " + users.getId();

            jdbcTemplate.update(sql);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteUsers(Integer id) throws IllegalAccessException {
        try {
            String sql = "DELETE\n" +
                    "FROM public.users\n" +
                    "WHERE id = " + id;
            jdbcTemplate.update(sql);
        } catch (Exception e) {
            throw new IllegalAccessException("Xatolik yuz berdi....");
        }
    }

    public Users getUsersById(Integer id) {
        String sql = "select * from users where id=" + id;

        Users query = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Users.class));
        return query;

    }
}
