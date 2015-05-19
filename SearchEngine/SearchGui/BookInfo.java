/**
 * Created by Cesar Ramirez on 3/9/2015.
 */
public class BookInfo {
    private String title;
    private String author;
    private String ebookNum;
    private String score;
    private String path;
    public BookInfo(String title, String author, String ebookNum, String score, String path)
    {
        this.title = title;
        this.author = author;
        this.author = this.author.replace("Author: ","");
        this.author = this.author.replace("Translator: ","");
        this.ebookNum = ebookNum;
        this.score = score;
        this.path = path;
    }

    public String accioTitle()
    {
        return this.title;
    }
    public String accioAuthor()
    {
        return this.author;
    }
    public String accioEbookNum()
    {
        return this.ebookNum;
    }
    public String accioScore()
    {
        return this.score;
    }
    public String accioPath() { return this.path;}






}
