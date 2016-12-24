package com.kolyadko_polovtseva.book_maze.search;

import com.kolyadko_polovtseva.book_maze.entity.Book;
import com.kolyadko_polovtseva.book_maze.util.AuthorUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.SimpleFSDirectory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;


/**
 * Created by nadez on 12/17/2016.
 */
@Transactional
@Component
public class LuceneIndexBuilder {
    private static final Logger LOG = LogManager.getLogger(LuceneIndexBuilder.class);
    private static final String LUCENE_INDEX_DIRECTORY = "lucene";

    //method for indexing
    public void buildIndex(Iterable<Book> books) {
        IndexWriterConfig config = new IndexWriterConfig();

        try (
                Directory index = new SimpleFSDirectory(new File(LUCENE_INDEX_DIRECTORY).toPath());
                IndexWriter writer = new IndexWriter(index, config)) {
            LOG.info("Start indexing");
            //iterate through result set
            for (Book book : books) {
                //create document object
                Document document = new Document();
                //create field objects and add to document
                Field idField = new TextField("idBook", book.getIdBook().toString(), Field.Store.YES);
                document.add(idField);
                Field nameField = new TextField("name", book.getName(), Field.Store.YES);
                document.add(nameField);
                Field descriptionField = new TextField("description", book.getDescription(), Field.Store.YES);
                document.add(descriptionField);
                Field categoryField = new TextField("category", book.getCategory().getName(), Field.Store.YES);
                document.add(categoryField);
                Field authorField = new TextField("author", AuthorUtil.toString(book.getAuthors()), Field.Store.YES);
                document.add(authorField);
                //add the document to writer
                writer.addDocument(document);
            }
            //optimize the index
            LOG.info("Optimizing index");
            writer.commit();
        } catch (Exception e) {
            LOG.error(e);
        }
    }
}