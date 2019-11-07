package stud.task;

import javafx.util.Pair;
import org.apache.log4j.Logger;
import stud.task.model.Font;
import stud.task.table.*;
import stud.task.table.domain.HeadTable;
import stud.task.types.Tag;
import stud.task.util.ClassFinder;
import stud.task.util.TTFInputStream;
import stud.task.util.TTFReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

public class TTFParser {

    private static final Logger LOGGER = Logger.getLogger(TTFParser.class);

    private final String PATH_TO_TABLES = "stud.task.table";
    private final Class<TTFTable> CLASS_ANNOTATION = TTFTable.class;

    private TTFHead ttfHead;

    private Map<Tag, ReadableTable> tables;
    private List<SetUpTable> setUpTables;
    private Map<Tag, Pair<TTFTable, Class<? extends ReadableTable>>> clazzTables;

    public TTFParser() throws TTFException {
        List<Class<?>> classes = ClassFinder.find(PATH_TO_TABLES);
        clazzTables = new HashMap<>();
        setUpTables = new LinkedList<>();
        ttfHead = new TTFHead();
        for (Class<?> c :
                classes) {
            TTFTable a = c.getAnnotation(CLASS_ANNOTATION);
            if (a != null) {
                if (ReadableTable.class.isAssignableFrom(c)) {
                    @SuppressWarnings("unchecked")
                    Class<? extends ReadableTable> ct = (Class<? extends ReadableTable>) c;
                    Pair<TTFTable, Class<? extends ReadableTable>> error;
                    if((error = clazzTables.put(a.value().TAG, new Pair<>(a, ct))) != null)
                        throw new TTFException(String.format("Two classes: %s, %s is declaration as %s", ct, error.getValue(), a.value()));
                } else {
                    throw new TTFException(String.format("Class %s is declaration as %s but do not implementation ReadableTable", c, CLASS_ANNOTATION));
                }
            }
        }
    }

    public void parse(File file) throws IOException, TTFTableFormatException {
        TTFInputStream in = createIN(file);
        parse(in);
    }

    private void parse(TTFInputStream in) throws IOException, TTFTableFormatException {
        ttfHead.read(in);
        tables = new HashMap<>();

        for (Tag tag :
                ttfHead.getTags()) {
            if (tables.get(tag) != null) {
                continue;
            }
            try {
                read(in, tag, false);
            } catch (TTFException e) {
                LOGGER.error(e);
            }
        }
        setUpTables.sort(Comparator.comparingInt(SetUpTable::priority));
    }

    private void read(TTFInputStream in, Tag tag, boolean requared) throws IOException, TTFException {
        Pair<TTFTable, Class<? extends ReadableTable>> p = clazzTables.get(tag);

        if (p == null) {
            if (requared) {
                throw new RequiredTableNotFoundException(tag);
            } else {
                return;
            }
        }

        HeadTable ht = ttfHead.getHeadTable(tag);
        Class<? extends ReadableTable> c = p.getValue();
        TTFTable a = p.getKey();

        ReadableTable table;

        if (a.dependencies().length == 0) {
            try {
                table = c.getConstructor(ht.getClass()).newInstance(ht);
            } catch (InstantiationException | InvocationTargetException e) {
                LOGGER.error(e);
                return;
            } catch (IllegalAccessException e) {
                throw new TTFException(String.format("Constructor of table %s is not public", ht.getTag()));
            } catch (NoSuchMethodException e) {
                throw new TTFException(String.format("Table is declaration as %s does not match the description of the annotation", ht.getTag()));
            }
        } else {
            Object[] args = new Object[a.dependencies().length + 1];
            args[0] = ht;
            for (int i = 0; i < a.dependencies().length; i++) {
                if (tables.containsKey(a.dependencies()[i].TAG)) {
                    args[i + 1] = tables.get(a.dependencies()[i].TAG);
                } else {
                    read(in, a.dependencies()[i].TAG, true);
                    i--;
                }
            }
            Class[] classesArgs = new Class[a.dependencies().length + 1];
            classesArgs[0] = ht.getClass();
            for (int i = 0; i < a.dependencies().length; i++) {
                classesArgs[i+1] = clazzTables.get(a.dependencies()[i].TAG).getValue();
            }
            try {
                table = c.getConstructor(classesArgs).newInstance(args);
            } catch (InstantiationException | InvocationTargetException e) {
                LOGGER.error(e);
                return;
            } catch (IllegalAccessException e) {
                throw new TTFException(String.format("Constructor of table %s is not public", ht.getTag()));
            } catch (NoSuchMethodException e) {
                throw new TTFException(String.format("Table is declaration as %s does not match the description of the annotation", ht.getTag()));
            }
        }
        in.mark((int) ht.getSize().unsigned());
        in.skip(ht.getOffSet().unsigned());

        try {
            table.read(in);
        } catch (TTFTableFormatException e) {
            LOGGER.warn(e);
        }
        in.reset();
        tables.put(ht.getTag(), table);

        if (SetUpTable.class.isAssignableFrom(table.getClass())) {
            setUpTables.add((SetUpTable) table);
        }
    }

    public Font createFont() {
        Font font = new Font();
        setUpTables.forEach(s -> s.setUp(font));
        return font;
    }

    private TTFInputStream createIN(File file) throws FileNotFoundException {
        return new TTFReader(file);
    }

}
