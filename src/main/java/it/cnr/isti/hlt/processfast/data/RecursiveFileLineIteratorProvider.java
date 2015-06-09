package it.cnr.isti.hlt.processfast.data;

import it.cnr.isti.hlt.processfast.utils.Pair;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.DirectoryFileFilter;
import org.apache.commons.io.filefilter.RegexFileFilter;
import org.apache.commons.io.filefilter.TrueFileFilter;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.Serializable;
import java.util.*;

/**
 * @author Tiziano Fagni (tiziano.fagni@isti.cnr.it)
 */
public class RecursiveFileLineIteratorProvider implements ImmutableDataSourceIteratorProvider<String> {

    private Collection<File> files;

    public RecursiveFileLineIteratorProvider(String baseDir, String regexInclusion) {
        if (baseDir == null)
            throw new NullPointerException("The collection is 'null'");

        files = listFiles(baseDir, regexInclusion);
    }

    private Collection<File> listFiles(String baseDir, String regexInclusion) {

        Collection<File> files = null;
        if (regexInclusion == null || regexInclusion.isEmpty()) {
            files = FileUtils.listFiles(new File(baseDir),
                    TrueFileFilter.INSTANCE,
                    DirectoryFileFilter.DIRECTORY
            );
        } else {
            files = FileUtils.listFiles(new File(baseDir),
                    new RegexFileFilter(regexInclusion),
                    DirectoryFileFilter.DIRECTORY
            );
        }
        return files;
    }

    public Iterator<String> iterator() {
        return new FileLineIterator(files);
    }


    private static class FileLineIterator implements Iterator<String> {

        private final Collection<File> files;
        private final Iterator<File> iter;
        private List<String> curFile;
        private int curIndexInFile;

        public FileLineIterator(Collection<File> files) {
            this.files = files;
            this.iter = files.iterator();
            if (iter.hasNext())
                curFile = readFile(iter.next());
            else
                curFile = new ArrayList<>();
            this.curIndexInFile = 0;
        }

        public boolean hasNext() {
            return (iter.hasNext() || curIndexInFile < curFile.size());
        }

        public String next() {
            if (!hasNext())
                throw new NoSuchElementException("There are no more lines to fetch");

            String line = curFile.get(curIndexInFile);
            curIndexInFile++;

            if (curIndexInFile >= curFile.size()) {
                if (iter.hasNext()) {
                    curFile = readFile(iter.next());
                    curIndexInFile = 0;
                }
            }

            return line;
        }

        public void remove() {
            throw new UnsupportedOperationException("The operation is not supported");
        }

        private ArrayList<String> readFile(File f) {
            ArrayList ret = new ArrayList();
            try (BufferedReader br = new BufferedReader(new FileReader(f))) {
                String l;
                while ((l = br.readLine()) != null) {
                    ret.add(l);
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            System.out.println("Letto " + f.toString());
            return ret;
        }
    }
}
