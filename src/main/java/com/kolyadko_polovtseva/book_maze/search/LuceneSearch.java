package com.kolyadko_polovtseva.book_maze.search;

import com.kolyadko_polovtseva.book_maze.dto.SearchQueryDto;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.Term;
import org.apache.lucene.search.*;
import org.apache.lucene.store.FSDirectory;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by nadez on 12/17/2016.
 */
public class LuceneSearch {
    private static final Logger LOG = LogManager.getLogger(LuceneSearch.class);
    private static final String LUCENE_INDEX_DIRECTORY = "lucene";

//    public static List<Integer> search(String searchString) {
//        TopDocs results;
//        List<Integer> ids = new ArrayList<>();
//
//        try (IndexReader reader = DirectoryReader.open(FSDirectory.open(Paths.get(LUCENE_INDEX_DIRECTORY)))) {
//            IndexSearcher searcher = new IndexSearcher(reader);
//            Analyzer analyzer = new StandardAnalyzer();
//            QueryParser queryParser = new QueryParser("name", analyzer);
//            Query query = queryParser.parse(searchString);
//            results = searcher.search(query, 10);
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

    public static Set<Integer> search(SearchQueryDto query) {
        TopDocs results;
        Set<Integer> ids = new HashSet<>();

        try (IndexReader reader = DirectoryReader.open(FSDirectory.open(Paths.get(LUCENE_INDEX_DIRECTORY)))) {
            IndexSearcher searcher = new IndexSearcher(reader);
            BooleanQuery.Builder builder = new BooleanQuery.Builder();

            if (!query.getName().isEmpty()) {
                for (String part : query.getName().split(" ")) {
                    builder.add(new TermQuery(new Term("name", part)), BooleanClause.Occur.MUST);
                }
            }

            if (!query.getAuthor().isEmpty()) {
                for (String part : query.getAuthor().split(" ")) {
                    builder.add(new TermQuery(new Term("author", part)), BooleanClause.Occur.MUST);
                }
            }

            if (!query.getDescription().isEmpty()) {
                for (String part : query.getDescription().split(" ")) {
                    builder.add(new TermQuery(new Term("description", part)), BooleanClause.Occur.MUST);
                }
            }

            if (!query.getCategory().isEmpty()) {
                for (String part : query.getCategory().split(" ")) {
                    builder.add(new TermQuery(new Term("category", part)), BooleanClause.Occur.MUST);
                }
            }

            results = searcher.search(builder.build(), 150);

            for (int i = 0; i < results.totalHits; i++) {
                Document document = searcher.doc(results.scoreDocs[i].doc);
                ids.add(Integer.parseInt(document.getField("idBook").stringValue()));
            }
        } catch (IOException e) {
            LOG.error(e);
        }

        return ids;
    }
}