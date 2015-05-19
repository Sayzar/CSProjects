import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.queryparser.classic.MultiFieldQueryParser;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class Browsing
 */
public class Search extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Search() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException  {
       try {
           query(request,response);
       }catch(Exception e)
       {

       }

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

    public void query(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        String usage =
                "Usage:\tjava org.apache.lucene.demo.SearchFiles [-index dir] [-field f] [-repeat n] [-queries file] [-query string] [-raw] [-paging hitsPerPage]\n\nSee http://lucene.apache.org/core/4_1_0/demo/ for details. :-)";

        ServletContext sc = getServletContext();
        String index = sc.getInitParameter("path");
        String field = "";
        String queries = null;
        int repeat = 0;
        boolean raw = false;
        String queryString = null;
        int hitsPerPage = Integer.parseInt(request.getParameter("numResults"));

        IndexReader reader = DirectoryReader.open(FSDirectory.open(new File(index)));
        IndexSearcher searcher = new IndexSearcher(reader);
        // :Post-Release-Update-Version.LUCENE_XY:
        Analyzer analyzer = new StandardAnalyzer(Version.LUCENE_4_10_0);

        BufferedReader in = null;

        // :Post-Release-Update-Version.LUCENE_XY:
        QueryParser parser = new QueryParser(Version.LUCENE_4_10_0, field, analyzer);
            String line = request.getParameter("query");
            //  Query queryOld = parser.parse(line);
            Query query = MultiFieldQueryParser.parse(new String[]{line, line, line, line}, new String[]{"eBook#", "contents", "author", "title"}, new StandardAnalyzer());
            System.out.println("Searching for: " + query.toString(field));

            if (repeat > 0) {                           // repeat & time as benchmark
                Date start = new Date();
                for (int i = 0; i < repeat; i++) {
                    searcher.search(query, null, 100);
                }
                Date end = new Date();
                System.out.println("Time: "+(end.getTime()-start.getTime())+"ms");
            }

            ArrayList<BookInfo> results = doSearch(in, searcher, query, hitsPerPage, raw, queries == null && queryString == null);
            request.setAttribute("results", results);
            request.getRequestDispatcher("/ListPage").include(request,response);
        reader.close();
    }


    public static ArrayList<BookInfo> doSearch(BufferedReader in, IndexSearcher searcher, Query query,
                                      int hitsPerPage, boolean raw, boolean interactive) throws IOException {

        ArrayList<BookInfo> listOfHits = new ArrayList<BookInfo>();

        // Collect enough docs to show 7 pages
        TopDocs results = searcher.search(query, 5 * hitsPerPage);
        ScoreDoc[] hits = results.scoreDocs;

        int numTotalHits = results.totalHits;
        System.out.println(numTotalHits + " total matching documents");

        int start = 0;
        int end = Math.min(hits.length, start + hitsPerPage);
        for (int i = start; i < end; i++) {
                if (raw) {                              // output raw format
                    System.out.println("doc="+hits[i].doc+" score="+hits[i].score);
                    continue;
                }


            Document doc = searcher.doc(hits[i].doc);

                String path = doc.get("path");
                if (path != null) {
                    String splitPath = path.replace("C:\\Users\\Cesar Ramirez\\Desktop\\SearchEngine\\","..\\");
                    System.out.println((i+1) + ". " + splitPath);
                    String title = doc.get("title");
                    String author = doc.get("author");
                    String eBook = doc.get("eBook#");

                    String score = ""+hits[i].score;

                    listOfHits.add(new BookInfo(title, author, eBook, score, splitPath));


                } else {
                    System.out.println((i+1) + ". " + "No path for this document");
                }

            }
            return listOfHits;
        }
    }


