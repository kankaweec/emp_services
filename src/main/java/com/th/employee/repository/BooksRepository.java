package com.th.employee.repository;
import org.springframework.data.repository.CrudRepository;

import com.th.employee.model.Books;
public interface BooksRepository extends CrudRepository<Books, Integer>
{
}
