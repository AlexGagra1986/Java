package ru.bot.botExforma.Repository;

import org.springframework.data.repository.CrudRepository;
import ru.bot.botExforma.ValuesDB.User;

public interface UserRepository extends CrudRepository<User, Long> {

}
