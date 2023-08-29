package book.store.service.impl;

import book.store.entity.Book;
import book.store.payload.request.BookRq;
import book.store.payload.response.BookRsp;
import book.store.repository.BookRepository;
import book.store.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImpl implements IBookService {


    @Value("${host.name}")
    private String hostName;

    @Autowired
    private BookRepository bookRepository;

    @Override
    public boolean addBook(BookRq bookRq) {
        try {
            Book book = new Book();
            book.setName(bookRq.getName());
            book.setPrice(book.getPrice());
            book.setImage(bookRq.getFile().getOriginalFilename());
            book.setQuantity(book.getQuantity());
            book.setDesc(book.getDesc());
            bookRepository.save(book);
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    @Override
    public List<BookRsp> getAllBook() {
        List<Book> bookList = bookRepository.findAll();
        List<BookRsp> bookRsps = new ArrayList<>();
        for (Book book : bookList) {
            BookRsp bookRsp = new BookRsp();
            bookRsp.setId(book.getId());
            bookRsp.setName(book.getName());
            bookRsp.setRating(book.getRating());
            bookRsp.setPrice(book.getPrice());
//            bookRsp.setImage(hostName + "/" + book.getImage());
            bookRsp.setImage(book.getImage());
            bookRsps.add(bookRsp);
        }
        return bookRsps;
    }

    @Override
    public boolean exist(int id) {
        return false;
    }

    @Override
    public void updateBook(int id, BookRq bookRq) {
        Book book = bookRepository.findById(id).orElse(null);
        if (book != null) {
            book.setName(bookRq.getName());
            book.setPrice(bookRq.getPrice());
            book.setDesc(bookRq.getDesc());

            bookRepository.save(book);
        }
    }

    @Override
    public BookRsp getBookDetail(int id) {
        Book book = bookRepository.findById(id).orElse(null);
        BookRsp bookRsp = new BookRsp();
        if (book != null) {
            bookRsp.setId(book.getId());
            bookRsp.setPrice(book.getPrice());
            bookRsp.setImage(book.getImage());
            bookRsp.setName(book.getName());
            bookRsp.setDesc(book.getDesc());
            bookRsp.setRating(book.getRating());
            return bookRsp;
        }
        return null;
    }
}
