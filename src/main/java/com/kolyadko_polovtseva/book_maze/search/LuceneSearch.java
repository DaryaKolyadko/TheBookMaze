package com.kolyadko_polovtseva.book_maze.search;

import com.kolyadko_polovtseva.book_maze.dto.SearchQueryDto;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.Term;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.*;
import org.apache.lucene.store.FSDirectory;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by nadez on 12/17/2016.
 */
public class LuceneSearch {
    private static final Logger LOG = LogManager.getLogger(LuceneSearch.class);
    private static final String LUCENE_INDEX_DIRECTORY = "lucene";

    public static List<Integer> search(String searchString) {
        TopDocs results;
        List<Integer> ids = new ArrayList<>();

        try (IndexReader reader = DirectoryReader.open(FSDirectory.open(Paths.get(LUCENE_INDEX_DIRECTORY)))) {
            IndexSearcher searcher = new IndexSearcher(reader);
            Analyzer analyzer = new StandardAnalyzer();
            QueryParser queryParser = new QueryParser("name", analyzer);
            Query query = queryParser.parse(searchString);
            results = searcher.search(query, 10);

            for (int i = 0; i < results.totalHits; i++) {
                Document document = searcher.doc(results.scoreDocs[i].doc);
                ids.add(Integer.parseInt(document.getField("idBook").stringValue()));
            }
        } catch (IOException | ParseException e) {
            LOG.error(e);
        }

        return ids;
    }

//    public static List<Integer> searchMultiple(String searchString) {
//        TopDocs results;
//        List<Integer> ids = new ArrayList<>();
//
//        try (IndexReader reader = DirectoryReader.open(FSDirectory.open(Paths.get(LUCENE_INDEX_DIRECTORY)))) {
//            IndexSearcher searcher = new IndexSearcher(reader);
//            Analyzer analyzer = new StandardAnalyzer();
//            MultiFieldQueryParser queryParser = new MultiFieldQueryParser(new String[]{"name",
//                    "author"}, analyzer);
//            Query query = queryParser.parse(searchString);
//            results = searcher.search(query, 50);
//
//            for (int i = 0; i < results.totalHits; i++) {
//                Document document = searcher.doc(results.scoreDocs[i].doc);
//                ids.add(Integer.parseInt(document.getField("idBook").stringValue()));
//            }
//        } catch (IOException | ParseException e) {
//            LOG.error(e);
//        }
//
//        return ids;
//    }


    public static List<Integer> search(SearchQueryDto query) {
        TopDocs results;
        List<Integer> ids = new ArrayList<>();

        try (IndexReader reader = DirectoryReader.open(FSDirectory.open(Paths.get(LUCENE_INDEX_DIRECTORY)))) {
            IndexSearcher searcher = new IndexSearcher(reader);
            BooleanQuery.Builder builder = new BooleanQuery.Builder();

            if (!query.getName().isEmpty()) {
                builder.add(new TermQuery(new Term("name", query.getName())), BooleanClause.Occur.MUST);
            }

//            if (!query.getAuthor().isEmpty()) {
//                builder.add(new TermQuery(new Term("first_name", query.getAuthor())), BooleanClause.Occur.MUST);
//            }

            if (!query.isEbooksOnly()) {
                builder.add(new TermQuery(new Term("ebookUrl", "* TO *")), BooleanClause.Occur.MUST);
            }

            results = searcher.search(builder.build(), 10);

            for (int i = 0; i < results.totalHits; i++) {
                Document document = searcher.doc(results.scoreDocs[i].doc);
                ids.add(Integer.parseInt(document.getField("idBook").stringValue()));
            }
        } catch (IOException e) {
            LOG.error(e);
        }

        return ids;
    }

//    public static  searchForBooks(String query) {
//
//    }
}
