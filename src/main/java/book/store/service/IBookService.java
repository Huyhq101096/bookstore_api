package book.store.service;

import book.store.payload.request.BookRq;
import book.store.payload.response.BookRsp;

import java.util.List;

public interface IBookService {

    boolean addBook(BookRq bookRq);

    List<BookRsp> getAllBook();

}
