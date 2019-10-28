package stud.task.service;

import java.io.File;
import java.nio.file.Path;
import java.util.Objects;

public class ResLoader {

    private ClassLoader loader;

    private static ResLoader ourInstance = new ResLoader();

    public static ResLoader getInstance() {
        return ourInstance;
    }

    private ResLoader() {
        loader = getClass().getClassLoader();
    }

    public File getFile(String name) {
        String path = Objects.requireNonNull(loader.getResource(name)).getFile();
        return new File(path);
    }

    public Path getPath(String name) {
        return getFile(name).toPath();
    }
}
