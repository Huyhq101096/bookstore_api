package book.store.payload.response;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookRsp {

    private int id;
    private String name;
    private String image;
    private String desc;
    private String rating;
}
