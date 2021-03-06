package org.starrier.dreamwar.repository.dao;


import org.springframework.stereotype.Repository;
import org.starrier.dreamwar.model.BookWithBookStore;
import org.starrier.dreamwar.model.entity.Book;

import java.util.List;

/**
 * @author Xiaoyue Xiao
 */
@Repository
public interface BookDao {

    Book selectBookById(Long id);

    List<Book> selectBooksByAuthor(String author);

    List<Book> selectBooksByLowPriceAndHighPrice(Double lowPrice, Double highPrice);

    List<Book> selectAllBooks();

    List<Book> selectBooksByPage(Integer offset, Integer perPage);

    BookWithBookStore selectBookWithBookStoreById(Long id);

    Integer selectCount();

    Integer insertBook(Book book);

    Integer updateBookOnNameById(Book book);

    Integer deleteBookById(Long id);

}
