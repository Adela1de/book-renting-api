package luiz.augusto.Bookstoreapi.model.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_book")
@Getter
@Setter
@NoArgsConstructor
public class Book implements Serializable {

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String author;
    private String publication;
    @ManyToMany
    @JoinTable(
        name = "book_category",
        joinColumns = @JoinColumn(name = "book_id"),
        inverseJoinColumns = @JoinColumn(name = "category_id"))
    private List<Category> categories = new ArrayList<>();
    @ManyToMany(mappedBy = "booksLiked")
    private List<User> likedBy = new ArrayList<>();
    private int quantityInStock;

    public Book(String title, String author, String publication)
    {
        this.title = title;
        this.author = author;
        this.publication = publication;
        this.quantityInStock = 10;
    }

    public boolean hasStock()
    {
        if(quantityInStock == 0) return false;
        else return true;
    }
}
