import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;
import java.awt.print.Book;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Cesar Ramirez on 3/9/2015.
 */
public class ListPage extends HttpServlet {
    private static final long serialVersionUID = 1L;
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        doGet(request, response);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        // Is the user logged in? Otherwise, go to the login page.
        response.setContentType("text/html");

        try {
            PrintWriter out = response.getWriter();
            out.println("<HTML><HEAD><TITLE>GutenBerg Search Results</TITLE>" + "<script src='/SearchGui/js/lib/jquery.js' type='text/javascript'></script>"
                    + "<script src='/SearchGui/paging.js' type='text/javascript'></script>" + "<link rel='StyleSheet' href='../pagingStyle.css'>" + "</HEAD>");
            out.println("<BODY><H1>Search Results</H1>");


            addResultsPerPageSelector(out, 25);
            Object srObj = request.getAttribute("results");
            if (srObj != null) {
                ArrayList<BookInfo> searchResults = (ArrayList<BookInfo>) srObj;
                createResultsTable(searchResults, out);
            } else {
                System.out.println("No searchResults data given!");
            }

            createPaginator(out);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private void addResultsPerPageSelector(PrintWriter out, int resultsPerPage) {
        String option10 = "<option value='10'>10</option>";
        String option25 = "<option value='25'>25</option>";
        String option50 = "<option value='50'>50</option>";
        String option100 = "<option value='100'>100</option>";

        switch (resultsPerPage) {
            case 10:
                option10 = "<option value='10' SELECTED>10</option>";
                break;
            case 25:
                option25 = "<option value='25' SELECTED>25</option>";
                break;
            case 50:
                option50 = "<option value='50' SELECTED>50</option>";
                break;
            case 100:
                option100 = "<option value='100' SELECTED>100</option>";
                break;
        }

        out.println("<div>Results per page: <select id='resultsperpage'>" + option10 + option25 + option50 + option100 + "</select>" + "</div>");
    }

    private void createResultsTable(ArrayList<BookInfo> results, PrintWriter out){
        out.println("<TABLE id='results' border>");
        out.println("<tr>" + "<th>Rank</th>"+ "<th>Score</th>"+  "<th>Path</th>"+ "<th>Title</th>" + "<th>Author</th>" + "<th>EBook #</th>");

        // Iterate through each row of rs

        for (int i = 0; i < results.size(); i++) {
            BookInfo book = results.get(i);
            out.println("<tr>" + "<td> </td>"+"<td>" + book.accioScore() + "</td>" + "<td>" + book.accioPath() + "</td>" +  "<td>" +
                    book.accioTitle() + "</td>" + "<td>" + book.accioAuthor() + "</td>" + "<td>" + book.accioEbookNum() + "</td>" +"</tr>");
        }

        out.println("</TABLE>");
        out.println("<script type='text/javascript' src='/SearchGui/tableRow.js'></script>");
    }
    private void createPaginator(PrintWriter out) throws SQLException {
        out.println("<div id='pageNavPosition'></div>");
        out.println("<script type='text/javascript' src='/SearchGui/pagingUser.js'></script>");
        out.println("<p><a href=\"javascript:history.back()\">Back</a></p>");

    }
}
