package com.perfecto.fm.Services;


import org.springframework.stereotype.Service;

@Service
public class FileManagerService {
    private Directory ROOT;
    private StringBuilder view = new StringBuilder();


    public Directory getROOT() {

        return ROOT;
    }


    public FileManagerService() {
        ROOT = new Directory("ROOT", "DATE", null);
        addDir("ROOT", "a", "asd");
        addDir("ROOT", "b", "asd");
        addFile("ROOT", "fa", 123, "asd");
        addDir("a", "c", "asd");
        addDir("b", "d", "asd");
        addDir("a", "e", "asd");
        addFile("d", "fb", 123, "asd");
        addDir("ROOT", "f", "asd");
    }


    public Directory findDirectory(Directory d, String name) {
        if (d.getName().equals(name)) {
            return d;
        } else {
            for (Directory child : d.getCildrens()) {
                Directory result = findDirectory(child, name);
                if (result != null) {
                    return result;
                }
            }
        }
        return null;
    }

    public void deleteDirectory(String name) {
        Directory dir = findDirectory(ROOT, name);
        if (dir != null) {
            dir.getPDir().getCildrens().remove(dir);
        }
    }

    public File findFile(Directory d, String name) {

            if (d.getFileList().containsKey(name)) {
                return d.getFileList().get(name);
            }


        for (Directory child : d.getCildrens()) {
            File file = findFile(child, name);
            if (file != null) {
                return file;
            }

        }
        return null;
    }


    public void deleteFile(String name) {
        File file = findFile(ROOT, name);
        if (file != null) {
            file.getPDir().getFileList().remove(file);
        }
    }


    public void addFile(String pdir, String name, long size, String date) {
        File file = findFile(ROOT, name);
        if (file == null) {
            Directory dir = findDirectory(ROOT, pdir);
            if (dir != null) {
                File nfile = new File(size, name, date, dir);
                dir.getFileList().put(nfile.getName(),nfile);

            } else System.out.println("could not get dir");

        } else System.out.println("file olready exist");
    }

    public void addDir(String pdir, String name, String date) {
        Directory cdir = findDirectory(ROOT, name);
        if (cdir == null) {

            Directory dir = findDirectory(ROOT, pdir);
            if (dir != null) {
                Directory ndir = new Directory(name, date, dir);
                dir.AddDir(ndir);;
            } else System.out.println("could not get dir");

        } else System.out.println("dir olready exist");

    }

    public String printroot() {
        ROOT.printTree(0, view);
        //System.out.println(view.toString());
        return view.toString();

    }


}
